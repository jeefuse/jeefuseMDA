package com.jeefuse.base.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;
public class ConvertUtil {
	private  static Log logger = LogFactory.getLog(ConvertUtil.class);

	/**将String转换为boolean 如果字符串不为空且其值为true则返回true,否则返回false
	 * @param b
	 * @return
	 */
	public static final boolean stringToBoolean(String b) {
		if (null != b && b.trim().equals("true"))
			return true;
		else
			return false;
	}
	/**如果传入的字符不空则返回true 否则返回false 注:空格若没有字符也当作是空
	 * @param i
	 * @return
	 */
	public static final boolean stringIsNoNull(String i) {
		if (null != i && !i.trim().equals(""))
			return true;
		else
			return false;
	}
	/**如果传入的字符不空则返回字符串的值(去掉两边空格) 注:空格若没有字符也当作是空
	 * @param i
	 * @return
	 */
	public static final String stringRetureValue(String i) {
		if (null != i && !i.trim().equals(""))
			return i.trim();
		else
			return null;
	}
	/**将String转换为Long
	 * @param i
	 * @return
	 */
	public static final Long stringToLong(String i) {
		try {
			if (null != i && !i.trim().equals(""))
				return Long.valueOf(i.trim());
			else
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**将String转换为Float
	 * @param i
	 * @return
	 */
	public static final Float stringToFloat(String i) {
		try {
			if (null != i && !i.trim().equals(""))
				return Float.parseFloat(i.trim());
			else
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**将String转换为Integer
	 * @param i
	 * @return
	 */
	public static final Integer stringToInteger(String i) {
		try {
			if (null != i && !i.trim().equals(""))
				return Integer.parseInt(i.trim());
			else
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static final String[] stringSplitArray(String i) {
		try {
			if (null != i && i.indexOf(",") != -1)
				return i.split(",");
			else
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static final Date strToDate(String str) {
		Date date = null;
		if (str != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = df.parse(str);
			} catch (ParseException e) {
				logger.error("DateParse Error!");
			}
		}
		return date;
	}

	public static final Date strToDateTime(String str) {
		Date date = null;
		if (str != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date = df.parse(str);
			} catch (ParseException e) {
				logger.error("DateParse Error!");
			}
		}
		return date;
	}

	public static final String dateTimeToStr(Date date) {
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date != null) {
			try {
				str = df.format(date);
			} catch (Exception e) {
				logger.error("format Error!");
			}
		}
		return str;
	}

	public static final String dateToStr(Date date) {
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			try {
				str = df.format(date);
			} catch (Exception e) {
				logger.error("format Error!");
			}
		}
		return str;
	}

	public static final String nullIfBlank(String str) {
		if (StringUtils.isBlank(str))
			return null;
		return str;
	}

}
