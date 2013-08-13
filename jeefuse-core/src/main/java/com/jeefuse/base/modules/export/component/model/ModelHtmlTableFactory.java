package com.jeefuse.base.modules.export.component.model;

import java.util.List;

import org.jmesa.core.CoreContext;
import org.jmesa.view.AbstractContextSupport;
import org.jmesa.view.ComponentFactory;
import org.jmesa.view.TableFactory;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;
import org.jmesa.view.html.HtmlComponentFactory;
import org.jmesa.web.WebContext;

import com.jeefuse.base.model.parse.ColumnField;

public class ModelHtmlTableFactory<T> extends AbstractContextSupport implements TableFactory {
	private ModelHtmlCellEditor<T> modelCellEditor;

	public ModelHtmlTableFactory(WebContext webContext, CoreContext coreContext, ModelHtmlCellEditor<T> modelCellEditor) {
		setWebContext(webContext);
		setCoreContext(coreContext);
		this.modelCellEditor = modelCellEditor;
	}

	public Table CreateTable(ColumnField<T>[] columnFields) {
		int length = columnFields.length;
		String[] columnProperties = new String[length];
		String[] columnLabels = new String[length];
		for (int i = 0; i < length; i++) {
			columnProperties[i] = columnFields[i].getFieldName();
			columnLabels[i] = columnFields[i].getFieldLabel();
		}
		return createTable(columnProperties, columnLabels);
	}

	public Table createTable(String... columnProperties) {
		return createTable(columnProperties, null);
	}

	public Table createTable(String[] columnProperties, String[] columnLabels) {
		ComponentFactory factory = getComponentFactory();

		// create the table
		Table table = factory.createTable();

		// create the row
		Row row = factory.createRow();
		table.setRow(row);

		// create the columns
		for (int i = 0; i < columnProperties.length; i++) {
			String columnName = columnProperties[i];
			Column column = factory.createColumn(columnName, getModelCellEditor());
			row.addColumn(column);
		}

		// set column label
		if (null != columnLabels && columnLabels.length > 0) {
			int len = columnLabels.length;
			List<Column> columns = row.getColumns();
			for (int i = 0; i < len; i++) {
				Column column = columns.get(i);
				column.setTitle(columnLabels[i]);
			}
		}

		return table;
	}

	protected ComponentFactory getComponentFactory() {
		return new HtmlComponentFactory(getWebContext(), getCoreContext());
	}

	protected ModelHtmlCellEditor<T> getModelCellEditor() {
		return modelCellEditor;
	}
}
