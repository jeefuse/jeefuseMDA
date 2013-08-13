package com.jeefuse.base.modules.export.component.model;

import org.jmesa.view.component.Column;
import org.jmesa.view.component.ColumnSupport;
import org.jmesa.view.editor.CellEditor;

import com.jeefuse.base.model.parse.PropertyValueGet;

public class ModelCellEditor<T> implements CellEditor, ColumnSupport {
	
	private PropertyValueGet<T> modelPropertyParse;

	public ModelCellEditor(PropertyValueGet<T> modelPropertyParse) {
		this.modelPropertyParse = modelPropertyParse;
	}

	private Column column;

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	@SuppressWarnings("unchecked")
	public Object getValue(Object item, String property, int rowcount) {
		return modelPropertyParse.getValue((T) item, property);

	}
}
