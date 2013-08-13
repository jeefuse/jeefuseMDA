package com.jeefuse.base.web.component.limit;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**排序.
 * @author  yonclv
 * @created 2009-7-23
 */
@SuppressWarnings("serial")
public class Sort implements Serializable, Comparable<Sort> {
    private final int position;
    private final String property;
    private final Order order;

    public Sort(int position, String property, Order order) {
        this.position = position;
        this.property = property;
        this.order = order;
    }

    public Order getOrder() {
		return order;
	}

    /**
     * 排序属性.
     * @return
     */
    public String getProperty() {
        return property;
    }



    /**
     * 排序位置.
     * @return
     */
    public int getPosition() {
        return position;
    }


    /**
     * 比较排序位置,小于返回"-1",相等返回"0",大于返回"1";
     * @param sort
     * @return
     */
    public int compareTo(Sort sort) {
        if (this.getPosition() < sort.getPosition())
			return -1;

        if (this.getPosition() == sort.getPosition())
			return 0;

        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Sort))
            return false;

        Sort that = (Sort) o;

        return that.getProperty().equals(this.getProperty());
    }

    @Override
    public int hashCode() {
        int result = 17;
		int curproperty = this.getProperty() == null ? 0 : this.getProperty().hashCode();
		result = result * 37 + curproperty;
        return result;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("position", position);
        builder.append("property", property);
        builder.append("order",order);
        return builder.toString();
    }
}
