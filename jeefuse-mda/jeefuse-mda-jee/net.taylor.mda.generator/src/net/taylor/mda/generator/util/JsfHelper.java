package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.taylor.mda.generator.GeneratorPlugin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Vertex;

public class JsfHelper {

	private static final String BASE_TAB = "\t\t\t";

	private static final String TAB = "\t";

	private static final String NEWLINE = "\n";

	static public String getInputField(String prefix, Class uml2Class,
			Property property, Property parent) {
		TagRender render = null;// renders.get(property.getType().getName());
		if (TypeHelper.isDate(property)) {
			render = new DateTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isTime(property)) {
			render = new DateTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isTimestamp(property)) {
			render = new DateTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isBoolean(property)) {
			render = new BooleanTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isText(property)) {
			render = new TextAreaTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isLink(property)) {
			render = new LinkTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isImage(property)) {
			render = new ImageTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isPercentage(property)) {
			render = new PercentageTagRender(prefix, uml2Class, property,
					parent);
		} else if (TypeHelper.isCurrency(property)) {
			render = new CurrencyTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isDecimal(property)
				|| TypeHelper.isDouble(property.getType())) {
			render = new DecimalTagRender(prefix, uml2Class, property, parent);
		} else if (TypeHelper.isInteger(property)
				|| TypeHelper.isLong(property.getType())) {
			render = new IntegerTagRender(prefix, uml2Class, property, parent);
		} else if (EnumerationHelper.isEnumeration(property)) {
			render = new EnumerationTagRender(prefix, uml2Class, property,
					parent);
		} else if (TypeHelper.isBlob(property.getType())) {
			render = new BlobTagRender(prefix, uml2Class, property, parent);
		} else {
			render = new StringTagRender(prefix, uml2Class, property, parent);
		}
		// TODO secret, textArea?
		return render.render();
	}

	static public String getType(Property property) {
		if (StereotypeHelper.isStereotypeApplied(property,
				StereotypeHelper.ID)) {
			return "ID";
		} else if (TypeHelper.isDate(property)) {
			return "Date";
		} else if (TypeHelper.isTime(property)) {
			return "Time";
		} else if (TypeHelper.isTimestamp(property)) {
			return "Timestamp";
		} else if (TypeHelper.isBoolean(property)) {
			return "Boolean";
		} else if ((TypeHelper.isText(property))) {
			return "TextArea";
		} else if (TypeHelper.isLink(property)) {
			return "Link";
		} else if (TypeHelper.isImage(property)) {
			return "Image";
		} else if (TypeHelper.isPercentage(property)) {
			return "Percent";
		} else if (TypeHelper.isCurrency(property)) {
			return "Currency";
		} else if (TypeHelper.isDecimal(property)
				|| TypeHelper.isDouble(property.getType())) {
			return "Decimal";
		} else if (TypeHelper.isInteger(property)
				|| TypeHelper.isLong(property.getType())) {
			return "Integer";
		} else if (EnumerationHelper.isEnumeration(property)) {
			return "Enum";
		} else if (TypeHelper.isBlob(property.getType())) {
			return "Blob";
		} else {
			return "String";
		}
	}

	static public String getOutputField(String prefix, Class uml2Class,
			Property property) {
		StringBuffer tag = new StringBuffer();
		tag.append("<tt:output");

		tag.append(" type=\"");
		tag.append(getType(property));
		tag.append("\"");

		tag.append(" id=\"#{id}");
		// tag.append(NameHelper.uncapSafeName(uml2Class));
		tag.append(NameHelper.getCapName(property));
		tag.append("\"");

		tag.append(" value=\"#{");
		tag.append(prefix);// +
		tag.append(".");
		tag.append(NameHelper.uncapSafeName(property));
		tag.append("}\"");

		tag.append(" label=\"#{messages['");
		tag.append(NameHelper.getCapName(uml2Class));
		tag.append("_");
		tag.append(NameHelper.uncapSafeName(property));
		tag.append("']}\"");

		tag.append(" hint=\"#{messages['");
		tag.append(NameHelper.getCapName(uml2Class));
		tag.append("_");
		tag.append(NameHelper.uncapSafeName(property));
		tag.append("Doc']}\"");
		tag.append(" />");
		return tag.toString();
	}

