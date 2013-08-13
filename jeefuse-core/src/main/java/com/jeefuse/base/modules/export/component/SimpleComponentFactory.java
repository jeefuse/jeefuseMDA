package com.jeefuse.base.modules.export.component;

import org.jmesa.view.ComponentFactory;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;
import org.jmesa.view.editor.CellEditor;

public class SimpleComponentFactory implements ComponentFactory {

	public SimpleComponentFactory() {
	}

	public Table createTable() {
		SimpleTableImpl table = new SimpleTableImpl();
		return table;
	}

	public Row createRow() {
		SimpleRowImpl row = new SimpleRowImpl();
		return row;
	}

	public CellEditor createBasicCellEditor() {
		SimpleCellEditor editor = new SimpleCellEditor();
		return editor;
	}

	public Column createColumn(CellEditor editor) {
		return createColumn(null, editor);
	}

	public Column createColumn(String property) {
		return createColumn(property, createBasicCellEditor());
	}

	public Column createColumn(String property, CellEditor editor) {
		SimpleColumnImpl column = new SimpleColumnImpl(property);
		SimpleCellRenderer exr = new SimpleCellRenderer(column, editor);
		column.setCellRenderer(exr);
		return column;
	}

}
