package com.jeefuse.base.modules.export.exporter.excel;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.jmesa.view.View;
import org.jmesa.view.ViewExporter;
import org.jmesa.view.component.Table;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.base.modules.export.component.model.ModelCellEditor;
import com.jeefuse.base.modules.export.component.model.ModelTableFactory;
import com.jeefuse.base.modules.export.exporter.AbstractModelExport;

/**
 * Excel http导出.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class HttpModelExcelExport<T> extends AbstractModelExport {

	private HttpServletResponse response;
	private String exportFileName;
	private String[] columnProperties;
	private String[] columnLabels;
	private Collection<T> items;
	ModelCellEditor<T> modelCellEditor;
	private Table table;

	public HttpModelExcelExport(HttpServletResponse response, String exportFileName, String[] columnProperties,
			String[] columnLabels, Collection<T> items, PropertyValueGet<T> modelPropertyParse) {
		this(response, exportFileName, columnProperties, columnLabels, items,
				new ModelCellEditor<T>(modelPropertyParse));
	}

	public HttpModelExcelExport(HttpServletResponse response, String exportFileName, ColumnField<?>[] columnFields,
			Collection<T> items, PropertyValueGet<T> modelPropertyParse) {
		this(response, exportFileName, columnFields, items, new ModelCellEditor<T>(modelPropertyParse));
	}

	public HttpModelExcelExport(HttpServletResponse response, String exportFileName, String[] columnProperties,
			String[] columnLabels, Collection<T> items, ModelCellEditor<T> modelCellEditor) {
		this.response = response;
		this.exportFileName = exportFileName;
		this.columnProperties = columnProperties;
		this.columnLabels = columnLabels;
		this.items = items;
		this.modelCellEditor = modelCellEditor;
	}

	public HttpModelExcelExport(HttpServletResponse response, String exportFileName, ColumnField<?>[] columnFields,
			Collection<T> items, ModelCellEditor<T> modelCellEditor) {
		this.response = response;
		this.items = items;
		this.exportFileName = exportFileName;
		int length = columnFields.length;
		this.columnProperties = new String[length];
		this.columnLabels = new String[length];
		for (int i = 0; i < length; i++) {
			this.columnProperties[i] = columnFields[i].getFieldName();
			this.columnLabels[i] = columnFields[i].getFieldLabel();
		}
		this.modelCellEditor = modelCellEditor;
	}

	@Override
	public Table getTable() {
		if (table == null) {
			table = createTable();
		}
		return table;
	}

	protected Table createTable() {
		ModelTableFactory<T> tableFactory = new ModelTableFactory<T>(modelCellEditor);
		Table createTable = tableFactory.createTable(columnProperties, columnLabels);
		if (null != exportFileName) {
			createTable.setCaption(exportFileName);
		}
		return createTable;
	}

	@Override
	public ViewExporter getExporter() {
		View view = new ExcelView(getTable(), items);
		return new HttpExcelExporter(view, response, exportFileName);
	}

	/**
	 * @return the exportFileName
	 */
	public String getExportFileName() {
		return exportFileName;
	}

	/**
	 * @param exportFileName
	 *            the exportFileName to set
	 */
	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
	}

}
