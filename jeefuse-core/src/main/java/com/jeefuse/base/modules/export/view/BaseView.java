package com.jeefuse.base.modules.export.view;

import java.util.Collection;

import org.jmesa.view.View;
import org.jmesa.view.component.Table;

public abstract class BaseView implements View {
	private Table table;
	private Collection<?> items;

	protected BaseView(Table table, Collection<?> items) {
		this.table = table;
		this.items = items;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * @return the items
	 */
	public Collection<?> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Collection<?> items) {
		this.items = items;
	}

}
