package com.jeefuse.base.utils.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查用效性工具类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class CheckUtils {
	final static String pattern_email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	final static String pateern_mobile = "^(13[0-9]|15[0-9]|18[7|8|9|6|5])\\d{4,8}$";

	public static boolean checkDate(String date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = df.parse(date);
		} catch (Exception e) {
			//如果不能转换,肯定是错误格式
			return false;
		}
		String s1 = df.format(d);
		// 转换后的日期再转换回String,如果不等,逻辑错误.如format为"yyyy-MM-dd",date为
		// "2006-02-31",转换为日期后再转换回字符串为"2006-03-03",说明格式虽然对,但日期
		// 逻辑上不对.
		return date.equals(s1);
	}

	/**
	 * 检查是否有效邮箱地址.
	 */
	public static boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile(pattern_email);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches())
			return true;
		return false;
	}

	/**
	 * 检查是否有效手机号码
	 */
	public static boolean checkMobile(String phone) {
		Pattern pattern = Pattern.compile(pateern_mobile);
		Matcher matcher = pattern.matcher(phone);
		if (matcher.matches())
			return true;
		return false;
	}
}
