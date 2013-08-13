package com.jeefuse.base.modules.export.exporter.cvs;

import java.util.Collection;
import java.util.List;

import org.jmesa.view.component.Column;
import org.jmesa.view.component.Table;

import com.jeefuse.base.modules.export.view.BaseView;

public class CsvView extends BaseView {

	public CsvView(Table table, Collection<?> items) {
		super(table, items);
	}

	public byte[] getBytes() {
		String render = (String) render();
		return render.getBytes();
	}

	public Object render() {
		StringBuilder data = new StringBuilder();

		List<Column> columns = getTable().getRow().getColumns();

		int rowcount = 0;
		Collection<?> items = getItems();
		for (Object item : items) {
			rowcount++;

			for (Column column : columns) {
				data.append(column.getCellRenderer().render(item, rowcount));
			}

			data.append("\r\n");
		}

		return data.toString();
	}
}
