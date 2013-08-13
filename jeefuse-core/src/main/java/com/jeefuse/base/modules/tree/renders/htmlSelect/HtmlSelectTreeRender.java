package com.jeefuse.base.modules.tree.renders.htmlSelect;

import java.util.List;

import com.jeefuse.base.modules.tree.TreeRender;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;

public class HtmlSelectTreeRender<T extends TreeNodeItem> implements TreeRender<TreeNodeGeneric<T>> {

	private String layerSeparator = "&nbsp;&nbsp;&nbsp;&nbsp;";
	private String checkId;
	

	public HtmlSelectTreeRender(String layerSeparator, String checkId) {
		if (null != layerSeparator) {
			this.layerSeparator = layerSeparator;
		}
		if (null != checkId) {
			this.checkId = checkId;
		}

	}

	public String render(TreeNodeGeneric<T> treeNode) {
		if (null == treeNode || !treeNode.hasChildrens())
			return null;
		StringBuilder sb = new StringBuilder(100);
		String layerPath = layerSeparator;
		List<TreeNodeGeneric<T>> childrenTreeNodes = treeNode.getChildrens();
		for (TreeNodeGeneric<T> curTreeNode : childrenTreeNodes) {
			render(sb, curTreeNode, layerPath);
		}
		return sb.toString();
	}

	public String render(StringBuilder sb, TreeNodeGeneric<T> treeNode, String layerPath) {
		T model = treeNode.getTargetObject();
		sb.append("<option value=\"" + model.getId() + "\"");
		if (null != checkId && model.getId().equals(checkId)) {
			sb.append(" selected=\"selected\" ");
		}
		sb.append(">");
		sb.append(layerPath);
		sb.append(model.getText());
		sb.append("</option>\r\n");
		if (treeNode.hasChildrens()) {
			List<TreeNodeGeneric<T>> childrenTreeNodes = treeNode.getChildrens();
			for (TreeNodeGeneric<T> curTreeNode : childrenTreeNodes) {
				render(sb, curTreeNode, layerSeparator + layerPath);
			}
		}
		return sb.toString();
	}



}
