package com.jeefuse.base.web.component.limit;

import java.util.Map;



/**查询限制条件构造工厂接口.
 * @author  yonclv
 * @created 2009-7-23
 */
public class LimitedFactory {
	
	/**
	 * 创建查询条件.
	 */
	public static  Limited createLimited(String id,Map<?,?> parameters,int defaultMaxRows,int totalRows){
	        LimitedParamedFactory limitedParamed=createdParamedFactory(id,parameters);
	        Limited limit = new LimitedImpl(id);
	        limit.setFilterSet(limitedParamed.getFilterSet());
	        limit.setSortSet(limitedParamed.getSortSet());
	        int curPage=limitedParamed.getPage();
	        int curMaxRows=limitedParamed.getMaxRows(defaultMaxRows);
	        limit.setRowSelect(new RowSelect(curPage,curMaxRows,totalRows));
	        return limit;	
	}
	
	/**
	 * 构造查询参数.
	 * @param id
	 * @param parameters
	 * @return
	 */
	public static LimitedParamedFactory createdParamedFactory(String id,Map<?,?> parameters){
		return new LimitedParamedFactory(id,parameters);
	}
}