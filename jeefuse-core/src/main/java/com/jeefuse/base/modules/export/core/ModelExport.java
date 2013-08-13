package com.jeefuse.base.modules.export.core;

import org.jmesa.view.ViewExporter;
import org.jmesa.view.component.Table;

/**
 * 导出接口.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface ModelExport {
	public Table getTable();

	public ViewExporter getExporter();

	public void export() throws Exception;
}
