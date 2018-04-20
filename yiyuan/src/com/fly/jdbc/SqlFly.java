package com.fly.jdbc;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import com.yy.util.Page;

/**
 * Fly核心对象，JDBC的封装
 * <p>该类提供一系列精简的API进行数据库的访问
 */
public class SqlFly {

	private Connection connection;			//连接对象
	private boolean isBT=false;		//是否已经开始事务
	public String sql;				//上一条执行的SQL
	
	/* * * * * * * * * * * * * 连接池 * * * * * * * * * * * * * * * * * * * * */
	
	private DataSource dataSource;	//连接池对象
	/**
	 * 获得DataSource
	 */
	public DataSource getDataSource() {
		if(this.dataSource==null) {
			this.dataSource=FlyDataSource.getdefaultDataSource();
		}
		return dataSource;
	}
	/**
	 * 写入指定DataSource
	 * <br>如果你在实例化SqlFly前并没有指定DataSource,那将使用Fly默认的连接池
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	/* * * * * * * * * * * * * 连接相关 * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * 获得底层的connection对象，<b>慎用！一般情况下你没有理由调用此方法！</b>
	 * <p>如果你希望将Connection取出并脱离此SqlFly的绑定，请执行setConnection(null)
	 * <br/>并在使用完毕后将其close()
	 */
	public Connection getConnection(){
		if(connection==null){
			try {
				setConnection(getDataSource().getConnection());
			} catch (SQLException e) {
				throw new RuntimeException("从连接池获取连接失败",e);
			}
		}
		return connection;
	}
	/**
	 * 给connection赋值，<b>慎用！一般情况下你没有理由调用此方法！</b>
	 */
	public void setConnection(Connection connection){
		this.connection=connection;
		startOrEnd(false);
	}
	/**
	 * 关闭此SqlFly底层绑定的connection
	 */
	public void close(){
		try {
			if(connection==null) {
				return;
			}
			if(isBT==true){
				rollback();
			}else {
				connection.close();
				setConnection(null);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//如果不在事务，直接释放
	private void closeByBT(){
		if(isBT==false){
			close();
		}
	}
	/*
	 * 更改SqlFly事务状态
	 * true  开启事务，isBT=true,并且autoCommit=false
	 * false 关闭事务，isBT=false,并且autoCommit=true
	 */
	private void startOrEnd(boolean bt) {
		try {
			if(connection!=null) {
				isBT=bt;
				connection.setAutoCommit(!bt);
			}
		} catch (SQLException e) {
			throw new RuntimeException("开始或结束事务异常：设置连接autoCommit状态失败",e);
		}
	}
	
	/* * * * * * * * * * * * * 事务相关 * * * * * * * * * * * * * * * * * * * * */
	/**
	 * 开始事务,且将autoCommit=false
	 * <p>SqlFly将不再实时回收连接,而是等到事务结束之后
	 * @throws SQLException 
	 */
	public SqlFly beginTransaction(){
		try {
			if(isBT==true){
				rollback();
			}
			getConnection();	//我漏写了这句，它让我瞪酸眼睛调了2个小时Bug
			startOrEnd(true);
			getConnection().setSavepoint();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	/**
	 * 提交事务,且将autoCommit=true
	 */
	public void commit(){
		try {
			getConnection().commit();
			startOrEnd(false);
			closeByBT();
		} catch (SQLException e) {
			throw new RuntimeException("事务提交失败",e);
		}
	}
	/**
	 * 回滚事务,且将autoCommit=true
	 */
	public void rollback(){
		try {
			getConnection().rollback();
			startOrEnd(false);
			closeByBT();
		} catch (SQLException e) {
			throw new RuntimeException("事务回滚失败",e);
		}
	}

	/* * * * * * * * * * * * * 基本交互 * * * * * * * * * * * * * * * * * * * * */
	
	/* * * * * * * * * * * * * 基本交互 * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * 执行任意类型sql，args为参数列表(其余函数同理)
	 */
	public PreparedStatement getExecute(String sql,Object... args){
		try {
			return FlyDbUtil.getExecute(getConnection(), this.sql=sql, args);
		} catch (SQLException e) {
			throw new RuntimeException("sql执行异常："+sql,e);
		}
	}
	/**
	 * 增删改，返回受影响行数
	 */
	public int getUpdate(String sql,Object... args){
		PreparedStatement ps=getExecute(sql,args);
		try {
			return ps.getUpdateCount();
		} catch (SQLException e) {
			throw new RuntimeException("增删改sql执行异常",e);
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				throw new RuntimeException("释放Statement失败",e);
			}
			closeByBT();
		}
	}
	/**
	 * 查询，返回ResultSet结果集
	 * <p>大多数情况下你不应该调用此方法，此方法会将ResultSet处理权交给你<b>
	 * <br/>这意味着Fly不会自动在处理完毕结果集后将其关闭，
	 * <br/>因此你必须在处理完结果集后执行rs.getStatement().close()释放资源;
	 * <br/>并且在调用此方法之前必须开启事务
	 */
	public ResultSet getResultSet(String sql,Object... args){
		try {
			return getExecute(sql,args).getResultSet();
		} catch (SQLException e) {
			throw new RuntimeException("获得ResultSet结果集失败",e);
		}
	}
	/**
	 * 聚合查询，返回第一行第一列值
	 */
	public Object getScalar(String sql,Object... args){
		ResultSet rs=getResultSet(sql,args);
		try {
			if(rs.next()){
				return rs.getObject(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("聚合查询失败",e);
		}finally{
			FlyDbUtil.close(rs);
			closeByBT();
		}
		return null;
	}
	/**
	 * 聚合查询，返回第一行第一列值，并将其强转成为Integer
	 */
	public Integer getScalarInt(String sql,Object... args){
		return Integer.parseInt(getScalar(sql, args).toString());
	}
	/**
	 * 增删改的重载：此方法()==getUpdate()+commit()
	 */
	public int getUpdateCommit(String sql,Object... args){
		try {
			return getUpdate(sql, args);
		} finally {
			commit();
		}
	}
	
	/* * * * * * * * * * * * * 结果集映射 * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * <h1>将结果集映射为指定Model</h1>
	 */
	public <T>T getModel(String sql,Class<T> cs,Object... args){
		List<T>list=getList(sql, cs, args);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	/**
	 * <h1>将结果集映射为指定Model集合</h1>
	 * 参数：sql语句，映射类型，参数列表<br/><br/>
	 */
	public<T> List<T> getList(String sql,Class<T> cs,Object... args){
		ResultSet rs=getResultSet(sql, args);
		try {
			return FlyDbUtil.getList(rs,cs);
		} finally {
			FlyDbUtil.close(rs);
			closeByBT();
		}
	}
	/**
	 * 将结果集映射为--List< Map >集合
	 */
	public List<Map<String,Object>> getListMap(String sql,Object... args){
		ResultSet rs=getResultSet(sql, args);
		try {
			return FlyDbUtil.getListMap(rs);
		} catch (SQLException e) {
			throw new RuntimeException("将结果集映射为List<Map>集合失败",e);
		} finally {
			FlyDbUtil.close(rs);
			closeByBT();
		}
	}
	
	/**
	 * 将结果集映射为基本数据类型的集合，如Integer、Double等
	 */
	public<T> List<T> getBaseList(String sql,Class<T> cs,Object... args){
		ResultSet rs=getResultSet(sql, args);
		try {
			return FlyDbUtil.getBaseList(rs,cs);
		} finally {
			FlyDbUtil.close(rs);
			closeByBT();
		}
	}
	
	/**
	 * MySql的分页，你只需要提供未分页形式的sql与参数集合就行了
	 */
	public<T> List<T> getPageList(Page page,String sql,Class<T> cs,Object... args){
		page.setCount(getScalarInt("select count(1) from ("+sql+") as T", args));
		return getList(sql+" limit ?,?", cs, Fly.ArrayAdd(args, page.getStart(),page.getPz()));
	}
	
	
	
}
