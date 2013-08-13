package net.taylor.mda.actions;

import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CopyResourceAction;
import org.eclipse.ui.actions.DeleteResourceAction;
import org.eclipse.ui.actions.MoveResourceAction;
import org.eclipse.ui.actions.OpenFileAction;
import org.eclipse.ui.actions.RenameResourceAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

public class FileActionExtension extends CommonActionProvider implements
		IMenuListener {

	private ICommonActionExtensionSite aConfig;

	private ICommonViewerWorkbenchSite viewSite;

	@Override
	public void init(ICommonActionExtensionSite aConfig) {
		this.aConfig = aConfig;
		if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			viewSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
			getViewer().addDoubleClickListener(
					new MyDoubleClickListener(viewSite));
		}
	}

	private static class MyDoubleClickListener implements IDoubleClickListener {

		private ICommonViewerWorkbenchSite viewSite;

		public MyDoubleClickListener(ICommonViewerWorkbenchSite viewSite) {
			this.viewSite = viewSite;
		}

		public void doubleClick(DoubleClickEvent event) {
			OpenFileAction openAction = new OpenFileAction(viewSite.getPage());
			openAction.selectionChanged((IStructuredSelection) event
					.getSelection());
			openAction.run();
		}
	}

	protected TreeViewer getViewer() {
		return (TreeViewer) aConfig.getStructuredViewer();
	}

	public void dispose() {
	}

	public void fillContextMenu(IMenuManager aMenu) {
		aMenu.addMenuListener(this);
		aMenu.setRemoveAllWhenShown(true);

		cpdMenu(aMenu);
		otherMenu(aMenu);
	}

	protected IStructuredSelection getSelection() {
		ISelection selection = getContext().getSelection();
		return (IStructuredSelection) selection;
	}

	protected void cpdMenu(IMenuManager aMenu) {
		aMenu.insertBefore("group.port", new Separator("cpd"));

		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();

		CopyResourceAction copyAction = new CopyResourceAction(aConfig
				.getViewSite().getShell());
		copyAction.selectionChanged(getSelection());
		copyAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		aMenu.appendToGroup("cpd", copyAction);

		MoveResourceAction moveAction = new MoveResourceAction(aConfig
				.getViewSite().getShell());
		moveAction.selectionChanged(getSelection());
		aMenu.appendToGroup("cpd", moveAction);

		DeleteResourceAction deleteAction = new DeleteResourceAction(aConfig
				.getViewSite().getShell());
		deleteAction.selectionChanged(getSelection());
		deleteAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		aMenu.appendToGroup("cpd", deleteAction);

		RenameResourceAction renameAction = new RenameResourceAction(aConfig
				.getViewSite().getShell());
		renameAction.selectionChanged(getSelection());
		aMenu.appendToGroup("cpd", renameAction);
	}

	protected void otherMenu(IMenuManager aMenu) {
		aMenu.add(new Separator("other"));
		aMenu.add(new LoadResourceAction());
		aMenu.add(new ValidateAction());
	}

	protected Object getObject() {
		ISelection selection = getContext().getSelection();
		IStructuredSelection s = (IStructuredSelection) selection;
		return s.getFirstElement();
	}

	public void menuAboutToShow(IMenuManager manager) {
	}
}
