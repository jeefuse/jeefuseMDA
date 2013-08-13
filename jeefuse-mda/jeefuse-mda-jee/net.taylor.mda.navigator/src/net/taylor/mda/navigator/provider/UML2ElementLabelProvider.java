package net.taylor.mda.navigator.provider;

import net.taylor.mda.navigator.Activator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;

public class UML2ElementLabelProvider extends AdapterFactoryLabelProvider {

	public UML2ElementLabelProvider() {
		super(Activator.getDefault().getItemProvidersAdapterFactory());
	}

	public Image getImage(Object object) {
		if (object instanceof IFile) {
			return getImageFromObject(object);
		}
		return super.getImage(object);
	}

	public String getText(Object object) {
		if (object instanceof IFile) {
			return ((IFile) object).getName();
		}
		return super.getText(object);
	}
}
