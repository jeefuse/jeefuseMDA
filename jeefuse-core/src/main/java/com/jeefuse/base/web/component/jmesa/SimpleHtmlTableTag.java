package com.jeefuse.base.web.component.jmesa;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.jmesa.view.html.HtmlComponentFactory;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.renderer.HtmlTableRenderer;

public class SimpleHtmlTableTag extends SimpleTagSupport {
	 // core attributes
    private String caption;
    private String captionKey;

    // style attributes
    private String theme;
    private String tableRenderer;
    private String style;
    private String styleClass;
    private String width;
    private String border;
    private String cellpadding;
    private String cellspacing;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaptionKey() {
        return captionKey;
    }

    public void setCaptionKey(String captionKey) {
        this.captionKey = captionKey;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * @since 2.2
     */
    public String getTableRenderer() {
        return tableRenderer;
    }

    /**
     * @since 2.2
     */
    public void setTableRenderer(String tableRenderer) {
        this.tableRenderer = tableRenderer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getCellpadding() {
        return cellpadding;
    }

    public void setCellpadding(String cellpadding) {
        this.cellpadding = cellpadding;
    }

    public String getCellspacing() {
        return cellspacing;
    }

    public void setCellspacing(String cellspacing) {
        this.cellspacing = cellspacing;
    }

    /**
     * The table to use. If the table does not exist then one will be created.
     */
    private HtmlTable getTable(HtmlComponentFactory factory) {
        HtmlTable table = factory.createTable();
        table.setCaption(getCaption());
        table.setCaptionKey(getCaptionKey());
        table.setTheme(getTheme());

		HtmlTableRenderer tableRender = TagUtils.getTableTableRenderer(table, getTableRenderer());
		table.setTableRenderer(tableRender);

		tableRender.setWidth(getWidth());
		tableRender.setStyle(getStyle());
		tableRender.setStyleClass(getStyleClass());
		tableRender.setBorder(getBorder());
		tableRender.setCellpadding(getCellpadding());
		tableRender.setCellspacing(getCellspacing());

        return table;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment body = getJspBody();
        if (body == null)
			throw new IllegalStateException("You need to wrap the table in the facade tag.");

        SimpleTableFacadeTag facadeTag = (SimpleTableFacadeTag) findAncestorWithClass(this, SimpleTableFacadeTag.class);
        HtmlTable table = facadeTag.getTable();
        if (table == null) {
            HtmlComponentFactory factory = facadeTag.getComponentFactory();
            table = getTable(factory);
            facadeTag.setTable(table);
        }

        body.invoke(null);
    }
}
