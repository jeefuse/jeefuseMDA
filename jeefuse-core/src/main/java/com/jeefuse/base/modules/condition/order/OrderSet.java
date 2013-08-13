package com.jeefuse.base.modules.condition.order;

import java.util.ArrayList;
import java.util.List;

import com.jeefuse.base.model.parse.ColumnField;

/**
 * 排序集合. <code>
 * 
 * @author yonclv
 * @created 2009-9-15
 */
public class OrderSet {

	public static OrderSet create() {
		return new OrderSet();
	}
	
	public static OrderSet create(String propertyName, OrderMode orderMode) {
		OrderSet orderSet = new OrderSet();
		orderSet.addOrder(propertyName, orderMode);
		return orderSet;
	}

	public static OrderSet create(ColumnField<?> columnField, OrderMode orderMode) {
		OrderSet orderSet = new OrderSet();
		orderSet.addOrder(columnField.getFieldName(), orderMode);
		return orderSet;
	}

	public static OrderSet create(Order... orders) {
		OrderSet orderSet = new OrderSet();
		orderSet.addOrder(orders);
		return orderSet;
	}

	private List<Order> orders;
	
	public OrderSet() {
		this.orders = new ArrayList<Order>();
	}


	/**
	 * 添加排序.
	 * @param propertyName 属性名
	 * @param orderMode    排序方向
	 * @return
	 */
	public OrderSet addOrder(String propertyName, OrderMode orderMode) {
		addOrder(new Order(propertyName, orderMode));
		return this;
	}

	/**
	 * 添加排序.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param orderMode
	 *            排序方向
	 * @param position
	 *            位置
	 * @return
	 */
	public OrderSet addOrder(String propertyName, OrderMode orderMode, int position) {
		addOrder(new Order(propertyName, orderMode), position);
		return this;
	}

	/**
	 * 添加排序.
	 * 
	 * @param order
	 * @return
	 */
	public OrderSet addOrder(Order... paramOrders) {
		if (null == paramOrders)
			return this;
		for (Order order : paramOrders) {
			if (orders.contains(order)) {
				orders.remove(order);
			}
			orders.add(order);
		}
		return this;
	}

	/**
	 * 添加排序.
	 * @param order
	 * @return
	 */
	public OrderSet addOrder(Order order, int position) {
		if (null == order)
			return this;
		if (orders.contains(order)) {
			orders.remove(order);
		}
		orders.add(position, order);
		return this;
	}

	/**
	 * 排序集合转换成数组.
	 */
	public Order[] toOrderArray() {
		if (null != orders && orders.size() > 0)
			return orders.toArray(new Order[orders.size()]);
		return null;
	}

	/**
	 * 构造排序SQL语句.
	 * <p>
	 * 例: ' order by name asc'
	 */
	public String toOrderBySql() {
		if (null == orders || orders.isEmpty())
			return "";
		StringBuilder sb = new StringBuilder(32);
		sb.append(" ORDER BY");
		for (Order order : orders) {
			sb.append(" " + order.toSql());
		}
		return sb.toString();
	}

	public boolean isEmpty() {
		if (null == orders || orders.isEmpty())
			return true;
		return false;
	}
}
