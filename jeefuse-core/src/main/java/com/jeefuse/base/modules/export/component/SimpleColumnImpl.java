package com.jeefuse.base.modules.export.component;

import org.apache.commons.lang.StringUtils;
import org.jmesa.util.SupportUtils;
import org.jmesa.view.ViewUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.renderer.CellRenderer;
import org.jmesa.view.renderer.HeaderRenderer;

public class SimpleColumnImpl implements Column {

	private String property;
	private String title;
	private CellRenderer cellRenderer;
	private HeaderRenderer headerRenderer;
	private Row row;

	public SimpleColumnImpl() {
	}

	public SimpleColumnImpl(String property) {
		this.property = property;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getTitle() {
		if (StringUtils.isBlank(title))
			return ViewUtils.camelCaseToWord(property);

		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleKey(String key) {
		if (StringUtils.isNotBlank(key)) {
			this.title = key;
		}
	}

	public CellRenderer getCellRenderer() {
		return cellRenderer;
	}

	public void setCellRenderer(CellRenderer cellRenderer) {
		this.cellRenderer = cellRenderer;
		SupportUtils.setColumn(cellRenderer, this);
	}

	public HeaderRenderer getHeaderRenderer() {
		return headerRenderer;
	}

	public void setHeaderRenderer(HeaderRenderer headerRenderer) {
		this.headerRenderer = headerRenderer;
		SupportUtils.setColumn(headerRenderer, this);
	}

	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

}
