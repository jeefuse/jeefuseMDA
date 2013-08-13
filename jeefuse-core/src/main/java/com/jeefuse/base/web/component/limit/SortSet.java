package com.jeefuse.base.web.component.limit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**排序集合.
 * @author  yonclv
 * @created 2009-7-23
 */
public class SortSet {
	private List<Sort> sorts;

	public SortSet() {
		sorts = new ArrayList<Sort>();
	}

	public boolean isSorted() {
		return sorts != null && !sorts.isEmpty();
	}

	public Collection<Sort> getSorts() {
		return sorts;
	}

	public Sort getSort(String property) {
		for (Iterator<Sort> iter = sorts.iterator(); iter.hasNext();) {
			Sort sort = iter.next();
			if (sort.getProperty().equals(property)) {
				return sort;
			}
		}
		return null;
	}

	public Order getSortOrder(String property) {
		return getSort(property).getOrder();
	}

	public void addSort(int position, String property, Order orderMode) {
		addSort(new Sort(position, property, orderMode));
	}

	public void addSort(String property, Order orderMode) {
		addSort(new Sort(sorts.size(), property, orderMode));
	}

	public void addSort(Sort sort) {
		if (sorts.contains(sort)) {
			sorts.remove(sort);
		}
		sorts.add(sort);
		Collections.sort(sorts);
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);

		if (sorts != null) {
			for (Iterator<Sort> iter = sorts.iterator(); iter.hasNext();) {
				Sort sort = iter.next();
				builder.append(sort.toString());
			}
		}

		return builder.toString();
	}
}
