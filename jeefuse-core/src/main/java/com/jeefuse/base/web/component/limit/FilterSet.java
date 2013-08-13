package com.jeefuse.base.web.component.limit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 查询过滤集合.
 * 
 * @author yonclv
 * @created 2009-7-23
 */
public class FilterSet {
	private List<Filter> filters;

	public FilterSet() {
		filters = new ArrayList<Filter>();
	}
	
	public Collection<Filter> getFilters() {
		return filters;
	}

	public Filter getFilter(String property) {
		for (Iterator<Filter> iter = filters.iterator(); iter.hasNext();) {
			Filter filter = iter.next();
			if (filter.getPropertyName().equals(property)) {
				return filter;
			}
		}
		return null;
	}

	public String getFilterValue(String property) {
		return getFilter(property).getValue();
	}

	public void addFilter(String property, String value, MatchType matchType) {
		addFilter(new Filter(property, value, matchType));
	}

	public void addFilter(Filter filter) {
		if (filters.contains(filter)) {
			filters.remove(filter);
		}

		filters.add(filter);
	    Collections.sort(filters);
	}

	public boolean isFiltered(){
			return filters != null && !filters.isEmpty();
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);

		for (Iterator<Filter> iter = filters.iterator(); iter.hasNext();) {
			Filter filter = iter.next();
			builder.append(filter.toString());
		}

		return builder.toString();
	}
}
