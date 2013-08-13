package net.taylor.mda.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.navigator.Activator;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.common.edit.provider.IItemQualifiedTextProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author John
 * 
 */
public class ApplyStereotypeAction extends Action {

	private static final String LABEL = "Apply Stereotype";

	private IStructuredSelection selection;

	private Shell shell;

	private TreeViewer viewer;

	public ApplyStereotypeAction(TreeViewer viewer, Shell shell,
			ISelection selection) {
		super();
		this.viewer = viewer;
		this.shell = shell;
		this.selection = (IStructuredSelection) selection;
		setText(LABEL);
	}

	protected Shell getShell() {
		return shell;
	}

	protected Element getElement() {
		return (Element) selection.getFirstElement();
	}

	protected void refresh() {
		viewer.refresh();
	}

	protected ILabelProvider getLabelProvider() {
		return new AdapterFactoryLabelProvider(Activator.getDefault()
				.getItemProvidersAdapterFactory()) {

			public String getColumnText(Object object, int columnIndex) {
				IItemQualifiedTextProvider itemQualifiedTextProvider = (IItemQualifiedTextProvider) adapterFactory
						.adapt(object, IItemQualifiedTextProvider.class);

				return null != itemQualifiedTextProvider ? itemQualifiedTextProvider
						.getQualifiedText(object)
						: super.getColumnText(object, columnIndex);
			}

			public String getText(Object object) {
				IItemQualifiedTextProvider itemQualifiedTextProvider = (IItemQualifiedTextProvider) adapterFactory
						.adapt(object, IItemQualifiedTextProvider.class);

				return null != itemQualifiedTextProvider ? itemQualifiedTextProvider
						.getQualifiedText(object)
						: super.getText(object);
			}
		};
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getElement());
	}

	protected class TextComparator implements Comparator {

		public int compare(Object o1, Object o2) {
			return getLabelProvider().getText(o1).compareTo(
					getLabelProvider().getText(o2));
		}
	}

	@SuppressWarnings("unchecked")
	public void run() {

		final Element element = getElement();

		List choiceOfValues = new ArrayList();

		for (Iterator applicableStereotypes = element
				.getApplicableStereotypes().iterator(); applicableStereotypes
				.hasNext();) {

			Stereotype stereotype = (Stereotype) applicableStereotypes.next();

			if (!element.isStereotypeApplied(stereotype)) {
				choiceOfValues.add(stereotype);
			}
		}

		Collections.sort(choiceOfValues, new TextComparator());

		final FeatureEditorDialog dialog = new FeatureEditorDialog(shell,
				getLabelProvider(), element, UMLPackage.eINSTANCE.getElement(),
				Collections.EMPTY_LIST, LABEL, choiceOfValues);
		dialog.open();

		if (FeatureEditorDialog.OK == dialog.getReturnCode()) {
			getEditingDomain().getCommandStack().execute(
					new RefreshingChangeCommand(getEditingDomain(),
							new Runnable() {

								public void run() {

									for (Iterator stereotypes = dialog
											.getResult().iterator(); stereotypes
											.hasNext();) {

										element
												.applyStereotype((Stereotype) stereotypes
														.next());
									}
								}
							}, LABEL));
		}
	}

	protected class RefreshingChangeCommand extends ChangeCommand {

		public RefreshingChangeCommand(EditingDomain editingDomain,
				Runnable runnable, String label) {
			super(editingDomain, runnable, label);
		}

		public void execute() {
			super.execute();

			refresh();
		}

		public void undo() {
			super.undo();

			refresh();
		}

		public void redo() {
			super.redo();

			refresh();
		}

	}

}