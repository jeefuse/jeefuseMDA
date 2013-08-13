package com.jeefuse.base.utils.page;

import java.util.Collections;
import java.util.List;

/**
 * 分页参数及查询结果封装.
 * 
 * @author yonclv
 * @param <T>
 *            结果对象类型
 */
public class Page<T> {

	static public final <T> Page<T> createPage() {
		return new Page<T>();
	}

	static public final <T> Page<T> createPage(int pageSize) {
		return new Page<T>(pageSize);
	}

	/**
	 * 不分页,查询所有记录.
	 */
	static public final <T> Page<T> createNoPage() {
		return new Page<T>(0);
	}

	public final static long defaultToalCount = -1;
	public static final int PAGESIZE_10 = 10;
	public static final int PAGESIZE_15 = 15;
	public static final int PAGESIZE_20 = 20;
	public static final int PAGESIZE_30 = 30;
	public static final int PAGESIZE_40 = 40;

	// 分页参数
	private int pageNo = 1;
	private int pageSize = PAGESIZE_20;
	// 返回结果
	private List<T> result = null;
	private long totalCount = defaultToalCount;
	private boolean autoCountTotal = true;// 是否需要自动计算总数

	public Page() {
	}

	/**
	 *分页对象.
	 * 
	 * @param autoCountTotal
	 *            是否需要自动计算总数 true:需要 false:不需要
	 */
	public Page(boolean autoCountTotal) {
		this.autoCountTotal = autoCountTotal;
	}

	/**
	 *分页对象.
	 * 
	 * @param pageSize
	 */
	public Page(final int pageSize) {
		setPageSize(pageSize);
	}

	/**
	 *分页对象.
	 * 
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页大小
	 */
	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	/**
	 * 获得当前页的页号,序号从1开始,默认为1.
	 */
	public int getPageNo() {
		if (pageNo < 1) {
			this.pageNo = 1;
		}

		return pageNo;
	}

	/**
	 * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
	 */
	public void setPageNo(int pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
		}
		this.pageNo = pageNo;
	}

	/**
	 * 获得每页的记录数量,默认为20.如果needPage为false则返回-1.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数量.
	 */
	public void setPageSize(final Integer pageSize) {
		if (null != pageSize) {
			this.pageSize = pageSize;
		}
	}

	/**
	 * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
	 * 
	 * @return
	 */
	public int getFirst() {
		return ((pageNo - 1) * pageSize);
	}

	/**
	 * 根据pageNo和pageSize计算当前页最后一条记录在总结果集中的位置.
	 * 
	 * @return
	 */
	public int getEnd() {
		return pageNo * pageSize;
	}

	/**
	 * 取得页内的记录列表.
	 */
	public List<T> getResult() {
		if (result == null) {
			result = Collections.emptyList();
		}
		return result;
	}

	/**
	 * 是否有结果记录列表.
	 * 
	 * @return
	 */
	public boolean isHasResult() {
		if (null == result || result.isEmpty())
			return false;
		return true;
	}

	public void setResult(final List<T> result) {
		this.result = result;
	}

	public long getTotalCount() {
		if (totalCount < 0 || !isAutoCountTotal()) {
			totalCount = result == null ? 0 : result.size();
		}
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 根据pageSize与totalCount计算总页数,默认值为-1.
	 */
	public long getTotalPages() {
		long total = getTotalCount();
		if (total < 0)
			return -1;

		long count = total / pageSize;
		if (total % pageSize > 0) {
			count++;
		}
		return count;
	}

	/**
	 * 是否还有下一页.
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * 取得下页的页号,序号从1开始.
	 */
	public int getNextPage() {
		if (isHasNext())
			return pageNo + 1;
		else
			return pageNo;
	}

	/**
	 * 是否还有上一页.
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 取得上页的页号,序号从1开始.
	 */
	public int getPrePage() {
		if (isHasPre())
			return pageNo - 1;
		else
			return pageNo;
	}

	/**
	 * 调置分页大小.
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 是否需要自动计算总数 true:需要, false:不需要,如果PageSize<=0将不自动计算总数.
	 */
	public boolean isAutoCountTotal() {
		if (this.getPageSize() <= 0)
			return false;
		return autoCountTotal;
	}

	/**
	 * 是否需要自动计算总数 true:需要, false:不需要
	 */
	public void setAutoCountTotal(boolean autoCountTotal) {
		this.autoCountTotal = autoCountTotal;
	}

	/**
	 * 不需要分页.获取所有数据.
	 */
	public void setNoPageGetAll() {
		this.pageSize = -1;
		this.autoCountTotal = false;
	}

}
