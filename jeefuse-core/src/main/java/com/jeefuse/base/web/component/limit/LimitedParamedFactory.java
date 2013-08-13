package com.jeefuse.base.web.component.limit;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeefuse.base.web.component.limit.exception.LimitedException;

/**
 * 查询限制条件参数获取.
 * 
 * @author yonclv
 * @created 2009-7-23
 */
public class LimitedParamedFactory {
	private static Logger logger = LoggerFactory.getLogger(LimitedParamedFactory.class);

	private static final String delimiter = "_";
	
	private final Map<?, ?> parameters;
	private final String id;
	private String prefixId="";

	public LimitedParamedFactory(String id, Map<?, ?> parameters) {
		this.id = id;
		this.parameters = parameters;
		if(StringUtils.isNotBlank(id)){
			   this.prefixId = id + "_";
		}
	}

	public String getId() {
		return id;
	}

	/**
	 * 从参数中获取一次获取记录数,没有返回null.
	 * @return
	 */
	public Integer getMaxRows() {
		String maxRows = LimitedUtils.getValue(parameters.get(prefixId+LimitedPrefix.MAX_ROWS.toParam()));
		if (StringUtils.isNotBlank(maxRows)) {
			if (logger.isDebugEnabled()) {
				logger.debug("Max Rows:" + maxRows);
			}
			return Integer.parseInt(maxRows);
		}
		return null;
	}
	
	public int getMaxRows(int initMaxRows){
		String maxRows = LimitedUtils.getValue(parameters.get(prefixId+LimitedPrefix.MAX_ROWS.toParam()));
		if (StringUtils.isNotBlank(maxRows)) {
			if (logger.isDebugEnabled()) {
				logger.debug("Max Rows:" + maxRows);
			}
			return Integer.parseInt(maxRows);
		}
		return initMaxRows;
	}

	/**
	 * 从参数中获取当前页码,没有返回null.
	 * @return
	 */
	public int getPage() {
		String page = LimitedUtils.getValue(parameters.get(prefixId+LimitedPrefix.PAGE.toParam()));
		if (StringUtils.isNotBlank(page)) {
			if (logger.isDebugEnabled()) {
				logger.debug("On Page :" + page);
			}
			return Integer.parseInt(page);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Defaulting to Page 1");
		}

		return 1;
	}
	
	/**
	 * 获取过滤集合.
	 * 解析规则为:prefix_flag_property_matchType_ordernum,e.g:假设前缀为a_,过滤的标识为f_
	 * @return
	 * @throws LimitedException
	 */
	public FilterSet getFilterSet() throws LimitedException{
		FilterSet filterSet = new FilterSet();
		for (Object param : parameters.keySet()) {
			String parameter = (String) param;
			if (parameter.startsWith(LimitedPrefix.FILTER.toParam())) {
				String value = LimitedUtils.getValue(parameters.get(parameter));
				if (StringUtils.isNotBlank(value)) {
					String[] paramed = StringUtils.split(parameter, delimiter);
					Filter filter=null;
					if(paramed.length<3)
						throw new LimitedException("过滤规则解析错误!过滤 "+parameter+" 参数设置错误!");
					if(paramed.length>3){
						filter= new Filter(paramed[2], value,MatchType.valueOfParam(paramed[3]),Integer.parseInt(paramed[4]));
					}else{
						filter= new Filter(paramed[2], value,MatchType.valueOfParam(paramed[3]));
					}
					filterSet.addFilter(filter);
				}
			}
		}
		return filterSet;
	}

	/**
	 *  排序集合.
	 *  解析规则为:prefix_flag_property_orderMode_ordernum,e.g:假设前缀为a_,排序的标识为s_
	 * ,属性为username,排序方向为asc,排序为1,则表示为:a_s_username_asc_1
	 * @return
	 * @throws LimitedException
	 */
	public SortSet getSortSet() throws LimitedException{
		SortSet sortSet = new SortSet();
		for (Object param : parameters.keySet()) {
			String parameter = (String) param;
			if (parameter.startsWith(prefixId + LimitedPrefix.SORT.toParam())) {
				String value = LimitedUtils.getValue(parameters.get(parameter));
				if (StringUtils.isNotBlank(value)) {
					String[] paramed = StringUtils.split(parameter, delimiter);
					if(paramed.length<4)
						throw new LimitedException("排序规则解析错误!排序 "+parameter+" 参数设置错误!");
					String property = paramed[2];
					String orderMode=paramed[3];
					int    position=Integer.parseInt(paramed[4]);
					Order order = Order.valueOfParam(orderMode);
					Sort sort = new Sort(position, property, order);
					sortSet.addSort(sort);
				}
			}
		}

		return sortSet;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("id", id);
		builder.append("prefixId", prefixId);
		if (parameters != null) {
			parameters.toString();
		}
		return builder.toString();
	}
}
