package com.jeefuse.base.modules.export.component;

import java.util.List;

import org.jmesa.limit.ExportType;
import org.jmesa.view.html.toolbar.Toolbar;
import org.jmesa.view.html.toolbar.ToolbarItem;
import org.jmesa.view.html.toolbar.ToolbarItemType;

public class EmptyToolbar implements Toolbar {

	protected boolean hasToolbarItems() {
		return false;
	}

	public String render() {

		return "";
	}

	public ToolbarItem addExportToolbarItem(ExportType exporttype) {
		return null;
	}

	public List<ToolbarItem> addExportToolbarItems(ExportType... aexporttype) {
		return null;
	}

	public void addToolbarItem(ToolbarItem toolbaritem) {
	}

	public ToolbarItem addToolbarItem(ToolbarItemType toolbaritemtype) {
		return null;
	}

}
