package com.jeefuse.base.web.component.jmesa;

import org.jmesa.view.AbstractContextSupport;
import org.jmesa.view.component.Column;
import org.jmesa.view.component.ColumnSupport;
import org.jmesa.view.editor.HeaderEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.renderer.HtmlHeaderRenderer;

public class HtmlCheckboxHeaderRendererImpl extends AbstractContextSupport implements HtmlHeaderRenderer, ColumnSupport {
	private Column column;
	private HeaderEditor headerEditor;
	private String style;
	private String styleClass;
	private String checkName;

	public HtmlCheckboxHeaderRendererImpl(HtmlColumn column, String checkName) {
		setColumn(column);
		this.checkName = checkName;
	}

	public HtmlColumn getColumn() {
		return (HtmlColumn) column;
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

	public Object render() {
		HtmlBuilder html = new HtmlBuilder();
		String element = getCoreContext().getPreference("html.column.header.renderer.element");
		if (element.equalsIgnoreCase("td")) {
			html.td(2);
		} else {
			html.th(2);
		}
		html.width(getColumn().getWidth());
		html.style(getStyle());
		html.styleClass(getStyleClass());
		html.close();
		html.append("<input type=\"checkbox\" class=\"checkbox\" onclick=\"checkAllOrNot('"
				+ getColumn().getProperty() + "',this)\"/>");
		if (element.equalsIgnoreCase("td")) {
			html.tdEnd();
		} else {
			html.thEnd();
		}
		return html.toString();
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public HeaderEditor getHeaderEditor() {
		return headerEditor;
	}

	public void setHeaderEditor(HeaderEditor headerEditor) {
		this.headerEditor = headerEditor;
	}

	public String getCheckName() {
		return checkName;
	}
}
