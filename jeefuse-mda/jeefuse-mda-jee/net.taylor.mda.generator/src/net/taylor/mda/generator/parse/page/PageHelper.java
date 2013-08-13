package net.taylor.mda.generator.parse.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.entity.Config;
import net.taylor.mda.generator.parse.page.render.ContentRender;
import net.taylor.mda.generator.parse.page.render.EnumerationRender;
import net.taylor.mda.generator.parse.page.render.FileRender;
import net.taylor.mda.generator.parse.page.render.ImageRender;
import net.taylor.mda.generator.parse.page.render.InputRender;
import net.taylor.mda.generator.parse.page.render.Render;
import net.taylor.mda.generator.util.EnumerationHelper;
import net.taylor.mda.generator.util.StereotypeHelper;
import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.hibernate.HibernateStereotype;
import net.jeefuse.mda.annotations.jpa.JpaStereotype;
import net.jeefuse.mda.annotations.view.InputAnnotations;
import net.jeefuse.mda.annotations.view.InputKind;

public class PageHelper {

	static public String getInputField(String prefix, Class uml2Class, Property property, Property parent) {
		Render render = null;
		Stereotype ste_input = StereotypeHelper.getStereotype(property, MdaStereotype.view_Input);
		String inputType = (String) property.getValue(ste_input, InputAnnotations.type.toString());
		if (TypeHelper.isDate(property)) {
			// render = new DateTagRender(prefix, uml2Class, property, parent);
		} else if (inputType.equalsIgnoreCase(InputKind.file.toParam())) {
			render = new FileRender(prefix, uml2Class, property, parent);
		} else if (inputType.equalsIgnoreCase(InputKind.image.toParam())) {
			render = new ImageRender(prefix, uml2Class, property, parent);
		} else if (inputType.equalsIgnoreCase(InputKind.content.toParam())) {
			render = new ContentRender(prefix, uml2Class, property, parent);
		} else if (EnumerationHelper.isEnumeration(property)) {
			render = new EnumerationRender(prefix, uml2Class, property, parent);
		} else {
			render = new InputRender(prefix, uml2Class, property, parent);
		}
		return render.render();
	}

