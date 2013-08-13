package com.jeefuse.base.modules.tree.renders.htmlSelect;

import com.jeefuse.base.modules.tree.TreeNodeable;

public interface TreeNodeItem extends TreeNodeable {

	/**
	 * 显示名称.
	 */
	public String getText();

	/**
	 * 获取值.
	 */
	public String getValue();


	/**
	 * 获取URL.
	 */
	public String getUrl();

}
