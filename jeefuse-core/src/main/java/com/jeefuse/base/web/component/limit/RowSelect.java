package com.jeefuse.base.web.component.limit;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 分页参数.
 * 
 * @author yonclv
 * @created 2009-7-24
 */
public class RowSelect {
	private int page;
	private int maxRows;
	private int rowStart;
	private int rowEnd;
	private int totalRows;

	public RowSelect(int page, int maxRows, int totalRows) {
		this.maxRows = maxRows;
		this.totalRows = totalRows;
		init(page);
	}

	private void init(int curpage) {
		page = getValidPage(curpage, maxRows, totalRows);

		rowStart = (page - 1) * maxRows;

		rowEnd = rowStart + maxRows;

		if (rowEnd > totalRows) {
			rowEnd = totalRows;
		}
	}

	/**
	 * The page returned that is not greater than the pages that can display.
	 */
	private int getValidPage(int p_page, int p_maxRows, int p_totalRows) {
		while (!isValidPage(p_page, p_maxRows, p_totalRows)) {
			--page;
		}
		return page;
	}

	/**
	 * Testing that the page returned is not greater than the pages that are
	 * able to be displayed. The problem arises if using the state feature and
	 * rows are deleted.
	 */
	private boolean isValidPage(int p_page, int p_maxRows, int p_totalRows) {
		if (p_page == 1)
			return true;

		rowStart = (p_page - 1) * p_maxRows;
		rowEnd = rowStart + p_maxRows;
		if (rowEnd > p_totalRows) {
			rowEnd = p_totalRows;
		}
		return rowEnd > rowStart;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		init(page);
	}

	public int getRowStart() {
		return rowStart;
	}

	public int getRowEnd() {
		return rowEnd;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public int getTotalRows() {
		return totalRows;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("page", page);
		builder.append("maxRows", maxRows);
		builder.append("rowEnd", rowEnd);
		builder.append("rowStart", rowStart);
		builder.append("totalRows", totalRows);
		return builder.toString();
	}
}
