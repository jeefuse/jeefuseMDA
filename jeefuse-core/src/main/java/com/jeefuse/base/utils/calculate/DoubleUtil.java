package com.jeefuse.base.utils.calculate;

import org.apache.commons.lang.StringUtils;

public class DoubleUtil {

	/**
	 * 转化为double 类型值,如果对象为null则返回'0'值.
	 */
	static public double valueOf(Double d) {
		if (null == d)
			return Double.parseDouble("0");
		return d.doubleValue();
	}

	/**
	 * 转化为double 类型值,如果对象为null或为空字符则返回'0'值.
	 */
	static public double valueOfString(String d) {
		if (StringUtils.isBlank(d))
			return Double.valueOf("0");
		return Double.parseDouble(d);
	}

	/**
	 * 转化为double 类型值,如果对象为null或为空字符则返回'0'值.
	 */
	public static Double valueOf(Object obj) {
		if (null == obj || obj.toString().trim().equals(""))
			return Double.valueOf("0");
		return Double.parseDouble(obj.toString());
	}

}
