package com.fly.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * FlyDataSource提供连接池的一个简易实现
 * <p>配置文件：默认文件名：sqlfly.properties
 * <p>这里以MySql为举个栗子
 * <textarea style="width: 60%;height: 500px;margin: 50px;">
########## 必修 ##########

#驱动、连接地址、用户、密码
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/yixiao?useUnicode=true&characterEncoding=utf-8
username=root
password=root

########## 选修 ##########

#初始化连接数(default=20),池中保持最小连接数(default=10),池中最多连接数(default=50),是否启用连接池(default=true)
init=20
min=10
max=50
ispool=true
</textarea>
 */
public class FlyDataSource implements DataSource{

	//连接相关
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	private int init=20;			//初始化连接数
	private int min=10;				//最小链接数
	private int max=50;				//最大连接数
	public boolean ispool=true;		//是否使用连接池，其值若为false，则代表不再使用连接池
	
	private LinkedList<Connection>conns=new LinkedList<Connection>();	//连接池

	public FlyDataSource() {	}
	public FlyDataSource(String path) {
		init(path);
	}
	
	//非null转int,null返回i
	private int getInt(String str,int i) {
		if(str==null) {
			return i;
		}
		return new Integer(str);
	}
	//根据指定地址，初始化连接池参数
	private void init(String path) {
		
		InputStream is=FlyDataSource.class.getClassLoader().getResourceAsStream(path);
		Properties prop=new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			throw new RuntimeException("连接池参数初始化失败",e);
		}

		setDriverClassName(prop.getProperty("driverClassName"));
		setUrl(prop.getProperty("url"));
		setUsername(prop.getProperty("username"));
		setPassword(prop.getProperty("password"));

		setInit(getInt(prop.getProperty("init"),init));
		setMin(getInt(prop.getProperty("min"),min));
		setMax(getInt(prop.getProperty("max"),max));
		
		String ispool=prop.getProperty("ispool");
		if(ispool!=null) {
			this.ispool=Boolean.valueOf(ispool);
		}
		
	}
	//根据配置信息加载一条链接
	private Connection loadConnection() {
		try {
			Connection connection=DriverManager.getConnection(url,username,password);
			if(ispool==false) {
				return connection;	//不启用连接池将不再代理
			}
			return new FlyConnectionProxy(connection).setFlyDataSource(this).getProxy(Connection.class);//返回代理对象
		} catch (SQLException e) {
			throw new RuntimeException("创建连接失败：",e);
		}
	}
	//尝试释放一条链接
	private void closeConn(Connection conn){
		((FlyConnectionProxy)Proxy.getInvocationHandler(conn)).closeClose();//真正的关闭
	}
	//初始化池
	private void initPool(){
		if(conns==null){
			conns=new LinkedList<Connection>();
		}
		for (int i = conns.size(); i < init; i++) {
			conns.add(loadConnection());
		}
	}
	
	
	/** 获取一条连接  */
	@Override
	public Connection getConnection() throws SQLException {
		if(ispool==false) {
			return loadConnection();
		}
		if(conns.size()<min||conns.size()==0){
			initPool();
		}
		return conns.removeFirst();
	}
	/** 获取一条连接,此方法参数无效  */
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return getConnection();
	}
	/**
	 * 获取池中连接数
	 */
	public int getPoolCount(){
		return conns.size();
	}
	/**
	 * 回收一条连接，不是从本连接池中取出的不要让本池回收
	 */
	public void callBackConn(Connection conn){
		try {
			if(conn==null){
				return;
			}else if(ispool==false||conn.isClosed()||conns.size()>=max){
				closeConn(conn);
			}else{
				if(conn.getAutoCommit()==false){
					conn.rollback();
				}
				conns.add(conn);
			}
		} catch (SQLException e) {
			throw new RuntimeException("回收连接失败",e);
		}
	}

	
	
	
	
	//一坨坨 set get
	/**
	 * @return the driverClassName
	 */
	public String getDriverClassName() {
		return driverClassName;
	}
	/**
	 * @param driverClassName the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(driverClassName+"驱动加载异常：",e);
		}
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the pwd
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the init
	 */
	public int getInit() {
		return init;
	}
	/**
	 * @param init the init to set
	 */
	public void setInit(int init) {
		this.init = init;
	}
	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	/**
	 * @return 是否使用连接池，其值若为false，则代表不再使用连接池
	 */
	public boolean isIspool() {
		return ispool;
	}
	/**
	 * @param ispool 是否使用连接池，其值若为false，则代表不再使用连接池
	 */
	public void setIspool(boolean ispool) {
		this.ispool = ispool;
	}
	
	
	//这么多属性烦的一笔
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	/* * 默认静态连接池  */
	
	private static DataSource defaultDataSource;
	/**
	 * 获得defaultDataSource
	 */
	public static DataSource getdefaultDataSource() {
		if(defaultDataSource==null) {
			setdefaultDataSource(new FlyDataSource("sqlfly.properties"));
		}
		return defaultDataSource;
	}
	/**
	 * 写入指定defaultDataSource，注意：如果defaultDataSource已存在，调用此方法无效
	 * <br>如果你在实例化SqlFly前并没有指定defaultDataSource,那将使用Fly默认的连接池
	 */
	public synchronized static void setdefaultDataSource(DataSource dataSource) {
		if(FlyDataSource.defaultDataSource!=null) {
			return;	//万一并发了呢,这样才能保证万无一失
		}
		FlyDataSource.defaultDataSource=dataSource;
	}
	
	
}
