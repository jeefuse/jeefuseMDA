package com.jeefuse.base.modules.export.component.model;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;

import org.jmesa.view.editor.AbstractCellEditor;

import com.jeefuse.base.model.parse.PropertyValueGet;

public class ModelHtmlCellEditor<T> extends AbstractCellEditor {
	private PropertyValueGet<T> modelPropertyParse;

	public ModelHtmlCellEditor(PropertyValueGet<T> modelPropertyParse) {
		this.modelPropertyParse = modelPropertyParse;
	}

	@SuppressWarnings("unchecked")
	public Object getValue(Object item, String property, int rowcount) {
		Object itemValue = modelPropertyParse.getValue((T) item, property);
		if (itemValue != null) {
			itemValue = escapeHtml(itemValue.toString());
		}
		return itemValue;
	}
}
