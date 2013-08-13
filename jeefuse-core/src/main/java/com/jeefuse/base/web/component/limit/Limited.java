package com.jeefuse.base.web.component.limit;



/**查询限制条件接口.
 * @author  yonclv
 * @created 2009-7-22
 */
public interface Limited {
	
    public abstract String getId();

    public abstract RowSelect getRowSelect();

    public abstract void setRowSelect(RowSelect rowselect);

    public abstract FilterSet getFilterSet();

    public abstract void setFilterSet(FilterSet filterset);

    public abstract SortSet getSortSet();

    public abstract void setSortSet(SortSet sortset);
}
