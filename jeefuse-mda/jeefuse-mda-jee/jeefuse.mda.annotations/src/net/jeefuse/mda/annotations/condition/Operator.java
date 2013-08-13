package net.jeefuse.mda.annotations.condition;

/**
 * 比较操作符.
 * 
 * @author yonclv
 * @created 2009-9-3
 */
public enum Operator {
	eq, ne, le, ge, gt, lt, between, in, notIn, likeStart, likeEnd, likeAnywhere, isNull, isNotNull;

	public String toParam() {
		switch (this) {
		case eq:
			return "eq";
		case ne:
			return "ne";
		case le:
			return "le";
		case ge:
			return "ge";
		case gt:
			return "gt";
		case lt:
			return "lt";
		case between:
			return "between";
		case in:
			return "in";
		case notIn:
			return "notIn";
		case likeStart:
			return "likeStart";
		case likeEnd:
			return "likeEnd";
		case likeAnywhere:
			return "likeAnywhere";
		case isNull:
			return "isNull";
		case isNotNull:
			return "isNotNull";
		default:
			return "eq";
		}
	}

	public static Operator valueOfParam(String param) {
		for (Operator operator : Operator.values()) {
			if (operator.toParam().equalsIgnoreCase(param)) {
				return operator;
			}
		}
		return null;
	}

}
