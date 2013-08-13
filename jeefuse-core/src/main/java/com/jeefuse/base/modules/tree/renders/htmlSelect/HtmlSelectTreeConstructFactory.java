package com.jeefuse.base.modules.tree.renders.htmlSelect;

import java.util.Collection;

import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGenericConstructUtil;

/**
 * html select 树构造输出工厂.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class HtmlSelectTreeConstructFactory {

	/**
	 * 输出html select 树形结构.
	 * 
	 * @param <T>
	 * @param list
	 *            构造数据例表,必需extends HtmlSelectTreeItem.
	 * @param layerSeparator
	 *            上级与下级行缩进的显示字符,默认为----
	 * @param checkId
	 *            当前select 选择的ID.
	 * @return
	 */
	public static final <T extends TreeNodeItem> String contructTreeViewJsonWriter(
			Collection<T> list, String layerSeparator, String checkId) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		HtmlSelectTreeRender<T> render = new HtmlSelectTreeRender<T>(layerSeparator, checkId);
		return render.render(treeNode);
	}



}
