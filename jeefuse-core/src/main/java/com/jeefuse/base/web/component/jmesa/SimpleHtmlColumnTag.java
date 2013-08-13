package com.jeefuse.base.web.component.jmesa;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;
import org.jmesa.util.ItemUtils;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.editor.FilterEditor;
import org.jmesa.view.editor.HeaderEditor;
import org.jmesa.view.html.HtmlComponentFactory;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.renderer.HtmlCellRenderer;
import org.jmesa.view.html.renderer.HtmlFilterRenderer;
import org.jmesa.view.html.renderer.HtmlHeaderRenderer;
import org.jmesa.worksheet.editor.WorksheetEditor;

public class SimpleHtmlColumnTag extends SimpleTagSupport {
	private String property;
	private String title;
	private String titleKey;
	private Boolean sortable;
	private String sortOrder;
	private Boolean filterable;
	private Boolean editable;
	private String worksheetEditor;
	private String width;
	private String cellRenderer;
	private String filterRenderer;
	private String headerRenderer;
	private String style;
	private String styleClass;
	private String filterStyle;
	private String filterClass;
	private String headerStyle;
	private String headerClass;
	private String pattern;
	private String cellEditor;
	private String headerEditor;
	private String filterEditor;
	private String checkName;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

	public Boolean isSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	/**
	 * @since 2.2
	 * @return The sort order for the column.
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * @since 2.2
	 * @param sortOrder
	 *            The order array.
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean isFilterable() {
		return filterable;
	}

	public void setFilterable(Boolean filterable) {
		this.filterable = filterable;
	}

	/**
	 * @since 2.3
	 */
	public Boolean isEditable() {
		return editable;
	}

	/**
	 * @since 2.3
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public String getWorksheetEditor() {
		return worksheetEditor;
	}

	public void setWorksheetEditor(String worksheetEditor) {
		this.worksheetEditor = worksheetEditor;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @since 2.2
	 */
	public String getCellRenderer() {
		return cellRenderer;
	}

	/**
	 * @since 2.2
	 */
	public void setCellRenderer(String cellRenderer) {
		this.cellRenderer = cellRenderer;
	}

	/**
	 * @since 2.2
	 */
	public String getFilterRenderer() {
		return filterRenderer;
	}

	/**
	 * @since 2.2
	 */
	public void setFilterRenderer(String filterRenderer) {
		this.filterRenderer = filterRenderer;
	}

	/**
	 * @since 2.2
	 */
	public String getHeaderRenderer() {
		return headerRenderer;
	}

	/**
	 * @since 2.2
	 */
	public void setHeaderRenderer(String headerRenderer) {
		this.headerRenderer = headerRenderer;
	}

	/**
	 * @since 2.2.1
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @since 2.2.1
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @since 2.2.1
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * @since 2.2.1
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * @since 2.2
	 */
	public String getFilterStyle() {
		return filterStyle;
	}

	/**
	 * @since 2.2
	 */
	public void setFilterStyle(String filterStyle) {
		this.filterStyle = filterStyle;
	}

	/**
	 * @since 2.2
	 */
	public String getFilterClass() {
		return filterClass;
	}

