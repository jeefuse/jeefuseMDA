package com.jeefuse.base.modules.tree.renders.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;

import com.jeefuse.base.modules.tree.TreeNodeable;

public class TreeNodeGenericConstructUtil {

	/**
	 * 构造树结构.如果传入分类例表为空,则返回null. 将自动添加一个节点为所有数据的根节点.根节点的名称未设置.
	 * 
	 * @param <T>
	 * @param list
	 *            分类例表
	 * @param rootName
	 *            树根名
	 * @return
	 */
	public static final <Item extends TreeNodeable> TreeNodeGeneric<Item> constructTreeNode(Collection<Item> list) {
		if (null == list)
			return null;
		TreeNodeGeneric<Item> root = new TreeNodeGeneric<Item>();// 根节点
		Map<String, TreeNodeGeneric<Item>> treeNodeMap = new HashMap<String, TreeNodeGeneric<Item>>();
		Iterator<Item> it = list.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			TreeNodeGeneric<Item> treeNode = new TreeNodeGeneric<Item>(item);
			treeNodeMap.put(item.getId(), treeNode);
		}
		for (Item item : list) {
			String id = item.getId();
			String parentId = item.getParentId();
			TreeNodeGeneric<Item> treeNode = treeNodeMap.get(id);
			// 判断是否有父节点.有则追加到父节点.否则添加到树形根节点
			if (StringUtils.isNotBlank(parentId)) {
				TreeNodeGeneric<Item> parenTreeNode = treeNodeMap.get(parentId);
				if (parenTreeNode != null) {
					treeNode.setParent(parenTreeNode);
					parenTreeNode.addChildren(treeNode);
				} else {// 上级节点不存在,即断节点,添加到根节点上
					root.addChildren(treeNode);
				}
			} else {
				root.addChildren(treeNode);
			}
		}
		return root;
	}

}
