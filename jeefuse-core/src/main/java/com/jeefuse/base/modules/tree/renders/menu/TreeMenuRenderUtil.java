package com.jeefuse.base.modules.tree.renders.menu;

import java.util.Collection;

import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGenericConstructUtil;
import com.jeefuse.base.modules.tree.renders.htmlSelect.TreeNodeItem;

/**
 * 构造html UI 树形结构.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class TreeMenuRenderUtil {

	/**
	 * 输出html UI 树形结构.
	 * <p>
	 * <strong>render schema:</strong>
	 * <p>
	 *<code><</code>li class="folder" ><code><</code>a href="url" >
	 * <code><</code>span>aa<code><</code>/span><code><</code>/a><code><</code>
	 * li>
	 * 
	 * @param <T>
	 * @param list
	 *            数据例表
	 * @param folderCssClass
	 *            有子节点的li class样式类
	 * @param leafCssClass
	 *            无子节点的li class样式类
	 * @return
	 */
	public static final <T extends TreeNodeItem> String contructTreeMenuUI(Collection<T> list, String folderCssClass,
			String leafCssClass) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		TreeMenuUIRender<T> render = new TreeMenuUIRender<T>(folderCssClass, leafCssClass);
		return render.render(treeNode);
	}

	/**
	 * 输出html UI 树形结构 .
	 * <p>
	 * <strong>render schema:</strong>
	 * <p>
	 *<code><</code>li class="folder" ><code><</code>a
	 * href="javascript:void(0)"
	 * onclick="menuItemClick(id,text,url,parentId,this);" ><code><</code>
	 * span>aa<code><</code>/span><code><</code>/a><code><</code> li>
	 * 
	 * @param <T>
	 * @param list
	 *            数据例表
	 * @param folderCssClass
	 *            有子节点的li class样式类
	 * @param leafCssClass
	 *            无子节点的li class样式类
	 * @param contextPath
	 *            web上下文
	 * @return
	 */
	public static final <T extends TreeNodeItem> String contructTreeMenuUIHrefMethod(Collection<T> list,
			String folderCssClass, String leafCssClass, String contextPath) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		TreeMenuUIHrefMethodRender<T> render = new TreeMenuUIHrefMethodRender<T>(folderCssClass, leafCssClass,
				contextPath);
		return render.render(treeNode);
	}

	/**
	 * 输出html UI 树形结构 .
	 * <p>
	 * <strong>render schema:</strong>
	 * <p>
	 *<code><</code>li class="folder" ><code><</code>a
	 * href="javascript:void(0)"
	 * onclick="hrefMethodName(id,text,url,parentId,this);" ><code><</code>
	 * span>aa<code><</code>/span><code><</code>/a><code><</code> li>
	 * 
	 * @param <T>
	 * @param list
	 *            数据例表
	 * @param folderCssClass
	 *            有子节点的li class样式类
	 * @param leafCssClass
	 *            无子节点的li class样式类
	 * @param contextPath
	 *            web上下文
	 * @param hrefMethodName
	 *            点击节点执行的js方法
	 * @return
	 */
	public static final <T extends TreeNodeItem> String contructTreeMenuUIHrefMethod(Collection<T> list,
			String folderCssClass, String leafCssClass, String contextPath, String hrefMethodName) {
		TreeNodeGeneric<T> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		TreeMenuUIHrefMethodRender<T> render = new TreeMenuUIHrefMethodRender<T>(folderCssClass, leafCssClass,
				contextPath, hrefMethodName);
		return render.render(treeNode);
	}

}
