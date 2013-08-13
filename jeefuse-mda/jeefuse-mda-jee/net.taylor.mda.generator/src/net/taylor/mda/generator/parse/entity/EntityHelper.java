package net.taylor.mda.generator.parse.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.ImportHelper;
import net.taylor.mda.generator.util.StereotypeHelper;
import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.hibernate.HibernateStereotype;

public class EntityHelper {

	/**
	 * 获取实体类中主键ID的属性.
	 * 
	 */
	public static Property getIDProperty(org.eclipse.uml2.uml.Class uml2Class) {
		for (Iterator<?> i = uml2Class.getAttributes().iterator(); i.hasNext();) {
			Property property = (Property) i.next();
			if (isIDProperty(property))
				return property;
		}
		return null;
	}

	public static boolean isIDProperty(Property property) {
		return StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.ID);
	}

	public static boolean hasIDProperty(org.eclipse.uml2.uml.Class uml2Class) {
		return null == getIDProperty(uml2Class) ? false : true;
	}

	public static boolean hasIdAssign(Class uml2Class) {
		Property property = getIDProperty(uml2Class);
		if (null == property)
			return false;
		if (isIDAssign(property)) {
			return true;
		}
		return false;
	}

	/**
	 * 是否ID生成策略为自动生成.
	 * 
	 * @param uml2Class
	 * @return
	 */
	public static boolean isIDAuto(Property property) {
		if (null == property)
			return false;
		String stereotype = HibernateStereotype.GenericGenerator;
		String attribute = "strategy";
		String value = "AUTO";
		if(StereotypeUtil.isAppliedValueMatch(property, stereotype, attribute, value)){
			return true;
		}else if(!(isIDUUID(property)||isIDAssign(property))){
			return true;
		}
		return false;
	}

	/**
	 * 是否ID生成策略为uuid.
	 */
	public static boolean isIDUUID(Property property) {
		if (null == property)
			return false;
		String stereotype = HibernateStereotype.GenericGenerator;
		String attribute = "strategy";
		String value = "uuid";
		return StereotypeUtil.isAppliedValueMatch(property, stereotype, attribute, value);
	}

	/**
	 * 是否ID生成策略为assign.
	 */
	public static boolean isIDAssign(Property property) {
		if (null == property)
			return false;
		String stereotype = HibernateStereotype.GenericGenerator;
		String attribute = "strategy";
		String value = "assigned";
		return StereotypeUtil.isAppliedValueMatch(property, stereotype, attribute, value);

	}

	public static String getIDPropertyImportType(org.eclipse.uml2.uml.Class uml2Class) {
		Property property = getIDProperty(uml2Class);
		if (null != property) {
			return TypeHelper.getImportedType(property.getType());
		}
		return "String";
	}
	
	public static boolean hasParentIdProperty(org.eclipse.uml2.uml.Class uml2Class) {
		List<Property> allSimpleProperties=getAllSimpleProperties(uml2Class);
		for(Property property:allSimpleProperties){
			if(property.getName().equalsIgnoreCase("parentId"))
				return true;
		}
		return false;
	}

	/**
	 * 获取实体类中除主键ID的所属属性,不包括继承.
	 */
	public static List<Property> getOwnAllPropertyExcluedIdProperty(org.eclipse.uml2.uml.Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		// for (Iterator<?> i = uml2Class.getAttributes().iterator();
		// i.hasNext();) {
		// Property property = (Property) i.next();
		List<Property> properties = getOwnedProperties(uml2Class);
		for (Property property : properties) {
			if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.ID))
				continue;
			resultList.add(property);
		}
		return resultList;
	}

	/**
	 * 获取实体类中除主键ID的所属属性,包括继承.
	 * 
	 */
	public static List<Property> getAllPropertyExcluedIdProperty(org.eclipse.uml2.uml.Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		// for (Iterator<?> i = uml2Class.getAttributes().iterator();
		// i.hasNext();) {
		// Property property = (Property) i.next();
		List<Property> propertyList = new ArrayList<Property>();
		getAllProperties(uml2Class, propertyList);
		for (Property property : propertyList) {
			if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.ID))
				continue;
			resultList.add(property);
		}
		return resultList;
	}



	public static List<Property> getOwnedProperties(org.eclipse.uml2.uml.Class uml2Class, List<Property> list) {
		for (Iterator<Property> i = uml2Class.getOwnedAttributes().iterator(); i.hasNext();) {
			Property property = i.next();
			list.add(property);
		}
		return list;
	}

	public static List<Property> getOwnedProperties(org.eclipse.uml2.uml.Class uml2Class) {
		List<Property> resulList = new ArrayList<Property>();
		return getOwnedProperties(uml2Class, resulList);
	}

	public static List<Property> getAllProperties(org.eclipse.uml2.uml.Class uml2Class, List<Property> list) {
		List<Class> supers = uml2Class.getSuperClasses();
		for (Class parent : supers) {
			getAllProperties(parent, list);
		}
		getOwnedProperties(uml2Class, list);
		return list;
	}

	static public List<Property> getAllSimpleProperties(Class element) {
		return getAllSimplePropertiesList(element, new ArrayList<Property>());
	}

	static public List<Property> getAllSimplePropertiesList(Class element, List<Property> list) {
		List<Class> supers = element.getSuperClasses();
		for (Class parent : supers) {
			getAllSimplePropertiesList(parent, list);
		}
		getOwnedSimpleProperties(element, list);
		return list;
	}

	static public List<Property> getOwnedSimpleProperties(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		return getOwnedSimpleProperties(element, resultList);
	}

	static public List<Property> getOwnedSimpleProperties(Class element, List<Property> list) {
		Iterator<Property> i = element.getOwnedAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (ClassHelper.isSimple(p)) {
				list.add(p);
			}
		}
		return list;
	}
	


	public static List<Property> getAllProperties(org.eclipse.uml2.uml.Class uml2Class) {
		List<Property> list = new ArrayList<Property>();
		return getAllProperties(uml2Class, list);
	}

	public static boolean hasSimpleProperty(org.eclipse.uml2.uml.Class uml2Class) {
		Iterator<Property> ite = ClassHelper.getAllSimpleProperties(uml2Class);
		if (ite.hasNext())
			return true;
		else
			return false;
	}

	public static boolean isM2MAssociationClass(org.eclipse.uml2.uml.Class uml2Class) {
		int count=uml2Class.getAllAttributes().size();
		if(count==2||count==3){
			List<Property> simpleList = new ArrayList<Property>();
			simpleList = ClassHelper.getAllSimplePropertiesList(uml2Class, simpleList);
			if (null == simpleList || simpleList.size() == 0) {
				return true;
			}
			if(simpleList.size()==1&&StereotypeHelper.isStereotypeApplied(simpleList.get(0), StereotypeHelper.ID)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取所有应用了stereotype 的属性.
	 */
	public static List<Property> getAllSimplePropertiesByStereotype(Class element, String stereotyleNames) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property p = (Property) i.next();
			if (isStereotypeApplied(p, stereotyleNames))
				propertyList.add(p);
		}
		return propertyList;
	}

	/**
	 * 获取所有应用了stereotype 的属性.
	 */
	public static List<Property> getAllSimplePropertiesByStereotype(Class element, String stereotyleName,
			String propertyName, boolean propertyValue) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property p = (Property) i.next();
			if (StereotypeHelper.isStereotypeApplied(p, stereotyleName)) {
				Stereotype stereotype = StereotypeHelper.getStereotype(p, stereotyleName);
				boolean v = (Boolean) p.getValue(stereotype, propertyName);
				if (v == propertyValue) {
					propertyList.add(p);
				}
			}
		}
		return propertyList;
	}

	/**
	 * 获取所有应用了stereotype 的属性.
	 */
	public static List<Property> getAllSimplePropertiesByStereotype(Class element, String stereotyleName,
			String propertyName, String propertyValue) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property p = (Property) i.next();
			if (StereotypeHelper.isStereotypeApplied(p, stereotyleName)) {
				Stereotype stereotype = StereotypeHelper.getStereotype(p, stereotyleName);
				String v = (String) p.getValue(stereotype, propertyName);
				if (v.equals(propertyValue)) {
					propertyList.add(p);
				}
			}
		}
		return propertyList;
	}

	/**
	 * 类中的属性是否应用的定型.
	 */
	public static boolean hasPropertiesApply(Class entity, String streotype) {
		EList<Property> list = entity.getAllAttributes();
		for (Property property : list) {
			if (StereotypeHelper.isStereotypeApplied(property, streotype)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 类中的属性是否应用的定型.且其属性与给定的值相等.
	 */
	public static boolean hasPropertiesValueApply(Class entity, String stereotype, String stereotypeProperty,
			String value) {
		EList<Property> list = entity.getAllAttributes();
		for (Property property : list) {
			if (StereotypeHelper.isStereotypeApplied(property, stereotype)) {
				Stereotype ste = StereotypeHelper.getStereotype(property, stereotype);
				Object steValue = property.getValue(ste, stereotypeProperty);
				if (null == steValue)
					return false;
				if (steValue instanceof EnumerationLiteral) {
					EnumerationLiteral enumerationLiteral = (EnumerationLiteral) steValue;
					if (null != enumerationLiteral) {
						return value.equalsIgnoreCase(steValue.toString());
					}
				}
				if (value.equalsIgnoreCase(steValue.toString()))
					return true;
			}
		}
		return false;
	}

	/**
	 * 是否有应用指定的stereotype.多个stereotype只需匹配一个既可.
	 */
	public static boolean isStereotypeApplied(NamedElement element, String... stereoNames) {
		for (String name : stereoNames) {
			if (StereotypeHelper.isStereotypeApplied(element, name))
				return true;
		}
		return false;
	}

	/**
	 * 是否有应用所有指定的stereotype.多个stereotype需全部匹配.
	 */
	public static boolean isStereotypeAppliedAll(NamedElement element, String... stereoNames) {
		for (String name : stereoNames) {
			if (!StereotypeHelper.isStereotypeApplied(element, name))
				return false;
		}
		return true;
	}

	/**
	 * 返回应用了指定版型的属性例表.
	 * 
	 * @return
	 */
	public static List<Property> getStreotypeApplied(List<Property> propertyList, String stereotype) {
		List<Property> resultList = new ArrayList<Property>();
		for (Property property : propertyList) {
			if (StereotypeUtil.isAppliedStereotype(property, stereotype)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/**
	 * 返回应用了指定版型且其属性的值与给定的值相等的属性例表.
	 * 
	 * @return
	 */
	public static List<Property> getStreotypeApplied(List<Property> propertyList, String stereotype, String attribute,
			String value) {
		List<Property> resultList = new ArrayList<Property>();
		for (Property property : propertyList) {
			if (StereotypeUtil.isAppliedValueMatch(property, stereotype, attribute, value)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/**
	 * 获取所有多对一关联属性与应用了MdaStereotype.property_ManageByProperty的属性.
	 */
	static public List<Property> getAllManyToOnePropertiesAndApplyManageByProperty(Class element, boolean withImport){
		List<Property> list = new ArrayList<Property>();
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (ClassHelper.isManyToOne(p)) {
				if (withImport) {
					if (p.getType() == null) {
						throw new RuntimeException("No Type assigned for: " + p);
					}
					ImportHelper.addImport(p.getType());
				}
				list.add(p);
			}else if(StereotypeHelper.isStereotypeApplied(p, MdaStereotype.property_ManageByProperty)){
				list.add(p);
			}
		}
		return list;
	}
	
	static public List<Property> getAllManyToOneProperties(Class element, boolean withImport) {
		List<Property> list = new ArrayList<Property>();
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (ClassHelper.isManyToOne(p)) {
				if (withImport) {
					if (p.getType() == null) {
						throw new RuntimeException("No Type assigned for: " + p);
					}
					ImportHelper.addImport(p.getType());
				}
				list.add(p);
			}
		}
		return list;
	}

	static public List<Property> getAllManyToManyProperties(Class element, boolean withImport) {
		List<Property> list = new ArrayList<Property>();
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (ClassHelper.isManyToMany(p)) {
				if (withImport) {
					if (p.getType() == null) {
						throw new RuntimeException("No Type assigned for: " + p);
					}
					ImportHelper.addImport(p.getType());
				}
				list.add(p);
			}
		}
		return list;
	}

	static public List<Property> getAllOneToManyProperties(Class element, boolean withImport) {
		List<Property> list = new ArrayList<Property>();
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (ClassHelper.isOneToMany(p)) {
				if (withImport) {
					if (p.getType() == null) {
						throw new RuntimeException("No Type assigned for: " + p);
					}
					ImportHelper.addImport(p.getType());
				}
				list.add(p);
			}
		}
		return list;
	}

	static public List<Property> getAllOneToOneProperties(Class element, boolean withImport) {
		List<Property> list = new ArrayList<Property>();
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property p = (Property) i.next();
			if (ClassHelper.isOneToOne(p)) {
				if (withImport) {
					if (p.getType() == null) {
						throw new RuntimeException("No Type assigned for: " + p);
					}
					ImportHelper.addImport(p.getType());
				}
				list.add(p);
			}
		}
		return list;
	}
	
	static public List<Property> getAllRelProperties(Class element, boolean withImport) {
		List<Property> list = new ArrayList<Property>();
		Iterator<Property> i = element.getAllAttributes().iterator();
		while (i.hasNext()) {
			Property property = (Property) i.next();
			if (ClassHelper.isOneToOne(property)||ClassHelper.isOneToMany(property)||ClassHelper.isManyToOne(property)||ClassHelper.isManyToMany(property)) {
				if (withImport) {
					if (property.getType() == null) {
						throw new RuntimeException("No Type assigned for: " + property);
					}
					ImportHelper.addImport(property.getType());
				}
				list.add(property);
			}
		}
		return list;
	}


}
