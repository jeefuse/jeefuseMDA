package com.jeefuse.base.modules.export.component;

import org.apache.commons.lang.StringUtils;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;
import org.jmesa.view.renderer.TableRenderer;

public class SimpleTableImpl implements Table {
	private Row row;
	private String caption;
	private TableRenderer tableRenderer;

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setCaptionKey(String key) {
		if (StringUtils.isNotEmpty(key)) {
			this.caption = key;
		}
	}

	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	public TableRenderer getTableRenderer() {
		return tableRenderer;
	}

	public void setTableRenderer(TableRenderer tableRenderer) {
		this.tableRenderer = tableRenderer;
		tableRenderer.setTable(this);
	}

}
