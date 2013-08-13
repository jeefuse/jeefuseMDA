package net.taylor.mda.builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.util.ModelUtil;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

public abstract class ElementSynchronizer {

	public ElementSynchronizer() {
	}

	/**
	 * The main method.
	 * 
	 * @param type
	 * @throws JavaModelException
	 */
	public void synchronize(final IType type, final NamedElement element)
			throws JavaModelException {
		if (element != null) {
			if (isMine(element)) {
				getEditingDomain().getCommandStack().execute(
						new ChangeCommand(getEditingDomain(), new Runnable() {
							public void run() {
								try {
									doSynchronize(type, element);
								} catch (JavaModelException e) {
									throw new RuntimeException(e);
								}
							}
						}, ""));
				save(element);
			}
		}
	}

	/**
	 * A filter.
	 * 
	 * @param element
	 * @return
	 */
	abstract protected boolean isMine(NamedElement element);

	/**
	 * Do your work.
	 * 
	 * @param type
	 * @param element
	 * @throws JavaModelException
	 */
	abstract protected void doSynchronize(final IType type,
			final NamedElement element) throws JavaModelException;

	/**
	 * Call this in synchronize to handle transactions.
	 * 
	 * @deprecated
	 */
	protected abstract class ChangeElementCommand {

		private Element element;

		public ChangeElementCommand(Element element) {
			this.element = element;
		}

		public void run() throws JavaModelException {
			getEditingDomain().getCommandStack().execute(
					new ChangeCommand(getEditingDomain(), new Runnable() {
						public void run() {
							try {
								doChanges();
							} catch (JavaModelException e) {
								throw new RuntimeException(e);
							}
						}
					}, ""));
			save(element);
		}

		/**
		 * Do the work inside a transaction.
		 * 
		 * @throws JavaModelException
		 */
		abstract protected void doChanges() throws JavaModelException;
	}

	protected boolean isGenerated(BodyDeclaration member)
			throws JavaModelException {
		Javadoc javadoc = member.getJavadoc();
		if (javadoc == null) {
			return false;
		} else {
			return javadoc.toString().contains("@generated");
		}
	}

	protected boolean isGenerated(IMember member) throws JavaModelException {
		String javadoc = member.getSource();
		if (javadoc == null) {
			return false;
		} else {
			return javadoc.contains("@generated");
		}
	}

	protected CompilationUnit getCompilationUnit(IType type) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(type.getCompilationUnit());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		return (CompilationUnit) parser.createAST(null);
	}

	protected TypeDeclaration getTypeDeclaration(CompilationUnit root) {
		return (TypeDeclaration) root.types().get(0);
	}

	@SuppressWarnings("unchecked")
	protected List<Annotation> getAnnotations(BodyDeclaration declaration) {
		List<IExtendedModifier> modifiers = (List<IExtendedModifier>) declaration
				.modifiers();
		List<Annotation> annotations = new ArrayList<Annotation>();
		for (IExtendedModifier modifier : modifiers) {
			if (modifier.isAnnotation()) {
				Annotation annotation = (Annotation) modifier;
				annotations.add(annotation);
			}
		}
		return annotations;
	}

	@SuppressWarnings("unchecked")
	protected List<MemberValuePair> getProperties(Annotation annotation) {
		if (annotation.isMarkerAnnotation()) {
			return new ArrayList<MemberValuePair>();
		} else {
			return ((NormalAnnotation) annotation).values();
		}
	}

	protected void applyStereotypes(Element element,
			List<Annotation> annotations, CompilationUnit root) {
		for (Annotation annotation : annotations) {
			String name = annotation.getTypeName().getFullyQualifiedName();
			name = getFullyQualifiedName(name, root);
			Stereotype stereotype = ModelUtil.getAppliedStereotype(element,
					name);
			if (stereotype == null) {
				ModelUtil.applyStereotype(element, name);
				stereotype = ModelUtil.getAppliedStereotype(element, name);
				if (stereotype == null) {
					continue;
				}
			}
			List<MemberValuePair> properties = getProperties(annotation);
			for (MemberValuePair pair : properties) {
				String key = pair.getName().getFullyQualifiedName();
				Object value = pair.getValue();
				if (pair.getValue() instanceof StringLiteral) {
					value = ((StringLiteral) pair.getValue()).getLiteralValue();
				}
				if (pair.getValue() instanceof QualifiedName) {
					value = ((QualifiedName) pair.getValue())
							.getFullyQualifiedName();
					String[] tokens = ((String)value).split("\\.");
					Element e = ModelUtil.getProfileElement(getFullyQualifiedName(tokens[0], root));
					if (e!= null) {
						if (e instanceof Enumeration) {
							value = ((Enumeration)e).getOwnedLiteral(tokens[1]);
						}
					}
				}
				if (pair.getValue() instanceof BooleanLiteral) {
					value = ((BooleanLiteral) pair.getValue()).booleanValue();
				}
				if (pair.getValue() instanceof NumberLiteral) {
					value = ((NumberLiteral) pair.getValue()).getToken();
				}
				if (pair.getValue() instanceof TypeLiteral) {
					value = ((TypeLiteral) pair.getValue()).getType();// TODO
				}
				element.setValue(stereotype, key, value);
			}
		}
	}

	protected String getFullyQualifiedName(String name, CompilationUnit root) {
		List imports = root.imports();
		for (Iterator i = imports.iterator(); i.hasNext();) {
			ImportDeclaration element = (ImportDeclaration) i.next();
			if (element.getName().getFullyQualifiedName().endsWith(name)) {
				return element.getName().getFullyQualifiedName();
			}
		}
		return name;
	}

	protected EditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("net.taylor.EditingDomain");
		return editingDomain;
	}

	/**
	 * @param element
	 */
	protected void save(Element element) {
		try {
			element.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void updateComment(BodyDeclaration body, Element element) {
		Javadoc javadoc = body.getJavadoc();
		List tags = javadoc.tags();
		if (tags.size() > 0) {
			TagElement t = (TagElement) tags.get(0);
			if (!t.toString().contains("todo")) {
				String text = t.fragments().get(0).toString();
				Comment comment = ModelUtil.getComment(element);
				comment.setBody(text);
			}
		}
	}
}
