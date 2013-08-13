package com.jeefuse.base.modules.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形节点.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class AbstractTreeNode<T extends AbstractTreeNode<T>> implements TreeNode<T> {

	private T parent = null;// 上级节点
	private List<T> childrens = null;// 子节点
	

	public void addChildren(T treeNode) {
		if (null == childrens) {
			childrens = new ArrayList<T>();
		}
		childrens.add(treeNode);
	}

	public List<T> getChildrens() {
		return childrens;
	}

	public int getDeep() {
		int deep = 0;
		T curtreeItem = this.getParent();
		while (null != curtreeItem) {
			deep++;
			curtreeItem = curtreeItem.getParent();
		}
		return deep;
	}

	public boolean hasParent() {
		if (null != this.parent)
			return true;
		else
			return false;
	}

	public T getParent() {
		return parent;
	}

	public boolean hasChildrens() {
		if (null != childrens && !childrens.isEmpty())
			return true;
		else
			return false;
	}

	public boolean isLeaf() {
		if (null == childrens || childrens.isEmpty())
			return true;
		else
			return false;
	}

	public void setParent(T parent) {
		this.parent = parent;
	}


}
