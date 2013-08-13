package com.jeefuse.base.utils.calculate;

import org.apache.commons.lang.StringUtils;

public class IntegerUtil {

	/**
	 * 转化为int类型值,如果对象为null或为空字符则返回'0'值.
	 */
	static public int valueOfString(String d) {
		if (StringUtils.isBlank(d))
			return Integer.valueOf("0");
		return Integer.parseInt(d);
	}

	/**
	 * 转化为int类型值,如果对象为null或为空字符则返回'0'值.
	 */
	public static int valueOf(Object obj) {
		if (null == obj || obj.toString().trim().equals(""))
			return Integer.valueOf("0");
		return Integer.parseInt(obj.toString());
	}

}
