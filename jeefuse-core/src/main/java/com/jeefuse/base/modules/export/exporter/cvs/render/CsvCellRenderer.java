package com.jeefuse.base.modules.export.exporter.cvs.render;

import org.jmesa.view.renderer.CellRenderer;

public interface CsvCellRenderer extends CellRenderer {
	public String getDelimiter();

	public void setDelimiter(String delimiter);
}
