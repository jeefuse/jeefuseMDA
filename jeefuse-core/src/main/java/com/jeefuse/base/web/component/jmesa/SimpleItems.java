package com.jeefuse.base.web.component.jmesa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jmesa.core.Items;
import org.jmesa.core.filter.RowFilter;
import org.jmesa.core.sort.ColumnSort;
import org.jmesa.limit.Limit;
import org.jmesa.limit.RowSelect;
import org.jmesa.limit.RowSelectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 返回数据集.
 * 
 * @author yonclv
 * @created 2009-8-20
 */
public class SimpleItems implements Items {
	private Logger logger = LoggerFactory.getLogger(SimpleItems.class);
	private Collection<?> allItems;
	private Collection<?> filteredItems;
	private Collection<?> pageItems;
	private Collection<?> sortedItems;

	public SimpleItems(Collection<?> items, Limit limit, RowFilter rowFilter,
			ColumnSort columnSort) {
		this.allItems = new ArrayList<Object>(items); // copy for thread safety

		if (null != rowFilter) {
			this.filteredItems = rowFilter.filterItems(allItems, limit);
			if (filteredItems.size() != allItems.size()) {
				recalculateRowSelect(filteredItems, limit);
			}
		}else{
			this.filteredItems=allItems;
		}

		if (null != columnSort) {
			this.sortedItems = columnSort.sortItems(filteredItems, limit);
		}else{
			this.sortedItems=filteredItems;
		}

		this.pageItems = getPageItems(sortedItems, limit);

		if (logger.isDebugEnabled()) {
			logger.debug(limit.toString());
		}
	}

	public Collection<?> getAllItems() {
		return allItems;
	}

	public Collection<?> getFilteredItems() {
		return filteredItems;
	}

	public Collection<?> getPageItems() {
		return pageItems;
	}

	public void setPageItems(Collection<?> pageItems) {
		this.pageItems = pageItems;
	}

	public Collection<?> getSortedItems() {
		return sortedItems;
	}

	/**
	 * Need to recalculate the RowSelect object if the items needed to be
	 * filtered.
	 * 
	 * @param filteredItems
	 * @param limit
	 */
	private void recalculateRowSelect(Collection<?> curfilteredItems, Limit limit) {
		RowSelect rowSelect = limit.getRowSelect();
		int page = rowSelect.getPage();
		int maxRows = rowSelect.getMaxRows();
		RowSelect recalcRowSelect = new RowSelectImpl(page, maxRows, curfilteredItems.size());
		limit.setRowSelect(recalcRowSelect);
	}

	private Collection<?> getPageItems(Collection<?> items, Limit limit) {
		int rowStart = limit.getRowSelect().getRowStart();
		int rowEnd = limit.getRowSelect().getRowEnd();

		// Normal case. Using Limit and paginating for a specific set of rows.
		if (rowStart >= items.size()) {
			if (logger.isDebugEnabled()) {
				logger.debug("The Limit row start is >= items.size(). Return the items available.");
			}

			return items;
		}

		if (rowEnd > items.size()) {
			if (logger.isDebugEnabled()) {
				logger.debug("The Limit row end is > items.size(). Return as many items as possible.");
			}

			rowEnd = items.size();
		}

		Collection<Object> results = new ArrayList<Object>();
		for (int i = rowStart; i < rowEnd; i++) {
			Object item = ((List<?>) items).get(i);
			results.add(item);
		}

		return results;
	}
}
