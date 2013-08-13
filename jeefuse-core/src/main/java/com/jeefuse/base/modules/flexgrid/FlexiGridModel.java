package com.jeefuse.base.modules.flexgrid;

import java.util.List;

/**
 * FlexGrid 表格JSON数据格式.
 * 
 * @author yonclv
 */
public class FlexiGridModel {
	private int page = 1;
	private long total = -1;
	private List<?> rows = null;
	private String message = null;
	private boolean success = true;

	public FlexiGridModel(int page, long total, List<?> list) {
		this.page = page;
		this.total = total;
		this.rows = list;
	}

	public FlexiGridModel(int page, long total, List<?> rows, String message, boolean success) {
		this.page = page;
		this.total = total;
		this.rows = rows;
		this.message = message;
		this.success = success;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "FlexiGridModel [message=" + message + ", page=" + page + ", rows=" + rows + ", success=" + success
				+ ", total=" + total + "]";
	}


}
