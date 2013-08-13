package net.taylor.mda.generator.parse.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.parse.NameRuled.nameRuled.NameRuledSqlAsKind;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.stereotype.ColumnStereotypeHelper;
import net.taylor.mda.generator.parse.stereotype.JoinColumnStereotypeHelper;
import net.taylor.mda.generator.parse.stereotype.TableStereotypeHelper;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.condition.Operator;
import net.jeefuse.mda.annotations.view.SearchAnnotations;

public class ViewSearchHelper {

	public static boolean isSearch(Property property) {
		String stereotype = MdaStereotype.view_Search;
		// String attribute=InputAnnotations.type.toString();
		// String value=InputKind.text.toParam();
		// return EntityHelper.isStreotypeApplied(property, stereotype,
		// attribute, value);
		return StereotypeUtil.isAppliedStereotype(property, stereotype);
	}

	static public String getSearchFieldName(Property property) {
		String stereotype = MdaStereotype.view_Search;
		String attribute = SearchAnnotations.searchText.toString();
		Object value = StereotypeHelper.getValue(property, stereotype, attribute);
		if (null == value) {
			return NameHelper.uncapSafeName(property);
		}
		return (String) value;
	}

	public static boolean isSearchFieldMatchPropertyName(Property property) {
		String value = getSearchFieldName(property);
		String propertyName = NameHelper.uncapSafeName(property);
		if (null == value) {
			return true;
		}
		return propertyName.equals(value);
	}

	static public boolean hasSearchFieldTwoName(Property property) {
		String stereotype = MdaStereotype.view_Search;
		String attribute = SearchAnnotations.searchTextTwo.toString();
		String value = (String) StereotypeHelper.getValue(property, stereotype, attribute);
		if (null == value || value.trim().equals(""))
			return false;
		return true;
	}

	static public String getSearchOperator(Property property) {
		String stereotype = MdaStereotype.view_Search;
		String attribute = SearchAnnotations.operator.toString();
		EnumerationLiteral enumerationLiteral = (EnumerationLiteral) StereotypeHelper.getValue(property, stereotype,
				attribute);
		if (null != enumerationLiteral) {
			return enumerationLiteral.getName();
		}
		return null;
	}

	static public boolean isBetweenOperator(Property property) {
		String operatorStr = getSearchOperator(property);
		if (Operator.between.toParam().equalsIgnoreCase(operatorStr)) {
			return true;
		}
		return false;
	}

	static public String getSearchFieldLabel(Property property) {
		String stereotype = MdaStereotype.view_Search;
		String attribute = SearchAnnotations.searchTextLabel.toString();
		String value = (String) StereotypeHelper.getValue(property, stereotype, attribute);
		return value;
	}

	static public String getSearchFieldTwoLabel(Property property) {
		String stereotype = MdaStereotype.view_Search;
		String attribute = SearchAnnotations.searchTextTwoLabel.toString();
		String value = (String) StereotypeHelper.getValue(property, stereotype, attribute);
		return value;
	}

	static public String getSearchFieldTwoName(Property property) {
		if (hasSearchFieldTwoName(property)) {
			String stereotype = MdaStereotype.view_Search;
			String attribute = SearchAnnotations.searchTextTwo.toString();
			String value = (String) StereotypeHelper.getValue(property, stereotype, attribute);
			return value;
		}
		return null;
	}

