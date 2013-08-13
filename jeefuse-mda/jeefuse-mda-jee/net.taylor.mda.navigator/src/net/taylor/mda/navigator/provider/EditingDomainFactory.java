package net.taylor.mda.navigator.provider;

import net.taylor.mda.navigator.Activator;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;

public class EditingDomainFactory extends DiagramEditingDomainFactory {

	public TransactionalEditingDomain createEditingDomain(IOperationHistory history) {
		WorkspaceCommandStackImpl stack = new WorkspaceCommandStackImpl(history);
		
//		TransactionalEditingDomain result = new TransactionalEditingDomainImpl(
//			new ComposedAdapterFactory(
//				ComposedAdapterFactory.Descriptor.Registry.INSTANCE),
//			stack);
		
		TransactionalEditingDomain result = new TransactionalEditingDomainImpl(
				Activator.getDefault().getItemProvidersAdapterFactory(),
				stack);
		mapResourceSet(result);
		configure(result);
		return result;
	}

	
}
