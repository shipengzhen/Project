package com.yy.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Web������
 */
public class WebFly {
	
	/**
	 * ��һ���ַ���ISO-8859-1ת��UTF-8
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
	 * ���һ���ַ���Ϊ(null,"","null")����ת��Ϊָ��ֵ
	 */
	public static String toStr(String str,String toStr){
		if(str==null||str.equals("")||str.equals("null")){
			return toStr;
		}
		return str;
	}
	
	/**
	 * ����û�����ת��һ�����֣��򷵻�ָ��ֵ
	 */
	public static Integer toInt(String str,Integer toInt){
		try {
			return new Integer(str);
		} catch (Exception e) {
			return toInt;
		}
	}
	
	/**
	 * ȡ��һ��ֵ���ұ�֤������
	 */
	public static String getParam(HttpServletRequest request,String key){
		try {
			request.setCharacterEncoding("UTF-8");
			String value=request.getParameter(key);	//���v
			if(value!=null&&request.getMethod().equals("GET")){
				value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
			}
			return value;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	/**
	 * ��һ��request������Я���Ĳ�����װ��map����
	 * <br/>���������Ͳ������˷���������ȷ���ֵ
	 * @param request
	 * @return
	 */
	public static Map<String,String>getParamsMap(HttpServletRequest request){
		Map<String,String>map=new HashMap<String, String>();
		try {
			Enumeration<String> paramNames = request.getParameterNames();//���K�б�
			request.setCharacterEncoding("UTF-8");
			while (paramNames.hasMoreElements()) {  
				try {
					String key =paramNames.nextElement();	//���k
					String value=request.getParameter(key);	//���v
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
	 * <h1>��һ��request��Ĳ�������ֵ��һ��obj����</h1>
	 * <br/>���������ָ���Զ���ӳ��,map��K��request��K,V��obj����������
	 * <br/>����map.put("id","userid")������request�е�idֵӳ�䵽obj��userid������
	 */
	public static <T>T setParamsObj(HttpServletRequest request,T obj,Map<String,String>map){
		try {
			request.setCharacterEncoding("UTF-8");
			Enumeration<String> keys = request.getParameterNames();//���K�б�
			if(map==null){
				map=new HashMap<String, String>();
			}
			//�Զ�����ӵ��ֶ���
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				if(map.containsKey(key)==false){
					map.put(key,key);
				}
			}
			//�Զ���+�ֶ������Զ���ӳ��
			for (String key : map.keySet()) {
				try {
					Field pf=obj.getClass().getDeclaredField(map.get(key));
					pf.setAccessible(true);
					String value=request.getParameter(key);
					if(request.getMethod().equals("GET")){
						value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
					}
					Object prop=getStrType(value,pf.getType());
					pf.set(obj,prop);//д������
				} catch (Exception e) {
					//e.printStackTrace();//�Ҳ�������
				} 
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return obj;
	}
	
	//��strת��Ϊָ��������
	public static Object getStrType(String str,Class<?> c){
		String type=c.getName();//��ȡ������Ϣ
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
				//������ʲô���ͣ�
				//System.out.println("�������ͣ�"+type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��������˵�IP��ַ
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
	
	
	//��һ���ַ���ת��Ϊ
	
	
}
