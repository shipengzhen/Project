package com.yy.util;
/**
 * Json�࣬�����
 * @author kong
 *
 */

import com.alibaba.fastjson.JSONObject;

public class Json extends JSONObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -903366395577524343L;




	public Json() {
		
	}
	
	public Json(String key,Object value) {
		put(key, value);
	}
	
	
	
	
	/**
	 * ������֯����һ��Json�ַ���
	 */
	public static String toStr(String key,Object value) {
		return new Json(key,value).toString();
	}
	
	
	
	
}
