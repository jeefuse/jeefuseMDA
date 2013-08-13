package com.jeefuse.base.modules.export.exporter.pdf;

import java.util.Collection;

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
import org.jmesa.view.View;
import org.jmesa.view.ViewExporter;
import org.jmesa.view.component.Table;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.web.HttpServletRequestWebContext;
import org.jmesa.web.WebContext;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.base.modules.export.component.EmptyToolbar;
import com.jeefuse.base.modules.export.component.model.ModelHtmlCellEditor;
import com.jeefuse.base.modules.export.component.model.ModelHtmlTableFactory;
import com.jeefuse.base.modules.export.core.NoLimitItems;
import com.jeefuse.base.modules.export.exporter.AbstractModelExport;
import com.jeefuse.base.utils.common.RandomUtil;

public class HttpModelPdfExport<T> extends AbstractModelExport {

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
	private Collection<T> items;
	ModelHtmlCellEditor<T> modelCellEditor;
	private Table table;

	public HttpModelPdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			String[] columnProperties,
			String[] columnLabels, Collection<T> items, PropertyValueGet<T> modelPropertyParse) {
		this(request, response, exportFileName, columnProperties, columnLabels, items, new ModelHtmlCellEditor<T>(
				modelPropertyParse));
	}

	public HttpModelPdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			ColumnField<T>[] columnFields,
			Collection<T> items, PropertyValueGet<T> modelPropertyParse) {
		this(request, response, exportFileName, items, columnFields, new ModelHtmlCellEditor<T>(modelPropertyParse));
	}

	public HttpModelPdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			String[] columnProperties,
			String[] columnLabels, Collection<T> items, ModelHtmlCellEditor<T> modelCellEditor) {
		this.request = request;
		this.response = response;
		this.exportFileName = exportFileName;
		this.columnProperties = columnProperties;
		this.columnLabels = columnLabels;
		this.items = items;
		this.modelCellEditor = modelCellEditor;
	}

	public HttpModelPdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			Collection<T> items, ColumnField<T>[] columnFields, ModelHtmlCellEditor<T> modelCellEditor) {
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
		this.modelCellEditor = modelCellEditor;
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

	@Override
	public Table getTable() {
		if (table == null) {
			table = createTable();
		}
		return table;
	}

	protected Table createTable() {
		ModelHtmlTableFactory<T> tableFactory = new ModelHtmlTableFactory<T>(getWebContext(), getCoreContext(),
				modelCellEditor);
		Table createtable = tableFactory.createTable(columnProperties, columnLabels);
		if (null != exportFileName) {
			table.setCaption(exportFileName);
		}
		return createtable;
	}

	@Override
	public ViewExporter getExporter() {
		View view = new PdfView((HtmlTable) getTable(), new EmptyToolbar(), getWebContext(), getCoreContext());
		return new HttpPdfExporter(view, request, response, exportFileName);
	}

}
