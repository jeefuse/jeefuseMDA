package net.taylor.mda.generator.actions;

import java.util.Collection;
import java.util.Collections;

import net.taylor.mda.generator.Console;
import net.taylor.mda.generator.GeneratorPlugin;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.util.ModelUtil;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * @author jgilbert01
 * 
 */
public abstract class BaseUtiltiyActionExtension extends CommonActionProvider
		implements IMenuListener {

	private ICommonActionExtensionSite aConfig;

	public void init(ICommonActionExtensionSite aConfig) {
		this.aConfig = aConfig;
	}

	protected IMenuManager getSubMenu(IMenuManager aMenu) {
		IMenuManager submenuManager = aMenu.findMenuUsingPath("utility.menu");
		if (submenuManager == null) {
			submenuManager = new MenuManager("Utilities", "utility.menu");
			aMenu.appendToGroup(ICommonMenuConstants.GROUP_GENERATE,
					submenuManager);
		}
		return submenuManager;
	}

	public void menuAboutToShow(IMenuManager manager) {
	}

	// --------------------------------------------------------------
	
	protected void execute(Object element) {
		if (element instanceof Package) {
			execute((Package) element);
		}
		if (element instanceof Interface) {
			execute((Interface) element);
		}
		if (element instanceof Class) {
			execute((Class) element);
		}
		if (element instanceof Interface) {
			execute((Interface) element);
		}
		if (element instanceof Enumeration) {
			execute((Enumeration) element);
		}
		
		// TODO  Activity, StateMachine, etc...
	}

	protected void execute(Package pkg) {
		EList<NamedElement> list = pkg.getMembers();
		for (NamedElement namedElement : list) {
			if (namedElement instanceof Package) {
				execute((Package) namedElement);
			}
			if (namedElement instanceof Class) {
				execute((Class) namedElement);
			}
			if (namedElement instanceof Interface) {
				execute((Interface) namedElement);
			}
			if (namedElement instanceof Enumeration) {
				execute((Enumeration) namedElement);
			}
		}
	}

	protected void execute(Class clazz) {
		EList<NamedElement> list = clazz.getMembers();
		for (NamedElement namedElement : list) {
			if (namedElement instanceof Property) {
				execute((Property) namedElement);
			}
		}
	}

	protected void execute(Interface iface) {
	}

	protected void execute(Operation operation) {
	}

	protected void execute(Enumeration e) {
	}

	protected void execute(Property property) {
	}

	// --------------------------------------------------------------

	protected IStructuredSelection getSelection() {
		return (IStructuredSelection) getContext().getSelection();
	}

	protected TreeViewer getViewer() {
		return (TreeViewer) aConfig.getStructuredViewer();
	}

	protected Object getElement() {
		return getSelection().getFirstElement();
	}

	protected void refresh() {
		Object object = getSelection().getFirstElement();
		getViewer().refresh(object);
	}

	protected boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return ModelUtil.getEditingDomain();
	}

	protected void print(String text) {
		Console.getStream().print(text);
	}

	protected void println(String text) {
		Console.getStream().println(text);
	}

	// --------------------------------------------------------------
	
	protected Stereotype set(Element element, String stereotypeName,
			String attrName, Object value) {
		Stereotype stereotype = apply(element, stereotypeName);
		if (stereotype != null) {
			setValue(element, stereotype, attrName, value);
		}
		return stereotype;
	}

	protected Stereotype apply(Element element, String stereotypeName) {
		Stereotype stereotype = (Stereotype) ModelUtil.getProfileElement(
				element, stereotypeName);
		if (stereotype != null) {
			if (!ModelUtil.isStereotypeApplied(element, stereotypeName)) {
				element.applyStereotype(stereotype);
				println(
						"Applying: " + stereotypeName + " to: "
								+ getQualifiedName(element));
			}
		}
		return stereotype;
	}

	protected boolean isApplied(NamedElement element, String stereotypeName) {
		return ModelUtil.isStereotypeApplied(element, stereotypeName);
	}

	protected void setValue(Element element, Stereotype stereotype,
			String attrName, Object value) {
		if (stereotype != null) {
			element.setValue(stereotype, attrName, value);
			println(
					"Setting: " + stereotype.getName() + "." + attrName
							+ " to: " + value + " on: "
							+ getQualifiedName(element));
		}
	}

	protected String getQualifiedName(Element element) {
		if (element instanceof NamedElement) {
			return ((NamedElement)element).getQualifiedName();
		} else {
			return element.toString();
		}
	}
	protected EnumerationLiteral getLiteral(Element element, String name,
			String value) {
		Element e = ModelUtil.getProfileElement(element, name);
		if (e != null) {
			if (e instanceof Enumeration) {
				return ((Enumeration) e).getOwnedLiteral(value);
			}
		}
		return null;
	}

	protected PrimitiveType getPrimitiveType(Element element, String name) {
		Profile types = element.getModel().getAppliedProfile("types");
		PrimitiveType primitiveType = (PrimitiveType) types.getOwnedType(name);
		return primitiveType;
	}

	protected boolean isMyParent(Property property) {
		return ClassHelper.isMyParent(property);
	}

	protected void addComment(Element element, String comment) {
		Comment newcomment = element.createOwnedComment();
		newcomment.setBody(comment);
	}

	// --------------------------------------------------------------

	protected void setAttribute(DynamicEObjectImpl attribute, String name,
			Object value) {
		EStructuralFeature feature = attribute.eClass().getEStructuralFeature(
				name);
		attribute.eSet(feature, value);
		println(
				"Setting: " + attribute.toString() + "." + name
						+ " to: " + value + " on: ");
//						+ getQualifiedName(element));
	}

	@SuppressWarnings("unchecked")
	protected DynamicEObjectImpl createChild(EObject stereotypeApplication) {
		AdapterFactory adapterFactory = GeneratorPlugin.getDefault()
				.getItemProvidersAdapterFactory();
		IEditingDomainItemProvider editingDomainItemProvider = (IEditingDomainItemProvider) adapterFactory
				.adapt(stereotypeApplication, IEditingDomainItemProvider.class);
		Collection descs = editingDomainItemProvider.getNewChildDescriptors(
				stereotypeApplication, getEditingDomain(), null);
		Object desc = descs.iterator().next();
		Collection result = (Collection) CreateChildCommand.create(
				getEditingDomain(), stereotypeApplication, desc,
				Collections.singleton(stereotypeApplication)).getResult();
		Object next = result.iterator().next();
		return (DynamicEObjectImpl) next;

		// try {
		// } catch (Throwable t) {
		// StringWriter sw = new StringWriter();
		// PrintWriter pw = new PrintWriter(sw);
		// t.printStackTrace(pw);
		// Console.getStream().println(sw.toString());
		// }
	}

	protected void addChild(EObject stereotypeApplication,
			DynamicEObjectImpl child, String name) {
		EStructuralFeature feature = stereotypeApplication.eClass()
				.getEStructuralFeature(name);
		AddCommand.create(getEditingDomain(), stereotypeApplication, feature,
				child).execute();
	}

	// --------------------------------------------------------------
	
	protected class BaseUtilityAction extends Action {
		public BaseUtilityAction(String label) {
			setText(label);
			setToolTipText(getText() + " Tip");
			setDescription(getText() + " Description");
		}

		public void run() {
			// needed; otherwise an EMF transaction error occurs.
			getEditingDomain().getCommandStack().execute(
					new RefreshingChangeCommand(getEditingDomain(),
							new Runnable() {
								public void run() {
									execute(getElement());
									ModelUtil.save((Element)getElement());
									refresh();
								}
							}, getText()));
			dialog();
		}

		protected String openInputDialog(String title, String[] validValues) {
			// http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/NumberInputDialog.htm
			InputDialog dlg = new InputDialog(Display.getDefault()
					.getActiveShell(), title, validValues);
			return dlg.open();
		}

		protected void dialog() {
			MessageDialog.openInformation(
					Display.getDefault().getActiveShell(), getText(), getText()
							+ " Complete.");
		}

	}

	private class RefreshingChangeCommand extends ChangeCommand {
		public RefreshingChangeCommand(EditingDomain editingDomain,
				Runnable runnable, String label) {
			super(editingDomain, runnable, label);
		}

		public void execute() {
			super.execute();
			getViewer().refresh();
		}

		private TreeViewer getViewer() {
			return (TreeViewer) aConfig.getStructuredViewer();
		}

		public void undo() {
			super.undo();
			getViewer().refresh();
		}

		public void redo() {
			super.redo();
			getViewer().refresh();
		}

	}

	// --------------------------------------------------------------

	public class InputDialog extends Dialog {
		String value;
		String title;
		String[] validValues;

		public InputDialog(Shell parent, String title, String[] validValues) {
			super(parent);
			this.title = title;
			this.validValues = validValues;
		}

		public String open() {
			Shell parent = getParent();
			final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER
					| SWT.APPLICATION_MODAL);
			shell.setText(title);

			shell.setLayout(new GridLayout(3, false));

			final Combo combo = new Combo(shell, SWT.SINGLE | SWT.BORDER);
			for (String str : validValues) {
				combo.add(str);
			}

			final Button buttonOK = new Button(shell, SWT.PUSH);
			buttonOK.setText("OK");
			buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
			Button buttonCancel = new Button(shell, SWT.PUSH);
			buttonCancel.setText("Cancel");

			combo.addListener(SWT.Modify, new Listener() {
				public void handleEvent(Event event) {
					try {
						value = new String(combo.getText());
						buttonOK.setEnabled(true);
					} catch (Exception e) {
						buttonOK.setEnabled(false);
					}
				}
			});

			buttonOK.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					shell.dispose();
				}
			});

			buttonCancel.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					value = null;
					shell.dispose();
				}
			});

			shell.addListener(SWT.Traverse, new Listener() {
				public void handleEvent(Event event) {
					if (event.detail == SWT.TRAVERSE_ESCAPE)
						event.doit = false;
				}
			});

			combo.setText("");
			shell.pack();
			shell.open();

			Display display = parent.getDisplay();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

			return value;
		}
	}
}
