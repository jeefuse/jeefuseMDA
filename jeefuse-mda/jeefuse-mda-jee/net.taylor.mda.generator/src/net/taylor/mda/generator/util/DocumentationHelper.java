package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.internal.impl.ActorImpl;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.eclipse.uml2.uml.internal.impl.InterfaceImpl;
import org.eclipse.uml2.uml.internal.impl.UseCaseImpl;

public class DocumentationHelper {


	public static String getDocumentation(NamedElement namedElement) {
		StringBuffer result = new StringBuffer();
		for (Iterator iter = namedElement.getOwnedComments().iterator(); iter
				.hasNext();) {
			Comment comment = (Comment) iter.next();
			if (result.length() > 0) {
				result.append("\n\n");
			}
			result.append(comment.getBody());
		}
		return result.toString();
	}
	
	public static String getImageName(NamedElement element) {
		String name = element.getQualifiedName();
		return name.replace("::", "-") + ".jpg";
	}

	public static boolean hasUseCases(Package pkg) {
		return getUseCases(pkg).size() > 0;
	}

	public static boolean hasActors(Package pkg) {
		return getActors(pkg).size() > 0;
	}

	public static boolean hasInterfaces(Model pkg) {
		return InterfaceHelper.getInterfaces(pkg).size() > 0;
	}

	public static boolean hasActivities(Model pkg) {
		return getActivities(pkg).size() > 0;
	}

	public static boolean hasPageflows(Model pkg) {
		return JsfHelper.getPageflows(pkg).hasNext();
	}
	
	public static List<UseCase> getUseCases(Package pkg) {
		List<UseCase> list = new ArrayList<UseCase>();
		for (Iterator i = pkg.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			if (element instanceof UseCase) {
				list.add((UseCase) element);
			}
		}
		return list;
	}

	public static List<Actor> getActors(Package pkg) {
		List<Actor> list = new ArrayList<Actor>();
		for (Iterator i = pkg.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			if (element instanceof Actor) {
				list.add((Actor) element);
			}
		}
		return list;
	}

	public static List<Actor> getActors(Model model) {
		List<Actor> list = new ArrayList<Actor>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectActor(element, list);
		}
		Collections.sort(list, new Comparator<NamedElement>() {
			public int compare(NamedElement lh, NamedElement rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list;
	}

	protected static void collectActor(NamedElement element, List<Actor> list) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectActor(ne, list);
			}
		}
		if (element instanceof Actor) {
			list.add((Actor) element);
		}
	}

	public static List<UseCase> getUseCases(Model model) {
		List<UseCase> list = new ArrayList<UseCase>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectUseCase(element, list);
		}
		Collections.sort(list, new Comparator<NamedElement>() {
			public int compare(NamedElement lh, NamedElement rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list;
	}

	protected static void collectUseCase(NamedElement element,
			List<UseCase> list) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectUseCase(ne, list);
			}
		}
		if (element instanceof UseCase) {
			list.add((UseCase) element);
		}
	}

	public static List<Activity> getActivities(Model model) {
		List<Activity> list = new ArrayList<Activity>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectActivity(element, list);
		}
		Collections.sort(list, new Comparator<NamedElement>() {
			public int compare(NamedElement lh, NamedElement rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list;
	}

	protected static void collectActivity(NamedElement element,
			List<Activity> list) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectActivity(ne, list);
			}
		}
		if (element instanceof Activity) {
			list.add((Activity) element);
		}
	}

	public static List<Package> getPackages(Model model) {
		List<Package> list = new ArrayList<Package>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectPackage(element, list);
		}
		return list;
	}

	protected static void collectPackage(NamedElement element,
			List<Package> list) {
		if (element instanceof Package) {
			list.add((Package) element);
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectPackage(ne, list);
			}
		}
	}

	public static List<Package> getPackagesWithActors(Model model) {
		List<Package> list = new ArrayList<Package>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectPackagesWith(element, list, ActorImpl.class);
		}
		return sort(list);
	}

	private static List<Package> sort(List<Package> list) {
		Collections.sort(list, new Comparator<NamedElement>() {
			public int compare(NamedElement lh, NamedElement rh) {
				return lh.getName().compareTo(rh.getName());
			}
		});
		return list;
	}

	public static List<Package> getPackagesWithUseCases(Model model) {
		List<Package> list = new ArrayList<Package>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectPackagesWith(element, list, UseCaseImpl.class);
		}
		return sort(list);
	}

	public static List<Package> getPackagesWithEntities(Model model) {
		List<Package> list = new ArrayList<Package>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectPackagesWith(element, list, ClassImpl.class);
		}
		return sort(list);
	}


	public static List<Package> getPackagesWithServices(Model model) {
		List<Package> list = new ArrayList<Package>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectPackagesWith(element, list, InterfaceImpl.class);
		}
		return sort(list);
	}
	protected static void collectPackagesWith(NamedElement element,
			List<Package> list, java.lang.Class class1) {
		if (element instanceof Package) {
			if (contains((Package) element, class1))
				list.add((Package) element);
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectPackagesWith(ne, list, class1);
			}
		}
	}

	private static boolean contains(Package element, java.lang.Class class1) {
		for (Iterator i = ((Package) element).getMembers().iterator(); i
				.hasNext();) {
			NamedElement ne = (NamedElement) i.next();
			if (ne.getClass().equals(class1)) {
				return true;
			}
		}
		return false;
	}
}
