package com.jeefuse.base.web.component.jmesa;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.jmesa.core.CoreContext;
import org.jmesa.util.ItemUtils;
import org.jmesa.util.SupportUtils;
import org.jmesa.view.component.Column;
import org.jmesa.view.html.HtmlComponentFactory;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlColumnsGenerator;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.web.WebContext;

public class SimpleHtmlColumnsTag extends SimpleTagSupport {
	private String htmlColumnsGenerator;

	public String getHtmlColumnsGenerator() {
		return htmlColumnsGenerator;
	}

	public void setHtmlColumnsGenerator(String htmlColumnsGenerator) {
		this.htmlColumnsGenerator = htmlColumnsGenerator;
	}

	private Object getValue(String property, String var) {
		Object item = getJspContext().getAttribute(var);

		if (item == null)
			return null;

		return ItemUtils.getItemValue(item, property);
	}

	/**
	 * @return The list of columns generated on the fly.
	 */
	private List<HtmlColumn> getColumns(HtmlComponentFactory factory,
			WebContext webContext, CoreContext coreContext) {
		HtmlColumnsGenerator htmlColumns = (HtmlColumnsGenerator) TagUtils.createInstance(getHtmlColumnsGenerator());
		SupportUtils.setWebContext(htmlColumnsGenerator, webContext);
		SupportUtils.setCoreContext(htmlColumnsGenerator, coreContext);

		return htmlColumns.getColumns(factory);
	}

	/**
	 * Process the list of columns that are generated on the fly.
	 */
	@Override
	public void doTag() {
		SimpleTableFacadeTag facadeTag = (SimpleTableFacadeTag) findAncestorWithClass(this,SimpleTableFacadeTag.class);
		SimpleHtmlRowTag rowTag = (SimpleHtmlRowTag) findAncestorWithClass(this,SimpleHtmlRowTag.class);
		Collection<Map<String, Object>> pageItems = facadeTag.getPageItems();
		Map<String, Object> pageItem = rowTag.getPageItem();
		
		if (pageItems.size() == 1) {
			HtmlRow row = facadeTag.getTable().getRow();
			HtmlComponentFactory factory = facadeTag.getComponentFactory();
			WebContext webContext = facadeTag.getTableFacade().getWebContext();
			CoreContext coreContext = facadeTag.getTableFacade().getCoreContext();
			List<HtmlColumn> columns = getColumns(factory, webContext,coreContext);
			for (HtmlColumn column : columns) {
				column.setGeneratedOnTheFly(true);
				validateColumn(pageItem,facadeTag,column.getProperty());
				row.addColumn(column);
			}
		}

		HtmlRow row = facadeTag.getTable().getRow();
		List<Column> columns = row.getColumns();
		for (Column column : columns) {
			HtmlColumn htmlColumn = (HtmlColumn) column;
			if (htmlColumn.isGeneratedOnTheFly()) {
				String property = htmlColumn.getProperty();
				if (property != null) {
					String var = facadeTag.getVar();
					pageItem.put(property, getValue(property, var));
				}
			}
		}
	}
	
	  /**
     * @return Is true is the validation passes
     */
    private boolean validateColumn(Map<String,?> pageItem,SimpleTableFacadeTag facadeTag, String property) {
        if (property == null)
			return true; // no coflicts
        if (pageItem.get(property) != null) {
            String msg = "The column property [" + property + "] is not unique. One column value will overwrite another.";
            throw new IllegalStateException(msg);
        }
        String var = facadeTag.getVar();
        if (var.equals(property)) {
            String msg = "The column property [" + property + "] is the same as the TableFacadeTag var attribute [" + var + "].";
            throw new IllegalStateException(msg);
        }
        return true;
    }
}
