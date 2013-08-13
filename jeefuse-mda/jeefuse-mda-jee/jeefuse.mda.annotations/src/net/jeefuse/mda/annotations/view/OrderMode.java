package net.jeefuse.mda.annotations.view;

public enum OrderMode {
	ASC, DESC;

	public String toParam() {
		switch (this) {
		case ASC:
			return "asc";
		case DESC:
			return "desc";
		default:
			return null;
		}
	}

	public static OrderMode valueOfParam(String param) {
		for (OrderMode orderMode : OrderMode.values()) {
			if (orderMode.toParam().equalsIgnoreCase(param))
				return orderMode;
		}
		return null;
	}
}
