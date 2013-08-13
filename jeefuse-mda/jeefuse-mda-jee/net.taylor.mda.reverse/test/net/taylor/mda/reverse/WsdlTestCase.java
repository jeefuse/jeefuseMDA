package net.taylor.mda.reverse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.Types;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import junit.framework.TestCase;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaComplexType;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaObjectCollection;
import org.apache.ws.commons.schema.XmlSchemaSequence;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.apache.ws.commons.schema.XmlSchemaType;

public class WsdlTestCase extends TestCase {

	static final String LINE = "------------------------------------------";

	public WsdlTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testReadWsdl() throws Exception {
		WSDLFactory wsdlfactory = WSDLFactory.newInstance();
		WSDLReader reader = wsdlfactory.newWSDLReader();
//		 Definition def =
//		 reader.readWSDL("http://JGILBERTXP:8080/payment-ws/PaymentWSBean?wsdl");
		Definition def = reader
				.readWSDL("http://JGILBERTXP:8080/payment-ws/TestWSBean?wsdl");

		System.out.println(LINE);
		XmlSchema schema = getSchema(def);

//		System.out.println(LINE);
//		Iterator values = schema.getElements().getValues();
//		while (values.hasNext()) {
//			XmlSchemaElement elt = (XmlSchemaElement) values.next();
//			System.out.println(elt.getName());
//			XmlSchemaType schemaType = elt.getSchemaType();
//			System.out.println(schemaType.getName());
//		}

		System.out.println(LINE);
		Map services = def.getServices();// TODO
		Iterator jt = services.values().iterator();
		while (jt.hasNext()) {
			Service service = (Service) jt.next();
			System.out.println(service.toString());
		}

		Map ports = def.getPortTypes();
		Iterator it = ports.values().iterator();
		while (it.hasNext()) {
			System.out.println(LINE);
			PortType type = (PortType) it.next();
			System.out.println(type.toString());

			java.util.List methodsList = type.getOperations();
			Iterator itMethods = methodsList.iterator();
			while (itMethods.hasNext()) {
				System.out.println(LINE);
				Operation op = (Operation) itMethods.next();
				System.out.println(op.toString());

				Iterator inputPartIter = op.getInput().getMessage().getParts()
						.values().iterator();
				System.out.print("Request: ");
				while (inputPartIter.hasNext()) {
					System.out.println(LINE);
					Part part = (Part) inputPartIter.next();
					printPart(schema, part);
				}

				Iterator outputPartIter = op.getOutput().getMessage()
						.getParts().values().iterator();
				System.out.print("Response: ");
				while (outputPartIter.hasNext()) {
					System.out.println(LINE);
					Part part = (Part) outputPartIter.next();
					printPart(schema, part);
				}
			}
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

	
	private void printPart(XmlSchema schema, Part part) {
		System.out.println(part.toString());
		if (schema == null) {
			System.out.println("Type QName: " + part.getTypeName());
		} else {
			System.out.println("Element QName: " + part.getElementName());
			System.out.println("Element: "
					+ schema.getElementByName(part.getElementName()));
			printSchemaElement(schema.getElementByName(part.getElementName()), "\t");

			System.out.println("Type QName: " + part.getTypeName());
			System.out.println("Type: " + schema.getTypeByName(part.getTypeName()));
		}
	}

	Set<XmlSchemaElement> elements = new HashSet<XmlSchemaElement>();

	private void printSchemaElement(XmlSchemaElement element, String tab) {
		if (elements.contains(element)) {
			return;
		}
		elements.add(element);

		XmlSchemaType type = element.getSchemaType();
		System.out.println(tab + "Schema Element/Type QName: "
				+ element.getQName() + " : " + type.getQName());
		if (element.getSchemaType() instanceof XmlSchemaComplexType) {
			XmlSchemaComplexType ctype = (XmlSchemaComplexType) type;
			XmlSchemaSequence seq = (XmlSchemaSequence) ctype.getParticle();
			XmlSchemaObjectCollection items = seq.getItems();
			Iterator i = items.getIterator();
			while (i.hasNext()) {
				XmlSchemaElement subElement = (XmlSchemaElement) i.next();
				printSchemaElement(subElement, tab + "\t");
			}
		} else {
			XmlSchemaSimpleType stype = (XmlSchemaSimpleType) type;
		}
	}
}
