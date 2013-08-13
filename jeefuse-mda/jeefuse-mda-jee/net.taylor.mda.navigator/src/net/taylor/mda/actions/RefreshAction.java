package net.taylor.mda.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * @author John
 *
 */
public class RefreshAction extends Action {

	private IStructuredSelection selection;
	
	private TreeViewer viewer;
	
	public RefreshAction(TreeViewer viewer, ISelection selection) {
		this.selection = (IStructuredSelection) selection;
		setText("Refresh");
//		setToolTipText(name + " Tip");
//		setDescription(name + " Description");
		this.viewer = viewer;
	}
	
	public void run() {
		Object object = selection.getFirstElement();
		viewer.refresh(object);
	}
}
