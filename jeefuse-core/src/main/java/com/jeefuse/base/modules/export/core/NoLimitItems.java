package com.jeefuse.base.modules.export.core;

import java.util.ArrayList;
import java.util.Collection;

import org.jmesa.core.Items;

public class NoLimitItems implements Items {

	private Collection<?> allItems;

	public NoLimitItems(Collection<?> items) {
		this.allItems = new ArrayList<Object>(items); // copy for thread safety
	}

	public Collection<?> getAllItems() {
		return allItems;
	}

	public Collection<?> getFilteredItems() {
		return allItems;
	}

	public Collection<?> getPageItems() {
		return allItems;
	}

	public Collection<?> getSortedItems() {
		return allItems;
	}

	public void setPageItems(Collection<?> arg0) {
		allItems=arg0;
	}

}
