package com.jeefuse.base.web.component.limit;

/**
 * 条件过滤前缀.
 * 
 * @author yonclv
 * @created 2009-7-23
 */
public enum LimitedPrefix {
	FILTER, SORT, PAGE, MAX_ROWS;

	public String toParam() {
		switch (this) {
		case FILTER:
			return "f_";
		case SORT:
			return "s_";
		case PAGE:
			return "p_";
		case MAX_ROWS:
			return "mr_";
		default:
			return "";
		}
	}

	public static LimitedPrefix valueOfParam(String param) {
		for (LimitedPrefix prefix : LimitedPrefix.values()) {
			if (prefix.toParam().equals(param)) {
				return prefix;
			}
		}
		return null;
	}
}
