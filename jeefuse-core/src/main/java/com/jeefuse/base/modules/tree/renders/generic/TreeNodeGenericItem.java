package com.jeefuse.base.modules.tree.renders.generic;

import com.jeefuse.base.modules.tree.TreeNodeable;



/**
 * 构造树形节点.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public interface TreeNodeGenericItem extends TreeNodeable {

	/**
	 * 显示名称.
	 * 
	 */
	public String getName();

	/**
	 * 显示图像.
	 * 
	 */
	public String getImage();

	/**
	 * 描述.
	 * 
	 */
	public String getDescript();

	/**
	 * 点击指向的url.
	 * 
	 */
	public String getHref();

	/**
	 * 点击指向url打开的目标窗口.
	 * 
	 */
	public String getHrefTarget();
}