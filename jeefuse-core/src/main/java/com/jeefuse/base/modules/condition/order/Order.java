package com.jeefuse.base.modules.condition.order;

import com.jeefuse.base.modules.condition.criteria.Criteria;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**构造字段排序
 * @author yonclv
 *         mailTo:yonclv@gmail.com
 */
public class Order implements Criteria {

	private static final long serialVersionUID = 2546523658800211333L;

	public static Order asc(String propertyName) {
		return new Order(propertyName, OrderMode.ASC);
	}

	public static Order desc(String propertyName) {
		return new Order(propertyName, OrderMode.DESC);
	}

	private OrderMode orderMode;
	private String propertyName;

	public Order(String propertyName, OrderMode orderMode) {
		this.propertyName = propertyName;
		this.orderMode = orderMode;
	}

	public OrderMode getOrderMode() {
		return orderMode;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String toSql() throws CriteriaQueryException {
		return propertyName + ' ' + orderMode.toParam();
	}

	@Override
	public String toString() {
		return propertyName + ' ' + orderMode.toParam();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderMode == null) ? 0 : orderMode.hashCode());
		result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderMode == null) {
			if (other.orderMode != null)
				return false;
		} else if (!orderMode.equals(other.orderMode))
			return false;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		return true;
	}
}
