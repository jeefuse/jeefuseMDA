package com.jeefuse.base.modules.export.exporter.cvs;

import org.jmesa.view.component.Column;
import org.jmesa.view.component.ColumnImpl;
import org.jmesa.view.csv.renderer.CsvCellRendererImpl;
import org.jmesa.view.editor.CellEditor;

import com.jeefuse.base.modules.export.component.SimpleComponentFactory;

public class CsvComponentFactory extends SimpleComponentFactory {
	private static final String DEFAULT_DELIMITER = ",";

	private String delimiter = DEFAULT_DELIMITER;

	public CsvComponentFactory(String delimiter) {
		this.delimiter = delimiter;
	}

	public CsvComponentFactory() {

	}

	@Override
	public Column createColumn(String property, CellEditor editor) {
		ColumnImpl column = new ColumnImpl(property);
		CsvCellRendererImpl columnRenderer = new CsvCellRendererImpl(column,
				editor);
		columnRenderer.setDelimiter(delimiter);
		column.setCellRenderer(columnRenderer);
		return column;
	}
}