	static public String getJqueryValidate(Property property) {
		List<String> list = new ArrayList<String>();
		if (TypeHelper.isDecimal(property) || TypeHelper.isDouble(property.getType())) {
			list.add("number:true");
		}
		if (TypeHelper.isInteger(property) || TypeHelper.isLong(property.getType())) {
			list.add("digits:true");
		}
		if (isRequired(property)) {
			list.add("required:true");
		}

		// add minLength
		int minLength = 0;
		if (StereotypeHelper.isStereotypeApplied(property, HibernateStereotype.validator_Length)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, HibernateStereotype.validator_Length);
			minLength = (Integer) property.getValue(stereotype, "min");
		} else if (StereotypeHelper.isStereotypeApplied(property, JpaStereotype.validate_size)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, JpaStereotype.validate_size);
			minLength = (Integer) property.getValue(stereotype, "min");
		} else if (StereotypeHelper.isStereotypeApplied(property, JpaStereotype.validate_min)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, JpaStereotype.validate_min);
			minLength = (Integer) property.getValue(stereotype, "value");
		}
		if (minLength != 0) {
			list.add("minlength:" + minLength);
		}
		// add maxlength
		int maxlength = maxLength(property);
		if (maxlength != 0) {
			list.add("maxlength:" + maxlength);
		}
		// min
		int min = 0;
		if (StereotypeHelper.isStereotypeApplied(property, JpaStereotype.validate_min)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, JpaStereotype.validate_min);
			min = (Integer) property.getValue(stereotype, "value");
		} else if (StereotypeHelper.isStereotypeApplied(property, HibernateStereotype.validator_Min)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, HibernateStereotype.validator_Min);
			min = (Integer) property.getValue(stereotype, "value");
		}
		if (min != 0) {
			list.add("min:" + min);
		}
		// max
		int max = 0;
		if (StereotypeHelper.isStereotypeApplied(property, JpaStereotype.validate_max)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, JpaStereotype.validate_max);
			max = (Integer) property.getValue(stereotype, "value");
		} else if (StereotypeHelper.isStereotypeApplied(property, HibernateStereotype.validator_Max)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, HibernateStereotype.validator_Max);
			max = (Integer) property.getValue(stereotype, "value");
		}
		if (max != 0) {
			list.add("max:" + max);
		}
		// validaterule
		String validateRule = (String) StereotypeHelper.getValue(property, MdaStereotype.view_Input,
				InputAnnotations.validateRule.toString());
		if (null != validateRule && !validateRule.trim().equals("")) {
			list.add(validateRule);
		}
		// date
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_DateCN)
				|| TypeHelper.isDate(property)) {
			list.add("dateCN:true");
		}
		// email:true
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_email)||StereotypeHelper.isStereotypeApplied(property, HibernateStereotype.validator_Email)) {
			list.add("email:true");
		}
		// idCardNo:true
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_IdCardNo)) {
			list.add("idCardNo:true");
		}
		// letterNum
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_letterNum)) {
			list.add("letterNum:true");
		}
		// mobile:true
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_Mobile)) {
			list.add("mobile:true");
		}
		// mobile:true
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_Phone)) {
			list.add("phone:true");
		}

		// tel
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_Tel)) {
			list.add("tel:true");
		}

		// url:true
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_Url)) {
			list.add("url:true");
		}
		// zipCode:true
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_ZipCode)) {
			list.add("zipCode:true");
		}
		// String email=(String)
		// to string
		if (list.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Iterator<String> i = list.iterator(); i.hasNext();) {
				sb.append(i.next());
				if (i.hasNext())
					sb.append(",");
			}
			return sb.toString();
		}
		return null;
	}

	static public String getJqueryValidateForSearch(Property property) {
		List<String> list = new ArrayList<String>();
		if (TypeHelper.isDecimal(property) || TypeHelper.isDouble(property.getType())) {
			list.add("number:true");
		}
		if (TypeHelper.isInteger(property) || TypeHelper.isLong(property.getType())) {
			list.add("digits:true");
		}
		// min
		int min = 0;
		if (StereotypeHelper.isStereotypeApplied(property, JpaStereotype.validate_min)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, JpaStereotype.validate_min);
			min = (Integer) property.getValue(stereotype, "value");
		} else if (StereotypeHelper.isStereotypeApplied(property, HibernateStereotype.validator_Min)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, HibernateStereotype.validator_Min);
			min = (Integer) property.getValue(stereotype, "value");
		}
		if (min != 0) {
			list.add("min:" + min);
		}
		// max
		int max = 0;
		if (StereotypeHelper.isStereotypeApplied(property, JpaStereotype.validate_max)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, JpaStereotype.validate_max);
			max = (Integer) property.getValue(stereotype, "value");
		} else if (StereotypeHelper.isStereotypeApplied(property, HibernateStereotype.validator_Max)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, HibernateStereotype.validator_Max);
			max = (Integer) property.getValue(stereotype, "value");
		}
		if (max != 0) {
			list.add("max:" + max);
		}
		// date
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_DateCN)
				|| TypeHelper.isDate(property)) {
			list.add("dateCN:true");
		}
		// letterNum
		if (StereotypeHelper.isStereotypeApplied(property, MdaStereotype.validate_letterNum)) {
			list.add("letterNum:true");
		}
		// String email=(String)
		// to string
		if (list.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Iterator<String> i = list.iterator(); i.hasNext();) {
				sb.append(i.next());
				if (i.hasNext())
					sb.append(",");
			}
			return sb.toString();
		}
		return null;
	}

	static public String getType(Property property) {
		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.ID)) {
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
		} else if (TypeHelper.isDecimal(property) || TypeHelper.isDouble(property.getType())) {
			return "Decimal";
		} else if (TypeHelper.isInteger(property) || TypeHelper.isLong(property.getType())) {
			return "Integer";
		} else if (EnumerationHelper.isEnumeration(property)) {
			return "Enum";
		} else if (TypeHelper.isBlob(property.getType())) {
			return "Blob";
		} else {
			return "String";
		}
	}

	static public boolean isRequired(Property property) {
		if (null == property)
			return false;
		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.NOT_NULL)) {
			return true;
		} else if (StereotypeHelper.isStereotypeApplied(property, "net.taylor.validator.Required")) {
			return true;
		} else if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.LENGTH)) {
			Object min = StereotypeHelper.getValue(property, StereotypeHelper.LENGTH, "min");
			if (min instanceof Number) {
				if (((Number) (min)).intValue() > 0) {
					return true;
				}
			}
		} else if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.COLUMN)) {
			Object nullable = StereotypeHelper.getValue(property, StereotypeHelper.COLUMN, "nullable");
			if (nullable instanceof Boolean) {
				if (((Boolean) (nullable)).equals(Boolean.FALSE)) {
					return true;
				}
			}
		} else if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.JONINCOLUMN)) {
			Object nullable = StereotypeHelper.getValue(property, StereotypeHelper.JONINCOLUMN, "nullable");
			if (nullable instanceof Boolean) {
				if (((Boolean) (nullable)).equals(Boolean.FALSE)) {
					return true;
				}
			}
		}

		return false;
	}

	protected static int maxLength(Property property) {
		if (StereotypeHelper.isStereotypeApplied(property, HibernateStereotype.validator_Length)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, HibernateStereotype.validator_Length);
			return (Integer) property.getValue(stereotype, "max");
		} else if (StereotypeHelper.isStereotypeApplied(property, JpaStereotype.validate_size)) {
			Stereotype stereotype = StereotypeHelper.getStereotype(property, JpaStereotype.validate_size);
			return (Integer) property.getValue(stereotype, "max");
		} else {
			if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.COLUMN)) {
				return (Integer) StereotypeHelper.getValue(property, StereotypeHelper.COLUMN, "length");
			}
			if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.LENGTH)) {
				return (Integer) StereotypeHelper.getValue(property, StereotypeHelper.LENGTH, "max");
			}
		}
		return 0;
	}

	static public String isReadOnly(Property property) {
		if (property.isReadOnly()) {
			return "true";
		}
		return "false";
	}

	static public String isDisabled(Property property) {
		if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.GENERATED_VALUE)
				|| StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.VERSION)) {
			return "true";
		} else if (property.isReadOnly()) {
			return "true";
		} else {
			return "false";
		}
	}

	public static boolean isStereotypeAppliedEnumeration(Property property) {
		return EnumerationHelper.isEnumeration(property);
	}

	public static int getMaxLength(Property property) {
		if (null == property)
			return 0;
		try {
			if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.COLUMN)) {
				return Integer.parseInt(StereotypeHelper.getValue(property, StereotypeHelper.COLUMN, "length")
						.toString());
			}
			if (StereotypeHelper.isStereotypeApplied(property, StereotypeHelper.LENGTH)) {
				return Integer.parseInt(StereotypeHelper.getValue(property, StereotypeHelper.LENGTH, "max").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Config.defaultPropertyGridLength;
	}

	public static int getMaxPixel(Property property) {
		if (TypeHelper.isDate(property)) {
			return Config.defaultDateGridPixed;
		}
		return getMaxPixel(getMaxLength(property));
	}

	public static int getMaxPixel(int maxLength) {
		int maxPixed = Config.defaultPropertyGridPixelScale * maxLength + Config.offsetGridPixel;
		if (maxPixed > Config.defaultContentPropertyLength_min) {
			maxPixed = Config.defaultContentPropertyLength_min;
		}
		if (maxPixed < Config.defaultMinPropertyGridPixed) {
			maxPixed = Config.defaultMinPropertyGridPixed;
		}
		return maxPixed;
	}

	public static int getWinWidth(Class uml2Class) {
		List<Property> propertyList = new ArrayList<Property>();
		List<Property> simpleList = ViewInputHelper.getViewInputPropertiesForSimple(uml2Class);
		// List<Property>
		// o2mTabsList=ViewInputHelper.getViewInputRelCheckboxsTabsO2m(uml2Class);
		propertyList.addAll(simpleList);
		// propertyList.addAll(o2mTabsList);
		int count = propertyList.size();
		if (count < 6) {
			return 560;
		} else {
			return 650;
		}
	}

	public static int getWinHeight(Class uml2Class) {
		List<Property> propertyList = new ArrayList<Property>();
		List<Property> simpleList = ViewInputHelper.getViewInputPropertiesForSimple(uml2Class);
		// List<Property>
		// o2mTabsList=ViewInputHelper.getViewInputRelCheckboxsTabsO2m(uml2Class);
		propertyList.addAll(simpleList);
		// propertyList.addAll(o2mTabsList);
		/****** rel property ********/
		List<Property> M2MCheckboxsList = ViewInputHelper.getApplyM2MCheckboxs(uml2Class);
		List<Property> M2MCheckboxsTreeList = ViewInputHelper.getApplyM2MCheckboxsTree(uml2Class);
		// List<Property>
		// M2MCheckboxsTabList=ViewInputHelper.getApplyM2MCheckboxsTab(uml2Class);
		// List<Property>
		// M2MCheckboxsTreeTabList=ViewInputHelper.getApplyM2MCheckboxsTreeTab(uml2Class);

		List<Property> M2OSelectList = ViewInputHelper.getApplyM2OSelect(uml2Class);
		List<Property> M2OSelectPageList = ViewInputHelper.getApplyM2OSelectPage(uml2Class);

		List<Property> O2OSelectList = ViewInputHelper.getApplyO2OSelect(uml2Class);
		List<Property> O2OSelectPageList = ViewInputHelper.getApplyO2OSelectPage(uml2Class);

		// List<Property>
		// O2MManagerPageList=ViewInputHelper.getApplyO2MManagerPage(uml2Class);

		if (O2OSelectPageList.size() > 0 || M2OSelectPageList.size() > 0 || M2MCheckboxsTreeList.size() > 0
				|| M2MCheckboxsList.size() > 0)
			return 510;
		propertyList.addAll(M2OSelectList);
		propertyList.addAll(O2OSelectList);

		int count = propertyList.size();
		if (count < 3) {
			return 280;
		} else if (count < 5) {
			return 350;
		} else if (count < 8) {
			return 430;
		} else {
			return 510;
		}
	}
}
