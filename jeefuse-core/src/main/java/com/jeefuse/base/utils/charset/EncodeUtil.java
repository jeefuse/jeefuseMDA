package com.jeefuse.base.utils.charset;

/**
 * 编码转换工具类.
 * 
 * @author yonclv
 * @created 2009-9-14
 */
public class EncodeUtil {

	public static String GBToUnicode(String strIn) {
		String strOut = null;
		if (strIn == null || strIn.trim().equals(""))
			return strIn;
		try {
			byte b[] = strIn.getBytes("GBK");
			strOut = new String(b, "iso-8859-1");
		} catch (Exception exception) {
		}
		return strOut;
	}

	/**
	 * 把字符串转成utf8编码.
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	public static String unicodeToGB(String strIn) {
		String strOut = null;
		if (strIn == null || strIn.trim().equals(""))
			return strIn;
		try {
			byte b[] = strIn.getBytes("iso-8859-1");
			strOut = new String(b, "GBK");
		} catch (Exception exception) {
		}
		return strOut;
	}

	public static String UTFToUnicode(String strIn) {
		String strOut = null;
		if (strIn == null || strIn.trim().equals(""))
			return strIn;
		try {
			byte b[] = strIn.getBytes("UTF-8");
			strOut = new String(b, "iso-8859-1");
		} catch (Exception exception) {
		}
		return strOut;
	}

	public static String unicodeToUTF(String strIn) {
		String strOut = null;
		if (strIn == null || strIn.trim().equals(""))
			return strIn;
		try {
			byte b[] = strIn.getBytes("iso-8859-1");
			strOut = new String(b, "UTF-8");
		} catch (Exception exception) {
		}
		return strOut;
	}
}
