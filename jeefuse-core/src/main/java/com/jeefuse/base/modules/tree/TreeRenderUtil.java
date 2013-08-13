package com.jeefuse.base.modules.tree;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.List;

import com.jeefuse.base.modules.json.TreeViewJsonWriter;
import com.jeefuse.base.modules.json.TreeViewShowcheckJsonWriter;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGenericConstructUtil;
import com.jeefuse.base.modules.tree.renders.htmlSelect.HtmlSelectTreeRender;
import com.jeefuse.base.modules.tree.renders.htmlSelect.TreeNodeItem;
import com.jeefuse.base.modules.tree.renders.menu.TreeMenuUIRender;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewConstructFactory;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.base.web.utils.RenderUtil;

public class TreeRenderUtil {

	/**
	 * 输出jquery.treeview.js json树形结构数据.
	 */
	static public <T extends TreeViewItem> void jsonTreeview(List<T> items, String rootName) {
		TreeViewJsonWriter<T> jsonWriter = TreeViewConstructFactory.contructTreeViewJsonWriter(items, rootName);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出jquery.treeview.js json树形结构数据显示checkbox.
	 * 
	 * @param items
	 *            源数据集合
	 * @param checkIds
	 *            已勾选的ID例表.
	 */
	static public <T extends TreeViewItem> void jsonTreeviewShowCheck(List<T> items, List<String> checkIds) {
		TreeViewShowcheckJsonWriter<T> jsonWriter = TreeViewConstructFactory.contructTreeViewShowcheckJsonWriter(items,
				checkIds);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 构造jquery.treeview.js json树形结构数据显示checkbox.返回json字符串.
	 * 
	 * @param items
	 * @param checkIds
	 * @return
	 * @throws IOException
	 */
	static public <T extends TreeViewItem> String jsonTreeviewShowCheckString(List<T> items, List<String> checkIds)
			throws IOException {
		TreeViewShowcheckJsonWriter<T> jsonWriter = TreeViewConstructFactory.contructTreeViewShowcheckJsonWriter(items,checkIds);
		StringWriter stringWriter = new StringWriter();
		jsonWriter.writeJson(stringWriter);
		return stringWriter.toString();
	}

	/**
	 * 构造Html select 树.如果传入分类例表为空,则返回null.
	 * 
	 * @param items
	 * @param checkId
	 * @return
	 */
	static public <T extends TreeNodeItem> String renderHtmlTreeSelect(Collection<T> items, String checkId) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(items);
		HtmlSelectTreeRender<T> render = new HtmlSelectTreeRender<T>(null, checkId);
		return render.render(treeNode);
	}

	/**
	 * 输出html UI 树形menu结构.
	 * 
	 * @return
	 */
	public static final <T extends TreeNodeItem> String contructTreeMenuUI(Collection<T> list) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		TreeMenuUIRender<T> render = new TreeMenuUIRender<T>();
		return render.render(treeNode);
	}
}
