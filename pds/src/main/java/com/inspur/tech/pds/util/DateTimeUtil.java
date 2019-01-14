package com.inspur.tech.pds.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	/**
	 * @功能描述：Date转成String
	 * @参数说明：@param date
	 * @参数说明：@param format
	 * @参数说明：@return @作者： shipengzhen
	 * @创建时间：2018年8月1日 下午4:29:46
	 */
	public static String dateChangeString(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String string = simpleDateFormat.format(date);// Date转String
		return string;
	}

	/**
	 * @功能描述：String转成Date
	 * @参数说明：@param date
	 * @参数说明：@param format
	 * @参数说明：@return
	 * @参数说明：@throws ParseException @作者： shipengzhen
	 * @创建时间：2018年8月19日 下午8:55:14
	 */
	public static Date stringChangeDate(String date, String format) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.parse(date);// String转Date
	}

	/**
	 * @功能描述：转变String的日期格式
	 * @参数说明：@param date
	 * @参数说明：@param oldFormat
	 * @参数说明：@param newFormat
	 * @参数说明：@return
	 * @参数说明：@throws ParseException @作者： shipengzhen
	 * @创建时间：2018年8月19日 下午9:05:01
	 */
	public static String formatStringDate(String date, String oldFormat, String newFormat) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(oldFormat);
		Date dt = simpleDateFormat.parse(date);// String转Date
		simpleDateFormat = new SimpleDateFormat(newFormat);
		String string = simpleDateFormat.format(dt);// Date转String
		return string;
	}
}
