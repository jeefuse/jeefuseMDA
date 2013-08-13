package com.jeefuse.base.modules.tree;

/**
 * 树形结构渲染.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface TreeRender<T extends TreeNode<T>> {

	/**
	 * 渲染.
	 */
	public String render(T treeNode);

}
