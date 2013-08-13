package net.taylor.mda.navigator.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

public class UML2DropAdapterAssistant extends CommonDropAdapterAssistant {

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter,
			DropTargetEvent aDropTargetEvent, Object aTarget) {

		Element tgt = (Element) aTarget;
		Collection src = extractDragSource(aDropTargetEvent.data);
		for (Iterator i = src.iterator(); i.hasNext();) {
			Object e = (Object) i.next();
			if (e instanceof Element) {
				Element element = (Element) e;
				if (element.getOwner().equals(tgt)) {
					// no op
					return null;
				}
				if (!element.getOwner().getClass().equals(tgt.getClass())) {
					// not compatible
					return null;
				}
			}
		}

		EditingDomain domain = TransactionUtil.getEditingDomain(tgt);
		Command command = DragAndDropCommand.create(domain, tgt,
				getLocation(aDropTargetEvent), aDropTargetEvent.operations,
				aDropTargetEvent.detail, src);
		domain.getCommandStack().execute(command);
		return Status.OK_STATUS;
	}

	@Override
	public IStatus validateDrop(Object target, int operation,
			TransferData transferType) {
		if (target instanceof Package) {
			return Status.OK_STATUS;
		}
		else if (target instanceof Class) {
			return Status.OK_STATUS;
		}
		return null;
	}

	protected Collection extractDragSource(Object object) {
		if (object instanceof IStructuredSelection) {
			Collection result = new ArrayList();
			for (Iterator elements = ((IStructuredSelection) object).iterator(); elements
					.hasNext(); result.add(elements.next()))
				;
			return result;
		} else {
			return Collections.EMPTY_LIST;
		}
	}

	protected static float getLocation(DropTargetEvent event) {
		if (event.item instanceof TreeItem) {
			TreeItem treeItem = (TreeItem) event.item;
			Control control = treeItem.getParent();
			Point point = control.toControl(new Point(event.x, event.y));
			Rectangle bounds = treeItem.getBounds();
			return (float) (point.y - bounds.y) / (float) bounds.height;
		}
		if (event.item instanceof TableItem) {
			TableItem tableItem = (TableItem) event.item;
			Control control = tableItem.getParent();
			Point point = control.toControl(new Point(event.x, event.y));
			Rectangle bounds = tableItem.getBounds(0);
			return (float) (point.y - bounds.y) / (float) bounds.height;
		} else {
			return 0.0F;
		}
	}

}
