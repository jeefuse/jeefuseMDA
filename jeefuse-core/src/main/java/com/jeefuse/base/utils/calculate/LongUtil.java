package com.jeefuse.base.utils.calculate;

import org.apache.commons.lang.StringUtils;

public class LongUtil {

	/**
	 * 转化为long类型值,如果对象为null或为空字符则返回'0'值.
	 */
	static public long valueOfString(String d) {
		if (StringUtils.isBlank(d))
			return 0;
		return Long.parseLong(d);
	}

	/**
	 * 转化为long类型值,如果对象为null或为空字符则返回'0'值.
	 */
	public static long valueOf(Object obj) {
		if (null == obj || obj.toString().trim().equals(""))
			return 0;
		return Long.parseLong(obj.toString());
	}

	/**
	 * 转化为long类型值,如果对象为空则返回'0'值.
	 */
	public static long valueOf(Long obj) {
		if (null == obj)
			return 0;
		return obj;
	}
}
