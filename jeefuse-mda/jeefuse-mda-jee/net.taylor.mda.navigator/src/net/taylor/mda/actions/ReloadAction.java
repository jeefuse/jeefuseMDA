package net.taylor.mda.actions;

import net.taylor.mda.util.ModelUtil;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.uml2.uml.Model;

/**
 * @author jgilbert01
 * 
 */
public class ReloadAction extends Action {

	private IStructuredSelection selection;

	private TreeViewer viewer;

	public ReloadAction(TreeViewer viewer, ISelection selection) {
		this.selection = (IStructuredSelection) selection;
		setText("Reload Model");
		// setToolTipText(name + " Tip");
		// setDescription(name + " Description");
		this.viewer = viewer;
	}

	public void run() {
		Model model = (Model) selection.getFirstElement();
		Resource resource = model.eResource();
		if (resource.isLoaded()) {
			resource.unload();
			ModelUtil.getEditingDomain().getResourceSet().getResources()
					.remove(resource);
			ModelUtil.getEditingDomain().loadResource(
					resource.getURI().toFileString());
			viewer.refresh();
		}
	}
}
