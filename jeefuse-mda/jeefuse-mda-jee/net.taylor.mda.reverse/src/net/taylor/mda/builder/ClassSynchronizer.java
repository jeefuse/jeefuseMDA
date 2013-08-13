package net.taylor.mda.builder;

import java.util.List;

import net.taylor.mda.util.ModelUtil;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class ClassSynchronizer extends ElementSynchronizer {

	public ClassSynchronizer() {
	}

	protected boolean isMine(NamedElement element) {
		return element instanceof Class;
	}

	protected void doSynchronize(final IType type, final NamedElement element)
			throws JavaModelException {
		final CompilationUnit root = getCompilationUnit(type);
		// TODO bean, mdb, other...
		// TODO associations
		final Class clazz = (Class) element;
		TypeDeclaration td = getTypeDeclaration(root);
		updateComment(td, clazz);
		final List<Annotation> classAnnotations = getAnnotations(td);
		applyStereotypes(clazz, classAnnotations, root);

		IField[] fields = type.getFields();
		FieldDeclaration[] fieldDecs = td.getFields();
		for (int i = 0; i < fields.length; i++) {
			if (isGenerated(fieldDecs[i])) {
				final String name = fields[i].getElementName();
				MethodDeclaration getter = getGetter(td, name);
				if (getter != null) {
					Property property = clazz.getOwnedAttribute(name, null);
					if (null == property) {
						final Type ptype = getType(clazz, fieldDecs[i]);
						property = ((Class) element).createOwnedAttribute(name,
								ptype);
					}
					final List<Annotation> fieldAnnotations = getAnnotations(getter);
					applyStereotypes(property, fieldAnnotations, root);
					updateComment(getter, property);
				}
			}
		}
	}

	protected MethodDeclaration getGetter(TypeDeclaration td, String name)
			throws JavaModelException {
		MethodDeclaration[] methods = td.getMethods();
		for (int i = 0; i < methods.length; i++) {
			String mname = methods[i].getName().getFullyQualifiedName();
			if (mname.toLowerCase().equals("get" + name.toLowerCase())) {
				return methods[i];
			}
		}
		return null;
	}

	protected Type getType(Class clazz, FieldDeclaration field)
			throws JavaModelException {
		if (field.getType().isSimpleType()) {
			String signature = ((SimpleType) field.getType()).getName()
					.getFullyQualifiedName().toLowerCase();
			if (signature.contains("long") || signature.contains("int")) {
				return ModelUtil.getPrimitiveType(clazz.getModel(), "Long");
			}
			if (signature.contains("double") || signature.contains("float")) {
				return ModelUtil.getPrimitiveType(clazz.getModel(), "Double");
			}
			if (signature.contains("date")) {
				return ModelUtil.getPrimitiveType(clazz.getModel(), "Date");
			}
			if (signature.startsWith("bool")) {
				return ModelUtil.getPrimitiveType(clazz.getModel(), "Boolean");
			}
			if (signature.contains("string")) {
				return ModelUtil.getPrimitiveType(clazz.getModel(), "String");
			}
			if (signature.contains("byte[]")) {
				return ModelUtil.getPrimitiveType(clazz.getModel(), "Byte[]");
			}
			signature = ((SimpleType) field.getType()).getName()
					.getFullyQualifiedName();
			NamedElement ne = ModelUtil.getElement(signature);// TODO
			if (ne instanceof Type) {
				return (Type) ne;
			} else {
				return null;
			}
		}
		if (field.getType().isQualifiedType()) {
		}
		return null;
	}
}
