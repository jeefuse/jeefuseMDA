package com.jeefuse.base.utils.string;

import org.apache.commons.lang.StringUtils;

/**
 * 一些文字操作,如是否有中文字符,文本转HTML，全角<->半角等
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class StringHelper {
	/**
	 * 是否有中文字符
	 * 
	 * @param s
	 * @return
	 */
	public static boolean hasCn(String s) {
		if (s == null)
			return false;
		return countCn(s) > s.length();
	}

	/**
	 * 获得字符,符合中文习惯。
	 * 
	 * @param s
	 * @param length
	 * @return
	 */
	public static String getCn(String s, int len) {
		if (s == null)
			return s;
		int sl = s.length();
		if (sl <= len)
			return s;
		// 留出一个位置用于…
		int curlen = len - 1;
		int maxCount = curlen * 2;
		int count = 0;
		int i = 0;
		while (count < maxCount && i < sl) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
			i++;
		}
		if (count > maxCount) {
			i--;
		}
		return s.substring(0, i) + "…";
	}

	/**
	 * 计算GBK编码的字符串的字节数
	 * 
	 * @param s
	 * @return
	 */
	public static int countCn(String s) {
		if (s == null)
			return 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
		}
		return count;
	}

	/**
	 * 文本转html
	 * 
	 * @param txt
	 * @return
	 */
	public static String txt2htm(String txt) {
		if (StringUtils.isBlank(txt))
			return txt;
		StringBuilder bld = new StringBuilder();
		char c;
		for (int i = 0; i < txt.length(); i++) {
			c = txt.charAt(i);
			switch (c) {
			case '&':
				bld.append("&amp;");
				break;
			case '<':
				bld.append("&lt;");
				break;
			case '>':
				bld.append("&gt;");
				break;
			case '"':
				bld.append("&quot;");
				break;
			case ' ':
				bld.append("&nbsp;");
				break;
			case '\n':
				bld.append("<br/>");
				break;
			default:
				bld.append(c);
				break;
			}
		}
		return bld.toString();
	}

	/**
	 * html转文本
	 * 
	 * @param htm
	 * @return
	 */
	public static String htm2txt(String htm) {
		String curhtm = htm;
		if (curhtm == null)
			return curhtm;
		curhtm = curhtm.replace("&amp;", "&");
		curhtm = curhtm.replace("&lt;", "<");
		curhtm = curhtm.replace("&gt;", ">");
		curhtm = curhtm.replace("&quot;", "\"");
		curhtm = curhtm.replace("&nbsp;", " ");
		curhtm = curhtm.replace("<br/>", "\n");
		return curhtm;
	}

	/**
	 * 全角-->半角
	 * 
	 * @param qjStr
	 * @return
	 */
	public String Q2B(String qjStr) {
		String outStr = "";
		String Tstr = "";
		byte[] b = null;
		for (int i = 0; i < qjStr.length(); i++) {
			try {
				Tstr = qjStr.substring(i, i + 1);
				b = Tstr.getBytes("unicode");
			} catch (java.io.UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (null != b && b.length > 3 && b[3] == -1) {
				b[2] = (byte) (b[2] + 32);
				b[3] = 0;
				try {
					outStr = outStr + new String(b, "unicode");
				} catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else {
				outStr = outStr + Tstr;
			}
		}
		return outStr;
	}

	public static final char[] N62_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };
	public static final char[] N36_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static final char[] Num_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private static StringBuilder longToNBuf(long l, char[] chars) {
		StringBuilder result = new StringBuilder();
		long cl = l;
		int upgrade = chars.length;
		int last;
		while (l > 0) {
			last = (int) (cl % upgrade);
			result.append(chars[last]);
			cl /= upgrade;
		}
		return result;
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l
	 * @return
	 */
	public static String longToN62(long l) {
		return longToNBuf(l, N62_CHARS).reverse().toString();
	}

	public static String longToN36(long l) {
		return longToNBuf(l, N36_CHARS).reverse().toString();
	}

	/**
	 * 长整数转换成N62
	 * 
	 * @param l
	 * @param length
	 *            如N62不足length长度，则补足0。
	 * @return
	 */
	public static String longToN62(long l, int length) {
		StringBuilder sb = longToNBuf(l, N62_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}

	public static String longToN36(long l, int length) {
		StringBuilder sb = longToNBuf(l, N36_CHARS);
		for (int i = sb.length(); i < length; i++) {
			sb.append('0');
		}
		return sb.reverse().toString();
	}

	/**
	 * N62转换成整数
	 * 
	 * @param n62
	 * @return
	 */
	public static long n62ToLong(String n62) {
		return nToLong(n62, N62_CHARS);
	}

	public static long n36ToLong(String n36) {
		return nToLong(n36, N36_CHARS);
	}

	private static long nToLong(String s, char[] chars) {
		char[] nc = s.toCharArray();
		long result = 0;
		long pow = 1;
		for (int i = nc.length - 1; i >= 0; i--, pow *= chars.length) {
			int n = findNIndex(nc[i], chars);
			result += n * pow;
		}
		return result;
	}

	private static int findNIndex(char c, char[] chars) {
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i])
				return i;
		}
		throw new RuntimeException("N62(N36)非法字符：" + c);
	}

	/**
	 * 前置补充指定个数的字符.如果传入的oriStr为空则返回null.
	 * 
	 * @param oriStr
	 *            原字符串
	 * @param suppyonclvhar
	 *            补充的字符
	 * @param supplyNum
	 *            补充的个数
	 * @return
	 */
	public static String supplyPreChar(String oriStr, String suppyonclvhar, int supplyNum) {
		if (null == oriStr)
			return null;
		String temp = oriStr;
		for (int i = 0; i < supplyNum; i++) {
			temp = suppyonclvhar + temp;
		}
		return temp;
	}
}
