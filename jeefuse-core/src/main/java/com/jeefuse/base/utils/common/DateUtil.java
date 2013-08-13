package com.jeefuse.base.utils.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.Assert;

/**
 * 日期工具类
 */
public class DateUtil extends org.apache.commons.lang.time.DateUtils {
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.CHINA);
	public static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss", java.util.Locale.CHINA);
	public static final DateFormat DATE_MINUTE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.CHINA);
	public static final DateFormat DATE_SESOND_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.CHINA);

	/**
	 * 返回当前时间
	 * 
	 */
	public static Date getCurrentDateTime() {
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(new Date());
		java.util.Date dtNow = calNow.getTime();
		return dtNow;
	}

	/**
	 * 获取当前的时间毫秒.
	 */
	public static long getCurrentTimeInMillis() {
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(new Date());
		return calNow.getTimeInMillis();
	}

	/**
	 * 返回当前时间转换成字符串.日期字符串匹配模式 例:yyyy-MM-dd-HH_mm.
	 * 
	 */
	public static String getCurrentDateTimeString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH_mm");
		return format.format(new Date());
	}

	/**
	 * 返回当前时间转换成字符串.日期字符串匹配模式 例:yyyy-MM-dd.
	 * 
	 */
	public static String getCurrentDateString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}

	/**
	 * @return 返回今天日期，时间部分为0。例如：2006-4-8 00:00:00
	 */
	public static Date getToday() {
		return truncate(new Date(), Calendar.DATE);
	}

	/**
	 * @return 返回今天日期，时间部分为23:59:59.999。例如：2006-4-19 23:59:59.999
	 */
	public static Date getTodayEnd() {
		return getDayEnd(new Date());
	}

	/**
	 * 将Date转换成字符串.
	 * 
	 * @param date
	 *            时间
	 * @param pattern
	 *            日期字符串匹配模式 例:yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDate(Date date, String pattern) {
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将Date转换成字符串.
	 * 
	 * @param date
	 *            时间
	 */
	public static String formatDate(Date date, DateFormat format) {
		if (null == date)
			return null;
		return format.format(date);
	}

	/**
	 * 将Date转换成字符串.
	 * 
	 * @param date
	 *            时间
	 * @param pattern
	 *            日期字符串匹配模式 例:yyyy-MM-dd
	 */
	public static String formatDate(Date date) {
		if (null == date)
			return null;
		return DATE_FORMAT.format(date);
	}

	/**
	 * 将Date转换成字符串.日期字符串匹配模式 例:yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 *            时间
	 */
	public static String formatDateTime(Date date) {
		if (null == date)
			return null;
		return DATE_MINUTE_FORMAT.format(date);
	}

	/**
	 * 将Date转换成字符串.日期字符串匹配模式 例:yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            时间
	 */
	public static String formatDateTimeSecond(Date date) {
		if (null == date)
			return null;
		return DATE_SESOND_FORMAT.format(date);
	}

	/**
	 * 检查字符串是否为日期格式yyyy-MM-dd
	 * 
	 * @param dateString
	 * @return true=是；false=否
	 */
	public static boolean checkDateString(String dateString) {
		return (parseDate(dateString) != null);
	}

	/**
	 * 将字符串转换为日期.
	 * 
	 * @param dateString
	 *            日期字符串
	 * @param pattern
	 *            日期字符串匹配模式 例:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseDate(String dateString, String pattern) {
		try {
			DateFormat format = new SimpleDateFormat(pattern);
			return format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将字符串转换为日期.
	 * 
	 * @param dateString
	 *            日期字符串
	 * @param format
	 *            日期字符串匹配模式
	 * @return
	 */
	public static Date parseDate(String dateString, DateFormat format) {
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 将字符串转换为日期（不包括时间）
	 * 
	 * @param dateString
	 *            "yyyy-MM-dd"格式的日期字符串
	 * @return 日期
	 */
	public static Date parseDate(String dateString) {
		try {
			return DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}


	/**
	 * 将字符串转换为日期（包括时间）
	 * 
	 * @param dateString
	 *            "yyyy-MM-dd HH:mm:ss"格式的日期字符串
	 * @return 日期时间
	 */
	public static Date formatDateTime(String dateTimeString) {
		try {
			return DATE_SESOND_FORMAT.parse(dateTimeString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 检查字符串是否为日期时间格式 例:yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateString
	 * @return true=是；false=否
	 */
	public static boolean checkDateTimeString(String dateTimeString) {
		return (formatDateTime(dateTimeString) != null);
	}

	/**
	 * 获取月底
	 * 
	 * @param year
	 *            年 4位年度
	 * @param month
	 *            月 1~12
	 * @return 月底的Date对象。例如：2006-3-31 23:59:59.999
	 */
	public static Date getMonthEnd(int year, int month) {
		StringBuffer sb = new StringBuffer(10);
		Date date;
		if (month < 12) {
			sb.append(Integer.toString(year));
			sb.append("-");
			sb.append(month + 1);
			sb.append("-1");
			date = parseDate(sb.toString());
		} else {
			sb.append(Integer.toString(year + 1));
			sb.append("-1-1");
			date = parseDate(sb.toString());
		}
		date.setTime(date.getTime() - 1);
		return date;
	}

	/**
	 * 获取月底
	 * 
	 * @param when
	 *            要计算月底的日期
	 * @return 月底的Date对象。例如：2006-3-31 23:59:59.999
	 */
	public static Date getMonthEnd(Date when) {
		Assert.notNull(when, "date must not be null !");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		return getMonthEnd(year, month);
	}

	/**
	 * 获取给定日的最后一刻。
	 * 
	 * @param when
	 *            给定日
	 * @return 最后一刻。例如：2006-4-19 23:59:59.999
	 */
	public static Date getDayEnd(Date when) {
		Date date = truncate(when, Calendar.DATE);
		date = addDays(date, 1);
		date.setTime(date.getTime() - 1);
		return date;
	}

	/**
	 * 获取给定日的第一刻。
	 * 
	 * @param when
	 *            给定日
	 * @return 例如：2012-05-02 00:00:00
	 */
	public static Date getDayStart(Date when) {
		Date date = truncate(when, Calendar.DATE);
		date.setTime(date.getTime() + 1);
		return date;
	}

	/**
	 * 日期加法
	 * 
	 * @param when
	 *            被计算的日期
	 * @param field
	 *            the time field. 在Calendar中定义的常数，例如Calendar.DATE
	 * @param amount
	 *            加数
	 * @return 计算后的日期
	 */
	public static Date add(Date when, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 计算给定的日期加上给定的天数。
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的天数
	 * @return 计算后的日期
	 */
	public static Date addDays(Date when, int amount) {
		return add(when, Calendar.DAY_OF_YEAR, amount);
	}

	/**
	 * 计算给定的日期加上给定的月数。
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的月数
	 * @return 计算后的日期
	 */
	public static Date addMonths(Date when, int amount) {
		return add(when, Calendar.MONTH, amount);
	}

}
