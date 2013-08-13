package com.jeefuse.base.modules.export.exporter.cvs;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.jmesa.view.View;
import org.jmesa.view.ViewExporter;
import org.jmesa.view.component.Table;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.base.modules.export.component.model.ModelCellEditor;
import com.jeefuse.base.modules.export.exporter.AbstractModelExport;

public class HttpModelCvsExport<T> extends AbstractModelExport {

	private HttpServletResponse response;
	private String exportFileName;
	private String[] columnProperties;
	private String[] columnLabels;
	private Collection<T> items;
	ModelCellEditor<T> modelCellEditor;
	private Table table;

	public HttpModelCvsExport(HttpServletResponse response, String exportFileName, String[] columnProperties,
			String[] columnLabels, Collection<T> items, PropertyValueGet<T> modelPropertyParse) {
		this(response, exportFileName, columnProperties, columnLabels, items,
				new ModelCellEditor<T>(modelPropertyParse));
	}

	public HttpModelCvsExport(HttpServletResponse response, String exportFileName, ColumnField<T>[] columnFields,
			Collection<T> items, PropertyValueGet<T> modelPropertyParse) {
		this(response, exportFileName, items, columnFields, new ModelCellEditor<T>(modelPropertyParse));
	}

	public HttpModelCvsExport(HttpServletResponse response, String exportFileName, String[] columnProperties,
			String[] columnLabels, Collection<T> items, ModelCellEditor<T> modelCellEditor) {
		this.response = response;
		this.exportFileName = exportFileName;
		this.columnProperties = columnProperties;
		this.columnLabels = columnLabels;
		this.items = items;
		this.modelCellEditor = modelCellEditor;
	}

	public HttpModelCvsExport(HttpServletResponse response, String exportFileName, Collection<T> items,
			ColumnField<T>[] columnFields, ModelCellEditor<T> modelCellEditor) {
		this.response = response;
		this.items = items;
		this.exportFileName = exportFileName;
		int length = columnProperties.length;
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
		CsvModelTableFactory<T> tableFactory = new CsvModelTableFactory<T>(modelCellEditor);
		Table createTable = tableFactory.createTable(columnProperties, columnLabels);
		if (null != exportFileName) {
			createTable.setCaption(exportFileName);
		}
		return createTable;
	}

	@Override
	public ViewExporter getExporter() {
		View view = new CsvView(getTable(), items);
		return new HttpCsvExporter(view, response, exportFileName);
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
