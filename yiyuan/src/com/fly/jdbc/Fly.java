package com.fly.jdbc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Fly,让代码飞起来
 * <p>作为工具类，Fly提供了SqlFly操作中一些常用的函数，虽然这些函数功能简单，但它们的确可以使你的代码更加优雅 
 */
public class Fly {
	
	
	private static ThreadLocal<SqlFly> SYTL = new ThreadLocal<SqlFly>();
	 
	/**
	 * 返回当前线程所绑定的SqlFly对象
	 * <br/>当你想要进行跨层并且多个Dao类的事务操作时，此函数将非常有用
	 */
	public static SqlFly getFly(){
		if(SYTL.get()==null){
			SYTL.set(new SqlFly());
		}
		return SYTL.get();
	}
	
	/**
	 * 快速组装一个Object[]
	 */
	public static Object[] doArrayObj(Object... arg){
		return arg;
	}
	
	/**
	 * 快速组装一个List< Object >
	 */
	public static List<Object> doListObj(Object... args){
		List<Object>list=new ArrayList<Object>();
		for (Object object : args) {
			list.add(object);
		}
		return list;
	}
	
	/**
	 * 快速组装一个List< String >
	 */
	public static List<String> doArrayStr(String... arg){
		List<String>list=new ArrayList<String>();
		for (String str : list) {
			list.add(str);
		}
		return list;
	}
	
	/**
	 * <h1>快速组装一个Map< S,S >集合</h1>
	 */
	public static Map<String, String> doMapStrStr(String... args){
		Map<String, String>map=new HashMap<String, String>();
		for (int i=1;i<args.length;i+=2) {
			map.put(args[i-1], args[i]);
		}
		return map;
	}

	/**
	 * <h1>快速组装一个Map< S,O >集合</h1>
	 */
	public static Map<String, Object> doMapStrObj(Object... args){
		Map<String, Object>map=new HashMap<String, Object>();
		for (int i=1;i<args.length;i+=2) {
			map.put(args[i-1].toString(), args[i]);
		}
		return map;
	}
	
	/**
	 * 在指定数组的末尾追加元素(此方法会新建数组，因此返回的数组并不是原来的数组)
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
	 * 动态sql辅助方法[追加sql,参数集合,要追加的参数...]返回追加sql
	 * <p>对于动态Sql，牵扯到数组扩容问题，这种扩容对内存开销较大，
	 * <p>所以：Fly建议的做法是先声明参数集合，最后再调用args.toArray()转回数组
	 */
	public static String sqlAppend(String sqlAppend,List<Object>args,Object...arg) {
		for (Object obj : arg) {
			args.add(obj);
		}
		return sqlAppend;
	}
	
	
	
	
	/**
	 * 返回一个类型父类(或接口)中泛型所代表的类型
	 */
	static Class<?> getAbsT  (Class<?> clz) {
		Type type=clz.getGenericSuperclass();	//获得类型
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


