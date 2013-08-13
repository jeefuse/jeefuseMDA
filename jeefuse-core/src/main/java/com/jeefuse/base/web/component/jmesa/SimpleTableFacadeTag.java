package com.jeefuse.base.web.component.jmesa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.jmesa.limit.Limit;
import org.jmesa.view.View;
import org.jmesa.view.html.HtmlComponentFactory;
import org.jmesa.view.html.HtmlUtils;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.web.JspPageWebContext;
import org.jmesa.web.WebContext;


/**自定义TableFacade tag.
 * @author  yonclv
 * @created 2009-8-18
 */
public class SimpleTableFacadeTag extends SimpleTagSupport{
    private String id;//表格id
    private Collection<?> items;//数据例表集合
    private int totalRows;//数据集合总数
    private int maxRows;//一次获取最大行数
    private String maxRowsIncrements;//可选记录数
    private Limit limit;
    private String columnSort;
    private String rowFilter;
    private String view;//视图
    private String toolbar;
	private boolean autoSort=false;
	private boolean autoFilter=false;
    private boolean editable=false;//是否可编辑
    private boolean enablePageNumbers=true;
    private String stateAttr;
    private String var;//变量
    private SimpleTableFacade tableFacade;
    private String messages;//本地化信息
	private String preferences;//喜好设定
	private String filterMatcherMap;
    private HtmlTable table;
	private String checkBoxProperty = null;
    private HtmlComponentFactory componentFactory;
    private Collection<Map<String, Object>> pageItems = new ArrayList<Map<String, Object>>();
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<?> getItems() {
		return items;
	}

	public void setItems(Collection<?> items) {
		this.items = items;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	public String getMaxRowsIncrements() {
		return maxRowsIncrements;
	}

	public void setMaxRowsIncrements(String maxRowsIncrements) {
		this.maxRowsIncrements = maxRowsIncrements;
	}

	public boolean isEnablePageNumbers() {
		return enablePageNumbers;
	}

	public void setEnablePageNumbers(boolean enablePageNumbers) {
		this.enablePageNumbers = enablePageNumbers;
	}

	public boolean isAutoSort() {
		return autoSort;
	}

	public void setAutoSort(boolean autoSort) {
		this.autoSort = autoSort;
	}

	public boolean isAutoFilter() {
		return autoFilter;
	}

	public void setAutoFilter(boolean autoFilter) {
		this.autoFilter = autoFilter;
	}

	public String getStateAttr() {
		return stateAttr;
	}

	public void setStateAttr(String stateAttr) {
		this.stateAttr = stateAttr;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
	public Limit getLimit() {
		return limit;
	}

	public void setLimit(Limit limit) {
		this.limit = limit;
	}

	public String getRowFilter() {
		return rowFilter;
	}

	public void setRowFilter(String rowFilter) {
		this.rowFilter = rowFilter;
	}

	public String getColumnSort() {
		return columnSort;
	}

	public void setColumnSort(String columnSort) {
		this.columnSort = columnSort;
	}

	public String getToolbar() {
		return toolbar;
	}

	public void setToolbar(String toolbar) {
		this.toolbar = toolbar;
	}

	public HtmlTable getTable() {
		return table;
	}

	public void setTable(HtmlTable table) {
		this.table = table;
	}

	public Collection<Map<String, Object>> getPageItems() {
		return pageItems;
	}

	public void setPageItems(Collection<Map<String, Object>> pageItems) {
		this.pageItems = pageItems;
	}

    public String getFilterMatcherMap() {
		return filterMatcherMap;
	}

	public void setFilterMatcherMap(String filterMatcherMap) {
		this.filterMatcherMap = filterMatcherMap;
	}

	/**
     * @return Get the HtmlComponentFactory.
     */
    HtmlComponentFactory getComponentFactory() {
        if (componentFactory != null)
			return componentFactory;

        this.componentFactory = new HtmlComponentFactory(tableFacade.getWebContext(), tableFacade.getCoreContext());

        return componentFactory;
    }
    
	@Override
	public void doTag() throws JspException, IOException {
		    JspFragment body = getJspBody();
	        if (body == null)
				throw new IllegalStateException("You need to wrap the table in the tablewrap tag.");
	        tableFacade = createTableFacade();
	        tableFacade.setId(getId());
	        tableFacade.setStateAttr(getStateAttr());
	        tableFacade.setEditable(isEditable());
	        tableFacade.setItems(getItems());
	        tableFacade.setMaxRows(getMaxRows());
	        tableFacade.setTotalRows(getTotalRows());
	        tableFacade.setAutoFilter(autoFilter);
	        tableFacade.setAutoSort(autoSort);
	        tableFacade.setLimit(getLimit());
	        tableFacade.setEnablePageNumbers(isEnablePageNumbers());
	        tableFacade.setMaxRowsIncrements(TagUtils.getTableFacadeMaxRowIncrements(getMaxRowsIncrements()));
	        tableFacade.setPreferences(TagUtils.getTableFacadePreferences(getPreferences()));
	        tableFacade.setMessages(TagUtils.getTableFacadeMessages(getMessages()));
	        tableFacade.setColumnSort(TagUtils.getTableFacadeColumnSort(getColumnSort()));
		// tableFacade.setRowFilter(TagUtils.getTableFacadeRowFilter(getRowFilter()));
	        tableFacade.addFilterMatcherMap(TagUtils.getTableFacadeFilterMatcherMap(getFilterMatcherMap()));

	        Collection<?> pi = tableFacade.getCoreContext().getPageItems();
	        if (pi.size() == 0) {
	            body.invoke(null);
	            getPageItems().clear();
	        } else {
	            int count = HtmlUtils.startingRowcount(tableFacade.getCoreContext());
	            for (Iterator<?> iterator = pi.iterator(); iterator.hasNext();) {
	                Object item = iterator.next();
	                getJspContext().setAttribute(getVar(), item);
	                getJspContext().setAttribute("rowcount", ++count);
	                body.invoke(null);
	            }
	        }

	        getJspContext().removeAttribute(getVar()); // clean up the page scoped bean
	        getJspContext().removeAttribute("rowcount");

	        tableFacade.setTable(getTable());
	        tableFacade.setToolbar(TagUtils.getTableFacadeToolbar(getToolbar()));
	        tableFacade.setView(TagUtils.getTableFacadeView(getView()));
	        tableFacade.getCoreContext().setPageItems(getPageItems());
	        
	        View v = tableFacade.getView();
	        getJspContext().getOut().print(v.render().toString());
	}
	
    public SimpleTableFacade getTableFacade() {
		return tableFacade;
	}

	protected WebContext getWebContext() {
        return new JspPageWebContext((PageContext) getJspContext());
    }

    protected SimpleTableFacade createTableFacade() {
    	SimpleTableFacade facade = new SimpleTableFacade(getId(), getWebContext());
        return facade;
    }

	public String getCheckBoxProperty() {
		return checkBoxProperty;
	}

	public void setCheckBoxProperty(String checkBoxProperty) {
		this.checkBoxProperty = checkBoxProperty;
	}
}
