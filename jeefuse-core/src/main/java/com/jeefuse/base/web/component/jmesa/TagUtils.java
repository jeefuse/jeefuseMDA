package com.jeefuse.base.web.component.jmesa;

import org.apache.commons.lang.StringUtils;
import org.jmesa.core.filter.FilterMatcherMap;
import org.jmesa.core.filter.RowFilter;
import org.jmesa.core.message.Messages;
import org.jmesa.core.preference.Preferences;
import org.jmesa.core.sort.ColumnSort;
import org.jmesa.limit.ExportType;
import org.jmesa.limit.Order;
import org.jmesa.util.SupportUtils;
import org.jmesa.view.View;
import org.jmesa.view.editor.BasicCellEditor;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.editor.FilterEditor;
import org.jmesa.view.editor.HeaderEditor;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.editor.HtmlCellEditor;
import org.jmesa.view.html.event.RowEvent;
import org.jmesa.view.html.renderer.HtmlCellRenderer;
import org.jmesa.view.html.renderer.HtmlFilterRenderer;
import org.jmesa.view.html.renderer.HtmlHeaderRenderer;
import org.jmesa.view.html.renderer.HtmlRowRenderer;
import org.jmesa.view.html.renderer.HtmlTableRenderer;
import org.jmesa.view.html.toolbar.Toolbar;
import org.jmesa.worksheet.editor.WorksheetEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TagUtils {
	private static Logger logger = LoggerFactory.getLogger(TagUtils.class);

	public static Object createInstance(String className) {
		if (StringUtils.isBlank(className))
			return null;
		try {
			return Class.forName(className).newInstance();
		} catch (Exception e) {
			logger.error((new StringBuilder()).append("Could not create the class [").append(className).append("]")
					.toString(), e);
			throw new RuntimeException((new StringBuilder()).append("Could not create the class [").append(className)
					.append("]").toString(), e);
		}
	}

	public static FilterMatcherMap getTableFacadeFilterMatcherMap(String filterMatcherMap) {
		return (FilterMatcherMap) createInstance(filterMatcherMap);
	}

	public static Messages getTableFacadeMessages(String messages) {
		return (Messages) createInstance(messages);
	}

	public static Preferences getTableFacadePreferences(String preferences) {
		return (Preferences) createInstance(preferences);
	}

	public static RowFilter getTableFacadeRowFilter(String rowFilter) {
		return (RowFilter) createInstance(rowFilter);
	}

	public static ColumnSort getTableFacadeColumnSort(String columnSort) {
		return (ColumnSort) createInstance(columnSort);
	}

	public static Toolbar getTableFacadeToolbar(String toolbar) {
		return (Toolbar) createInstance(toolbar);
	}

	public static int[] getTableFacadeMaxRowIncrements(String maxRowsIncrements) {
		if (StringUtils.isEmpty(maxRowsIncrements))
			return null;
		String results[] = StringUtils.split(maxRowsIncrements, ",");
		int toolbarMaxRowIncrements[] = new int[results.length];
		for (int i = 0; i < results.length; i++) {
			toolbarMaxRowIncrements[i] = Integer.parseInt(results[i]);
		}

		return toolbarMaxRowIncrements;
	}

	public static View getTableFacadeView(String view) {
		return (View) createInstance(view);
	}

	public static HtmlTableRenderer getTableTableRenderer(HtmlTable table, String tableRenderer) {
		if (StringUtils.isBlank(tableRenderer))
			return table.getTableRenderer();
		else
			return (HtmlTableRenderer) createInstance(tableRenderer);
	}

	public static HtmlRowRenderer getRowRowRenderer(HtmlRow row, String rowRenderer) {
		if (StringUtils.isBlank(rowRenderer))
			return row.getRowRenderer();
		else
			return (HtmlRowRenderer) createInstance(rowRenderer);
	}

	public static RowEvent getRowOnclick(HtmlRow row, String onclick) {
		if (StringUtils.isBlank(onclick))
			return row.getOnclick();
		else
			return (RowEvent) createInstance(onclick);
	}

	public static RowEvent getRowOnmouseover(HtmlRow row, String onmouseover) {
		if (StringUtils.isBlank(onmouseover))
			return row.getOnmouseover();
		else
			return (RowEvent) createInstance(onmouseover);
	}

	public static RowEvent getRowOnmouseout(HtmlRow row, String onmouseout) {
		if (StringUtils.isBlank(onmouseout))
			return row.getOnmouseout();
		else
			return (RowEvent) createInstance(onmouseout);
	}

	public static HtmlCellRenderer getColumnCellRenderer(HtmlColumn column, String cellRenderer) {
		if (StringUtils.isBlank(cellRenderer))
			return column.getCellRenderer();
		else {
			HtmlCellRenderer result = (HtmlCellRenderer) createInstance(cellRenderer);
			result.setCellEditor(column.getCellRenderer().getCellEditor());
			return result;
		}
	}

	public static WorksheetEditor getColumnWorksheetEditor(String worksheetEditor) {
		if (StringUtils.isEmpty(worksheetEditor))
			return null;
		else {
			WorksheetEditor result = (WorksheetEditor) createInstance(worksheetEditor);
			return result;
		}
	}

	public static CellEditor getColumnCellEditor(String cellEditor, String pattern, boolean hasBody) {
		boolean cellEditorNotDefined = StringUtils.isEmpty(cellEditor);
		if (hasBody && cellEditorNotDefined)
			return new BasicCellEditor();
		if (cellEditorNotDefined)
			return new HtmlCellEditor();
		else {
			CellEditor result = (CellEditor) createInstance(cellEditor);
			SupportUtils.setPattern(result, pattern);
			return result;
		}
	}

	public static HtmlFilterRenderer getColumnFilterRenderer(HtmlColumn column, String filterRenderer) {
		if (StringUtils.isBlank(filterRenderer))
			return column.getFilterRenderer();
		else {
			HtmlFilterRenderer result = (HtmlFilterRenderer) createInstance(filterRenderer);
			result.setFilterEditor(column.getFilterRenderer().getFilterEditor());
			return result;
		}
	}

	public static FilterEditor getColumnFilterEditor(HtmlColumn column, String filterEditor) {
		if (StringUtils.isEmpty(filterEditor))
			return column.getFilterRenderer().getFilterEditor();
		else
			return (FilterEditor) createInstance(filterEditor);
	}

	public static HtmlHeaderRenderer getColumnHeaderRenderer(HtmlColumn column, String headerRenderer) {
		if (StringUtils.isBlank(headerRenderer))
			return column.getHeaderRenderer();
		else {
			HtmlHeaderRenderer result = (HtmlHeaderRenderer) createInstance(headerRenderer);
			result.setHeaderEditor(column.getHeaderRenderer().getHeaderEditor());
			return result;
		}
	}

	public static HeaderEditor getColumnHeaderEditor(HtmlColumn column, String headerEditor) {
		if (StringUtils.isEmpty(headerEditor))
			return column.getHeaderRenderer().getHeaderEditor();
		else
			return (HeaderEditor) createInstance(headerEditor);
	}

	public static Order[] getColumnSortOrder(String sortOrder) {
		if (StringUtils.isBlank(sortOrder))
			return null;
		String orders[] = StringUtils.split(sortOrder, ",");
		Order results[] = new Order[orders.length];
		for (int i = 0; i < orders.length; i++) {
			String order = orders[i];
			Order valueOfParam = Order.valueOfParam(order);
			if (valueOfParam == null)
				throw new IllegalStateException(
						"The sortOrder must consist of comma separated values of asc, desc, and none.");
			results[i] = valueOfParam;
		}

		return results;
	}

	public static ExportType[] getTableFacadeExportTypes(String exportTypes) {
		if (StringUtils.isBlank(exportTypes))
			return null;
		String types[] = StringUtils.split(exportTypes, ",");
		ExportType et[] = new ExportType[types.length];
		for (int i = 0; i < types.length; i++) {
			et[i] = ExportType.valueOfParam(types[i]);
		}

		return et;
	}

}
