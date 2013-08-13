package net.taylor.mda.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLPackage;

public class ModelUtil {

	public static void applyStereotype(Element element, String name) {
		for (Iterator applicableStereotypes = element
				.getApplicableStereotypes().iterator(); applicableStereotypes
				.hasNext();) {

			Stereotype stereotype = (Stereotype) applicableStereotypes.next();

			if (stereotype.getName().equals(name)) {
				element.applyStereotype(stereotype);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void unapplyStereotypes(Element element) {
		List<Stereotype> applied = element.getAppliedStereotypes();
		for (Stereotype s : applied) {
			element.unapplyStereotype(s);
		}
		// List<Element> owned = element.allOwnedElements();
		// for (Element element2 : owned) {
		// unapplyStereotypes(element2);
		// }
	}

	public static Stereotype getAppliedStereotype(Element element, String name) {
		for (Iterator applicableStereotypes = element.getAppliedStereotypes()
				.iterator(); applicableStereotypes.hasNext();) {
			Stereotype stereotype = (Stereotype) applicableStereotypes.next();
			if (stereotype.getName().equals(name)) {
				return stereotype;
			}
		}
		return null;
	}

	public static boolean isStereotypeApplied(Element element, String name) {
		Iterator i = element.getAppliedStereotypes().iterator();
		while (i.hasNext()) {
			Stereotype stereotype = (Stereotype) i.next();
			if (name.equals(stereotype.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param e
	 *            the subordinate element to clean
	 * @param context
	 *            the element that was deleted
	 */
	@SuppressWarnings("unchecked")
	public static void clean(Element e, Element context) {
		// TODO EMFT transaction listener
		unapplyStereotypes(e);

		if (e instanceof Association) {
			Association association = (Association) e;
			Property[] list = (Property[]) association.getMemberEnds().toArray(
					new Property[association.getMemberEnds().size()]);
			for (Property p : list) {
				clean(p, context);
				if (!context.equals(p.getOwner())) {
					p.destroy();
				}
			}
		}

		if (e instanceof Operation) {
			Operation o = (Operation) e;
			List params = o.getOwnedParameters();
			for (Iterator j = params.iterator(); j.hasNext();) {
				Parameter p = (Parameter) j.next();
				clean(p, context);
			}
		}

		if (e instanceof org.eclipse.uml2.uml.Classifier) {
			org.eclipse.uml2.uml.Classifier entity = (org.eclipse.uml2.uml.Classifier) e;

			Relationship[] relationships = (Relationship[]) entity
					.getRelationships().toArray(
							new Relationship[entity.getRelationships().size()]);
			for (Relationship relationship : relationships) {
				unapplyStereotypes(relationship);
				clean(relationship, context);
				relationship.destroy();
			}
		}

		if (e instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class entity = (org.eclipse.uml2.uml.Class) e;
			List list = entity.getOwnedAttributes();
			for (Iterator i = list.iterator(); i.hasNext();) {
				Property p = (Property) i.next();
				clean(p, context);
			}
		}

		if (e instanceof org.eclipse.uml2.uml.Interface) {
			org.eclipse.uml2.uml.Interface entity = (org.eclipse.uml2.uml.Interface) e;
			List list = entity.getOwnedOperations();
			for (Iterator i = list.iterator(); i.hasNext();) {
				Operation o = (Operation) i.next();
				clean(o, context);
			}
		}

		if (e instanceof org.eclipse.uml2.uml.Activity) {
			org.eclipse.uml2.uml.Activity activity = (org.eclipse.uml2.uml.Activity) e;
			List list = activity.getEdges();
			for (Iterator i = list.iterator(); i.hasNext();) {
				ActivityEdge edge = (ActivityEdge) i.next();
				clean(edge, context);
			}
			list = activity.getNodes();
			for (Iterator i = list.iterator(); i.hasNext();) {
				ActivityNode node = (ActivityNode) i.next();
				clean(node, context);
			}
		}
		
		if (e instanceof org.eclipse.uml2.uml.ActivityNode) {
			org.eclipse.uml2.uml.ActivityNode node = (org.eclipse.uml2.uml.ActivityNode) e;
			List list = node.getIncomings();
			list.addAll(node.getOutgoings());
			ActivityEdge[] array = (ActivityEdge[]) list.toArray(
					new ActivityEdge[list.size()]);
			for (ActivityEdge edge : array) {
				clean(edge, context);
				edge.destroy();
			}
			
		}

		if (e instanceof org.eclipse.uml2.uml.Vertex) {
			org.eclipse.uml2.uml.Vertex vertex = (org.eclipse.uml2.uml.Vertex) e;
			List list = vertex.getIncomings();
			list.addAll(vertex.getOutgoings());
			Transition[] array = (Transition[]) list.toArray(
					new Transition[list.size()]);
			for (Transition edge : array) {
				clean(edge, context);
				edge.destroy();
			}
		}
	}

	public static Comment getComment(Element element) {
		if (!element.getOwnedComments().iterator().hasNext()) {
			element.createOwnedComment();
		}
		return (Comment) element.getOwnedComments().iterator().next();
	}

	public static EObject adaptObject(Object object) {
		if (object == null) {
			return null;
		} else if (object instanceof EObject) {
			return (EObject) object;
		} else if (object instanceof IAdaptable) {
			// Try IAdaptable
			IAdaptable adapted = (IAdaptable) object;
			Object eObject = adapted.getAdapter(EObject.class);
			if (eObject != null) {
				return (EObject) eObject;
			}
		} else {
			// Try registered adapter
			Object adapted = Platform.getAdapterManager().getAdapter(object,
					EObject.class);
			if (adapted != null) {
				return (EObject) adapted;
			}
		}
		return null;
	}

	public static PrimitiveType getPrimitiveType(Package pkg, String name) {
		Profile types = pkg.getAppliedProfile("types");
		PrimitiveType primitiveType = (PrimitiveType) types.getOwnedType(name);
		return primitiveType;
	}

	/**
	 * Find the element in the model.
	 * 
	 * @param name
	 * @return
	 */
	public static NamedElement getElement(String name) {
		Iterator h = getEditingDomain().getResourceSet().getResources()
				.iterator();
		while (h.hasNext()) {
			Resource resource = (Resource) h.next();
			Package pkg = (Package) EcoreUtil.getObjectByType(resource
					.getContents(), UMLPackage.eINSTANCE.getPackage());
			if (pkg != null) {
				NamedElement ne = getElement(pkg, name);
				if (ne != null) {
					return ne;
				}
			}
		}
		return null;
	}

	public static TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("net.taylor.EditingDomain");
		return editingDomain;
	}

	public static NamedElement getElement(Package pkg, String name) {
		Iterator j = pkg.getMembers().iterator();
		while (j.hasNext()) {
			NamedElement element = (NamedElement) j.next();
			if (name.equals(element.getName())) {
				return element;
			} else if (element instanceof Package) {
				NamedElement ne = getElement((Package) element, name);
				if (ne != null) {
					return ne;
				}
			} else {
				EList<Element> list = element.getOwnedElements();
				for (Element element2 : list) {
					if (element2 instanceof NamedElement) {
						NamedElement ne = (NamedElement) element2;
						if (name.equals(ne.getName())) {
							return ne;
						}
					}
				}
			}
		}
		return null;
	}

	public static NamedElement getProfileElement(String name) {
		Iterator h = getEditingDomain().getResourceSet().getResources()
				.iterator();
		while (h.hasNext()) {
			Resource resource = (Resource) h.next();
			Profile profile = (Profile) EcoreUtil.getObjectByType(resource
					.getContents(), UMLPackage.eINSTANCE.getProfile());
			if (profile != null) {
				NamedElement ne = getElement(profile, name);
				if (ne != null) {
					return ne;
				}
			}
		}
		return null;
	}

	public static NamedElement getProfileElement(Element element, String name) {
		Iterator<Profile> h = element.getModel().getAllAppliedProfiles()
				.iterator();
		while (h.hasNext()) {
			Profile profile = (Profile) h.next();
			if (profile != null) {
				NamedElement ne = getElement(profile, name);
				if (ne != null) {
					return ne;
				}
			}
		}
		return null;
	}

	public static IFile getWorkspaceFile(Resource resource) {
		String filePath = getWorkspaceFilePath(resource);
		if (filePath == null)
			return null;

		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(filePath);
		if ((workspaceResource == null)
				|| (workspaceResource.getType() != IResource.FILE))
			return null;

		return (IFile) workspaceResource;
	}

	public static String getWorkspaceFilePath(Resource resource) {
		if (resource == null)
			return null;

		String uriToString = resource.getURI().toString();
		return uriToString;
		// if (!uriToString.startsWith("platform:/resource"))
		// return null;
		//
		// return uriToString.substring("platform:/resource".length());
	}

	public static boolean isSynchronized(Resource resource) {
		IFile file = getWorkspaceFile(resource);
		return file.isSynchronized(0);
	}

	public static void save(final EObject element) {
		try {
			Resource savedResource = element.eResource();
			if (!isSynchronized(savedResource)) {
				String msg = savedResource.getURI() + " is not synchronized.";
				MessageDialog.openError(Display.getDefault().getActiveShell(),
						"Synchronization Error", msg);
				throw new RuntimeException(msg);
			}
			savedResource.setTrackingModification(false);// TODO
			savedResource.eAdapters().add(SAVE_TOKEN);
			savedResource.save(Collections.EMPTY_MAP);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void setToken(Resource resource) {
		resource.eAdapters().add(SAVE_TOKEN);
	}

	public static final Adapter SAVE_TOKEN = new Adapter() {

		public Notifier getTarget() {
			return null;
		}

		public boolean isAdapterForType(Object arg0) {
			return false;
		}

		public void notifyChanged(Notification arg0) {
		}

		public void setTarget(Notifier arg0) {
		}
	};

}
