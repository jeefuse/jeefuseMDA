package net.taylor.mda.reverse;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.Types;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaComplexType;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaObjectCollection;
import org.apache.ws.commons.schema.XmlSchemaSequence;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.apache.ws.commons.schema.XmlSchemaType;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.jboss.ws.tools.NamespacePackageMapping;
import org.osgi.framework.Bundle;

public class WsdlReverseEngineer extends ModelReverseEngineer {

	private Map<String, Package> packages = new HashMap<String, Package>();

	public InputStream createModel(IProgressMonitor monitor, String url,
			String name) {
		try {
			registerResourceFactories();
			Bundle b = Platform.getBundle("org.eclipse.uml2.uml.resources");
			String location = b.getLocation();
			location = location.replace("reference", "jar");
			location = location + "!/";
			registerPathmaps(URI.createURI(location));

			out("Creating model...");
			Model model = createModel(name, URI.createURI("model")
					.appendSegment(name).appendFileExtension(
							UMLResource.FILE_EXTENSION));
			// these are for unit testing
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/Persistence.profile.uml");
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/types.profile.uml");

			WSDLFactory wsdlfactory = WSDLFactory.newInstance();
			WSDLReader reader = wsdlfactory.newWSDLReader();
			Definition def = reader.readWSDL(url);
			XmlSchema schema = getSchema(def);

			handleServices(def, model, url);
			handlePortTypes(def, schema, model, url);

			out("Saving model...");
			return toInputStream(model, URI.createURI("model").appendSegment(
					name).appendFileExtension(UMLResource.FILE_EXTENSION));
			// these are for unit testing
			// save(model, URI.createURI("model").appendSegment(name)
			// .appendFileExtension(UMLResource.FILE_EXTENSION));
			// return null;

		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected XmlSchema getSchema(Definition def) {
		Types types = def.getTypes();
		if (types.getExtensibilityElements().isEmpty()) {
			System.out.println("No Schema");
			return null;
		}
		XmlSchemaCollection schemaCol = new XmlSchemaCollection();
		XmlSchema schema = schemaCol.read(((Schema) types
				.getExtensibilityElements().get(0)).getElement(), null);

		System.out.println("Schema:\n");
		schema.write(System.out);
		return schema;
	}

	protected void handleServices(Definition def, Model model, String url) {
		Map services = def.getServices();// TODO
		Iterator jt = services.values().iterator();
		while (jt.hasNext()) {
			Service service = (Service) jt.next();
			System.out.println("Service: " + service.toString());
		}
	}

	protected void handlePortTypes(Definition def, XmlSchema schema,
			Model model, String url) throws Exception {
		Map ports = def.getPortTypes();
		Iterator it = ports.values().iterator();
		while (it.hasNext()) {
			PortType portType = (PortType) it.next();
			org.eclipse.uml2.uml.Interface service = processPortType(
					getPackage(model, portType.getQName()), portType, url);

			java.util.List methodsList = portType.getOperations();
			Iterator itMethods = methodsList.iterator();
			while (itMethods.hasNext()) {
				Operation op = (Operation) itMethods.next();
				processOperation(model, schema, service, op);
			}
		}
	}

	protected Interface processPortType(Package pkg, PortType type, String url)
			throws Exception {
		String name = type.getQName().getLocalPart();
		Interface service = createInterface(pkg, name, false);
		// TODO stereotypes - WebService, WebServiceClient
		// TODO SOAPBinding
		Stereotype client = applyStereotype(service,
				"javax.xml.ws.WebServiceClient");
		if (client == null) {
			throw new RuntimeException("JaxWS.profile.uml not found");
		}
		service.setValue(client, "name", name);// TODO
		service.setValue(client, "targetNamespace", type.getQName()
				.getNamespaceURI());
		service.setValue(client, "wsdlLocation", url);

		if (type.getDocumentationElement() != null) {
			service.createOwnedComment().setBody(
					type.getDocumentationElement().getNodeValue());
		}
		return service;
	}

	protected Package getPackage(Model model, QName qname) {
		String name = NamespacePackageMapping.getJavaPackageName(qname
				.getNamespaceURI());
		Package pkg = packages.get(name);
		if (pkg == null) {
			System.out.println("Namespace QName: " + qname);
			System.out.println("Converted package name: " + name);
			pkg = createPackage(model, name);
			packages.put(name, pkg);
		}
		return pkg;
	}

	private org.eclipse.uml2.uml.Operation processOperation(Model model,
			XmlSchema schema, Interface service, Operation op) {
		org.eclipse.uml2.uml.Operation operation = createOperation(service, op
				.getName());
		// TODO stereotypes

		if (op.getDocumentationElement() != null) {
			operation.createOwnedComment().setBody(
					op.getDocumentationElement().getNodeValue());
		}

		Map partsMap = op.getInput().getMessage().getParts();
		if (op.getParameterOrdering() != null) {
			// RPC style
			Iterator i = op.getParameterOrdering().iterator();
			while (i.hasNext()) {
				String name = (String) i.next();
				System.out.println("pname: " + name);
				Part part = (Part) partsMap.get(name);
				processInputPart(model, schema, operation, part);
			}
		} else {
			// DOCUMENT style
			Part part = (Part) partsMap.values().iterator().next();
			processInputPart(model, schema, operation, part);
		}

		// response parameters
		Map outputPartsMap = op.getOutput().getMessage().getParts();
		Collection outputParts = outputPartsMap.values();
		Iterator outputPartIter = outputParts.iterator();
		System.out.print("\tResponse: ");
		while (outputPartIter.hasNext()) {
			Part part = (Part) outputPartIter.next();
			processReturnPart(model, schema, operation, part);
		}
		return operation;
	}

	protected void processInputPart(Model model, XmlSchema schema,
			org.eclipse.uml2.uml.Operation operation, Part part) {
		String name = part.getName();
		out("Part: " + part.toString());
		Parameter param;
		if (schema == null) {
			out("Type QName: " + part.getTypeName());
			param = operation.createOwnedParameter(name, getPrimitiveType(
					model, getType(part.getTypeName().getLocalPart())));
		} else {
			QName partElementName = part.getElementName();
			out(part.getName() + ":" + partElementName.getLocalPart() + " , "
					+ partElementName.getNamespaceURI());
			XmlSchemaElement element = schema.getElementByName(part
					.getElementName());
			param = operation.createOwnedParameter(name, getType(model,
					element, part.getElementName()));
		}

		if (part.getDocumentationElement() != null) {
			param.createOwnedComment().setBody(
					part.getDocumentationElement().getNodeValue());
		}
	}

	protected void processReturnPart(Model model, XmlSchema schema,
			org.eclipse.uml2.uml.Operation operation, Part part) {
		String name = part.getName();
		out("Part: " + part.toString());
		Parameter param;
		if (schema == null) {
			out("Type QName: " + part.getTypeName());
			param = operation.createReturnResult(name, getPrimitiveType(model,
					getType(part.getTypeName().getLocalPart())));
		} else {
			QName partElementName = part.getElementName();
			out(part.getName() + ":" + partElementName.getLocalPart() + " , "
					+ partElementName.getNamespaceURI());
			XmlSchemaElement element = schema.getElementByName(part
					.getElementName());
			param = operation.createReturnResult(name, getType(model, element,
					part.getElementName()));
		}

		if (part.getDocumentationElement() != null) {
			param.createOwnedComment().setBody(
					part.getDocumentationElement().getNodeValue());
		}
	}

	protected Type getType(Model model, XmlSchemaElement element, QName qname) {
		String typeName = getType(qname.getLocalPart());
		if (typeName == null) {
			Package pkg = getPackage(model, qname);
			String name = qname.getLocalPart();
			//TODO Enums
			org.eclipse.uml2.uml.Class entity = (org.eclipse.uml2.uml.Class) pkg
					.getOwnedType(name);
			if (entity == null) {
				entity = createClass(pkg, name, false);
				XmlSchemaType type = element.getSchemaType();
				System.out.println("Schema Element/Type QName: "
						+ element.getQName() + " : " + type.getQName());
				if (element.getSchemaType() instanceof XmlSchemaComplexType) {
					XmlSchemaComplexType ctype = (XmlSchemaComplexType) type;
					XmlSchemaSequence seq = (XmlSchemaSequence) ctype
							.getParticle();
					XmlSchemaObjectCollection items = seq.getItems();
					Iterator i = items.getIterator();
					while (i.hasNext()) {
						XmlSchemaElement subElement = (XmlSchemaElement) i
								.next();
						XmlSchemaType stype = subElement.getSchemaType();
						
						int min = (int) subElement.getMinOccurs();
						int max = (int) subElement.getMaxOccurs();
						entity.createOwnedAttribute(subElement.getName(),
								getType(model, subElement, stype.getQName()),
								min, max);
					}
				} else {
					XmlSchemaSimpleType stype = (XmlSchemaSimpleType) type;
					entity.createOwnedAttribute(element.getName(),
							getPrimitiveType(model, getType(stype.getQName()
									.getLocalPart())), 1, 1);
				}
				return entity;
			} else {
				return entity;
			}
		} else {
			return getPrimitiveType(model, typeName);
		}
	}

	protected String getType(String type) {
		if (type.equals("string") || type.equals("byte")) {
			return "String";
		}
		if (type.equals("double") || type.equals("float")
				|| type.equals("decimal")) {
			return "Double";
		}
		if (type.equals("int") || type.equals("short") || type.equals("long")
				|| type.equals("integer")) {
			return "Long";
		}
		if (type.equals("boolean") || type.equals("Boolean")) {
			return "Boolean";
		}
		if (type.equals("dateTime")) {
			return "Date";
		}
		if (type.equals("base64Binary") || type.equals("hexBinary")) {
			return "Byte[]";
		}
		return null;
	}

	protected PrimitiveType getPrimitiveType(Package package_, String name) {
		Profile types = package_.getAppliedProfile("types");
		PrimitiveType primitiveType = (PrimitiveType) types.getOwnedType(name);
		out("Primitive type '" + primitiveType.getQualifiedName()
				+ "' imported.");
		return primitiveType;
	}
}
