package com.yy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间的工具类
 */
public class DT {

	/**
	 * 返回指定时间的YYYY-MM-dd hh:mm:ss 字符串格式
	 */
	public static String getDTString(Date d){
		return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(d);
	}
	
	
	/**
	 * 将一个字符串转换为日期格式（YYYY-MM-dd HH:mm:ss）
	 */
	public static Date getDT(String d) throws ParseException{
		return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(d);
	}
	
	/**
	 * 返回系统当前时间的YYYY-MM-dd hh:mm:ss 字符串格式
	 */
	public static String getNow(){
		return getDTString(new Date());
	}
	
}
