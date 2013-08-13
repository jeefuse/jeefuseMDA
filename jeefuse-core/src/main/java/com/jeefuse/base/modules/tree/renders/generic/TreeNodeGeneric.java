package com.jeefuse.base.modules.tree.renders.generic;

import com.jeefuse.base.modules.tree.AbstractTreeNode;

/**
 * 树形节点.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class TreeNodeGeneric<T> extends AbstractTreeNode<TreeNodeGeneric<T>> {
	private T model;
	
	public TreeNodeGeneric() {
	}
	
	public TreeNodeGeneric(T model) {
		this.model = model;
	}

	public T getTargetObject() {
		return model;
	}
}
