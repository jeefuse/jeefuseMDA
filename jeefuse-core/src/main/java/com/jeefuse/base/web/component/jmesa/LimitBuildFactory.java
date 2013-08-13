package com.jeefuse.base.web.component.jmesa;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jmesa.limit.Action;
import org.jmesa.limit.ExportType;
import org.jmesa.limit.Filter;
import org.jmesa.limit.FilterSet;
import org.jmesa.limit.FilterSetImpl;
import org.jmesa.limit.LimitUtils;
import org.jmesa.limit.Order;
import org.jmesa.limit.Sort;
import org.jmesa.limit.SortSet;
import org.jmesa.limit.SortSetImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LimitBuildFactory {

	private Logger logger = LoggerFactory.getLogger(LimitBuildFactory.class);
	private final Map<?, ?> parameters;
	private final String id;
	private final String prefixId;

	/**
	 *查询条件构造.
	 * @param id
	 * @param parameters
	 */
	public LimitBuildFactory(String id, Map<?, ?> parameters) {
		this.id = id;
		this.parameters = parameters;
		this.prefixId = id + "_";
	}

	public String getId() {
		return id;
	}

	/**
	 * 获取一次获取记录数,没有返回null.
	 * @return
	 */
	public Integer getMaxRows() {
		String maxRows = LimitUtils.getValue(parameters.get(prefixId+ Action.MAX_ROWS.toParam()));
		if (StringUtils.isNotBlank(maxRows)) {
			if (logger.isDebugEnabled()) {
				logger.debug("Max Rows:" + maxRows);
			}
			return Integer.parseInt(maxRows);
		}

		return null;
	}

	/**
	 * 获取当前分页,默认返回1.
	 * @return
	 */
	public int getPage() {
		String page = LimitUtils.getValue(parameters.get(prefixId+ Action.PAGE.toParam()));
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
	 * @return
	 */
	public FilterSet getFilterSet() {
		FilterSet filterSet = new FilterSetImpl();

		String clear = LimitUtils.getValue(parameters.get(prefixId+ Action.CLEAR.toParam()));
		if (StringUtils.isNotEmpty(clear)) {
			if (logger.isDebugEnabled()) {
				logger.debug("Cleared out the filters.");
			}
			return filterSet;
		}

		for (Object param : parameters.keySet()) {
			String parameter = (String) param;
			if (parameter.startsWith(prefixId + Action.FILTER.toParam())) {
				String value = LimitUtils.getValue(parameters.get(parameter));
				if (StringUtils.isNotBlank(value)) {
					String property = StringUtils.substringAfter(parameter,prefixId + Action.FILTER.toParam());
					Filter filter = new Filter(property, value);
					filterSet.addFilter(filter);
				}
			}
		}

		return filterSet;
	}

	/**
	 * 排序集合.
	 * @return
	 */
	public SortSet getSortSet() {
		SortSet sortSet = new SortSetImpl();

		for (Object param : parameters.keySet()) {
			String parameter = (String) param;
			if (parameter.startsWith(prefixId + Action.SORT.toParam())) {
				String value = LimitUtils.getValue(parameters.get(parameter));
				if (StringUtils.isNotBlank(value)) {
					String position = StringUtils.substringBetween(parameter,
							prefixId + Action.SORT.toParam(), "_");
					String property = StringUtils.substringAfter(parameter,
							prefixId + Action.SORT.toParam() + position + "_");
					Order order = Order.valueOfParam(value);
					Sort sort = new Sort(new Integer(position), property, order);
					sortSet.addSort(sort);
				}
			}
		}

		return sortSet;
	}

	public ExportType getExportType() {
		String exportType = LimitUtils.getValue(parameters.get(prefixId+ Action.EXPORT.toParam()));
		if (StringUtils.isNotBlank(exportType)) {
			if (logger.isDebugEnabled()) {
				logger.debug("ExportType: " + exportType);
			}
			ExportType et = ExportType.valueOfParam(exportType);
			if (et != null) {
				return et;
			}

			throw new IllegalStateException(
					"Not able to handle the export of type: " + exportType);
		}

		return null;
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
