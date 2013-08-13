package com.jeefuse.base.web.component.jmesa;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jmesa.limit.ExportType;
import org.jmesa.limit.FilterSet;
import org.jmesa.limit.Limit;
import org.jmesa.limit.LimitImpl;
import org.jmesa.limit.RowSelect;
import org.jmesa.limit.RowSelectImpl;
import org.jmesa.limit.SortSet;
import org.jmesa.limit.state.SessionState;
import org.jmesa.limit.state.State;
import org.jmesa.web.WebContext;

public class SimpleLimitFactoryImpl {
	private final LimitBuildFactory limitActionFactory;
	private final String id;
	private final WebContext webContext;
	private State state;

	/**
	 * @param id
	 *            The unique identifier for the current table being built.
	 * @param webContext
	 *            The adapter for the servlet request.
	 */
	public SimpleLimitFactoryImpl(String id, WebContext webContext) {
		this.id = id;
		this.webContext = webContext;
		this.limitActionFactory = new LimitBuildFactory(id, webContext.getParameterMap());
	}

	/**
	 * @param id
	 *            The unique identifier for the current table being built.
	 * @param webContext
	 *            The adapter for the servlet request.
	 */
	public SimpleLimitFactoryImpl(String id, HttpServletRequest request) {
		this.id = id;
		webContext=null;
		this.limitActionFactory = new LimitBuildFactory(id, request.getParameterMap());
	}
	
	public void setStateAttr(String stateAttr) {
		if (StringUtils.isNotEmpty(stateAttr)) {
			this.state = new SessionState(id, stateAttr, webContext);
		}
	}

	
	public Limit createLimit() {
		Limit limit = getStateLimit();

		if (limit != null)
			return limit;

		limit = new LimitImpl(limitActionFactory.getId());

		FilterSet filterSet =  getFilterSet();
		limit.setFilterSet(filterSet);

		SortSet sortSet = getSortSet();
		limit.setSortSet(sortSet);

		ExportType exportType = getExportType();
		limit.setExportType(exportType);

		limit.setRowSelect(getRowSelect());
		if (state != null && !limit.isExported()) {
			state.persistLimit(limit);
		}

		return limit;
	}
	
	public  ExportType getExportType(){
		return limitActionFactory.getExportType();
	}

	public FilterSet getFilterSet(){
		return limitActionFactory.getFilterSet();
	}
	
	public SortSet getSortSet(){
		return limitActionFactory.getSortSet();
	}
	
	public RowSelect getRowSelect(){
		int curpage=limitActionFactory.getPage();
		Integer maxRows = getMaxRows(limitActionFactory.getMaxRows());
		return new RowSelectImpl(curpage, maxRows, maxRows);
	}
	
	public RowSelect createRowSelect(int curMaxRows, int totalRows) {
		int page = limitActionFactory.getPage();
		int maxRows = getMaxRows(curMaxRows);
		return new RowSelectImpl(page, maxRows, totalRows);
	}

	
	public RowSelect createLimitAndRowSelect(int page, int curMaxRows, int totalRows) {
		int maxRows = getMaxRows(curMaxRows);
		return new RowSelectImpl(page, maxRows, totalRows);
	}

	private int getMaxRows(int maxRows) {
		Integer currentMaxRows = limitActionFactory.getMaxRows();
		if (currentMaxRows == null)
			return maxRows;

		return currentMaxRows;
	}

	public Limit getStateLimit() {
		if (state != null) {
			Limit l = state.retrieveLimit();
			if (l != null)
				return l;
		}

		return null;
	}
}
