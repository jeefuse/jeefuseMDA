package net.taylor.mda.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.navigator.Activator;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CopyAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CutAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

@SuppressWarnings("unchecked")
public class UML2ElementActionExtension extends CommonActionProvider {

	private ICommonActionExtensionSite aConfig;

	private ICommonViewerWorkbenchSite viewSite;

	@Override
	public void init(ICommonActionExtensionSite aConfig) {
		this.aConfig = aConfig;
		if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			viewSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
		}
	}

	public void dispose() {
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getObject());
	}

	protected Object getObject() {
		return getSelection().getFirstElement();
	}

	protected IStructuredSelection getSelection() {
		ISelection selection = getContext().getSelection();
		return (IStructuredSelection) selection;
	}

	protected TreeViewer getViewer() {
		return (TreeViewer) aConfig.getStructuredViewer();
	}

	public void fillContextMenu(IMenuManager aMenu) {
		newMenu(aMenu);
//		stereotypeMenu(aMenu);
		saveMenu(aMenu);
		cpdMenu(aMenu);
		otherMenu(aMenu);
	}

	protected void stereotypeMenu(IMenuManager aMenu) {
		aMenu.add(new Separator("stereotype"));
		aMenu.add(new ApplyStereotypeAction(getViewer(), aConfig.getViewSite()
				.getShell(), getContext().getSelection()));
		aMenu.add(new UnapplyStereotypeAction(getViewer(), aConfig
				.getViewSite().getShell(), getContext().getSelection()));
		aMenu.add(new Separator("profile"));
		aMenu.add(new ApplyProfileAction(getViewer(), aConfig.getViewSite()
				.getShell(), getContext().getSelection()));
		aMenu.add(new UnapplyProfileAction(getViewer(), aConfig.getViewSite()
				.getShell(), getContext().getSelection()));
	}

	protected void saveMenu(IMenuManager aMenu) {
		aMenu.add(new Separator("save"));
		SaveAction saveAction = new SaveAction(getContext().getSelection());
		aMenu.appendToGroup("group.save", saveAction);
	}

	protected void cpdMenu(IMenuManager aMenu) {
		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();

		UndoAction undoAction = new UndoAction(getEditingDomain());
		undoAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		aMenu.appendToGroup("group.undo", undoAction);

		RedoAction redoAction = new RedoAction(getEditingDomain());
		redoAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		aMenu.appendToGroup("group.undo", redoAction);

		aMenu.add(new Separator());

		CutAction cutAction = new CutAction(getEditingDomain());
		cutAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		cutAction.selectionChanged(getSelection());
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, cutAction);

		CopyAction copyAction = new CopyAction(getEditingDomain());
		copyAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		copyAction.selectionChanged(getSelection());
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, copyAction);

		PasteAction pasteAction = new PasteAction(getEditingDomain());
		pasteAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		pasteAction.selectionChanged(getSelection());
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, pasteAction);

		aMenu.add(new Separator());

		if (getObject() instanceof Element) {
			DestroyElementAction deleteAction = new DestroyElementAction(
					getSelection());
			deleteAction.setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
			aMenu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, deleteAction);
		} else {
			DeleteAction deleteAction = new DeleteAction(getEditingDomain(),
					true) {
				// public Command createCommand(Collection selection) {
				// return new DeleteCommand(domain, selection);
				// }
			};
			deleteAction.setImageDescriptor(sharedImages
					.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
			deleteAction.selectionChanged(getSelection());
			aMenu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, deleteAction);
		}
	}

	protected void otherMenu(IMenuManager aMenu) {
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS,
				new RefreshAction(getViewer(), getSelection()));

		if (getSelection().getFirstElement() instanceof Model) {
			aMenu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS,
					new ReloadAction(getViewer(), getSelection()));
		}

		aMenu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS,
				new LoadResourceAction(getEditingDomain()));

		ControlAction ca = new ControlAction(getEditingDomain());
		ca.updateSelection(getSelection());
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS, ca);

		ValidateAction va = new ValidateAction();
		va.updateSelection(getSelection());
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS, va);
	}

	protected void newMenu(IMenuManager aMenu) {
		IMenuManager submenuManager = new MenuManager("New", "new.menu");
		aMenu.appendToGroup(ICommonMenuConstants.GROUP_NEW, submenuManager);
		populateManager(submenuManager);
	}

	protected void populateManager(IContributionManager manager) {
		try {
			Collection actions = generateCreateChildActions();
			if (actions != null) {
				for (Iterator i = actions.iterator(); i.hasNext();) {
					IAction action = (IAction) i.next();
					manager.add(action);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Collection generateCreateChildActions() {
		Collection descriptors = getNewChildDescriptors();
		List createChildActions = (List) generateCreateChildActionsGen(descriptors);

		Collections.sort(createChildActions, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((IAction) o1).getText().compareTo(
						((IAction) o2).getText());
			}
		});

		return createChildActions;
	}

	protected Collection getNewChildDescriptors() {
		Object object = getObject();

		IEditingDomainItemProvider editingDomainItemProvider = (IEditingDomainItemProvider) Activator
				.getDefault().getItemProvidersAdapterFactory().adapt(object,
						IEditingDomainItemProvider.class);

		return editingDomainItemProvider != null ? editingDomainItemProvider
				.getNewChildDescriptors(object, null, null)
				: Collections.EMPTY_LIST;
	}

	protected Collection generateCreateChildActionsGen(Collection descriptors) {
		ISelection selection = new StructuredSelection(getObject());
		Collection actions = new ArrayList();
		if (descriptors != null) {
			for (Iterator i = descriptors.iterator(); i.hasNext();) {
				actions.add(new CreateChildAction(viewSite.getPart(),
						selection, i.next()));
			}
		}
		return actions;
	}
}
