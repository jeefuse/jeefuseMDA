package com.jeefuse.base.modules.export.component;

import org.jmesa.view.ComponentFactory;
import org.jmesa.view.TableFactory;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;

import com.jeefuse.base.model.parse.ColumnField;

public class SimpleTableFactory implements TableFactory {
	public SimpleTableFactory() {
	}

	public Table CreateTable(ColumnField<?>[] columnFields) {
		int length = columnFields.length;
		String[] columnProperties = new String[length];
		String[] columnLabels = new String[length];
		for (int i = 0; i < length; i++) {
			columnProperties[i] = columnFields[i].getFieldName();
			columnLabels[i] = columnFields[i].getFieldLabel();
		}
		return createTable(columnProperties, columnLabels);
	}

	public Table createTable(String[] columnProperties, String[] columnLabels) {
		ComponentFactory factory = getComponentFactory();

		// create the table
		Table table = factory.createTable();

		// create the row
		Row row = factory.createRow();
		table.setRow(row);

		// create the columns
		int columnLabelsLength = 0;
		if (null != columnLabels) {
			columnLabelsLength = columnLabels.length;
		}
		for (int i = 0; i < columnProperties.length; i++) {
			String columnName = columnProperties[i];
			Column column = factory.createColumn(columnName);
			if (columnLabels != null && columnLabelsLength > i) {
				column.setTitle(columnLabels[i]);
			}
			row.addColumn(column);
		}

		return table;
	}

	public Table createTable(String... columnProperties) {
		ComponentFactory factory = getComponentFactory();

		// create the table
		Table table = factory.createTable();

		// create the row
		Row row = factory.createRow();
		table.setRow(row);

		// create the columns
		for (int i = 0; i < columnProperties.length; i++) {
			String columnName = columnProperties[i];
			Column firstNameColumn = factory.createColumn(columnName);
			row.addColumn(firstNameColumn);
		}

		return table;
	}

	protected ComponentFactory getComponentFactory() {
		return new SimpleComponentFactory();
	}
}
