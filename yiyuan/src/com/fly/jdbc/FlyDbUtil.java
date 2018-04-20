package com.fly.jdbc;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;


/**
 * Fly�����ݿ���ʵ���ײ���
 * <p>�㲻��Ҫ���ô����API����ΪSqlFly��Դ�������˸������ķ�װ
 */
class FlyDbUtil {

	
	//API
	
	/* * * * * * * * * * * * * �ͷ���Դ * * * * * * * * * * * * * * * * * * * * */
	/** �ͷ�ResultSet */
	static void close(ResultSet rs){
		try {
			if(rs!=null){
				rs.getStatement().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("�ͷ�ResultSet����Statementʧ��",e);
		}
	}
	
	/* * * * * * * * * * * * * �������� * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * ִ����������sql��argsΪ�����б�(���ຯ��ͬ��)
	 * <p>����ִ�к��PreparedStatement�����ڴ˻����ϣ�����ԣ�
	 * <p>ps.getResultSet() ���ؽ����
	 * <p>ps.getUpdateCount() ������Ӱ���������ȵȡ���
	 * @throws SQLException 
	 */
	static PreparedStatement getExecute(Connection connection,String sql,Object...args) throws SQLException {
		PreparedStatement pst=connection.prepareStatement(sql);
		if(args!=null){
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i+1,args[i]);
			}
		}
		pst.execute();
		return pst;
	}

	/* * * * * * * * * * * * * �����ӳ�� * * * * * * * * * * * * * * * * * * * * */
	/**
	 * �������ӳ��Ϊ--List< Map >����
	 * @throws SQLException 
	 */
	static List<Map<String,Object>> getListMap(ResultSet rs) throws SQLException{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		ResultSetMetaData md = rs.getMetaData();
		while (rs.next()) {
			Map<String,Object> rowData = new HashMap<String,Object>();
	        for (int i = 1; i <= md.getColumnCount(); i++){
	        	rowData.put(md.getColumnName(i), rs.getObject(i));
	        }
	        list.add(rowData);
		}
        return list;
	}
	
	/**
	 * <b>�������ӳ��Ϊָ��Model����</b>
	 */
	static<T> List<T> getList(ResultSet rs,Class<T> cs) {
		List<T>objList=new ArrayList<T>();
		try {
			while(rs.next()){
				objList.add(getVal_Obj(rs, cs));
			}
		} catch (Exception e) {
			throw new RuntimeException(cs.getCanonicalName()+"����ת��List<T>����",e);
		}
		return objList;
	}
	
	/**
	 * �������ӳ��Ϊ�����������͵ļ��ϣ���Integer��Double��
	 */
	@SuppressWarnings("unchecked")
	static<T> List<T> getBaseList(ResultSet rs,Class<T> cs){
		List<T>list=new ArrayList<T>();
		try {
			ResultSetMetaData md = rs.getMetaData();
			String key=md.getColumnName(1);
			while(rs.next()) {
				list.add((T)getVal_KC(rs, key, cs));
			}
		} catch (Exception e) {
			throw new RuntimeException(cs.getCanonicalName()+"����ӳ�����",e);
		}
		return list;
	}
	
	
	/* * * * * * * * * * * * * FlyDbUtil˽��  * * * * * * * * * * * * * * * * * * * * */
	
	//��[ResultSet]��ȡֵ����ֵ��ָ��[����]��Object�ϣ�������
	private static<T> T getVal_Obj(ResultSet rs,Class<T> cs) throws InstantiationException, IllegalAccessException{
		T obj=cs.newInstance();	//ʵ��������
		
		for (AtFlyCache ac : getAtFlyCache(cs)) {
			try {
				if(ac.orm==false) {continue;}
				Object value=getVal_KC(rs, ac.column, cs);	//ָ��ֵ
				if(ac.set==null) {
					ac.field.set(obj, value);	//������set
				}else if(ac.set.equals("pojo")) {
					ac.field.set(obj, getVal_Obj(rs, ac.field.getType()));	//�ݹ�ӳ��
				}else {
					for (Method m : obj.getClass().getDeclaredMethods()) {
						if(m.getName().equals(ac.set)){
							m.invoke(obj,value);break;
						}
					}
					throw new RuntimeException("�Ҳ���"+ac.set+"����Ϊ�ֶ�"+ac.field.getName()+"��ֵ");
				}
			} catch (IllegalArgumentException e) {
				//e.printStackTrace();	�Զ���ʱ������Fieldû�д����Դ���
			} catch (Exception e) {
				throw new RuntimeException("�ֶ�"+ac.field.getName()+"��ֵʱ��������",e);
			}
		}
		
		return obj;
	}
	
	//����8�������������+3��Date
	//��[ResultSet]ȡ��ָ������[key]��ֵ������[ָ��ȡֵ��ʽ]
	private static Object getVal_KC(ResultSet rs,String key,Class<?>cs) {
		try {
			if (cs.equals(String.class)) {
				return rs.getString(key);
			} else if (cs.equals(int.class)||cs.equals(Integer.class)) {
	        	return rs.getInt(key);
	        } else if (cs.equals(long.class)||cs.equals(Long.class)) {
				return rs.getLong(key);
	        } else if (cs.equals(short.class)||cs.equals(Short.class)) {
	        	return rs.getShort(key);
	        } else if (cs.equals(byte.class)||cs.equals(Byte.class)) {
	        	return rs.getByte(key);
	        } else if (cs.equals(float.class)||cs.equals(Float.class)) {
	        	return rs.getFloat(key);
	        } else if (cs.equals(double.class)||cs.equals(Double.class)) {
	        	return rs.getDouble(key);
	        } else if (cs.equals(boolean.class)||cs.equals(Boolean.class)) {
	        	return rs.getBoolean(key);
	        } else if (cs.equals(char.class)||cs.equals(Character.class)) {
	        	return rs.getString(key).charAt(0);
	        } else if (cs.equals(java.sql.Timestamp.class)||cs.equals(java.util.Date.class)) {
	        	return rs.getTimestamp(key);
			} else if (cs.equals(java.sql.Date.class)) {
	        	return new java.sql.Date(rs.getTimestamp(key).getTime());
			} else{
				return rs.getObject(key);	//����ƥ�䣬���Ƽ��İ�
	        }
		} catch (SQLException e) {
			return null;
		}
	}
	
	//AtFlyCacheȡֵ��ʽ����
	private static class AtFlyCache{
		Field field;	//�������ֶ�
		boolean orm=true;	//�Ƿ����Fly��ӳ��
		String set;		//����set
		String column;	//��Ӧtable��
	}
	
	//�������Ͷ�ȡ��ʽ��������Ƶ��������ɵ���������
	private static Map<Class<?>,List<AtFlyCache>>AtFlyCacheMap=new HashMap<Class<?>,List<AtFlyCache>>();
	
	//���ָ�����͵�ע�⻺�棬û�оͶ�ȡ����һ��
	private static List<AtFlyCache> getAtFlyCache(Class<?> cs) {
		if (AtFlyCacheMap.containsKey(cs) == false) {
			setAtFlyCache(cs);
		}
		return AtFlyCacheMap.get(cs);
	}

	//����ָ�����͵Ļ���
	private synchronized static void setAtFlyCache(Class<?>cs){
		if (AtFlyCacheMap.containsKey(cs) == true) {
			return;		//��ֹ����ʱ�ظ�д��
		}
		List<AtFlyCache>afcList=new ArrayList<AtFlyCache>();
		for (Field field : cs.getDeclaredFields()) {
			field.setAccessible(true);		//��˽������
			AtFlyCache afc=new AtFlyCache();
			afc.field=field;			//����
			afc.column=field.getName();	//��Ӧ��
			if(field.isAnnotationPresent(AtFly.class)==true){
				AtFly at=field.getAnnotation(AtFly.class);
				afc.orm=at.orm();
				if(at.set().equals("")==false) {
					afc.set=at.set();
				}
				if(at.column().equals("")==false) {
					afc.column=at.column();
				}
			}
			afcList.add(afc);
		}
		AtFlyCacheMap.put(cs, afcList);
	}
	
	
	
	
	
}
