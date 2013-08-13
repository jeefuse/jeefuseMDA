package com.jeefuse.base.modules.tree.renders.generic;

import java.util.Collection;

/**
 * 构造简单树形结构显示.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class TreeGenericConstructFactory {

	/**
	 * 构造TreeNodeGeneric树形结构.
	 * 
	 * @param <T>
	 * @param list
	 * @return
	 */
	public static final <T extends TreeNodeGenericItem> TreeNodeGeneric<T> contructTreeNodeGeneric(Collection<T> list) {
		return TreeNodeGenericConstructUtil.constructTreeNode(list);
	}


}
