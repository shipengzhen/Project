package com.fly.jdbc;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import com.yy.util.Page;

/**
 * Fly���Ķ���JDBC�ķ�װ
 * <p>�����ṩһϵ�о����API�������ݿ�ķ���
 */
public class SqlFly {

	private Connection connection;			//���Ӷ���
	private boolean isBT=false;		//�Ƿ��Ѿ���ʼ����
	public String sql;				//��һ��ִ�е�SQL
	
	/* * * * * * * * * * * * * ���ӳ� * * * * * * * * * * * * * * * * * * * * */
	
	private DataSource dataSource;	//���ӳض���
	/**
	 * ���DataSource
	 */
	public DataSource getDataSource() {
		if(this.dataSource==null) {
			this.dataSource=FlyDataSource.getdefaultDataSource();
		}
		return dataSource;
	}
	/**
	 * д��ָ��DataSource
	 * <br>�������ʵ����SqlFlyǰ��û��ָ��DataSource,�ǽ�ʹ��FlyĬ�ϵ����ӳ�
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	/* * * * * * * * * * * * * ������� * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * ��õײ��connection����<b>���ã�һ���������û�����ɵ��ô˷�����</b>
	 * <p>�����ϣ����Connectionȡ���������SqlFly�İ󶨣���ִ��setConnection(null)
	 * <br/>����ʹ����Ϻ���close()
	 */
	public Connection getConnection(){
		if(connection==null){
			try {
				setConnection(getDataSource().getConnection());
			} catch (SQLException e) {
				throw new RuntimeException("�����ӳػ�ȡ����ʧ��",e);
			}
		}
		return connection;
	}
	/**
	 * ��connection��ֵ��<b>���ã�һ���������û�����ɵ��ô˷�����</b>
	 */
	public void setConnection(Connection connection){
		this.connection=connection;
		startOrEnd(false);
	}
	/**
	 * �رմ�SqlFly�ײ�󶨵�connection
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
	//�����������ֱ���ͷ�
	private void closeByBT(){
		if(isBT==false){
			close();
		}
	}
	/*
	 * ����SqlFly����״̬
	 * true  ��������isBT=true,����autoCommit=false
	 * false �ر�����isBT=false,����autoCommit=true
	 */
	private void startOrEnd(boolean bt) {
		try {
			if(connection!=null) {
				isBT=bt;
				connection.setAutoCommit(!bt);
			}
		} catch (SQLException e) {
			throw new RuntimeException("��ʼ����������쳣����������autoCommit״̬ʧ��",e);
		}
	}
	
