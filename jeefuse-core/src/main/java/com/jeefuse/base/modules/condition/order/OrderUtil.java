package com.jeefuse.base.modules.condition.order;


/**
 * 排序集合. <code>
 * 
 * @author yonclv
 * @created 2009-9-15
 */
public class OrderUtil {

	/**
	 * 构造排序SQL语句.
	 * <p>
	 * 例: ' ORDER BY name asc'
	 */
	static public String toOrderBySql(Order[] orders) {
		if (null == orders || 0 == orders.length)
			return "";
		StringBuilder sb = new StringBuilder(32);
		sb.append(" order by");
		for (Order order : orders) {
			sb.append(" " + order.toSql());
		}
		return sb.toString();
	}

	/**
	 * 构造排序SQL语句.
	 * <p>
	 * 例: ' ORDER BY name asc'
	 */
	// static public String toOrderBySql(Order[] orders, String prefix) {
	// if (null == orders || 0 == orders.length)
	// return "";
	// StringBuilder sb = new StringBuilder(32);
	// sb.append(" order by");
	// for (Order order : orders) {
	// if (null != prefix) {
	// sb.append(" ").append(prefix).append(order.toSql());
	// } else {
	// sb.append(" " + order.toSql());
	// }
	// }
	// return sb.toString();
	// }
}
