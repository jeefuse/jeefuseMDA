package com.jeefuse.base.modules.export.component;

import java.util.ArrayList;
import java.util.List;

import org.jmesa.util.ItemUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.renderer.RowRenderer;
import org.jmesa.worksheet.UniqueProperty;

public class SimpleRowImpl implements Row {
	private String uniqueProperty;

    private RowRenderer rowRenderer;

	private List<Column> columns = new ArrayList<Column>();

	/**
	 * 
	 * @param item
	 *            The Bean (or Map) for the current row.
	 * @since 2.3
	 */
	public UniqueProperty getUniqueProperty(Object item) {
		if (uniqueProperty != null) {
			Object value = ItemUtils.getItemValue(item, uniqueProperty);
			if (value != null)
				return new UniqueProperty(uniqueProperty, value.toString());
		}

		return null;
	}

	/**
	 * @param uniqueProperty
	 *            The property that uniquely identifies the row.
	 * @since 2.3
	 */
	public void setUniqueProperty(String uniqueProperty) {
		this.uniqueProperty = uniqueProperty;
	}

	public Column getColumn(String property) {
		for (Column column : columns) {
			if (column.getProperty() == null) {
				continue;
			}

			if (column.getProperty().equals(property))
				return column;
		}

		throw new IllegalStateException("The column property [" + property + "] does not exist.");
	}

	public Column getColumn(int index) {
		return columns.get(index);
	}

	public void addColumn(Column column) {
		column.setRow(this);
		columns.add(column);
	}

	public List<Column> getColumns() {
		return columns;
	}

	public RowRenderer getRowRenderer() {
		return rowRenderer;
	}

	public void setRowRenderer(RowRenderer rowRenderer) {
		this.rowRenderer = rowRenderer;
		rowRenderer.setRow(this);
	}
}