	static public boolean hasTextArea(Class uml2Class) {
		return ClassHelper.hasProperty(uml2Class, "description")
				|| ClassHelper.hasProperty(uml2Class, "text");
		// || StereotypeHelper.isStereotypeApplied(property, "types.Text");
	}

	static public String isRequired(Property property) {
		if (StereotypeHelper.isStereotypeApplied(property,
				StereotypeHelper.NOT_NULL)) {
			return "true";
		} else if (StereotypeHelper.isStereotypeApplied(property,
					"net.taylor.validator.Required")) {
				return "true";
		} else if (StereotypeHelper.isStereotypeApplied(property,
				StereotypeHelper.LENGTH)) {
			Object min = StereotypeHelper.getValue(property,
					StereotypeHelper.LENGTH, "min");
			if (min instanceof Number) {
				if (((Number) (min)).intValue() > 0) {
					return "true";
				}
			}
		} else if (StereotypeHelper.isStereotypeApplied(property,
				StereotypeHelper.COLUMN)) {
			Object nullable = StereotypeHelper.getValue(property,
					StereotypeHelper.COLUMN, "nullable");
			if (nullable instanceof Boolean) {
				if (((Boolean) (nullable)).equals(Boolean.FALSE)) {
					return "true";
				}
			}
		}
		return "false";
	}

	static public String isReadOnly(Property property) {
		if (property.isReadOnly()) {
			return "true";
		}
		return "false";
	}

	static public String isDisabled(Property property) {
		if (StereotypeHelper.isStereotypeApplied(property,
				StereotypeHelper.GENERATED_VALUE)
				|| StereotypeHelper.isStereotypeApplied(property,
						StereotypeHelper.VERSION)) {
			return "true";
		} else if (property.isReadOnly()) {
			return "true";
		} else {
			return "false";
		}
	}

	static public class TagRender {

		protected String prefix = "";

		protected Class uml2Class = null;

		protected Property property = null;

		protected Property parent = null;

		protected StringBuffer tag = null;

		public TagRender(String prefix, Class uml2Class, Property property,
				Property parent) {
			super();
			this.prefix = prefix;
			this.parent = parent;
			this.uml2Class = uml2Class;
			this.property = property;
		}

		public String render() {
			tag = new StringBuffer();
			startTag();
			body();
			endTag();
			return tag.toString();
		}

		protected void startTag() {
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append("<");
			tagName();
			attributes();
			// tag.append(">");
		}

		protected void attributes() {
			type();
			id();
			value();
			label();
			hint();
			required();
		}

