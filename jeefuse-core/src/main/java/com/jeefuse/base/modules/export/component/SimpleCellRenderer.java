package com.jeefuse.base.modules.export.component;

import org.jmesa.util.SupportUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.renderer.CellRenderer;

public class SimpleCellRenderer implements CellRenderer {
	private Column column;
	private CellEditor cellEditor;

	public SimpleCellRenderer(Column column, CellEditor editor) {
		setColumn(column);
		setCellEditor(editor);
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	/**
	 * @return The CellEditor.
	 */
	public CellEditor getCellEditor() {
		return cellEditor;
	}

	public void setCellEditor(CellEditor cellEditor) {
		this.cellEditor = cellEditor;
		SupportUtils.setColumn(cellEditor, getColumn());
	}

	public Object render(Object item, int rowcount) {
		return getCellEditor().getValue(item, getColumn().getProperty(), rowcount);
	}
}
