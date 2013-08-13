package com.jeefuse.base.modules.tree.renders.menu;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jmesa.view.html.HtmlBuilder;

import com.jeefuse.base.modules.tree.TreeRender;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.htmlSelect.TreeNodeItem;

public class TreeMenuUIRender<T extends TreeNodeItem> implements TreeRender<TreeNodeGeneric<T>> {

	private String folderCssClass = null;
	private String leafCssClass = null;

	public TreeMenuUIRender() {
	}

	public TreeMenuUIRender(String folderCssClass, String leafCssClass) {
		this.folderCssClass = folderCssClass;
		this.leafCssClass = leafCssClass;
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
			html.tabs(treeNode.getDeep()).li();
			if (null != folderCssClass) {
				html.styleClass(folderCssClass);
			}
			html.close();
			html.a();
			if (StringUtils.isBlank(model.getValue())) {
				html.href("#");
			} else {
				html.href(model.getValue());
			}
			html.close().span().close().append(model.getText()).spanEnd().aEnd();
			html.newline();
			html.tabs(treeNode.getDeep()).tab().ul().close().newline();
			List<TreeNodeGeneric<T>> childrenTreeNodes = treeNode.getChildrens();
			for (TreeNodeGeneric<T> curTreeNode : childrenTreeNodes) {
				render(html, curTreeNode);
			}
			html.tabs(treeNode.getDeep()).tab().ulEnd().newline();
			html.tabs(treeNode.getDeep()).liEnd().newline();
		} else {
			html.tabs(treeNode.getDeep()).li();
			if (null != leafCssClass) {
				html.styleClass(leafCssClass);
			}
			html.close();
			html.a();
			if (StringUtils.isBlank(model.getValue())) {
				html.href("#");
			} else {
				html.href(model.getValue());
			}
			html.close().span().close().append(model.getText()).spanEnd().aEnd();
			html.liEnd().newline();
		}
	}
}
