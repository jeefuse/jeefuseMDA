package com.jeefuse.base.modules.json;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;

/**
 * 使用jackson.输出FlexidGridTree格式的json数据.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class FlexidTreeGridJsonWriter<T extends TreeViewItem> implements JsonWriter {
	protected static final String TOTAL = "total";
	protected static final String PAGE = "page";
	protected static final String ROWS = "rows";
	protected static final String SUCCESS = "success";
	protected static final String MESSAGE = "message";
	protected static final String TEXT = "text";
	protected static final String HAS_CHILDREN = "hasChildren";
	protected static final String COMPLETE = "complete";
	protected static final String CHILD_NODES = "childNodes";

	protected int pageNo = 1;
	protected long total = -1;
	private List<TreeNodeGeneric<T>> treeNodeList;
	private String message;
	private boolean success = true;

	public FlexidTreeGridJsonWriter(List<TreeNodeGeneric<T>> treeNodeList, long total) {
		this.treeNodeList = treeNodeList;
		this.total = total;
	}

	public FlexidTreeGridJsonWriter(List<TreeNodeGeneric<T>> treeNodeList, long total, boolean success, String message) {
		this.treeNodeList = treeNodeList;
		this.total = total;
		this.success = success;
		this.message = message;
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
			g.writeBooleanField(SUCCESS, success);
			g.writeStringField(MESSAGE, message);
			g.writeArrayFieldStart(ROWS);
			if (null != treeNodeList && !treeNodeList.isEmpty()) {
				for (TreeNodeGeneric<T> treeNode : treeNodeList) {
					g.writeStartObject();
					writeJsonModel(g, treeNode);
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

	protected abstract void writeJsonModel(JsonGenerator g, TreeNodeGeneric<T> treeNode)
			throws JsonGenerationException, IOException;

}
