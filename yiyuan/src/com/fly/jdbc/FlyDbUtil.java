package com.fly.jdbc;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;


/**
 * Fly对数据库访问的最底层类
 * <p>你不需要调用此类的API，因为SqlFly类对此类进行了更完美的封装
 */
class FlyDbUtil {

	
	//API
	
	/* * * * * * * * * * * * * 释放资源 * * * * * * * * * * * * * * * * * * * * */
	/** 释放ResultSet */
	static void close(ResultSet rs){
		try {
			if(rs!=null){
				rs.getStatement().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("释放ResultSet或其Statement失败",e);
		}
	}
	
	/* * * * * * * * * * * * * 基本交互 * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * 执行任意类型sql，args为参数列表(其余函数同理)
	 * <p>返回执行后的PreparedStatement对象，在此基础上，你可以：
	 * <p>ps.getResultSet() 返回结果集
	 * <p>ps.getUpdateCount() 返回受影响行数，等等……
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

	/* * * * * * * * * * * * * 结果集映射 * * * * * * * * * * * * * * * * * * * * */
	/**
	 * 将结果集映射为--List< Map >集合
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
	 * <b>将结果集映射为指定Model集合</b>
	 */
	static<T> List<T> getList(ResultSet rs,Class<T> cs) {
		List<T>objList=new ArrayList<T>();
		try {
			while(rs.next()){
				objList.add(getVal_Obj(rs, cs));
			}
		} catch (Exception e) {
			throw new RuntimeException(cs.getCanonicalName()+"类型转换List<T>出错：",e);
		}
		return objList;
	}
	
	/**
	 * 将结果集映射为基本数据类型的集合，如Integer、Double等
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
			throw new RuntimeException(cs.getCanonicalName()+"类型映射出错：",e);
		}
		return list;
	}
	
	
	/* * * * * * * * * * * * * FlyDbUtil私货  * * * * * * * * * * * * * * * * * * * * */
	
	//从[ResultSet]里取值，赋值到指定[类型]的Object上，并返回
	private static<T> T getVal_Obj(ResultSet rs,Class<T> cs) throws InstantiationException, IllegalAccessException{
		T obj=cs.newInstance();	//实例化对象
		
		for (AtFlyCache ac : getAtFlyCache(cs)) {
			try {
				if(ac.orm==false) {continue;}
				Object value=getVal_KC(rs, ac.column, cs);	//指定值
				if(ac.set==null) {
					ac.field.set(obj, value);	//无特殊set
				}else if(ac.set.equals("pojo")) {
					ac.field.set(obj, getVal_Obj(rs, ac.field.getType()));	//递归映射
				}else {
					for (Method m : obj.getClass().getDeclaredMethods()) {
						if(m.getName().equals(ac.set)){
							m.invoke(obj,value);break;
						}
					}
					throw new RuntimeException("找不到"+ac.set+"方法为字段"+ac.field.getName()+"赋值");
				}
			} catch (IllegalArgumentException e) {
				//e.printStackTrace();	自动挡时遇到的Field没有此属性错误
			} catch (Exception e) {
				throw new RuntimeException("字段"+ac.field.getName()+"赋值时发生错误：",e);
			}
		}
		
		return obj;
	}
	
	//处理8大基本数据类型+3种Date
	//从[ResultSet]取出指定列名[key]的值，根据[指定取值方式]
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
				return rs.getObject(key);	//都不匹配，给推荐的吧
	        }
		} catch (SQLException e) {
			return null;
		}
	}
	
	//AtFlyCache取值方式缓存
	private static class AtFlyCache{
		Field field;	//所代表字段
		boolean orm=true;	//是否接受Fly的映射
		String set;		//特殊set
		String column;	//对应table列
	}
	
	//缓存类型读取方式，以削减频繁反射造成的性能消耗
	private static Map<Class<?>,List<AtFlyCache>>AtFlyCacheMap=new HashMap<Class<?>,List<AtFlyCache>>();
	
	//获得指定类型的注解缓存，没有就读取创建一个
	private static List<AtFlyCache> getAtFlyCache(Class<?> cs) {
		if (AtFlyCacheMap.containsKey(cs) == false) {
			setAtFlyCache(cs);
		}
		return AtFlyCacheMap.get(cs);
	}

	//创建指定类型的缓存
	private synchronized static void setAtFlyCache(Class<?>cs){
		if (AtFlyCacheMap.containsKey(cs) == true) {
			return;		//防止并发时重复写入
		}
		List<AtFlyCache>afcList=new ArrayList<AtFlyCache>();
		for (Field field : cs.getDeclaredFields()) {
			field.setAccessible(true);		//打开私有属性
			AtFlyCache afc=new AtFlyCache();
			afc.field=field;			//属性
			afc.column=field.getName();	//对应列
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