		protected void required() {
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.NOT_NULL)) {
				tag.append(" required=\"true\"");
			} else if (StereotypeHelper.isStereotypeApplied(property,
					"net.taylor.validator.Required")) {
				tag.append(" required=\"true\"");
			} else if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.LENGTH)) {
				Object min = StereotypeHelper.getValue(property,
						StereotypeHelper.LENGTH, "min");
				if (min instanceof Number) {
					if (((Number) (min)).intValue() > 0) {
						tag.append(" required=\"true\"");
					}
				}
			} else if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.COLUMN)) {
				Object nullable = StereotypeHelper.getValue(property,
						StereotypeHelper.COLUMN, "nullable");
				if (nullable instanceof Boolean) {
					if (((Boolean) (nullable)).equals(Boolean.FALSE)) {
						tag.append(" required=\"true\"");
					}
				}
			} else {
				tag.append(" required=\"false\"");
			}
		}

		protected void maxLength() {
			if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.COLUMN)) {
				StereotypeHelper.getValue(property, StereotypeHelper.COLUMN,
						"length");
				// tag.append("maxLength=\"true\"");
			}
			if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.LENGTH)) {
				StereotypeHelper.getValue(property, StereotypeHelper.LENGTH,
						"max");
				// tag.append("maxLength=\"true\"");
			}
		}

		protected void body() {
		}

		protected void endTag() {
			// tag.append(NEWLINE);
			// tag.append(BASE_TAB);
			// tag.append(TAB);
			// tag.append(TAB);
			// tag.append("</");
			// tagName();
			tag.append(" />");
		}

		protected void tagName() {
			tag.append("tt:input");
		}

		protected void value() {
			// tag.append(NEWLINE);
			// tag.append(BASE_TAB);
			// tag.append(TAB);
			// tag.append(TAB);
			// tag.append(TAB);
			tag.append(" value=\"#{");
			tag.append(prefix);// +
			// NameHelper.uncapSafeName(uml2Class));//"entity");
			tag.append(".");
			tag.append(NameHelper.uncapSafeName(property));
			tag.append("}\"");
		}

		protected void type() {
			tag.append(" type=\"");
			// special case
			if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.ID)) {
				tag.append("ID");
			} else {
				tag.append(getType(property));
			}

			tag.append("\"");
		}

		protected void id() {
			// tag.append(NEWLINE);
			// tag.append(BASE_TAB);
			// tag.append(TAB);
			// tag.append(TAB);
			// tag.append(TAB);
			tag.append(" id=\"");
			if (parent == null) {
				tag.append(NameHelper.uncapSafeName(property));
			} else {
				tag.append(NameHelper.uncapSafeName(parent));
				tag.append(NameHelper.getCapName(property));
			}
			tag.append("\"");
		}

		protected void label() {
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append(" label=\"#{messages['");
			tag.append(NameHelper.getCapName(uml2Class));
			tag.append("_");
			tag.append(property.getName());
			tag.append("']}\"");
		}

		protected void hint() {
			// tag.append(NEWLINE);
			// tag.append(BASE_TAB);
			// tag.append(TAB);
			// tag.append(TAB);
			// tag.append(TAB);
			tag.append(" hint=\"#{messages['");
			tag.append(NameHelper.getCapName(uml2Class));
			tag.append("_");
			tag.append(NameHelper.uncapSafeName(property));
			tag.append("Doc']}\"");
		}
	}

	static public class StringTagRender extends TagRender {
		public StringTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}

		protected void attributes() {
			super.attributes();
			size();
		}

		protected void size() {
			Object size = "20";
			if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.COLUMN)) {
				size = StereotypeHelper.getValue(property,
						StereotypeHelper.COLUMN, "length");
			}
			if (StereotypeHelper.isStereotypeApplied(property,
					StereotypeHelper.LENGTH)) {
				size = StereotypeHelper.getValue(property,
						StereotypeHelper.LENGTH, "max");
			}
			tag.append(" size=\"");
			tag.append(size.toString());
			tag.append("\"");
		}
	}

	static public class DateTagRender extends TagRender {
		public DateTagRender(String prefix, Class uml2Class, Property property,
				Property parent) {
			super(prefix, uml2Class, property, parent);
		}
	}

	static public class BooleanTagRender extends TagRender {
		public BooleanTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}
	}

	static public class BlobTagRender extends TagRender {
		public BlobTagRender(String prefix, Class uml2Class, Property property,
				Property parent) {
			super(prefix, uml2Class, property, parent);
		}

		protected void value() {
			// assume the entity has the following fields: content, contentType,
			// size, name, description
			tag.append(" value=\"#{");
			tag.append(prefix);
			tag.append("}\"");
		}
	}

	static public class TextAreaTagRender extends TagRender {
		public TextAreaTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}

		protected void attributes() {
			super.attributes();
			rows();
			cols();
		}

		protected void rows() {
			tag.append(" rows=\"5\"");
		}

		protected void cols() {
			tag.append(" cols=\"40\"");
		}
	}

	static public class DecimalTagRender extends TagRender {
		public DecimalTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}
	}

	static public class IntegerTagRender extends TagRender {
		public IntegerTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}
	}

	static public class CurrencyTagRender extends TagRender {
		public CurrencyTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}
	}

	static public class PercentageTagRender extends TagRender {
		public PercentageTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}
	}

	static public class ImageTagRender extends TagRender {
		public ImageTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}
	}

	static public class LinkTagRender extends TagRender {
		public LinkTagRender(String prefix, Class uml2Class, Property property,
				Property parent) {
			super(prefix, uml2Class, property, parent);
		}

		protected void attributes() {
			super.attributes();
			text();
		}

		protected void text() {
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("text=\"#{row.name}\"");
		}
		
	}

	static public class EnumerationTagRender extends TagRender {
		public EnumerationTagRender(String prefix, Class uml2Class,
				Property property, Property parent) {
			super(prefix, uml2Class, property, parent);
		}

		protected void startTag() {
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append("<");
			tagName();
			attributes();
			tag.append(">");
		}

		protected void endTag() {
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append("</");
			tagName();
			tag.append(">");
		}

		protected void attributes() {
			// super.attributes();
			src();
		}

		protected void src() {
			tag.append(" src=\"/WEB-INF/jsf/");
			tag.append(NameHelper.getCapName(property.getType()));
			tag.append("/Tag.xhtml\"");
		}

		protected void body() {
			id();
			value();
			label();
			hint();
			required();
			listener();
			rerender();
		}

		protected void id() {
			// <ui:param name="id" value="<%=id%>" />
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("<ui:param name=\"id\" value=\"");
			tag.append(NameHelper.uncapSafeName(property));
			tag.append("\"/>");
		}

		protected void label() {
			// <ui:param name="label" value="#{messages['<%=className%>_<%=id%>}" />
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("<ui:param name=\"label\" value=\"#{messages['");
			tag.append(NameHelper.getCapName(uml2Class));
			tag.append("_");
			tag.append(NameHelper.uncapSafeName(property));
			tag.append("']}\"/>");
		}

		protected void hint() {
			// <ui:param name="hint" value="#{messages['<%=className%>_<%=id%>Doc}" />
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("<ui:param name=\"hint\" value=\"#{messages['");
			tag.append(NameHelper.getCapName(uml2Class));
			tag.append("_");
			tag.append(NameHelper.uncapSafeName(property));
			tag.append("Doc']}\"/>");
		}

		protected void value() {
			// <ui:param name="value" value="#{<%=entity%>.<%=id%>}" />
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("<ui:param name=\"value\" value=\"#{");
			tag.append(prefix);// +
			tag.append(".");
			tag.append(NameHelper.uncapSafeName(property));
			tag.append("}\"/>");
		}

		protected void required() {
			// <ui:param name="required" value="<%=required%>" />
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("<ui:param name=\"required\" value=\"");
			tag.append(isRequired(property));
			tag.append("\"/>");
		}

		private void listener() {
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("<ui:param name=\"listener\" value=\"onChange");
			if (!"entity".equals(prefix)) {
				tag.append(NameHelper.capName(prefix.substring(7)));
			}
			tag.append(NameHelper.getCapName(property));
			tag.append("\"/>");
		}

		private void rerender() {
			tag.append(NEWLINE);
			tag.append(BASE_TAB);
			tag.append(TAB);
			tag.append(TAB);
			tag.append("<ui:param name=\"reRender\" value=\"#{editor.");
			if (!"entity".equals(prefix)) {
				tag.append(prefix.substring(7));
				tag.append(NameHelper.getCapName(property));
			} else {
				tag.append(NameHelper.uncapSafeName(property));
			}
			tag.append("ReRender}");
			tag.append("\"/>");
		}

		protected void tagName() {
			tag.append("ui:include");
		}
	}

	static public Iterator<Region> getPageflows(Model model) {
		List<Region> list = new ArrayList<Region>();
		for (Iterator i = model.getMembers().iterator(); i.hasNext();) {
			NamedElement element = (NamedElement) i.next();
			collectRegion(element, list);
		}
		return list.iterator();
	}

	static protected void collectRegion(NamedElement element, List<Region> list) {
		if (element instanceof Package) {
			for (Iterator i = ((Package) element).getMembers().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectRegion(ne, list);
			}
		}
		if (element instanceof StateMachine) {
			for (Iterator i = ((StateMachine) element).getRegions().iterator(); i
					.hasNext();) {
				NamedElement ne = (NamedElement) i.next();
				collectRegion(ne, list);
			}
		}
		if (element instanceof Region) {
			list.add((Region) element);
		}
	}

	static public Iterator<State> getPages(Region region) {
		List<State> list = new ArrayList<State>();
		for (Iterator i = region.getSubvertices().iterator(); i.hasNext();) {
			Object state = i.next();
			if (state instanceof State) {
				list.add((State) state);
			}
		}
		return list.iterator();
	}

	static public String getStartPage(Region region) {
		Vertex start = getStartState(region);
		if (start != null) {
			return NameHelper.removeSpaces(start.getName());
		}
		return "NOT FOUND";
	}
	
	static public Vertex getStartState(Region region) {
		for (Iterator i = region.getSubvertices().iterator(); i.hasNext();) {
			Object state = i.next();
			if (state instanceof Pseudostate) {
				Pseudostate ps = (Pseudostate) state;
				if (ps.getKind().equals(PseudostateKind.INITIAL_LITERAL)) {
					for (Iterator j = ps.getOutgoings().iterator(); i.hasNext();) {
						// the first will do...
						Transition t = (Transition) j.next();
						return t.getTarget();
					}
				}
			}
		}
		return null;
	}


	static public boolean isFinalTransition(Region region, Transition t) {
		Vertex start = getStartState(region);
		if (start == null) {
			return false;
		}
		Vertex src = t.getSource();
		return t.getTarget().equals(start) && src.getOutgoings().size() == 1;
	}
	
	static public String getPageActions(State state) {
		StringBuilder builder = new StringBuilder();
		for (Iterator<Transition> i = state.getOutgoings().iterator(); i.hasNext();) {
			Transition transition = i.next();
			String name = NameHelper.removeSpaces(NameHelper.uncapSafeName(transition));
			if (name != null && name.length() > 0) {
				builder.append("\"");
				builder.append(name);
				builder.append("\"");
				if (i.hasNext()) {
					builder.append(", ");
				}
			}
		}
		return builder.toString();
	}

	static public Iterator<Class> getPageDomains(Region region) {
		Set<Class> list = new HashSet<Class>();
		for (Iterator<State> i = getPages(region); i.hasNext();) {
			State state = i.next();
			if (StereotypeHelper.isStereotypeApplied(state, "Page")) {
				Class domain = (Class) StereotypeHelper.getValue(state, "Page",
						"domain");
				if (domain != null) {
					list.add(domain);
				}
			}
		}
		return list.iterator();
	}

	static public String getReportFieldType(Type type) {
		String value = TypeHelper.getPrimitiveObjectType(type);
		if (value == null) {
			return "java.lang.String";
		} else {
			return value;
		}
	}

	static public String getReferenceType(Class owner, Property property) {
		Iterator i = getReRenderM2o(owner, property);
		if (i.hasNext()) {
			return "ReferenceReRender";
		} else {
			return "Reference";
		}
	}

	static public boolean isReRenderM2o(Class owner, Property property) {
		Iterator i = getReRenderM2o(owner, property);
		return i.hasNext();
	}

	static public String getReRenderM2oPanels(Class owner, Property property) {
		String value = "";
		Iterator i = getReRenderM2o(owner, property);
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (value.length() > 0) {
				value = value + ",";
			}
			value = value + p.getName() + "InputPanel";
		}
		return value;
	}

	static private Iterator<Property> getReRenderM2o(Class owner, Property m2o) {
		List<Property> list = new ArrayList<Property>();
		Iterator i = ClassHelper.getAllManyToOneProperties(owner);
		while (i.hasNext()) {
			Property p = (Property) i.next();
			Class otherRef = (Class) p.getType(); // TODO inheritance
			Iterator j = ClassHelper.getAllManyToOneProperties(otherRef);
			while (j.hasNext()) {
				Property p2 = (Property) j.next();
				if (p2.getType().equals(m2o.getType())) {// TODO m2m
					list.add(p);
					break;
				}
			}
		}
		return list.iterator();
	}
	
	static public String getViewRoles(Class entity) {
		return getRoles(entity, new String[]{"ALL", "READ"}, "s:hasRole('", " or ", "')");
	}
	
	static public String getEditRoles(Class entity) {
		return getRoles(entity, new String[]{"ALL", "INSERT", "UPDATE"}, "s:hasRole('", " or ", "')");
	}
	
	static public String getEditableRoles(Class entity) {
		return getRoles(entity, new String[]{"ALL", "INSERT", "UPDATE"}, "isUserInRole(\"", " || ", "\")");
	}
	
	static private String getRoles(Class entity, String[] permission, String prefix, String operator, String suffix) {
		StringBuilder builder = new StringBuilder();
		Stereotype permissions = StereotypeHelper.getStereotype(entity, "net.taylor.security.jpa.Permissions");
		if (permissions != null) {
			Collection value = (Collection) entity.getValue(permissions, "value");
			for (Object impl : value) {
				List<Actor> actors = getRoles((DynamicEObjectImpl)impl, entity, permission);
				for (Actor actor : actors) {
					if (builder.length() > 0) {
						builder.append(operator);
					}
					builder.append(prefix);
					builder.append(actor.getName());
					builder.append(suffix);
				}
			}
		}
		if (builder.length() == 0) {
			builder.append(prefix);
			builder.append("User");
			builder.append(suffix);
		}
		return builder.toString();
	}
	

	private static List<Actor> getRoles(DynamicEObjectImpl impl, Element element, String[] permissions) {
		List<Actor> roles = new ArrayList<Actor>();
		EClass eClass = impl.eClass();
		boolean hasPermission = false;
		for (Iterator i = eClass.getEAllAttributes().iterator(); i.hasNext();) {
			EAttribute eAttribute = (EAttribute) i.next();
			if ("actions".equals(eAttribute.getName())) {
				Collection value = (Collection) impl.eGet(eAttribute);
				if (value != null) {
					log(value.toString());
					for (Object action : value) {
						log(action.toString());
						for (String permission : permissions) {
							if (action.toString().contains(permission)) {
								hasPermission = true;
							}
						}
					}
				}
			}
		}
		if (hasPermission) {
			for (Iterator i = eClass.getEAllReferences().iterator(); i.hasNext();) {
				EReference eReference = (EReference) i.next();
				if ("roles".equals(eReference.getName())) {
					Collection value = (Collection) impl.eGet(eReference);
					for (Object actor : value) {
						roles.add((Actor) actor);
					}
				}
			}
		}
		return roles;
	}
	
	private static void log(String msg) {
		GeneratorPlugin plugin = GeneratorPlugin.getDefault();
		if (plugin != null) {
			plugin.log(msg);
		}
	}
	
	public static boolean isRenderCharts(Class clazz) {
		boolean render = EnumerationHelper.getAllEnumerations(clazz).hasNext();
		for (Iterator<Property> l = ClassHelper
				.getAllManyToOneProperties(clazz); l.hasNext();) {
			Property property = l.next();
			if (!ClassHelper.isComposite(property)) {
				render = true;
			}
		}
		return render;
	}
}