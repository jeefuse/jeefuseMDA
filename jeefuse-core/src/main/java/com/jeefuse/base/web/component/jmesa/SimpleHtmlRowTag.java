package com.jeefuse.base.web.component.jmesa;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.jmesa.util.ItemUtils;
import org.jmesa.view.html.HtmlComponentFactory;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.renderer.HtmlRowRenderer;

public class SimpleHtmlRowTag extends SimpleTagSupport {
	private String rowRenderer;
	private String style;
	private String styleClass;
	private String evenClass;
	private String oddClass;
	private String highlightStyle;
	private String highlightClass;
	private boolean highlighter = true;
	private Boolean sortable;
	private Boolean filterable;
	private String onclick;
	private String onmouseover;
	private String onmouseout;
	private String uniqueProperty;
	private Map<String, Object> pageItem;

	/**
	 * @since 2.2
	 */
	public String getRowRenderer() {
		return rowRenderer;
	}

	/**
	 * @since 2.2
	 */
	public void setRowRenderer(String rowRenderer) {
		this.rowRenderer = rowRenderer;
	}

	/**
	 * @since 2.2
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @since 2.2
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @since 2.2
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * @since 2.2
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * @since 2.2
	 */
	public String getEvenClass() {
		return evenClass;
	}

	/**
	 * @since 2.2
	 */
	public void setEvenClass(String evenClass) {
		this.evenClass = evenClass;
	}

	/**
	 * @since 2.2
	 */
	public String getOddClass() {
		return oddClass;
	}

	/**
	 * @since 2.2
	 */
	public void setOddClass(String oddClass) {
		this.oddClass = oddClass;
	}

	/**
	 * @since 2.2
	 */
	public String getHighlightStyle() {
		return highlightStyle;
	}

	/**
	 * @since 2.2
	 */
	public void setHighlightStyle(String highlightStyle) {
		this.highlightStyle = highlightStyle;
	}

	/**
	 * @since 2.2
	 */
	public String getHighlightClass() {
		return highlightClass;
	}

	/**
	 * @since 2.2
	 */
	public void setHighlightClass(String highlightClass) {
		this.highlightClass = highlightClass;
	}

	public boolean isHighlighter() {
		return highlighter;
	}

	public void setHighlighter(boolean highlighter) {
		this.highlighter = highlighter;
	}

	/**
	 * @since 2.2
	 */
	public Boolean isSortable() {
		return sortable;
	}

	/**
	 * @since 2.2
	 */
	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	/**
	 * @since 2.2
	 */
	public Boolean isFilterable() {
		return filterable;
	}

	/**
	 * @since 2.2
	 */
	public void setFilterable(Boolean filterable) {
		this.filterable = filterable;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOnmouseover() {
		return onmouseover;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseout() {
		return onmouseout;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getUniqueProperty() {
		return uniqueProperty;
	}

	public void setUniqueProperty(String uniqueProperty) {
		this.uniqueProperty = uniqueProperty;
	}

	/**
	 * The row to use. If the row does not exist then one will be created.
	 */
	private HtmlRow getRow(HtmlComponentFactory factory) {
		HtmlRow row = factory.createRow();
		row.setUniqueProperty(getUniqueProperty());
		row.setHighlighter(isHighlighter());
		row.setSortable(isSortable());
		row.setFilterable(isFilterable());
		row.setOnclick(TagUtils.getRowOnclick(row, getOnclick()));
		row.setOnmouseover(TagUtils.getRowOnmouseover(row, getOnmouseover()));
		row.setOnmouseout(TagUtils.getRowOnmouseout(row, getOnmouseout()));

		HtmlRowRenderer curRowRender = TagUtils.getRowRowRenderer(row, getRowRenderer());
		row.setRowRenderer(curRowRender);

		curRowRender.setStyle(getStyle());
		curRowRender.setStyleClass(getStyleClass());
		curRowRender.setEvenClass(getEvenClass());
		curRowRender.setOddClass(getOddClass());
		curRowRender.setHighlightStyle(getHighlightClass());
		curRowRender.setStyleClass(getStyleClass());

		return row;
	}

	/**
	 * @return The current page item.
	 */
	Map<String, Object> getPageItem() {
		return pageItem;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment body = getJspBody();
		if (body == null)
			throw new IllegalStateException(
					"You need to wrap the columns in the row tag.");

		SimpleTableFacadeTag facadeTag = (SimpleTableFacadeTag) findAncestorWithClass(
				this, SimpleTableFacadeTag.class);
		Collection<Map<String, Object>> pageItems = facadeTag.getPageItems();
		this.pageItem = new HashMap<String, Object>();
		pageItems.add(pageItem);

		String var = facadeTag.getVar();
		Object bean = getJspContext().getAttribute(var);
		pageItem.put(var, bean);
		pageItem.put(ItemUtils.JMESA_ITEM, bean);

		HtmlTable table = facadeTag.getTable();
		HtmlRow row = table.getRow();
		if (row == null) {
			HtmlComponentFactory factory = facadeTag.getComponentFactory();
			row = getRow(factory);
			table.setRow(row);
		}

		body.invoke(null);
	}
}
