package com.jeefuse.base.web.component.jmesa;

import static org.apache.commons.lang.StringEscapeUtils.escapeJavaScript;
import static org.jmesa.view.html.HtmlConstants.ON_INVOKE_ACTION;
import static org.jmesa.view.html.HtmlConstants.ON_INVOKE_EXPORT_ACTION;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jmesa.core.CoreContext;
import org.jmesa.limit.Filter;
import org.jmesa.limit.Limit;
import org.jmesa.limit.RowSelect;
import org.jmesa.limit.Sort;
import org.jmesa.view.ViewUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.HtmlConstants;
import org.jmesa.view.html.HtmlUtils;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.toolbar.Toolbar;
import org.jmesa.worksheet.Worksheet;

public class SimpleHtmlSnippetsImpl{
	private HtmlTable table;
	private Toolbar toolbar;
	private CoreContext coreContext;

	public SimpleHtmlSnippetsImpl(HtmlTable table, Toolbar toolbar,
			CoreContext coreContext) {
		this.table = table;
		this.toolbar = toolbar;
		this.coreContext = coreContext;
	}

	protected HtmlTable getHtmlTable() {
		return table;
	}

	protected Toolbar getToolbar() {
		return toolbar;
	}

	protected CoreContext getCoreContext() {
		return coreContext;
	}

	public String themeStart() {
		HtmlBuilder html = new HtmlBuilder();
		html.div().styleClass(table.getTheme()).close();
		return html.toString();
	}

	public String themeEnd() {
		HtmlBuilder html = new HtmlBuilder();
		html.newline();
		html.divEnd();
		return html.toString();
	}

	public String tableStart() {
		HtmlBuilder html = new HtmlBuilder();
		html.append(table.getTableRenderer().render());
		return html.toString();
	}

	public String tableEnd() {
		HtmlBuilder html = new HtmlBuilder();
		html.tableEnd(0);
		return html.toString();
	}

	public String theadStart() {
		HtmlBuilder html = new HtmlBuilder();
		html.thead(1).close();
		return html.toString();
	}

	public String theadEnd() {
		HtmlBuilder html = new HtmlBuilder();
		html.theadEnd(1);
		return html.toString();
	}

	public String tbodyStart() {
		HtmlBuilder html = new HtmlBuilder();
		String tbodyClass = coreContext.getPreference(HtmlConstants.TBODY_CLASS);
		html.tbody(1).styleClass(tbodyClass).close();
		return html.toString();
	}

	public String tbodyEnd() {
		HtmlBuilder html = new HtmlBuilder();
		html.tbodyEnd(1);
		return html.toString();
	}

	@SuppressWarnings("unchecked")
	public String filter() {
		HtmlRow row = table.getRow();
		List columns = row.getColumns();

		if (!ViewUtils.isFilterable(columns))
			return "";

		HtmlBuilder html = new HtmlBuilder();
		String filterClass = coreContext.getPreference(HtmlConstants.FILTER_CLASS);
		html.tr(1).styleClass(filterClass).close();

		for (Iterator<Column> iter = columns.iterator(); iter.hasNext();) {
			HtmlColumn column = (HtmlColumn) iter.next();
			if (column.isFilterable()) {
				html.append(column.getFilterRenderer().render());
			} else {
				html.td(2).close().tdEnd();
			}
		}

		html.trEnd(1);
		return html.toString();
	}

	public String header() {
		HtmlBuilder html = new HtmlBuilder();
		String headerClass = coreContext.getPreference(HtmlConstants.HEADER_CLASS);
		html.tr(1).styleClass(headerClass).close();

		HtmlRow row = table.getRow();
		List<Column> columns = row.getColumns();

		for (Iterator<Column> iter = columns.iterator(); iter.hasNext();) {
			HtmlColumn column = (HtmlColumn) iter.next();
			html.append(column.getHeaderRenderer().render());
		}

		html.trEnd(1);
		return html.toString();
	}

	public String footer() {
		return null;
	}

	public String body() {
		HtmlBuilder html = new HtmlBuilder();

		int rowcount = HtmlUtils.startingRowcount(coreContext);

		Collection<?> items = coreContext.getPageItems();
		for (Object item : items) {
			rowcount++;

			HtmlRow row = table.getRow();
			List<Column> columns = row.getColumns();

			html.append(row.getRowRenderer().render(item, rowcount));

			for (Iterator<Column> iter = columns.iterator(); iter.hasNext();) {
				HtmlColumn column = (HtmlColumn) iter.next();
				html.append(column.getCellRenderer().render(item, rowcount));
			}

			html.trEnd(1);
		}
		return html.toString();
	}

