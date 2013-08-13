package com.jeefuse.base.modules.export;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.core.CoreContext;
import org.jmesa.core.CoreContextImpl;
import org.jmesa.core.Items;
import org.jmesa.core.message.Messages;
import org.jmesa.core.message.MessagesFactory;
import org.jmesa.core.preference.Preferences;
import org.jmesa.core.preference.PreferencesFactory;
import org.jmesa.limit.FilterSet;
import org.jmesa.limit.FilterSetImpl;
import org.jmesa.limit.Limit;
import org.jmesa.limit.LimitImpl;
import org.jmesa.limit.RowSelectImpl;
import org.jmesa.limit.SortSet;
import org.jmesa.limit.SortSetImpl;
import org.jmesa.util.SupportUtils;
import org.jmesa.view.ExportTableFactory;
import org.jmesa.view.TableFactory;
import org.jmesa.view.View;
import org.jmesa.view.ViewExporter;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.Row;
import org.jmesa.view.component.Table;
import org.jmesa.view.csv.CsvTableFactory;
import org.jmesa.view.csv.CsvView;
import org.jmesa.view.html.HtmlTableFactory;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.web.HttpServletRequestWebContext;
import org.jmesa.web.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.modules.export.component.EmptyToolbar;
import com.jeefuse.base.modules.export.core.ExportType;
import com.jeefuse.base.modules.export.core.NoLimitItems;
import com.jeefuse.base.modules.export.exporter.cvs.HttpCsvExporter;
import com.jeefuse.base.modules.export.exporter.excel.ExcelView;
import com.jeefuse.base.modules.export.exporter.excel.HttpExcelExporter;
import com.jeefuse.base.modules.export.exporter.pdf.HttpPdfExporter;
import com.jeefuse.base.modules.export.exporter.pdf.PdfView;
import com.jeefuse.base.utils.common.RandomUtil;

/**
 * 导出文件.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ExportFacade {

	private Logger logger = LoggerFactory.getLogger(ExportFacade.class);
	private HttpServletResponse response;
	private HttpServletRequest request;
	private CoreContext coreContext;
	private WebContext webContext;
	private Messages messages;
	private Preferences preferences;
	private Limit limit;
	private String exportFileName;
	private String[] columnProperties;
	private String[] columnLabels;
	private Collection<?> items;

	public static ExportFacade instance(HttpServletRequest request, HttpServletResponse response, Collection<?> items,
			String[] columnProperties, String[] columnLabels, String exportFileName) {
		return new ExportFacade(request, response, items, columnProperties, columnLabels, exportFileName);
	}

	public static ExportFacade instance(HttpServletRequest request, HttpServletResponse response, Collection<?> items,
			ColumnField<?>[] columnFields, String exportFileName) {
		return new ExportFacade(request, response, items, columnFields, exportFileName);
	}

	public ExportFacade(HttpServletRequest request, HttpServletResponse response, Collection<?> items,
			ColumnField<?>[] columnFields, String exportFileName) {
		this.request = request;
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
	}

	public ExportFacade(HttpServletRequest request, HttpServletResponse response, Collection<?> items,
			String[] columnProperties, String[] columnLabels, String exportFileName) {
		this.request = request;
		this.response = response;
		this.items = items;
		this.columnProperties = columnProperties;
		this.columnLabels = columnLabels;
		this.exportFileName = exportFileName;
	}

	public WebContext getWebContext() {
		if (webContext == null) {
			this.webContext = new HttpServletRequestWebContext(request);
		}

		return webContext;
	}

	public CoreContext getCoreContext() {
		if (coreContext != null)
			return coreContext;

		Items itemsImpl = new NoLimitItems(items);
		coreContext = new CoreContextImpl(itemsImpl, getLimit(), null, getPreferences(), getMessages());
		return coreContext;
	}

	Messages getMessages() {
		if (messages != null)
			return messages;

		this.messages = MessagesFactory.getMessages(getWebContext());
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
		SupportUtils.setWebContext(messages, getWebContext());
	}

	Preferences getPreferences() {
		if (preferences != null)
			return preferences;

		this.preferences = PreferencesFactory.getPreferences(getWebContext());
		return preferences;
	}

	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
		SupportUtils.setWebContext(preferences, getWebContext());
	}

	public Limit getLimit() {
		if (null == limit) {

			limit = new LimitImpl(RandomUtil.timeRandom(5));
			FilterSet filterSet = new FilterSetImpl();
			limit.setFilterSet(filterSet);

			SortSet sortSet = new SortSetImpl();
			limit.setSortSet(sortSet);
			limit.setRowSelect(new RowSelectImpl(1, items.size(), items.size()));
		}
		return limit;
	}

	public void export(ExportType exportType) {
		try {
			switch (exportType) {
			case CSV:
				csvExport();
				break;
			case EXCEL:
				excelExport();
				break;
			case PDF:
				pdfExport();
				break;
			default:
				throw new IllegalArgumentException("未定义" + exportType + "类型的导出处理!");
			}
		} catch (Exception e) {
			logger.error("Not able to perform the " + exportType + " export.", e);
		}
	}

	private void settingTable(Table table) {
		if (null != columnLabels && columnLabels.length > 0) {
			Row row = table.getRow();
			List<Column> columns = row.getColumns();
			int len = columnLabels.length;
			for (int i = 0; i < len; i++) {
				Column column = columns.get(i);
				column.setTitle(columnLabels[i]);
			}
		}
		if (null != exportFileName) {
			table.setCaption(exportFileName);
		}
	}

	public void pdfExport() throws Exception {
		// create table
		TableFactory tableFactory = new HtmlTableFactory(getWebContext(), getCoreContext());
		Table table = tableFactory.createTable(columnProperties);
		settingTable(table);
		// create view
		View view = new PdfView((HtmlTable) table, new EmptyToolbar(), getWebContext(), getCoreContext());
		// create export
		ViewExporter export = new HttpPdfExporter(view, request, response, exportFileName);
		// export
		export.export();
	}

	public void excelExport() throws Exception {
		// create table
		TableFactory tableFactory = new ExportTableFactory(getWebContext(), getCoreContext());
		Table table = tableFactory.createTable(columnProperties);
		settingTable(table);
		// create view
		View view = new ExcelView(table, items);
		// create export
		ViewExporter export = new HttpExcelExporter(view, response, exportFileName);
		// export
		export.export();

	}

	public void csvExport() throws Exception {
		// create table
		TableFactory tableFactory = new CsvTableFactory(getWebContext(), getCoreContext());
		Table table = tableFactory.createTable(columnProperties);
		settingTable(table);
		// create view
		View view = new CsvView(table, getCoreContext());
		// create export
		ViewExporter export = new HttpCsvExporter(view, response, exportFileName);
		// export
		export.export();

	}

}