	/**
	 * 获取所有非关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getSearchTextFieldPropertiesFromSimple(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isSearch(property)) {
				if (ViewInputHelper.isViewInputRadio(property))
					continue;
				if (ViewInputHelper.isViewInputCheckbox(property))
					continue;
				propertyList.add(property);
			}
		}
		return propertyList;
	}

	public static List<Property> getSearchRadioFieldPropertiesFromSimple(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isSearch(property)) {
				if (ViewInputHelper.isViewInputRadio(property)) {
					propertyList.add(property);
				}
			}
		}
		return propertyList;
	}

	public static List<Property> getSearchCheckboxFieldPropertiesFromSimple(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isSearch(property)) {
				if (ViewInputHelper.isViewInputCheckbox(property)) {
					propertyList.add(property);
				}
			}
		}
		return propertyList;
	}

	public static String getSearchFieldRtoCondition(Property property, String modelFieldName, String modelRTOName) {
		String operatorStr = getSearchOperator(property);
		String searchFieldName = getSearchFieldName(property);
		String searchFieldCapName = NameHelper.getCapName(searchFieldName);
		String propertyUncapSafeName = NameHelper.uncapSafeName(property);
		if (Operator.between.toParam().equalsIgnoreCase(operatorStr)) {
			String searchFieldTwoName = getSearchFieldTwoName(property);
			String searchFieldTwoCapName = NameHelper.getCapName(searchFieldTwoName);
			return "addCompareIfNotBlank(" + modelFieldName + "." + propertyUncapSafeName + ".getFieldName(), "
					+ modelRTOName + ".get" + searchFieldCapName + "()," + modelRTOName + ".get"
					+ searchFieldTwoCapName + "())";
		}
		return getSearchFieldRestrict(operatorStr) + "(" + modelFieldName + "." + propertyUncapSafeName
				+ ".getFieldName(), " + modelRTOName + ".get" + searchFieldCapName + "())";
	}

	public static String getSearchFieldRestrict(String operator) {
		if (null == operator) {
			return "addEqIfNotBlank";
		}
		Operator op = Operator.valueOfParam(operator);
		switch (op) {
		case eq:
			return "addEqIfNotBlank";
		case ne:
			return "addneIfNotBlank";
		case le:
			return "addLeIfNotBlank";
		case ge:
			return "addGeIfNotBlank";
		case gt:
			return "addGeIfNotBlank";
		case lt:
			return "addLeIfNotBlank";
		case between:
			return "addCompareIfNotBlank";
		case in:
			return "addInIfNotBlank";
		case notIn:
			return "addNotinIfNotBlank";
		case likeStart:
			return "addStartsLikeIfNotBlank";
		case likeEnd:
			return "addEndsLikeIfNotBlank";
		case likeAnywhere:
			return "addContainsLikeIfNotBlank";
		case isNull:
			return "addNull";
		case isNotNull:
			return "addNotNull";
		default:
			return "addEqIfNotBlank";
		}
	}

	public static String getSqlMapCondition(List<Property> properties,String ownerTableNameAs) {
		//List<Property> properties=getSearchTextFieldPropertiesFromSimple(clazz);
		StringBuilder sb=new StringBuilder();
		for(Property property:properties){
			String propertyUncapSafeName = NameHelper.uncapSafeName(property);
			String columnName = ColumnStereotypeHelper.getApplyColumn_name(property);
			String operator = getSearchOperator(property);
			Type propertyType = property.getType();
			String propertyTypeName = propertyType.getName();
			String compareColumnName=ownerTableNameAs+"."+columnName;
			String comparePropertyName=propertyUncapSafeName;
			if(ClassHelper.isSimple(property)){
				sb.append(getSqlMapSearchStatement(compareColumnName,comparePropertyName,propertyTypeName,operator,property));
			}else  if(ClassHelper.isOneToOne(property)||ClassHelper.isManyToOne(property)){
				Class relTargetClass = (Class) propertyType;
				// String relTargetClassCommentName=TypeHelper.getDocumentationOrName(relTargetClass);
				String relTargetClassTableName = TableStereotypeHelper.getApplyTable_name(relTargetClass);
				String relTargetClassTableNameAs = NameRuledSqlAsKind.tableAs.getRuleNamed(relTargetClassTableName);
				//for relClass id property
				Property propertyTypeIdProperty=EntityHelper.getIDProperty(relTargetClass);
				String propertyTypeIdPropertyUncapSafeName=NameHelper.uncapSafeName(propertyTypeIdProperty);
				String relJoinColumnName= JoinColumnStereotypeHelper.getApplyColumn_name(property);
				compareColumnName=ownerTableNameAs+"."+relJoinColumnName; 
				comparePropertyName=propertyUncapSafeName+"."+propertyTypeIdPropertyUncapSafeName;
				sb.append(getSqlMapSearchStatement(compareColumnName,comparePropertyName,propertyTypeName,operator,property));
				//for relClass lable property
				Property listLabelProperty=ViewListHelper.getProperty_listLabel(property);
				if(null!=listLabelProperty){
					String listLabelPropertyUncapSafeName=ViewListHelper.getViewListLabelRelPropertyName(property);
					//String listLabelPropertyComment=ViewListHelper.getViewListLabelRelPropertyName(property);
					String listLabelColumnName=ColumnStereotypeHelper.getApplyColumn_name(property);
					compareColumnName=relTargetClassTableNameAs+"."+listLabelColumnName;
					comparePropertyName=propertyUncapSafeName+"."+listLabelPropertyUncapSafeName;
					sb.append(getSqlMapSearchStatement(compareColumnName,comparePropertyName,propertyTypeName,operator,property));
				}
			}
			//String searchFieldName = getSearchFieldName(property);
			//String searchFieldCapName = NameHelper.getCapName(searchFieldName);
		}
		return sb.toString();
	}
	
	public static String getSqlMapSearchStatement(String compareColumnName,String comparePropertyName,String propertyTypeName,String operator,Property property) {
		StringBuilder sb = new StringBuilder();
		if ("Boolean".equalsIgnoreCase(propertyTypeName)) {
			sb.append("\t<isNotEmpty prepend=\"AND\" property=\"" + comparePropertyName + "\">"+"\n");
			sb.append("\t\t<![CDATA["+"\n");
			sb.append("\t\t"+compareColumnName + "=#" + comparePropertyName + "#"+"\n");
			sb.append("\t\t]]>"+"\n");
			sb.append("\t</isNotEmpty>"+"\n");
		} else if ("Date".equalsIgnoreCase(propertyTypeName)) {
			sb.append("\t<isNotEmpty prepend=\"AND\" property=\"" + comparePropertyName + "\">"+"\n");
			sb.append("\t\t<![CDATA["+"\n");
			sb.append("\t\t"+getIbatisCompareOperatorProperty(operator, compareColumnName,comparePropertyName,property)+"\n");
			sb.append("\t\t]]>"+"\n");
			sb.append("\t</isNotEmpty>"+"\n");
		} else if ("Timestamp".equalsIgnoreCase(propertyTypeName)) {
			sb.append("\t<isNotEmpty prepend=\"AND\" property=\"" + comparePropertyName + "\">"+"\n");
			sb.append("\t\t<![CDATA["+"\n");
			sb.append("\t\t"+getIbatisCompareOperatorProperty(operator, compareColumnName,comparePropertyName,property)+"\n");
			sb.append("\t\t]]>"+"\n");
			sb.append("\t</isNotEmpty>"+"\n");
		} else if ("Long".equalsIgnoreCase(propertyTypeName) || "Integer".equalsIgnoreCase(propertyTypeName)
				|| "Double".equalsIgnoreCase(propertyTypeName) || "Decimal".equalsIgnoreCase(propertyTypeName)) {
			sb.append("\t<isNotEmpty prepend=\"AND\" property=\"" + comparePropertyName + "\">"+"\n");
			sb.append("\t\t<![CDATA["+"\n");
			sb.append("\t\t"+getIbatisCompareOperatorProperty(operator,compareColumnName,comparePropertyName, property)+"\n");
			sb.append("\t\t]]>"+"\n");
			sb.append("\t</isNotEmpty>"+"\n");
		} else {
			sb.append("\t<isNotEmpty prepend=\"AND\" property=\"" + comparePropertyName + "\">"+"\n");
			sb.append("\t\t<![CDATA["+"\n");
			sb.append("\t\t"+getIbatisCompareOperatorProperty(operator,compareColumnName,comparePropertyName, property)+"\n");
			sb.append("\t\t]]>"+"\n");
			sb.append("\t</isNotEmpty>"+"\n");
		}
		return sb.toString();
	}

	private static String getIbatisCompareOperatorProperty(String operator, String columnName,String propertyName,Property property) {
		if (null == operator) {
			return columnName + " =#" + propertyName + "#";
		}
		Operator op = Operator.valueOfParam(operator);
		switch (op) {
		case eq:
			return columnName + " =#" + propertyName + "#";
		case ne:
			return columnName + " !=#" + propertyName + "#";
		case le:
			return columnName + " <=#" + propertyName + "#";
		case ge:
			return columnName + " >=#" + propertyName + "#";
		case gt:
			return columnName + " >#" + propertyName + "#";
		case lt:
			return columnName + " <#" + propertyName + "#";
		case between:
			String searchFieldName = getSearchFieldName(property);
			// String searchFieldCapName=NameHelper.getCapName(searchFieldName);
			String searchFieldTwoName = getSearchFieldTwoName(property);
			// String
			// searchFieldTwoCapName=NameHelper.getCapName(searchFieldTwoName);
			return columnName + " >" + "#" + searchFieldName + "# AND " + columnName + " <=#" + searchFieldTwoName
					+ "#";
			// return
			// "BETWEEN #"+searchFieldName+"# AND #"+searchFieldTwoName+"#" ;
		case in:
			return columnName + " IN ($" + propertyName + "$)";
		case notIn:
			return columnName + " INOT IN ($" + propertyName + "$)";
		case likeStart:
			return columnName + " LIKE '%$" + propertyName + "$'";
		case likeEnd:
			return columnName + " LIKE '$" + propertyName + "$%'";
		case likeAnywhere:
			return columnName + " LIKE '%$" + propertyName + "$%'";
		case isNull:
			return columnName + " IS NULL";
		case isNotNull:
			return columnName + " IS NOT NULL";
		default:
			return columnName + " =#" + propertyName + "#";
		}
	}

	/**
	 * 获取所有非关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getApplyViewSearchProperties(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> list = EntityHelper.getAllProperties(element);
		for (Iterator<Property> i=list.iterator(); i.hasNext();) {
			Property property =  i.next();
			if (isSearch(property))
				resultList.add(property);
		}
		return resultList;
	}

	/**
	 * 获取所有非关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getApplyViewSearchPropertiesFromSimple(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property =  i.next();
			if (isSearch(property))
				propertyList.add(property);
		}
		return propertyList;
	}

	/**
	 * 获取所有多对一关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getViewSearchPropertiesFromM2o(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		// m2o relation
		List<Property> m20List = EntityHelper.getAllManyToOneProperties(element, false);
		for (Property property : m20List) {
			if (isSearch(property)) {
				propertyList.add(property);
			}
		}
		return propertyList;
	}

	/**
	 * 获取所有多对一关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getViewSearchPropertiesFromO2o(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		// o2o relation
		List<Property> o2oList = EntityHelper.getAllOneToOneProperties(element, false);
		for (Property property : o2oList) {
			if (isSearch(property)) {
				propertyList.add(property);
			}
		}
		return propertyList;
	}
	
	public static String getSpecialResultType(Property property){
		Type propertyType = property.getType();
		String propertyTypeName = propertyType.getName();
		StringBuilder sb = new StringBuilder();
		if ("Boolean".equalsIgnoreCase(propertyTypeName)) {
			sb.append("jdbcType=\"Boolean\" javaType=\"Boolean\"");
		} else if ("Date".equalsIgnoreCase(propertyTypeName)) {
			sb.append("jdbcType=\"Date\" javaType=\"Date\"");
		} else if ("Timestamp".equalsIgnoreCase(propertyTypeName)) {
			sb.append("jdbcType=\"Timestamp\" javaType=\"Timestamp\"");
		} else if ("Long".equalsIgnoreCase(propertyTypeName) || "Integer".equalsIgnoreCase(propertyTypeName)
				|| "Double".equalsIgnoreCase(propertyTypeName) || "Decimal".equalsIgnoreCase(propertyTypeName)) {
			//sb.append("jdbcType=\"Timestamp\" javaType=\"Timestamp\"");
		} else if ("Clob".equalsIgnoreCase(propertyTypeName) ) {
			//sb.append("jdbcType=\"Timestamp\" javaType=\"Timestamp\"");
		}else {
			return "";
		}
		return sb.toString();
	}
	
}
