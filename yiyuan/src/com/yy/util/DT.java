package com.yy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ��Ĺ�����
 */
public class DT {

	/**
	 * ����ָ��ʱ���YYYY-MM-dd hh:mm:ss �ַ�����ʽ
	 */
	public static String getDTString(Date d){
		return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(d);
	}
	
	
	/**
	 * ��һ���ַ���ת��Ϊ���ڸ�ʽ��YYYY-MM-dd HH:mm:ss��
	 */
	public static Date getDT(String d) throws ParseException{
		return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(d);
	}
	
	/**
	 * ����ϵͳ��ǰʱ���YYYY-MM-dd hh:mm:ss �ַ�����ʽ
	 */
	public static String getNow(){
		return getDTString(new Date());
	}
	
}
