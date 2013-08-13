package com.jeefuse.base.modules.condition.util;

public class MatchLike {
	/**
	 * "'"+pattern+"'".
	 * @param pattern
	 * @return
	 */
	public static String toMatchExact(String pattern) {
		return pattern;
	}

	/**
	 * "'"+pattern + "%'".
	 * @param pattern
	 * @return
	 */
	public static String toMatchStart(String pattern) {
		return pattern + "%";
	}

	/**
	 * "'%" + pattern+"'".
	 * @param pattern
	 * @return
	 */
	public static String toMatchEnd(String pattern) {
		return "%" + pattern;
	}

	/**
	 * "'%" + pattern + "%'".
	 * @param pattern
	 * @return
	 */
	public static String toMatchAnyWhere(String pattern) {
		return "%" + pattern + "%";
	}
}
