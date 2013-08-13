package com.jeefuse.base.modules.tree.renders.treeview;

import com.jeefuse.base.modules.tree.renders.htmlSelect.TreeNodeItem;

/**
 * 树形结构数据.构造如jquery.tree.js等树形结构.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface TreeViewItem extends TreeNodeItem {

	/**
	 * 是否展开.
	 */
	public boolean getIsexpand();

	/**
	 * 是否需要加载子节点.
	 */
	public boolean getComplete();


}
