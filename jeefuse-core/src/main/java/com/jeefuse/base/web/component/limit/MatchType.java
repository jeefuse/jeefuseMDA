package com.jeefuse.base.web.component.limit;


/**匹配方式.
 * @author  yonclv
 * @created 2009-7-23
 */
public enum MatchType {
	EQ,GT,GE,LT,LE,NE,LIKE,LIKESTART,LIKEEND;
	
	public String toParam() {
		switch (this) {
		case EQ:
			return "eq";
		case GT:
			return "gt";
		case GE:
			return "ge";
		case LT:
			return "lt";
		case NE:
			return "ne";
		case LIKE:
			return "like";
		case LIKESTART:
			return "likeStart";
		case LIKEEND:
			return "likeEnd";
		default:
			return "eq";
		}
	}
	
	public static MatchType valueOfParam(String param) {
		for (MatchType matchType : MatchType.values()) {
			if (matchType.toParam().equals(param))
				return matchType;
		}
		return null;
	}
}
