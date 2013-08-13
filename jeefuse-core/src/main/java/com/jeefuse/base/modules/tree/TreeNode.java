package com.jeefuse.base.modules.tree;

import java.util.List;


/**
 * 树节点构造.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface TreeNode<T extends TreeNode<T>> {

	public void addChildren(T treeNode);

	public List<T> getChildrens();

	public int getDeep();

	public boolean hasParent();

	public T getParent();

	public boolean hasChildrens();

	public boolean isLeaf();

}
