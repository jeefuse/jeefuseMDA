package com.jeefuse.base.modules.tree.renders.treeview;

import java.util.Collection;
import java.util.List;

import com.jeefuse.base.modules.json.TreeViewJsonWriter;
import com.jeefuse.base.modules.json.TreeViewShowcheckJsonWriter;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGenericConstructUtil;

/**
 * jquery treeView树构造输出工厂.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class TreeViewConstructFactory {


	/**
	 * 输出jquery.treeview.js json树形结构数据.
	 * 
	 * @param <T>
	 * @param list
	 * @param rootName
	 *            根节点名称,如不显示根节点则该值为空.
	 * @return
	 */
	public static final <T extends TreeViewItem> TreeViewJsonWriter<T> contructTreeViewJsonWriter(Collection<T> list,
			String rootName) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		TreeViewJsonWriter<T> jsonWriter = new TreeViewJsonWriter<T>(treeNode, rootName);
		return jsonWriter;
	}

	/**
	 * 输出jquery.treeview.js json树形结构数据显示checkbox.
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static final <T extends TreeViewItem> TreeViewShowcheckJsonWriter<T> contructTreeViewShowcheckJsonWriter(
			Collection<T> list, List<String> checkIds) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		TreeViewShowcheckJsonWriter<T> jsonWriter = new TreeViewShowcheckJsonWriter<T>(treeNode, checkIds);
		return jsonWriter;
	}

}
