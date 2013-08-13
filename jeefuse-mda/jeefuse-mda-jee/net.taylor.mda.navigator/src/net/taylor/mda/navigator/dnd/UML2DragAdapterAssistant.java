package net.taylor.mda.navigator.dnd;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.navigator.CommonDragAdapterAssistant;

public class UML2DragAdapterAssistant extends CommonDragAdapterAssistant {

	@Override
	public Transfer[] getSupportedTransferTypes() {
		return new Transfer[0];
	}

	@Override
	public boolean setDragData(DragSourceEvent anEvent,
			IStructuredSelection aSelection) {
		return false;
	}
}
