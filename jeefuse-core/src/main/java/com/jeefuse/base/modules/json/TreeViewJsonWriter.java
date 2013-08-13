package com.jeefuse.base.modules.json;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;

/**
 * 构造jquery.tree.js树形结构数据.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class TreeViewJsonWriter<T extends TreeViewItem> implements JsonWriter {
	// treeview 输出字段
	private static final String ID = "id";
	private static final String TEXT = "text";
	private static final String VALUE = "value";
	private static final String HASCHILDREN = "hasChildren";
	private static final String ISEXPAND = "isexpand";
	private static final String COMPLETE = "complete";
	private static final String CHILD_NODES = "childNodes";
	private static final String DEFAULT_ROOT_ID = "";

	private String rootName;
	private TreeNodeGeneric<T> rootTreeNode;

	public TreeViewJsonWriter(TreeNodeGeneric<T> rootTreeNode) {
		this.rootTreeNode = rootTreeNode;
	}

	public TreeViewJsonWriter(TreeNodeGeneric<T> treeNode, String rootName) {
		this.rootTreeNode = treeNode;
		this.rootName = rootName;
	}

	public void writeJson(Writer writer) throws IOException {
		JsonGenerator g = JsonUtil.jsonFactory.createJsonGenerator(writer);
		writeJson(g);
	}

	public void writeJson(JsonGenerator g) {
		try {
			g.writeStartArray();
			if (null != rootName) {
				g.writeStartObject();
				g.writeStringField(ID, DEFAULT_ROOT_ID);
				g.writeStringField(TEXT, rootName);
				g.writeStringField(VALUE, DEFAULT_ROOT_ID);
				g.writeBooleanField(ISEXPAND, true);
				g.writeBooleanField(COMPLETE, true);
				g.writeBooleanField(HASCHILDREN, null != rootTreeNode && rootTreeNode.hasChildrens());
				if (null != rootTreeNode && rootTreeNode.hasChildrens()) {
					g.writeArrayFieldStart(CHILD_NODES);
					List<TreeNodeGeneric<T>> treeViewItems = rootTreeNode.getChildrens();
					for (TreeNodeGeneric<T> model : treeViewItems) {
						writeJsonModel(g, model);
					}
					g.writeEndArray();
				}
				g.writeEndObject();
			} else {
				if (null != rootTreeNode) {
					List<TreeNodeGeneric<T>> treeViewItems = rootTreeNode.getChildrens();
					for (TreeNodeGeneric<T> model : treeViewItems) {
						writeJsonModel(g, model);
					}
				}
			}
			g.writeEndArray();
			g.flush();
			g.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeJsonModel(JsonGenerator g, TreeNodeGeneric<T> treeNode) throws JsonGenerationException,
			IOException {
		g.writeStartObject();// write model data
		TreeViewItem treeViewItem = treeNode.getTargetObject();
		g.writeStringField(ID, treeViewItem.getId().toString());
		g.writeStringField(TEXT, treeViewItem.getText());
		g.writeStringField(VALUE, treeViewItem.getValue());
		// g.writeNumberField(checkstate, treeViewItem.getCheckstate());
		g.writeBooleanField(ISEXPAND, treeViewItem.getIsexpand());
		g.writeBooleanField(COMPLETE, treeViewItem.getComplete());
		g.writeBooleanField(HASCHILDREN, treeNode.hasChildrens());
		if (treeNode.hasChildrens()) {
			List<TreeNodeGeneric<T>> treeNodeChildren = treeNode.getChildrens();
			g.writeArrayFieldStart(CHILD_NODES);
			int len = treeNodeChildren.size();
			for (int i = 0; i < len; i++) {
				TreeNodeGeneric<T> model = treeNodeChildren.get(i);
				writeJsonModel(g, model);
			}
			g.writeEndArray();
		}
		g.writeEndObject();// write model data end

	}
}
