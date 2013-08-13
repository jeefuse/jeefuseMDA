package com.jeefuse.base.web.component.limit;

/**排序方向.
 * @author  yonclv
 * @created 2009-7-31
 */
public enum Order {
	ASC, DESC, NONE;
	
	public String toParam() {
		switch (this) {
		case ASC:
			return "asc";
		case DESC:
			return "desc";
		default:
			return "none";
		}
	}

	public static Order valueOfParam(String param) {
		for (Order order : Order.values()) {
			if (order.toParam().equals(param)) {
				return order;
			}
		}

		return null;
	}
}
