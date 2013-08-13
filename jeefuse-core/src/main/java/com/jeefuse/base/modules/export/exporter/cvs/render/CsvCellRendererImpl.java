package com.jeefuse.base.modules.export.exporter.cvs.render;

import org.jmesa.view.component.Column;
import org.jmesa.view.editor.CellEditor;

import com.jeefuse.base.modules.export.component.SimpleCellRenderer;

public class CsvCellRendererImpl extends SimpleCellRenderer implements CsvCellRenderer {
    private String delimiter;

    public CsvCellRendererImpl(Column column, CellEditor editor) {
		super(column, editor);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
	public Object render(Object item, int rowcount) {
        StringBuilder data = new StringBuilder();
        
        String property = getColumn().getProperty();
        
        Object value = getCellEditor().getValue(item, property, rowcount);
        data.append("\"").append(value).append("\"");
        data.append(delimiter);
        
        return data.toString();
    }
}
