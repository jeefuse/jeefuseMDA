package com.jeefuse.base.web.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.jeefuse.base.exception.InvalidParamException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.condition.order.OrderMode;
import com.jeefuse.base.modules.condition.order.OrderSet;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.component.jmesa.LimitBuildFactory;

/**
 * Request请求工具类,规定的请求参数构造,如分页、排序字段.
 * 
 * @author yonclv
 */
public class RequestUtil {

	public static final String sortFieldName = "sortField";
	public static final String sortOrderName = "sortOrder";
	public static final String separator = ",";

	/**
	 * 构造排序字段.
	 */
	public static Order[] buildOrders(HttpServletRequest request) {
		String sortField = request.getParameter(sortFieldName);
		String sortOrder = request.getParameter(sortOrderName);
		if (StringUtils.isNotBlank(sortField)) {
			if (-1 == StringUtils.indexOf(sortField, separator)) {
				OrderMode orderMode = OrderMode.valueOfParam(sortOrder);
				if (null == orderMode)
					return null;
				return new Order[] { new Order(sortField, orderMode) };
			}
			String[] sortFields = StringUtils.split(sortField, separator);
			String[] sortOrders = StringUtils.split(sortOrder, separator);
			if (sortFields.length != sortOrders.length)
				throw new InvalidParamException("指定的排序字段与排序方向不一致!");
			int len = sortFields.length;
			List<Order> orderList = new ArrayList<Order>();
			for (int i = 0; i < len; i++) {
				OrderMode orderMode = OrderMode.valueOfParam(sortOrders[i]);
				if (null == orderMode) {
					continue;
				}
				orderList.add(new Order(sortFields[i], orderMode));
			}
			if (orderList.isEmpty())
				return null;
			return orderList.toArray(new Order[orderList.size()]);
		}
		return null;
	}

	/**
	 * 构造排序字段.
	 */
	public static OrderSet buildOrderSet(HttpServletRequest request) {
		String sortField = request.getParameter(sortFieldName);
		String sortOrder = request.getParameter(sortOrderName);
		if (StringUtils.isNotBlank(sortField)) {
			if (-1 == StringUtils.indexOf(sortField, separator))
				return OrderSet.create(sortField, OrderMode.valueOfParam(sortOrder));
			String[] sortFields = StringUtils.split(sortField, separator);
			String[] sortOrders = StringUtils.split(sortOrder, separator);
			if (sortFields.length != sortOrders.length)
				throw new InvalidParamException("指定的排序字段与排序方向不一致!");
			int len = sortFields.length;
			Order[] orders = new Order[len];
			for (int i = 0; i < len; i++) {
				orders[i] = new Order(sortFields[i], OrderMode.valueOfParam(sortOrders[i]));
			}
			return OrderSet.create(orders);
		}
		return null;
	}

	/**
	 * 构造extJmesa Tag 分页参数.
	 * 
	 * @param id
	 *            extJmesa Tag Id
	 * @param request
	 *            请求对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Page buildPage(String id, HttpServletRequest request) {
		LimitBuildFactory limitBuilder = new LimitBuildFactory(id, request.getParameterMap());
		int page = limitBuilder.getPage();
		Integer maxRows = limitBuilder.getMaxRows();
		if (null == maxRows)
			return new Page(page);
		return new Page(page, maxRows);
	}

	/**
	 * 构造extJmesa Tag 分页参数.
	 * 
	 * @param id
	 *            extJmesa Tag Id
	 * @param page
	 *            分页对象.
	 * @param request
	 *            请求对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Page buildPage(String id, Page page, HttpServletRequest request) {
		LimitBuildFactory limitBuilder = new LimitBuildFactory(id, request.getParameterMap());
		int curpage = limitBuilder.getPage();
		page.setPageNo(curpage);
		Integer maxRows = limitBuilder.getMaxRows();
		if (null != maxRows) {
			page.setPageSize(maxRows);
		}
		return page;
	}

	public static Map<String, Object> filterParamsWithPrefix(String prefix, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<?, ?> params = request.getParameterMap();
		for (Iterator<?> it = params.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			if (key.startsWith(prefix)) {
				map.put(key, params.get(key));
			}
		}
		return map;
	}

}
