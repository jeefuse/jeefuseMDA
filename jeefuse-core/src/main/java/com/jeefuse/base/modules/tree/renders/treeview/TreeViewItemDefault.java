package com.jeefuse.base.modules.tree.renders.treeview;

public class TreeViewItemDefault implements TreeViewItem {
	private boolean complete;
	private boolean isexpand;
	private String text;
	private String value;
	private String id;
	private String parentId;
	private String descript;
	private String url;

	public TreeViewItemDefault(boolean complete, boolean isexpand, String text, String value, String id,
			String parentId) {
		this.complete = complete;
		this.isexpand = isexpand;
		this.text = text;
		this.value = value;
		this.id = id;
		this.parentId = parentId;
	}

	public TreeViewItemDefault(boolean complete, boolean isexpand, String text, String value, String id,
			String parentId, String descript, String url) {
		this.complete = complete;
		this.isexpand = isexpand;
		this.text = text;
		this.value = value;
		this.id = id;
		this.parentId = parentId;
		this.descript = descript;
		this.url = url;
	}

	public boolean getComplete() {

		return complete;
	}

	public boolean getIsexpand() {

		return isexpand;
	}

	public String getText() {

		return text;
	}

	public String getValue() {

		return value;
	}

	public String getId() {

		return id;
	}

	public String getParentId() {

		return parentId;
	}

	public String getDescript() {
		return descript;
	}

	public String getUrl() {
		return url;
	}

}
