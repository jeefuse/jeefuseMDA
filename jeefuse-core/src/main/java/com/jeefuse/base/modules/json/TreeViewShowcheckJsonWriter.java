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
public class TreeViewShowcheckJsonWriter<T extends TreeViewItem> implements JsonWriter {
	// treeview 输出字段
	private static final String id = "id";
	private static final String text = "text";
	private static final String value = "value";
	private static final String showcheck = "showcheck";
	private static final String checkstate = "checkstate";
	private static final String hasChildren = "hasChildren";
	private static final String isexpand = "isexpand";
	private static final String complete = "complete";
	private static final String childNodes = "childNodes";

	private TreeNodeGeneric<T> rootTreeNode;
	private List<String> checkIds;

	public TreeViewShowcheckJsonWriter(TreeNodeGeneric<T> rootTreeNode, List<String> checkIds) {
		this.rootTreeNode = rootTreeNode;
		this.checkIds = checkIds;
	}

	public void writeJson(Writer writer) throws IOException {
		JsonGenerator g = JsonUtil.jsonFactory.createJsonGenerator(writer);
		writeJson(g);
	}

	public void writeJson(JsonGenerator g) {
		try {
			g.writeStartArray();
			if (null != rootTreeNode) {
				List<TreeNodeGeneric<T>> treeViewItem = rootTreeNode.getChildrens();
				int len = treeViewItem.size();
				for (int i = 0; i < len; i++) {
					TreeNodeGeneric<T> model = treeViewItem.get(i);
					g.writeStartObject();// write model data
					writeJsonModel(g, model);
					g.writeEndObject();// write model data end
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
		TreeViewItem treeViewItem = treeNode.getTargetObject();
		g.writeStringField(id, treeViewItem.getId().toString());
		g.writeStringField(text, treeViewItem.getText());
		g.writeStringField(value, treeViewItem.getValue());
		g.writeBooleanField(showcheck, true);
		g.writeNumberField(checkstate, getCheckState(treeNode));
		g.writeBooleanField(isexpand, treeViewItem.getIsexpand());
		g.writeBooleanField(complete, treeViewItem.getComplete());
		g.writeBooleanField(hasChildren, treeNode.hasChildrens());
		if (treeNode.hasChildrens()) {
			List<TreeNodeGeneric<T>> treeNodeChildrens = treeNode.getChildrens();
			g.writeArrayFieldStart(childNodes);
			int len = treeNodeChildrens.size();
			for (int i = 0; i < len; i++) {
				TreeNodeGeneric<T> model = treeNodeChildrens.get(i);
				g.writeStartObject();// write model data
				writeJsonModel(g, model);
				g.writeEndObject();// write model data end
			}
			g.writeEndArray();
		}
	}

	/**
	 * 获取选中状态,0未选中,1选中,2有子节点选 中.
	 */
	private int getCheckState(TreeNodeGeneric<T> treeNode) {
		TreeViewItem treeViewItem = treeNode.getTargetObject();
		if (null != checkIds && checkIds.contains(treeViewItem.getId()))
			return 1;
		if (hasChildrensCheck(treeNode))
			return 2;
		return 0;
	}

	private boolean hasChildrensCheck(TreeNodeGeneric<T> treeNode) {
		TreeViewItem treeViewItem = treeNode.getTargetObject();
		if (null != checkIds && checkIds.contains(treeViewItem.getId()))
			return true;
		if (treeNode.hasChildrens()) {
			List<TreeNodeGeneric<T>> treeNodeChildrens = treeNode.getChildrens();
			for (TreeNodeGeneric<T> treeNodeGeneric : treeNodeChildrens) {
				hasChildrensCheck(treeNodeGeneric);
			}
		}
		return false;
	}
}
