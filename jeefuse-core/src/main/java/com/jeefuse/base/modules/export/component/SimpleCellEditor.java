package com.jeefuse.base.modules.export.component;

import org.jmesa.util.ItemUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.ColumnSupport;
import org.jmesa.view.editor.CellEditor;

public class SimpleCellEditor implements CellEditor, ColumnSupport {

	private Column column;

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public Object getValue(Object item, String property, int rowcount) {

		return ItemUtils.getItemValue(item, property);
	}
}
