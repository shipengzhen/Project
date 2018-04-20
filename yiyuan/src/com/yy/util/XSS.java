package com.yy.util;



public class XSS {

	/**
	 * ×ªÒÆµôÌØÊâ×Ö·û<¡¢>¡¢on¡¢script 
	 */
	public static String TH(String str) {
		String reg="^<|>|(?i)script|(?i)on$/gi";
		return str.replaceAll(reg,"0");
	}
	
	/**
	 * ×ªÒÆµôÌØÊâ×Ö·ûon¡¢script 
	 */
	public static String THText(String str) {
		String reg="^(?i)script|(?i)on$/gi";
		return str.replaceAll(reg,"0");
	}
	
	
}
