package net.taylor.mda.navigator;

import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class Activator extends AbstractUIPlugin {

	// The shared instance.
	private static Activator plugin;

	private static final String PLUGIN_ID = "net.taylor.mda.navigator";

	/**
	 * The constructor.
	 */
	public Activator() {
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	public class ElementDeleteListener implements INotifyChangedListener {
		@SuppressWarnings("unchecked")
		public void notifyChanged(Notification notification) {
			if (notification.getEventType() == Notification.REMOVE) {
				if (notification.getOldValue() instanceof Element) {
					Element e = (Element) notification.getOldValue();
					List<Stereotype> applied = e.getAppliedStereotypes();
					for (Stereotype s : applied) {
						e.unapplyStereotype(s);
					}
				}
			}
		}
	}
	/**
	 * 
	 */
	public AdapterFactory getItemProvidersAdapterFactory() {
		return net.taylor.mda.properties.Activator.getDefault().getItemProvidersAdapterFactory();
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public void log(String msg) {
		log(msg, null);
	}

	public void log(String msg, Exception e) {
		getLog().log(new Status(Status.INFO, PLUGIN_ID, Status.OK, msg, e));
	}
}
