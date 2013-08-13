package com.jeefuse.base.modules.condition.criteria;


/**比较操作符.
 * @author  yonclv
 * @created 2009-9-3
 */
public enum Operator {
 EQ,NE,LE,GE,GT,LT,BETWEEN,AND,IN,NOT_IN,LIKE,IS_NULL,IS_NOT_NULL;
 
 public String toParam() {
		switch (this) {
		case EQ:
			return "=";
		case NE:
			return "<>";
		case LE:
			return "<=";
		case GE:
			return ">=";
		case GT:
			return ">";
		case LT:
			return "<";
		case BETWEEN:
			return "between";
		case AND:
			return "and";
		case IN:
			return "in";
		case NOT_IN:
			return "not in";
		case LIKE:
			return "like";
		case IS_NULL:
			return "is null";
		case IS_NOT_NULL:
			return "is not null";
		default:
			return "none";
		}
	}

	public static Operator valueOfParam(String param) {
		for (Operator operator : Operator.values()) {
			if (operator.toParam().equals(param)) {
				return operator;
			}
		}
		return null;
	}
	
}
