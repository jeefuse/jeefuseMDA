package com.jeefuse.base.web.component.jmesa;

import static org.jmesa.limit.LimitConstants.LIMIT_ROWSELECT_MAXROWS;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmesa.core.CoreContext;
import org.jmesa.core.CoreContextFactory;
import org.jmesa.core.filter.FilterMatcher;
import org.jmesa.core.filter.FilterMatcherMap;
import org.jmesa.core.filter.MatcherKey;
import org.jmesa.core.filter.RowFilter;
import org.jmesa.core.message.Messages;
import org.jmesa.core.message.MessagesFactory;
import org.jmesa.core.preference.Preferences;
import org.jmesa.core.preference.PreferencesFactory;
import org.jmesa.core.sort.ColumnSort;
import org.jmesa.facade.WorksheetWrapper;
import org.jmesa.limit.ExportType;
import org.jmesa.limit.FilterSet;
import org.jmesa.limit.FilterSetImpl;
import org.jmesa.limit.Limit;
import org.jmesa.limit.LimitImpl;
import org.jmesa.limit.SortSet;
import org.jmesa.limit.SortSetImpl;
import org.jmesa.util.SupportUtils;
import org.jmesa.view.ExportTableFactory;
import org.jmesa.view.TableFactory;
import org.jmesa.view.View;
import org.jmesa.view.component.Table;
import org.jmesa.view.csv.CsvTableFactory;
import org.jmesa.view.csv.CsvView;
import org.jmesa.view.csv.CsvViewExporter;
import org.jmesa.view.excel.ExcelView;
import org.jmesa.view.excel.ExcelViewExporter;
import org.jmesa.view.html.HtmlTableFactory;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.toolbar.Toolbar;
import org.jmesa.view.jexcel.JExcelView;
import org.jmesa.view.jexcel.JExcelViewExporter;
import org.jmesa.view.pdf.PdfView;
import org.jmesa.view.pdf.PdfViewExporter;
import org.jmesa.view.pdfp.PdfPView;
import org.jmesa.view.pdfp.PdfPViewExporter;
import org.jmesa.web.HttpServletRequestWebContext;
import org.jmesa.web.WebContext;
import org.jmesa.worksheet.Worksheet;
import org.jmesa.worksheet.WorksheetImpl;
import org.jmesa.worksheet.state.SessionWorksheetState;
import org.jmesa.worksheet.state.WorksheetState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class SimpleTableFacade  {
	private Logger logger = LoggerFactory.getLogger(SimpleTableFacade.class);
	private HttpServletRequest request;
	private HttpServletResponse response;
	private WebContext webContext;
	private CoreContext coreContext;
	private Messages messages;
	private Preferences preferences;
	private String id;
	private int maxRows;
	private int totalRows;
	private Collection<?> items=null;
	private String[] columnProperties=null;
	private Limit limit=null;
	private Table table=null;
	private Toolbar toolbar=null;
	private int[] maxRowsIncrements=null;
	private boolean enablePageNumbers=true;
	private boolean autoSort=false;
	private boolean autoFilter=false;
	private boolean editable=false;
	private String stateAttr;
	private Worksheet worksheet=null;
	private Map<MatcherKey, FilterMatcher> filterMatchers=null;
	private RowFilter rowFilter=null;
	private ColumnSort columnSort=null;
	private View view=null;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SimpleTableFacade(String id, HttpServletRequest request) {
		this.id = id;
		this.request = request;
	}

	public SimpleTableFacade(String id, WebContext webContext) {
		this.id = id;
		this.webContext = webContext;
	}
	
	public void addFilterMatcher(MatcherKey key, FilterMatcher matcher) {
		Assert.isNull(coreContext,"It is too late to set the FilterMatcher. You need to set the FilterMatcher before using the CoreContext.");
		if (filterMatchers == null) {
			filterMatchers = new HashMap<MatcherKey, FilterMatcher>();
		}
		filterMatchers.put(key, matcher);
	}

	public void addFilterMatcherMap(FilterMatcherMap filterMatcherMap) {
		Assert.isNull(coreContext,"It is too late to set the FilterMatcher. You need to set the FilterMatcher before using the CoreContext.");
		if (filterMatcherMap == null)
			return;
		SupportUtils.setWebContext(filterMatcherMap, getWebContext());
		Map<MatcherKey, FilterMatcher> matchers = filterMatcherMap.getFilterMatchers();
		Set<MatcherKey> keys = matchers.keySet();
		for (MatcherKey key : keys) {
			FilterMatcher matcher = matchers.get(key);
			addFilterMatcher(key, matcher);
		}
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

	public CoreContext getCoreContext() {

        if (coreContext != null)
			return coreContext;
        
        Assert.notNull(items,"The items are null. You need to set the items on the facade.");
        
        CoreContextFactory factory = new SimpleCoreContextFactory(autoFilter,autoSort,getWebContext());
        factory.setPreferences(getPreferences());
        factory.setMessages(getMessages());
        factory.setColumnSort(columnSort);
        factory.setRowFilter(rowFilter);

        if (filterMatchers != null) {
            Set<MatcherKey> keySet = filterMatchers.keySet();
            for (MatcherKey key : keySet) {
                FilterMatcher matcher = filterMatchers.get(key);
                factory.addFilterMatcher(key, matcher);
            }
        }

        this.coreContext = factory.createCoreContext(items, getLimit(), getWorksheet());
        return coreContext;

	}

	public Limit getLimit() {
		if (limit != null)
			return limit;
		SimpleLimitFactoryImpl limitFactory=new SimpleLimitFactoryImpl(id, getWebContext());
		limitFactory.setStateAttr(stateAttr);
		limit = limitFactory.getStateLimit();
		if(null!=limit)
			return limit;
		
		limit= new LimitImpl(id);
		
		//exportType
		limit.setExportType(limitFactory.getExportType());
		
		//rowSelect
		limit.setRowSelect(limitFactory.createRowSelect(maxRows, totalRows));

		//sortSet
		SortSet sortSet = new SortSetImpl();
		if (autoSort) {
			sortSet=limitFactory.getSortSet();
		}
		limit.setSortSet(sortSet);
		
		//filter
		FilterSet filterSet = new FilterSetImpl();
		if(autoFilter){
			filterSet=limitFactory.getFilterSet();
		}
		limit.setFilterSet(filterSet);
		return  limit;
	}

	public Table getTable() {
		if (table != null)
			return table;
		if (columnProperties == null || columnProperties.length == 0)
			throw new IllegalStateException("The column properties are null. You need to set the columnProperties, or build the Table with the factory.");

		Limit l = getLimit();

		if (!l.isExported()) {
			 if (limit.getRowSelect() == null)
				throw new IllegalStateException( "The RowSelect is null. You need to set the totalRows on the facade.");
			HtmlTableFactory tableFactory = new HtmlTableFactory(getWebContext(), getCoreContext());
			this.table = tableFactory.createTable(columnProperties);
		} else {
			this.table = getExportTable(l.getExportType());
		}
		return table;
	}

	protected Table getExportTable(ExportType exportType) {

        if (exportType == ExportType.CSV) {
            TableFactory tableFactory = new CsvTableFactory(getWebContext(), getCoreContext());
            return tableFactory.createTable(columnProperties);
        } else if (exportType == ExportType.EXCEL) {
            TableFactory tableFactory = new ExportTableFactory(getWebContext(), getCoreContext());
            return tableFactory.createTable(columnProperties);
        } else if (exportType == ExportType.JEXCEL) {
            TableFactory tableFactory = new ExportTableFactory(getWebContext(), getCoreContext());
            return tableFactory.createTable(columnProperties);
        } else if (exportType == ExportType.PDF) {
            TableFactory tableFactory = new HtmlTableFactory(getWebContext(), getCoreContext());
            return tableFactory.createTable(columnProperties);
        } else if (exportType == ExportType.PDFP) {
            TableFactory tableFactory = new ExportTableFactory(getWebContext(), getCoreContext());
            return tableFactory.createTable(columnProperties);
        }

        throw new IllegalStateException("Not able to handle the export of type: " + exportType);
    }

	public Toolbar getToolbar() {

        if (toolbar != null)
			return toolbar;
        this.toolbar = new PagenatorToolbar(enablePageNumbers);
        SupportUtils.setCoreContext(toolbar, getCoreContext());
        SupportUtils.setWebContext(toolbar, getWebContext());
        SupportUtils.setMaxRowsIncrements(toolbar, maxRowsIncrements);
        return toolbar;
	}

	public View getView() {
		if (view != null)
			return view;

        Limit l = getLimit();

        if (!l.isExported()) {
            setView(new SimpleHtmlView());
        } else {
            this.view = getExportView(l.getExportType());
        }

        return view;

	}
	
    protected View getExportView(ExportType exportType) {

        if (exportType == ExportType.CSV)
			return new CsvView(getTable(), getCoreContext());
		else if (exportType == ExportType.EXCEL)
			return new ExcelView(getTable(), getCoreContext());
		else if (exportType == ExportType.JEXCEL)
			return new JExcelView(getTable(), getCoreContext());
		else if (exportType == ExportType.PDF)
			return new PdfView((HtmlTable) getTable(), getToolbar(), getWebContext(), getCoreContext());
		else if (exportType == ExportType.PDFP)
			return new PdfPView(getTable(), getToolbar(), getWebContext(), getCoreContext());

        throw new IllegalStateException("Not able to handle the export of type: " + exportType);
    }

    public int getMaxRows() {
        if (maxRows == 0) {
            String mr = getPreferences().getPreference(LIMIT_ROWSELECT_MAXROWS);
            this.maxRows = Integer.valueOf(mr);
        }
        return maxRows;
    }
    
	public WebContext getWebContext() {
        if (webContext == null) {
            this.webContext = new HttpServletRequestWebContext(request);
        }
        return webContext;

	}
    
	public Worksheet getWorksheet() {
	    if (worksheet != null || !editable)
			return worksheet;

        WorksheetState state = new SessionWorksheetState(id, getWebContext());
        Worksheet ws = state.retrieveWorksheet();

        if (ws == null || !SimpleTableFacadeUtils.isTableRefreshing(id, getWebContext())) {
            ws = new WorksheetImpl(id, getMessages());
            state.persistWorksheet(ws);
        }

        this.worksheet = new WorksheetWrapper(ws, getWebContext());

        return worksheet;

	}

	public void setColumnProperties(String... columnProperties) {
	    Assert.isNull(table,"It is too late to set the columnProperties. You need to set the columnProperties before using the Table.");
	    this.columnProperties = columnProperties;
	}

	public void setColumnSort(ColumnSort columnSort) {
		Assert.isNull(coreContext,"It is too late to set the ColumnSort. You need to set the ColumnSort before using the CoreContext.");
		this.columnSort = columnSort;
		SupportUtils.setWebContext(columnSort, getWebContext());
	}

	public void setCoreContext(CoreContext coreContext) {
	    Assert.isNull(table,"It is too late to set the CoreContext. You need to set the CoreContext before using the Table.");
        this.coreContext = coreContext;
        SupportUtils.setWebContext(coreContext, getWebContext());
	}

	public void setEditable(boolean editable) {
		Assert.isNull(items,"It is too late to set editable. You need to set editable before using the Limit.");
	    this.editable = editable;
	}

	public void setItems(Collection<?> items) {
		Assert.isNull(coreContext,"It is too late to set the items. You need to set the items before using the CoreContext.");
		if (editable) {
			this.items = SimpleTableFacadeUtils.filterWorksheetItems(items, getWorksheet());
		} else {
			this.items = items;
		}
	}

	public void setLimit(Limit limit) {
		Assert.isNull(coreContext,"It is too late to set the Limit. You need to set the Limit before using the CoreContext.");
	    this.limit = limit;
	}

	public void setMaxRows(int maxRows) {
        Assert.isNull(coreContext,"It is too late to set the maxRows. You need to set the maxRows before using the CoreContext.");
        this.maxRows = maxRows;

	}

	public void setMaxRowsIncrements(int... maxRowsIncrements) {
	    if (toolbar != null)
			throw new IllegalStateException(
                "It is too late to set the maxRowsIncrements. You need to set the maxRowsIncrements before using the Toolbar.");
        this.maxRowsIncrements = maxRowsIncrements;
	}

    public Messages getMessages() {
        if (messages != null)
			return messages;
        this.messages = MessagesFactory.getMessages(getWebContext());
        return messages;
    }
    
	public void setMessages(Messages messages) {
		Assert.isNull(coreContext,"It is too late to set the Messages. You need to set the Messages before using the CoreContext.");
		this.messages = messages;
		SupportUtils.setWebContext(messages, getWebContext());
	}

    public Preferences getPreferences() {
        if (preferences != null)
			return preferences;

        this.preferences = PreferencesFactory.getPreferences(getWebContext());
        return preferences;
    }
    
	public void setPreferences(Preferences preferences) {
		Assert.isNull(coreContext,"It is too late to set the Preferences. You need to set the Preferences before using the CoreContext.");
		this.preferences = preferences;
		SupportUtils.setWebContext(preferences, getWebContext());
	}

	public void setRowFilter(RowFilter rowFilter) {
		Assert.isNull(coreContext,"It is too late to set the RowFilter. You need to set the RowFilter before using the CoreContext.");
		this.rowFilter = rowFilter;
		SupportUtils.setWebContext(rowFilter, getWebContext());
	}

	public void setTable(Table table) {
	    if (view != null)
			throw new IllegalStateException(
                "It is too late to set the Table. You need to set the Table before using the View.");
        this.table = table;
	}

	public void setToolbar(Toolbar toolbar) {
		if (view != null)
			throw new IllegalStateException(
                "It is too late to set the Toolbar. You need to set the Toolbar before using the View.");
		this.toolbar = toolbar;
		SupportUtils.setTable(toolbar, getTable());
		SupportUtils.setCoreContext(toolbar, getCoreContext());
		SupportUtils.setWebContext(toolbar, getWebContext());
		SupportUtils.setMaxRowsIncrements(toolbar, maxRowsIncrements);
	}

	public void setTotalRows(int totalRows) {
		this.totalRows=totalRows;
	}

	public void setView(View view) {
		this.view = view;
		SupportUtils.setTable(view, getTable());
		SupportUtils.setToolbar(view, getToolbar());
		SupportUtils.setCoreContext(view, getCoreContext());
		SupportUtils.setWebContext(view, getWebContext());
	}

	public void setWebContext(WebContext webContext) {
		 this.webContext = webContext;
	}

	public String render() {

		Limit l = getLimit();
		View v = getView();

		if (!l.isExported())
			return v.render().toString();

		ExportType exportType = l.getExportType();
		renderExport(exportType, v);

		return null;

	}
	
	public void renderExport(ExportType exportType){
		view = getExportView(exportType);
		renderExport(exportType,view);
	}

	protected void renderExport(ExportType exportType, View curView) {
		try {
			CoreContext cc = getCoreContext();

			if (exportType == ExportType.CSV) {
				new CsvViewExporter(curView, cc, response).export();
			} else if (exportType == ExportType.EXCEL) {
				new ExcelViewExporter(curView, cc, response).export();
			} else if (exportType == ExportType.JEXCEL) {
				new JExcelViewExporter(curView, cc, response).export();
			} else if (exportType == ExportType.PDF) {
				new PdfViewExporter(curView, cc, request, response).export();
			} else if (exportType == ExportType.PDFP) {
				new PdfPViewExporter(curView, cc, request, response).export();
			}
		} catch (Exception e) {
			logger.error("Not able to perform the " + exportType + " export.");
		}
	}

	public boolean isEnablePageNumbers() {
		return enablePageNumbers;
	}

	public void setEnablePageNumbers(boolean enablePageNumbers) {
		this.enablePageNumbers = enablePageNumbers;
	}

}
