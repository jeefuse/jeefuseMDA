package com.jeefuse.base.modules.json;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;

import com.jeefuse.base.utils.page.Page;

/**
 * 运用jackson.输出FlexidGrid格式的json数据.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class FlexidGridJsonWriter<T> extends ModelJsonWriter<T> {
	private static final String TOTAL = "total";
	private static final String PAGE = "page";
	private static final String ROWS = "rows";
	private static final String SUCCESS = "success";
	private static final String MESSAGE = "message";

	private int pageNo = 1;
	private long total = 0;
	private List<T> items = null;
	private String message;
	private boolean success = true;

	public FlexidGridJsonWriter(int pageNo, long total, List<T> items) {
		this.pageNo = pageNo;
		this.total = total;
		this.items = items;
	}

	public FlexidGridJsonWriter(int pageNo, long total, List<T> items, String message, boolean success) {
		this.pageNo = pageNo;
		this.total = total;
		this.items = items;
		this.message = message;
		this.success = success;
	}

	public FlexidGridJsonWriter(Page<T> page) {
		this.pageNo = page.getPageNo();
		this.total = page.getTotalCount();
		this.items = page.getResult();
	}

	public void writeJson(Writer writer) throws IOException {
		JsonGenerator g = JsonUtil.jsonFactory.createJsonGenerator(writer);
		writeJson(g);
	}

	public void writeJson(JsonGenerator g) {
		try {
			g.writeStartObject();
			g.writeNumberField(TOTAL, total);
			g.writeNumberField(PAGE, pageNo);
			g.writeStringField(MESSAGE, message);
			g.writeBooleanField(SUCCESS, success);
			g.writeArrayFieldStart(ROWS);
			if (null != items && !items.isEmpty()) {
				for (T model : items) {
					// write model data
					g.writeStartObject();
					writeJsonModel(g, model);
					g.writeEndObject();
				}
			}
			g.writeEndArray();
			g.writeEndObject();
			g.flush();
			g.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
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

}
