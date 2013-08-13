package com.jeefuse.base.modules.tree.renders.menu;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jmesa.view.html.HtmlBuilder;

import com.jeefuse.base.modules.tree.TreeRender;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.htmlSelect.TreeNodeItem;

/**
 * 构造树形html结构.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class TreeMenuUIHrefMethodRender<T extends TreeNodeItem> implements TreeRender<TreeNodeGeneric<T>> {

	private static final String DEFAULT_HREF_METHOD_NAME = "menuItemClick";
	private String folderCssClass = null;
	private String leafCssClass = null;
	private String contextPath = null;
	private String hrefMethodName = DEFAULT_HREF_METHOD_NAME;

	public TreeMenuUIHrefMethodRender(String contextPath, String hrefMethodName) {
		this.contextPath = contextPath;
		this.hrefMethodName = hrefMethodName;
	}

	public TreeMenuUIHrefMethodRender(String folderCssClass, String leafCssClass, String contextPath) {
		this.folderCssClass = folderCssClass;
		this.leafCssClass = leafCssClass;
		this.contextPath = contextPath;
	}

	public TreeMenuUIHrefMethodRender(String folderCssClass, String leafCssClass, String contextPath,
			String hrefMethodName) {
		this.folderCssClass = folderCssClass;
		this.leafCssClass = leafCssClass;
		this.contextPath = contextPath;
		if (StringUtils.isNotBlank(hrefMethodName)) {
			this.hrefMethodName = hrefMethodName;
		}
	}

	public String render(TreeNodeGeneric<T> treeNode) {
		if (null == treeNode || !treeNode.hasChildrens())
			return null;
		HtmlBuilder html = new HtmlBuilder();
		List<TreeNodeGeneric<T>> childrenTreeNodes = treeNode.getChildrens();
		for (TreeNodeGeneric<T> curTreeNode : childrenTreeNodes) {
			render(html, curTreeNode);
		}
		return html.toString();
	}

	private void render(HtmlBuilder html, TreeNodeGeneric<T> treeNode) {
		T model = treeNode.getTargetObject();
		if (treeNode.hasChildrens()) {
			html.tabs(treeNode.getDeep() + 1).li();
			// if (null != folderCssClass) {
			// html.styleClass(folderCssClass);
			// }
			html.close();
			html.a();
			// if (StringUtils.isBlank(model.getUrl())) {
			// html.href("javascript:void(0)");
			// } else {
			html.id(model.getId());
			html.href("javascript:void(0)");
			html.append(" onclick=\"");
			getHrefMethod(html, model);
			html.append("\" ");
			// }
			html.close().span();
			if (null != folderCssClass) {
				html.styleClass(folderCssClass);
			}
			html.close().append(model.getText()).spanEnd().aEnd();
			html.newline();
			// if (isExpanded) {
			html.tabs(treeNode.getDeep() + 2).ul().close().newline();
			// } else {
			// html.tabs(treeItem.getDeep()).tab().ul().style("display:none;").close().newline();
			// }
			List<TreeNodeGeneric<T>> childrenTreeNodes = treeNode.getChildrens();
			for (TreeNodeGeneric<T> curTreeNode : childrenTreeNodes) {
				render(html, curTreeNode);
			}
			html.tabs(treeNode.getDeep() + 2).ulEnd().newline();
			html.tabs(treeNode.getDeep() + 1).liEnd().newline();
		} else {
			html.tabs(treeNode.getDeep() + 2).li();
			html.close();
			html.a();
			html.id(model.getId());
			html.href("javascript:void(0)");
			html.append(" onclick=\"");
			getHrefMethod(html, model);
			html.append("\" ");
			html.close().span();
			if (null != leafCssClass) {
				html.styleClass(leafCssClass);
			}
			html.close().append(model.getText()).spanEnd().aEnd();
			html.liEnd().newline();
		}
	}

	private void getHrefMethod(HtmlBuilder html, T model) {
		html.append(hrefMethodName);
		html.append("('");
		html.append(model.getId()).append("'");
		html.append(",'").append(model.getText()).append("'");
		html.append(",'");
		if (StringUtils.isBlank(model.getUrl())) {
			html.append("#");
		} else if (model.getUrl().startsWith("/")) {
			html.append(contextPath).append(model.getUrl());
		} else {
			html.append(model.getUrl());
		}
		html.append("'");
		//		html.append(",'").append(model.getParentId()).append("'");
		html.append(",this");
		html.append(");");
	}
}
