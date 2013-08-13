package com.jeefuse.base.utils.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.jeefuse.base.utils.string.StringHelper;

/**
 * 生成随机数工具.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class RandomUtil {

	public static String timeRandom(int digit) {
		return System.currentTimeMillis() + RandomStringUtils.random(digit, StringHelper.N36_CHARS);
	}

	/**
	 * 返回当前时间+2位随机数,格式化:yyMMddHHmmS e.g 101018114323
	 */
	public static String dateTimeMillisecondSerial() {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmssS");
		return format.format(new Date()) + RandomUtils.nextInt(2);
	}

	/**
	 * 返回当前时间+2位随机数,格式化:yyMMddHHmm e.g 101018114321
	 */
	public static String dateTimeSecondSerial() {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		return format.format(new Date()) + RandomUtils.nextInt(2);
	}

	/**
	 * 返回当前时间+digit位随机数,格式化:yyMMddHHmm e.g 1010181143b6
	 */
	public static String dateTimeSerialChar(int digit) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmssS");
		return format.format(new Date()) + RandomStringUtils.random(digit, StringHelper.N36_CHARS);
	}
}
