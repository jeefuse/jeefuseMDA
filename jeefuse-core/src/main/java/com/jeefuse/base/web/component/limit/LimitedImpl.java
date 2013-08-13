package com.jeefuse.base.web.component.limit;

/**
 * 查询限制条件.
 * 
 * @author yonclv
 * @created 2009-7-23
 */
public class LimitedImpl implements Limited {
	private final String id;
	private RowSelect rowSelect;
	private FilterSet filterSet;
	private SortSet sortSet;
	
	public LimitedImpl(String id) {
		this.id = id;
	}

	public FilterSet getFilterSet() {

		return filterSet;

	}

	public String getId() {
		return id;
	}

	public RowSelect getRowSelect() {

		return rowSelect;

	}

	public SortSet getSortSet() {

		return sortSet;

	}

	public void setFilterSet(FilterSet filterset) {
		this.filterSet=filterset;
	}

	public void setRowSelect(RowSelect rowselect) {
		this.rowSelect=rowselect;
	}

	public void setSortSet(SortSet sortset) {
		this.sortSet=sortset;
	}

}
