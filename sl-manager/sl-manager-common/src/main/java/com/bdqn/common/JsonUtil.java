package com.bdqn.common;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public abstract class JsonUtil {
	
	private final static String SUCCESS_CODE="200";
	private final static String ERRPR_CODE="500";
	
	private JsonUtil() {
		throw new RuntimeException();
	}
	
	public static String success() {
		Map<String,String> map=new HashMap<String,String>(2);
		map.put("code", SUCCESS_CODE);
		return JSONObject.fromObject(map).toString();
	}
	
	public static String success(Object obj) {
		Map<String,Object> map=new HashMap<String,Object>(4);
		map.put("code", SUCCESS_CODE);
		map.put("data", obj);
		return JSONObject.fromObject(map).toString();
	}
	public static String error(String msg) {
		Map<String,String> map=new HashMap<String,String>(4);
		map.put("code", ERRPR_CODE);
		map.put("data", msg);
		return JSONObject.fromObject(map).toString();
	}
	
	

}
