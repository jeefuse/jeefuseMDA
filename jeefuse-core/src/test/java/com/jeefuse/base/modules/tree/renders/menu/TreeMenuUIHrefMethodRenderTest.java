package com.jeefuse.base.modules.tree.renders.menu;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItemDefault;

public class TreeMenuUIHrefMethodRenderTest {

	@Test
	public void testRender() {
		int loop = 100000;
		long oneStartTime = System.currentTimeMillis();
		String renderString = "";
		for (int i = 0; i < loop; i++) {
			TreeViewItem viewItem1 = new TreeViewItemDefault(false, false, "aa", "aa", "a1", "", "a11", "asd");
			TreeViewItem viewItem2 = new TreeViewItemDefault(false, false, "aa", "aa", "a2", "", "a11", "asd");
			TreeViewItem viewItem3 = new TreeViewItemDefault(false, false, "aa", "aa", "a3", "a1", "a11", "asd");
			TreeViewItem viewItem4 = new TreeViewItemDefault(false, false, "aa", "aa", "a4", "a1", "a11", "asd");
			List<TreeViewItem> list = new ArrayList<TreeViewItem>();
			list.add(viewItem1);
			list.add(viewItem2);
			list.add(viewItem3);
			list.add(viewItem4);
			// TreeNodeGeneric<TreeViewItem> treeNode =
			// TreeNodeGenericConstructUtil.constructTreeNode(list);
			renderString = TreeMenuRenderUtil.contructTreeMenuUIHrefMethod(list, "folder", "file", "/cater");
		}
		long oneEndTime = System.currentTimeMillis();
		System.out.println(renderString);
		System.out.println("one elapse:" + (oneEndTime - oneStartTime));
	}

}
