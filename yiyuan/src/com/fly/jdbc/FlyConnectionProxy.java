package com.fly.jdbc;

import java.lang.reflect.*;
import java.sql.Connection;

/**
 * Fly��̬����Connection���Ա���Connection����close()ʱ���������Ĺرգ����ǽ������·ŵ����ӳ���
 */
class FlyConnectionProxy implements InvocationHandler{

	private Connection connection;	//��Ҫ������Ķ���
	
	/**
	 * ����һ���������
	 * @param obj ��Ҫ������Ķ���
	 */
	public FlyConnectionProxy(Connection connection) {
		this.connection=connection;
	}
	
	/**
	 * ����obj�䶯̬����Ķ�����ע��c���ͱ����Ǹ��ӿڣ���obj�Ѿ�ʵ������
	 */
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> c) {
		return (T)Proxy.newProxyInstance(FlyConnectionProxy.class.getClassLoader(),
				new Class[] {c} , this);
	}


	//������رշ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("close")) {
			dataSource.callBackConn(connection);	//֪ͨ���ӳػ��մ�����
			return null;
		}
		return method.invoke(connection, args);	//ִ�д˵ײ㷽��
	}
	//�����Ĺرշ���
	public void closeClose() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//���󶨵����ӳ�
	private FlyDataSource dataSource;
	public FlyConnectionProxy setFlyDataSource(FlyDataSource dataSource) {
		this.dataSource=dataSource;
		return this;
	}
	
}
