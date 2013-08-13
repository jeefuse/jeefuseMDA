package net.taylor.mda.utils;

public class StrUtil {

	public static boolean isBlank(String str) {
		if (null == str)
			return true;
		if (str.trim().equals(""))
			return true;
		return false;
	}
}