	public String statusBarText() {
		Limit limit = coreContext.getLimit();
		RowSelect rowSelect = limit.getRowSelect();

		if (rowSelect.getTotalRows() == 0)
			return coreContext.getMessage(HtmlConstants.STATUSBAR_NO_RESULTS_FOUND);

		Integer total = rowSelect.getTotalRows();
		Integer from = rowSelect.getRowStart() + 1;
		Integer to = rowSelect.getRowEnd();
		Object[] messageArguments = { total, from, to };
		return coreContext.getMessage(HtmlConstants.STATUSBAR_RESULTS_FOUND,
				messageArguments);
	}

	public String toolbar() {
		HtmlBuilder html = new HtmlBuilder();

		HtmlRow row = table.getRow();
		List<Column> columns = row.getColumns();

		String toolbarClass = coreContext.getPreference(HtmlConstants.TOOLBAR_CLASS);
		html.tr(1).styleClass(toolbarClass).close();
		html.td(2).colspan(String.valueOf(columns.size())).close();

		html.append(toolbar.render());

		html.tdEnd();
		html.trEnd(1);

		return html.toString();
	}

	public String statusBar() {
		HtmlBuilder html = new HtmlBuilder();

		HtmlRow row = table.getRow();
		List<Column> columns = row.getColumns();

		html.tbody(1).close();

		String toolbarClass = coreContext
				.getPreference(HtmlConstants.STATUS_BAR_CLASS);
		html.tr(1).styleClass(toolbarClass).close();
		html.td(2).align("left").colspan(String.valueOf(columns.size()))
				.close();

		html.append(statusBarText());

		html.tdEnd();
		html.trEnd(1);

		html.tbodyEnd(1);

		return html.toString();
	}

	/**
	 * Create a Limit implementation in JavaScript. Will be invoked when the
	 * page is loaded.
	 * 
	 * @return The JavaScript Limit.
	 */
	public String initJavascriptLimit() {
		HtmlBuilder html = new HtmlBuilder();

		html.newline();
		html.script().type("text/javascript").close();

		html.newline();

		Limit limit = coreContext.getLimit();

		boolean useDocumentReady = HtmlUtils
				.useDocumentReadyToInitJavascriptLimit(coreContext);

		if (useDocumentReady) {
			html.append("$(document).ready(function(){").newline();
		}

		html.tab().append(
				"jQuery.jmesa.addTableFacade('" + limit.getId() + "')")
				.semicolon().newline();

		html.tab().append(
				"jQuery.jmesa.setMaxRowsToLimit('" + limit.getId() + "','"
						+ limit.getRowSelect().getMaxRows() + "')").semicolon()
				.newline();

		for (Sort sort : limit.getSortSet().getSorts()) {
			html.tab().append(
					"jQuery.jmesa.addSortToLimit('" + limit.getId() + "','"
							+ sort.getPosition() + "','" + sort.getProperty()
							+ "','" + sort.getOrder().toParam() + "')")
					.semicolon().newline();
		}

		for (Filter filter : limit.getFilterSet().getFilters()) {
			String value = escapeJavaScript(filter.getValue());
			html.tab().append(
					"jQuery.jmesa.addFilterToLimit('" + limit.getId() + "','"
							+ filter.getProperty() + "','" + value + "')")
					.semicolon().newline();
		}

		Worksheet worksheet = coreContext.getWorksheet();
		if (worksheet != null && worksheet.isFiltering()) {
			html.tab().append(
					"jQuery.jmesa.setFilterToWorksheet('" + limit.getId()
							+ "')").semicolon().newline();
		}

		html.tab().append(
				"jQuery.jmesa.setPageToLimit('" + limit.getId() + "','"
						+ limit.getRowSelect().getPage() + "')").semicolon()
				.newline();

		html.tab().append(
				"jQuery.jmesa.setOnInvokeAction('" + limit.getId() + "','"
						+ coreContext.getPreference(ON_INVOKE_ACTION) + "')")
				.semicolon().newline();
		html.tab().append(
				"jQuery.jmesa.setOnInvokeExportAction('" + limit.getId()
						+ "','"
						+ coreContext.getPreference(ON_INVOKE_EXPORT_ACTION)
						+ "')").semicolon().newline();

		if (useDocumentReady) {
			html.append("});").newline();
		}

		html.scriptEnd();

		return html.toString();
	}
}
