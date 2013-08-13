package net.taylor.mda.actions;

import java.util.Iterator;

import net.taylor.mda.util.ModelUtil;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;

/**
 * @author jgilbert
 * 
 */
public class DestroyElementAction extends Action {

	private static final String LABEL = "Delete";

	private IStructuredSelection selection;

	public DestroyElementAction(ISelection selection) {
		super();
		this.selection = (IStructuredSelection) selection;
		setText(LABEL);
	}

	protected Element getElement() {
		return (Element) selection.getFirstElement();
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getElement());
	}

	@SuppressWarnings("unchecked")
	public void run() {
		getEditingDomain().getCommandStack().execute(
				new ChangeCommand(getEditingDomain(), new Runnable() {

					public void run() {
						for (Iterator i = selection.iterator(); i.hasNext();) {
							Object e = (Object) i.next();
							if (e instanceof Element) {
								Element element = (Element) e;
								ModelUtil.clean(element, element);
								element.destroy();
							}
						}
					}
				}, LABEL));
	}
}