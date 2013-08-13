package net.taylor.mda.navigator.provider;

import java.io.IOException;
import java.util.Collections;

import net.taylor.mda.navigator.Activator;
import net.taylor.mda.util.ModelUtil;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.swt.widgets.Display;

/**
 * @author jgilbert
 * 
 */
public class UML2ElementContentProvider extends AdapterFactoryContentProvider {

	@SuppressWarnings("unused")
	private WorkspaceSynchronizer mySynchronizer;

	public UML2ElementContentProvider() {
		super(Activator.getDefault().getItemProvidersAdapterFactory());
	}

	public boolean hasChildren(Object object) {
		if (isFile(object)) {
			return true;
		}
		return super.hasChildren(object);
	}

	public Object[] getChildren(Object object) {
		if (isFile(object)) {
			String path = ((IFile) object).getFullPath().toString();
			object = getFirstRoot(path);
		}
		return super.getChildren(object);
	}

	public Object getParent(Object object) {
		if (isFile(object)) {
			return ((IResource) object).getParent();
		}
		return super.getParent(object);
	}

	public Object[] getElements(Object object) {
		if (isFile(object)) {
			String path = ((IFile) object).getFullPath().toString();
			object = getFirstRoot(path);
		}
		return super.getElements(object);
	}

	protected boolean isFile(Object object) {
		if (object instanceof IFile) {
			// TODO fix and uncomment
			// initListener();
			return true;
		} else {
			return false;
		}
	}

	protected void initListener() {
		if (mySynchronizer == null) {
			mySynchronizer = new WorkspaceSynchronizer(ModelUtil
					.getEditingDomain(), new WorkspaceSynchronizer.Delegate() {

				public void dispose() {
				}

				public boolean handleResourceChanged(final Resource resource) {
					refresh(resource);
					return true;
				}

				public boolean handleResourceDeleted(Resource resource) {
					refresh(resource);
					return true;
				}

				public boolean handleResourceMoved(Resource resource, URI newURI) {
					refresh(resource);
					return true;
				}

				private void refresh(final Resource resource) {
					if ("uml".equals(resource.getURI().fileExtension())
							&& !resource.eAdapters().contains(
									ModelUtil.SAVE_TOKEN)) {
						// Activator.getDefault().log("Refreshing
						// Navigator...");
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								if (resource.isLoaded()) {
									resource.unload();
									try {
										resource.load(Collections.EMPTY_MAP);
									} catch (IOException e) {
										Activator.getDefault().log(
												e.getMessage(), e);
									}
								}
								viewer.refresh();
							}
						});
					} else {
						resource.eAdapters().remove(ModelUtil.SAVE_TOKEN);
					}
				}
			});
		}
	}

	protected static Object getFirstRoot(String path) {
		TransactionalEditingDomain editingDomain = ModelUtil.getEditingDomain();
		Resource resource = editingDomain.loadResource(path);
		return resource;
	}
}