	/**
	 * @since 2.2
	 */
	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}

	/**
	 * @since 2.2
	 */
	public String getHeaderStyle() {
		return headerStyle;
	}

	/**
	 * @since 2.2
	 */
	public void setHeaderStyle(String headerStyle) {
		this.headerStyle = headerStyle;
	}

	/**
	 * @since 2.2
	 */
	public String getHeaderClass() {
		return headerClass;
	}

	/**
	 * @since 2.2
	 */
	public void setHeaderClass(String headerClass) {
		this.headerClass = headerClass;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getCellEditor() {
		return cellEditor;
	}

	public void setCellEditor(String cellEditor) {
		this.cellEditor = cellEditor;
	}

	/**
	 * @since 2.2
	 * @return The header editor for the column.
	 */
	public String getHeaderEditor() {
		return headerEditor;
	}

	/**
	 * @since 2.2
	 * @param headerEditor
	 *            The header editor to use.
	 */
	public void setHeaderEditor(String headerEditor) {
		this.headerEditor = headerEditor;
	}

	/**
	 * @since 2.2
	 * @return The filter editor for the column.
	 */
	public String getFilterEditor() {
		return filterEditor;
	}

	/**
	 * @since 2.2
	 * @param filterEditor
	 *            The filter editor to use.
	 */
	public void setFilterEditor(String filterEditor) {
		this.filterEditor = filterEditor;
	}

	/**
	 * The column to use. If the column does not exist then one will be created.
	 */
	private HtmlColumn getColumn(HtmlComponentFactory factory) {
		HtmlColumn column = factory.createColumn(getProperty());
		column.setTitle(getTitle());
		column.setTitleKey(getTitleKey());
		column.setSortable(isSortable());
		column.setSortOrder(TagUtils.getColumnSortOrder(getSortOrder()));
		column.setFilterable(isFilterable());
		column.setEditable(isEditable());
		column.setWidth(getWidth());

		HtmlCellRenderer cr = TagUtils.getColumnCellRenderer(column, getCellRenderer());
		cr.setStyle(getStyle());
		cr.setStyleClass(getStyleClass());
		column.setCellRenderer(cr);

		// worksheet
		WorksheetEditor we = TagUtils.getColumnWorksheetEditor(getWorksheetEditor());
		cr.setWorksheetEditor(we);

		// cell

		CellEditor ce = TagUtils.getColumnCellEditor(getCellEditor(), getPattern(), getJspBody() != null);
		cr.setCellEditor(ce);

		// filter

		HtmlFilterRenderer fr = TagUtils.getColumnFilterRenderer(column, getFilterRenderer());
		fr.setStyle(getFilterStyle());
		fr.setStyleClass(getFilterClass());
		column.setFilterRenderer(fr);

		FilterEditor fe = TagUtils.getColumnFilterEditor(column, getFilterEditor());
		fr.setFilterEditor(fe);

		// header
		HtmlHeaderRenderer hr = null;
		if (StringUtils.isNotBlank(getCheckName())) {
			hr = new HtmlCheckboxHeaderRendererImpl(column, getCheckName());
		} else {
			hr = TagUtils.getColumnHeaderRenderer(column, getHeaderRenderer());
			HeaderEditor he = TagUtils.getColumnHeaderEditor(column, getHeaderEditor());
			hr.setHeaderEditor(he);
		}
		hr.setStyle(getHeaderStyle());
		hr.setStyleClass(getHeaderClass());
		column.setHeaderRenderer(hr);
		return column;
	}

	/**
	 * If a ColumnTag body is defined then use it as the current page item
	 * value. If it is not defined then get the page item value from the regular
	 * bean by using the property
	 * 
	 * @return The item to use.
	 */
	private Object getValue(Object item) throws JspException, IOException {
		if (item == null)
			return null;

		JspFragment body = getJspBody();
		if (body == null)
			return ItemUtils.getItemValue(item, getProperty());

		StringWriter value = new StringWriter();
		body.invoke(value);
		return value;
	}

	@Override
	public void doTag() throws JspException, IOException {
		SimpleTableFacadeTag facadeTag = (SimpleTableFacadeTag) findAncestorWithClass(this, SimpleTableFacadeTag.class);
		SimpleHtmlRowTag rowTag = (SimpleHtmlRowTag) SimpleTagSupport.findAncestorWithClass(this,
				SimpleHtmlRowTag.class);
		Collection<Map<String, Object>> pageItems = facadeTag.getPageItems();
		if (pageItems.size() == 1) {
			HtmlRow row = facadeTag.getTable().getRow();
			HtmlComponentFactory factory = facadeTag.getComponentFactory();
			HtmlColumn column = getColumn(factory);
			Map<String, ?> pageItem = rowTag.getPageItem();
			validateColumn(pageItem, facadeTag, getProperty());
			row.addColumn(column);
		}
		Map<String, Object> pageItem = rowTag.getPageItem();
		String var = facadeTag.getVar();
		Object item = getJspContext().getAttribute(var);
		pageItem.put(getProperty(), getValue(item));
	}

	/**
	 * @return Is true is the validation passes
	 */
	private boolean validateColumn(Map<String, ?> pageItem, SimpleTableFacadeTag facadeTag, String p_property) {
		if (p_property == null)
			return true; // no coflicts
		if (pageItem.get(p_property) != null) {
			String msg = "The column property [" + p_property
					+ "] is not unique. One column value will overwrite another.";
			throw new IllegalStateException(msg);
		}
		String var = facadeTag.getVar();
		if (var.equals(p_property)) {
			String msg = "The column property [" + p_property + "] is the same as the TableFacadeTag var attribute ["
					+ var + "].";
			throw new IllegalStateException(msg);
		}
		return true;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
}
