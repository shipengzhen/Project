package com.yy.util;



public class XSS {

	/**
	 * ת�Ƶ������ַ�<��>��on��script 
	 */
	public static String TH(String str) {
		String reg="^<|>|(?i)script|(?i)on$/gi";
		return str.replaceAll(reg,"0");
	}
	
	/**
	 * ת�Ƶ������ַ�on��script 
	 */
	public static String THText(String str) {
		String reg="^(?i)script|(?i)on$/gi";
		return str.replaceAll(reg,"0");
	}
	
	
}
