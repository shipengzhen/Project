package com.yy.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Web工具类
 */
public class WebFly {
	
	/**
	 * 将一个字符串ISO-8859-1转码UTF-8
	 */
	public static String getUtf8(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 如果一个字符串为(null,"","null")，则转化为指定值
	 */
	public static String toStr(String str,String toStr){
		if(str==null||str.equals("")||str.equals("null")){
			return toStr;
		}
		return str;
	}
	
	/**
	 * 如果该货不能转成一个数字，则返回指定值
	 */
	public static Integer toInt(String str,Integer toInt){
		try {
			return new Integer(str);
		} catch (Exception e) {
			return toInt;
		}
	}
	
	/**
	 * 取出一个值，我保证不乱码
	 */
	public static String getParam(HttpServletRequest request,String key){
		try {
			request.setCharacterEncoding("UTF-8");
			String value=request.getParameter(key);	//获得v
			if(value!=null&&request.getMethod().equals("GET")){
				value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
			}
			return value;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	/**
	 * 将一个request请求所携带的参数封装成map返回
	 * <br/>对于数组型参数，此方法不能正确获得值
	 * @param request
	 * @return
	 */
	public static Map<String,String>getParamsMap(HttpServletRequest request){
		Map<String,String>map=new HashMap<String, String>();
		try {
			Enumeration<String> paramNames = request.getParameterNames();//获得K列表
			request.setCharacterEncoding("UTF-8");
			while (paramNames.hasMoreElements()) {  
				try {
					String key =paramNames.nextElement();	//获得k
					String value=request.getParameter(key);	//获得v
					if(request.getMethod().equals("GET")){
						value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
					}
					map.put(key,value);	
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return map;
	}
	
	/**
	 * <h1>将一个request里的参数，赋值给一个obj对象</h1>
	 * <br/>并且你可以指定自定义映射,map的K是request的K,V是obj的属性名字
	 * <br/>例如map.put("id","userid")代表让request中的id值映射到obj的userid属性里
	 */
	public static <T>T setParamsObj(HttpServletRequest request,T obj,Map<String,String>map){
		try {
			request.setCharacterEncoding("UTF-8");
			Enumeration<String> keys = request.getParameterNames();//获得K列表
			if(map==null){
				map=new HashMap<String, String>();
			}
			//自动挡添加到手动挡
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				if(map.containsKey(key)==false){
					map.put(key,key);
				}
			}
			//自动挡+手动挡，自定义映射
			for (String key : map.keySet()) {
				try {
					Field pf=obj.getClass().getDeclaredField(map.get(key));
					pf.setAccessible(true);
					String value=request.getParameter(key);
					if(request.getMethod().equals("GET")){
						value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
					}
					Object prop=getStrType(value,pf.getType());
					pf.set(obj,prop);//写入属性
				} catch (Exception e) {
					//e.printStackTrace();//找不到属性
				} 
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return obj;
	}
	
	//将str转化为指定的类型
	public static Object getStrType(String str,Class<?> c){
		String type=c.getName();//获取类型信息
		try {
			if (type.equalsIgnoreCase("java.lang.String")) {
				return str;
			} else if (type.equalsIgnoreCase("int")||type.equalsIgnoreCase("java.lang.Integer")) {
	        	return new Integer(str);
	        } else if (type.equalsIgnoreCase("long")||type.equalsIgnoreCase("java.lang.Long")) {
				return new Long(str);
	        } else if (type.equalsIgnoreCase("short")||type.equalsIgnoreCase("java.lang.Short")) {
	        	return new Short(str);
	        } else if (type.equalsIgnoreCase("float")||type.equalsIgnoreCase("java.lang.Float")) {
	        	return new Float(str);
	        } else if (type.equalsIgnoreCase("double")||type.equalsIgnoreCase("java.lang.Double")) {
	        	return new Double(str);
	        } else if (type.equalsIgnoreCase("boolean")||type.equalsIgnoreCase("java.lang.Boolean")) {
	        	return new Boolean(str);
	        } else if(type.equals("java.sql.Date")){
				return java.sql.Date.valueOf(str);
			} else if(c.equals(java.sql.Timestamp.class)){
				java.util.Date date=(java.util.Date)getStrType(str, java.util.Date.class);
				return new java.sql.Timestamp(date.getTime());
			} else if (type.equals("java.util.Date")) {
	        	try {
	        		return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(str);
				} catch (Exception e) {
					return java.sql.Date.valueOf(str);
				}
			}else{
				//还能有什么类型？
				//System.out.println("超纲类型："+type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回请求端的IP地址
	 */
	public static String getRemoteHost(HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	
	
	//将一个字符串转化为
	
	
}