	/* * * * * * * * * * * * * ������� * * * * * * * * * * * * * * * * * * * * */
	/**
	 * ��ʼ����,�ҽ�autoCommit=false
	 * <p>SqlFly������ʵʱ��������,���ǵȵ��������֮��
	 * @throws SQLException 
	 */
	public SqlFly beginTransaction(){
		try {
			if(isBT==true){
				rollback();
			}
			getConnection();	//��©д����䣬�����ҵ����۾�����2��СʱBug
			startOrEnd(true);
			getConnection().setSavepoint();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	/**
	 * �ύ����,�ҽ�autoCommit=true
	 */
	public void commit(){
		try {
			getConnection().commit();
			startOrEnd(false);
			closeByBT();
		} catch (SQLException e) {
			throw new RuntimeException("�����ύʧ��",e);
		}
	}
	/**
	 * �ع�����,�ҽ�autoCommit=true
	 */
	public void rollback(){
		try {
			getConnection().rollback();
			startOrEnd(false);
			closeByBT();
		} catch (SQLException e) {
			throw new RuntimeException("����ع�ʧ��",e);
		}
	}

	/* * * * * * * * * * * * * �������� * * * * * * * * * * * * * * * * * * * * */
	
	/* * * * * * * * * * * * * �������� * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * ִ����������sql��argsΪ�����б�(���ຯ��ͬ��)
	 */
	public PreparedStatement getExecute(String sql,Object... args){
		try {
			return FlyDbUtil.getExecute(getConnection(), this.sql=sql, args);
		} catch (SQLException e) {
			throw new RuntimeException("sqlִ���쳣��"+sql,e);
		}
	}
	/**
	 * ��ɾ�ģ�������Ӱ������
	 */
	public int getUpdate(String sql,Object... args){
		PreparedStatement ps=getExecute(sql,args);
		try {
			return ps.getUpdateCount();
		} catch (SQLException e) {
			throw new RuntimeException("��ɾ��sqlִ���쳣",e);
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				throw new RuntimeException("�ͷ�Statementʧ��",e);
			}
			closeByBT();
		}
	}
	/**
	 * ��ѯ������ResultSet�����
	 * <p>�����������㲻Ӧ�õ��ô˷������˷����ὫResultSet����Ȩ������<b>
	 * <br/>����ζ��Fly�����Զ��ڴ�����Ͻ��������رգ�
	 * <br/>���������ڴ�����������ִ��rs.getStatement().close()�ͷ���Դ;
	 * <br/>�����ڵ��ô˷���֮ǰ���뿪������
	 */
	public ResultSet getResultSet(String sql,Object... args){
		try {
			return getExecute(sql,args).getResultSet();
		} catch (SQLException e) {
			throw new RuntimeException("���ResultSet�����ʧ��",e);
		}
	}
	/**
	 * �ۺϲ�ѯ�����ص�һ�е�һ��ֵ
	 */
	public Object getScalar(String sql,Object... args){
		ResultSet rs=getResultSet(sql,args);
		try {
			if(rs.next()){
				return rs.getObject(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("�ۺϲ�ѯʧ��",e);
		}finally{
			FlyDbUtil.close(rs);
			closeByBT();
		}
		return null;
	}
	/**
	 * �ۺϲ�ѯ�����ص�һ�е�һ��ֵ��������ǿת��ΪInteger
	 */
	public Integer getScalarInt(String sql,Object... args){
		return Integer.parseInt(getScalar(sql, args).toString());
	}
	/**
	 * ��ɾ�ĵ����أ��˷���()==getUpdate()+commit()
	 */
	public int getUpdateCommit(String sql,Object... args){
		try {
			return getUpdate(sql, args);
		} finally {
			commit();
		}
	}
	
	/* * * * * * * * * * * * * �����ӳ�� * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * <h1>�������ӳ��Ϊָ��Model</h1>
	 */
	public <T>T getModel(String sql,Class<T> cs,Object... args){
		List<T>list=getList(sql, cs, args);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	/**
	 * <h1>�������ӳ��Ϊָ��Model����</h1>
	 * ������sql��䣬ӳ�����ͣ������б�<br/><br/>
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
	 * �������ӳ��Ϊ--List< Map >����
	 */
	public List<Map<String,Object>> getListMap(String sql,Object... args){
		ResultSet rs=getResultSet(sql, args);
		try {
			return FlyDbUtil.getListMap(rs);
		} catch (SQLException e) {
			throw new RuntimeException("�������ӳ��ΪList<Map>����ʧ��",e);
		} finally {
			FlyDbUtil.close(rs);
			closeByBT();
		}
	}
	
	/**
	 * �������ӳ��Ϊ�����������͵ļ��ϣ���Integer��Double��
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
	 * MySql�ķ�ҳ����ֻ��Ҫ�ṩδ��ҳ��ʽ��sql��������Ͼ�����
	 */
	public<T> List<T> getPageList(Page page,String sql,Class<T> cs,Object... args){
		page.setCount(getScalarInt("select count(1) from ("+sql+") as T", args));
		return getList(sql+" limit ?,?", cs, Fly.ArrayAdd(args, page.getStart(),page.getPz()));
	}
	
	
	
}
