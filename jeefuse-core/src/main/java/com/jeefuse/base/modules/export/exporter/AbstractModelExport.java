package com.jeefuse.base.modules.export.exporter;

import org.jmesa.view.ViewExporter;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Table;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.renderer.CellRenderer;
import org.jmesa.view.renderer.HeaderRenderer;

import com.jeefuse.base.modules.export.core.ModelExport;

public abstract class AbstractModelExport implements ModelExport {

	public void setColumnRender(String columnName, CellRenderer cellRender) {
		Column column = getTable().getRow().getColumn(columnName);
		column.setCellRenderer(cellRender);
	}

	public CellRenderer getColumnRender(String columnName) {
		Column column = getTable().getRow().getColumn(columnName);
		return column.getCellRenderer();
	}

	public void setColumnHeaderRender(String columnName, HeaderRenderer headerRenderer) {
		Column column = getTable().getRow().getColumn(columnName);
		column.setHeaderRenderer(headerRenderer);
	}

	public void setColumnCellEditor(String columnName, CellEditor cellEditor) {
		getColumnRender(columnName).setCellEditor(cellEditor);
	}

	public abstract Table getTable();


	public abstract ViewExporter getExporter();

	public void export() throws Exception {
		getExporter().export();
	}
}
