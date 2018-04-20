package com.fly.jdbc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Fly,�ô��������
 * <p>��Ϊ�����࣬Fly�ṩ��SqlFly������һЩ���õĺ�������Ȼ��Щ�������ܼ򵥣������ǵ�ȷ����ʹ��Ĵ���������� 
 */
public class Fly {
	
	
	private static ThreadLocal<SqlFly> SYTL = new ThreadLocal<SqlFly>();
	 
	/**
	 * ���ص�ǰ�߳����󶨵�SqlFly����
	 * <br/>������Ҫ���п�㲢�Ҷ��Dao����������ʱ���˺������ǳ�����
	 */
	public static SqlFly getFly(){
		if(SYTL.get()==null){
			SYTL.set(new SqlFly());
		}
		return SYTL.get();
	}
	
	/**
	 * ������װһ��Object[]
	 */
	public static Object[] doArrayObj(Object... arg){
		return arg;
	}
	
	/**
	 * ������װһ��List< Object >
	 */
	public static List<Object> doListObj(Object... args){
		List<Object>list=new ArrayList<Object>();
		for (Object object : args) {
			list.add(object);
		}
		return list;
	}
	
	/**
	 * ������װһ��List< String >
	 */
	public static List<String> doArrayStr(String... arg){
		List<String>list=new ArrayList<String>();
		for (String str : list) {
			list.add(str);
		}
		return list;
	}
	
	/**
	 * <h1>������װһ��Map< S,S >����</h1>
	 */
	public static Map<String, String> doMapStrStr(String... args){
		Map<String, String>map=new HashMap<String, String>();
		for (int i=1;i<args.length;i+=2) {
			map.put(args[i-1], args[i]);
		}
		return map;
	}

	/**
	 * <h1>������װһ��Map< S,O >����</h1>
	 */
	public static Map<String, Object> doMapStrObj(Object... args){
		Map<String, Object>map=new HashMap<String, Object>();
		for (int i=1;i<args.length;i+=2) {
			map.put(args[i-1].toString(), args[i]);
		}
		return map;
	}
	
	/**
	 * ��ָ�������ĩβ׷��Ԫ��(�˷������½����飬��˷��ص����鲢����ԭ��������)
	 * <br/>
	 */
	public static Object[]ArrayAdd(Object[]array,Object...args){
		Object[] newArray=new Object[array.length+args.length];
		System.arraycopy(array, 0, newArray, 0, array.length);
		for (int i = 0; i < args.length; i++) {
			newArray[array.length+i]=args[i];
		}
		return newArray;
	}
	
	/**
	 * ��̬sql��������[׷��sql,��������,Ҫ׷�ӵĲ���...]����׷��sql
	 * <p>���ڶ�̬Sql��ǣ���������������⣬�������ݶ��ڴ濪���ϴ�
	 * <p>���ԣ�Fly������������������������ϣ�����ٵ���args.toArray()ת������
	 */
	public static String sqlAppend(String sqlAppend,List<Object>args,Object...arg) {
		for (Object obj : arg) {
			args.add(obj);
		}
		return sqlAppend;
	}
	
	
	
	
	/**
	 * ����һ�����͸���(��ӿ�)�з��������������
	 */
	static Class<?> getAbsT  (Class<?> clz) {
		Type type=clz.getGenericSuperclass();	//�������
		if(!(type instanceof ParameterizedType)){  
			return Object.class;  
		}
		Type[] params = ((ParameterizedType)type).getActualTypeArguments();
		if(!(params[0] instanceof Class)) {  
			return Object.class;  
		}  
		return (Class<?>) params[0];
	} 
	
}


