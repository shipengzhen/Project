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
 * FlyDataSource�ṩ���ӳص�һ������ʵ��
 * <p>�����ļ���Ĭ���ļ�����sqlfly.properties
 * <p>������MySqlΪ�ٸ�����
 * <textarea style="width: 60%;height: 500px;margin: 50px;">
########## ���� ##########

#���������ӵ�ַ���û�������
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/yixiao?useUnicode=true&characterEncoding=utf-8
username=root
password=root

########## ѡ�� ##########

#��ʼ��������(default=20),���б�����С������(default=10),�������������(default=50),�Ƿ��������ӳ�(default=true)
init=20
min=10
max=50
ispool=true
</textarea>
 */
public class FlyDataSource implements DataSource{

	//�������
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	private int init=20;			//��ʼ��������
	private int min=10;				//��С������
	private int max=50;				//���������
	public boolean ispool=true;		//�Ƿ�ʹ�����ӳأ���ֵ��Ϊfalse���������ʹ�����ӳ�
	
	private LinkedList<Connection>conns=new LinkedList<Connection>();	//���ӳ�

	public FlyDataSource() {	}
	public FlyDataSource(String path) {
		init(path);
	}
	
	//��nullתint,null����i
	private int getInt(String str,int i) {
		if(str==null) {
			return i;
		}
		return new Integer(str);
	}
	//����ָ����ַ����ʼ�����ӳز���
	private void init(String path) {
		
		InputStream is=FlyDataSource.class.getClassLoader().getResourceAsStream(path);
		Properties prop=new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			throw new RuntimeException("���ӳز�����ʼ��ʧ��",e);
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
	//����������Ϣ����һ������
	private Connection loadConnection() {
		try {
			Connection connection=DriverManager.getConnection(url,username,password);
			if(ispool==false) {
				return connection;	//���������ӳؽ����ٴ���
			}
			return new FlyConnectionProxy(connection).setFlyDataSource(this).getProxy(Connection.class);//���ش������
		} catch (SQLException e) {
			throw new RuntimeException("��������ʧ�ܣ�",e);
		}
	}
	//�����ͷ�һ������
	private void closeConn(Connection conn){
		((FlyConnectionProxy)Proxy.getInvocationHandler(conn)).closeClose();//�����Ĺر�
	}
	//��ʼ����
	private void initPool(){
		if(conns==null){
			conns=new LinkedList<Connection>();
		}
		for (int i = conns.size(); i < init; i++) {
			conns.add(loadConnection());
		}
	}
	
	
	/** ��ȡһ������  */
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
	/** ��ȡһ������,�˷���������Ч  */
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return getConnection();
	}
	/**
	 * ��ȡ����������
	 */
	public int getPoolCount(){
		return conns.size();
	}
	/**
	 * ����һ�����ӣ����Ǵӱ����ӳ���ȡ���Ĳ�Ҫ�ñ��ػ���
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
			throw new RuntimeException("��������ʧ��",e);
		}
	}

	
	
	
	
	//һ���� set get
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
			throw new RuntimeException(driverClassName+"���������쳣��",e);
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
	 * @return �Ƿ�ʹ�����ӳأ���ֵ��Ϊfalse���������ʹ�����ӳ�
	 */
	public boolean isIspool() {
		return ispool;
	}
	/**
	 * @param ispool �Ƿ�ʹ�����ӳأ���ֵ��Ϊfalse���������ʹ�����ӳ�
	 */
	public void setIspool(boolean ispool) {
		this.ispool = ispool;
	}
	
	
	//��ô�����Է���һ��
	
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

	
	/* * Ĭ�Ͼ�̬���ӳ�  */
	
	private static DataSource defaultDataSource;
	/**
	 * ���defaultDataSource
	 */
	public static DataSource getdefaultDataSource() {
		if(defaultDataSource==null) {
			setdefaultDataSource(new FlyDataSource("sqlfly.properties"));
		}
		return defaultDataSource;
	}
	/**
	 * д��ָ��defaultDataSource��ע�⣺���defaultDataSource�Ѵ��ڣ����ô˷�����Ч
	 * <br>�������ʵ����SqlFlyǰ��û��ָ��defaultDataSource,�ǽ�ʹ��FlyĬ�ϵ����ӳ�
	 */
	public synchronized static void setdefaultDataSource(DataSource dataSource) {
		if(FlyDataSource.defaultDataSource!=null) {
			return;	//��һ��������,�������ܱ�֤����һʧ
		}
		FlyDataSource.defaultDataSource=dataSource;
	}
	
	
}
