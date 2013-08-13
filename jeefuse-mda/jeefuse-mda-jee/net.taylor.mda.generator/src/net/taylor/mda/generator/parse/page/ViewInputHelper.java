package net.taylor.mda.generator.parse.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.parse.UmlHelper;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.stereotype.FileStereotypeHelper;
import net.taylor.mda.generator.parse.stereotype.RelStereotypeModel;
import net.taylor.mda.generator.parse.stereotype.TreeStereotypeHelper;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.view.InputAnnotations;
import net.jeefuse.mda.annotations.view.InputKind;

/**
 * view input define.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ViewInputHelper {

	/******* input **********/
	public static boolean isViewInput(Property property) {
		String stereotype = MdaStereotype.view_Input;
		return StereotypeUtil.isAppliedStereotype(property, stereotype);
	}

	/*****************************************************************
	 * input simple define /
	 *****************************************************************/

	public static boolean isViewInput_readonly(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.readonly.toString();
		String value = "true";
		return StereotypeUtil.isAppliedValueMatch(property, stereotype, attribute, value);
	}

	/**
	 * 获取所有非关联且应用了view_Input版型的属性例表.
	 * 
	 */
	public static List<Property> getViewInputPropertiesForSimple(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isViewInput(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******* input text **********/
	public static boolean isViewInputText(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.text.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputText(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputText(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** input title ***************/
	public static boolean isViewInputTitle(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.title.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputTitle(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputTitle(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** input texttarea *******/
	public static boolean isViewInputTextarea(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.textarea.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputTextarea(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputTextarea(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******* input select *************/
	public static boolean isViewInputSelect(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.select.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputSelect(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputSelect(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******* input checkbox *************/
	public static boolean isViewInputCheckbox(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.checkbox.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputCheckbox(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputCheckbox(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/************ input radio *************/
	public static boolean isViewInputRadio(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.radio.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputRadio(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputRadio(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** input file ********/
	public static boolean isViewInputFile(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.file.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputFile(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputFile(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******* input image *******/
	public static boolean isViewInputImage(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.image.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputImage(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputImage(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/************ input content **********/
	public static boolean isViewInputContent(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.content.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static boolean isViewInputContentTab(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.contenttab.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputContent(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputContent(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	public static List<Property> getViewInputContentTab(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputContentTab(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	public static List<Property> getViewInputContentOrContentTab(Class element) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(element);
		for (Property property : propertyList) {
			if (isViewInputContent(property)||isViewInputContentTab(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}
	/********* input datePicker *********/
	public static boolean isViewInputDatePicker(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.type.toString();
		String value = InputKind.datePicker.toParam();
		return StereotypeUtil.isAppliedValueMatchForEnum(property, stereotype, attribute, value);
	}

	public static List<Property> getViewInputDatePicker(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = getViewInputPropertiesForSimple(uml2Class);
		for (Property property : propertyList) {
			if (isViewInputDatePicker(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/*****************************************************************
	 * input relation define /
	 *****************************************************************/

	/**
	 * 获取关联目标类和关联
	 * 
	 * @param model
	 * @param targetClassName
	 * @param relMediateClassName
	 */
	public List<RelStereotypeModel> populateRelStereotypeModel(org.eclipse.uml2.uml.Package model,
			String targetClassName, String relMediateClassName) {
		if (null != targetClassName && !targetClassName.trim().equals("")) {
			String[] splitTargetClassNames = targetClassName.split(",");
			String[] splitRelMediateClassNames = null;
			if (null != relMediateClassName && !relMediateClassName.trim().equals("")) {
				splitRelMediateClassNames = relMediateClassName.split(",");
			}
			List<RelStereotypeModel> list = new ArrayList<RelStereotypeModel>();
			for (int i = 0; i < splitTargetClassNames.length; i++) {
				if (null != splitTargetClassNames[i] && !splitTargetClassNames[i].trim().equals("")) {
					// targetClass
					RelStereotypeModel relStereotypeModel = new RelStereotypeModel();
					Class targetClass = (Class) UmlHelper.getClassElement(model, splitTargetClassNames[i]);
					relStereotypeModel.setTargetClass(targetClass);
					// relMediateClass
					if (null != splitRelMediateClassNames && i <= splitRelMediateClassNames.length) {
						Class relMediateClass = (Class) UmlHelper.getClassElement(model, splitRelMediateClassNames[i]);
						relStereotypeModel.setRelMediateClass(relMediateClass);
					}
					list.add(relStereotypeModel);
				}
			}
			return list;
		}
		return null;
	}

	/******** M2MCheckboxs ********/
	public static boolean isApplyM2MCheckboxs(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2MCheckboxs);
	}

	public static List<Property> getApplyM2MCheckboxs(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2MCheckboxs(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** M2MCheckboxsTree ********/
	public static boolean isApplyM2MCheckboxsTree(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2MCheckboxsTree);
	}

	public static List<Property> getApplyM2MCheckboxsTree(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2MCheckboxsTree(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** M2MCheckboxsPage ********/
	public static boolean isApplyM2MCheckboxsPage(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2MCheckboxsPage);
	}

	public static List<Property> getApplyM2MCheckboxsPage(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2MCheckboxsPage(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** M2MCheckboxsTreePage ********/
	public static boolean isApplyM2MCheckboxsTreePage(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2MCheckboxsTreePage);
	}

	public static List<Property> getApplyM2MCheckboxsTreePage(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2MCheckboxsTreePage(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** M2MCheckboxsTab ********/
	public static boolean isApplyM2MCheckboxsTab(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2MCheckboxsTab);
	}

	public static List<Property> getApplyM2MCheckboxsTab(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2MCheckboxsTab(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** M2MCheckboxsTreeTab ********/
	public static boolean isApplyM2MCheckboxsTreeTab(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2MCheckboxsTreeTab);
	}

	public static List<Property> getApplyM2MCheckboxsTreeTab(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2MCheckboxsTreeTab(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** O2MManagerPage ********/
	public static boolean isApplyO2MManagerPage(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.O2MManagerPage);
	}

	public static List<Property> getApplyO2MManagerPage(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyO2MManagerPage(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** O2OSelect ********/
	public static boolean isApplyO2OSelect(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.O2OSelect);
	}

	public static List<Property> getApplyO2OSelect(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyO2OSelect(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** O2OSelectPage ********/
	public static boolean isApplyO2OSelectPage(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.O2OSelectPage);
	}

	public static List<Property> getApplyO2OSelectPage(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyO2OSelectPage(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/******** M2OSelect ********/
	public static boolean isApplyM2OSelect(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2OSelect);
	}

	public static List<Property> getApplyM2OSelect(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2OSelect(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}
	
	public static List<Property> getApplyM2OAndO2OSelect(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2OSelect(property)) {
				resultList.add(property);
			}
			if (isApplyO2OSelect(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}
	
	public static List<Property> getApplyM2OSelectTree(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllManyToOneProperties(uml2Class,false);
		for (Property property : propertyList) {
			if (isApplyM2OSelect(property)||isApplyO2OSelect(property)) {
				if(TreeStereotypeHelper.isApply((Class)property.getType())){
					resultList.add(property);
				}
			}
		}
		return resultList;
	}

	/******** M2OSelectPage ********/
	public static boolean isApplyM2OSelectPage(Property property) {
		return StereotypeUtil.isAppliedStereotype(property, MdaStereotype.M2OSelectPage);
	}

	public static List<Property> getApplyM2OSelectPage(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isApplyM2OSelectPage(property)) {
				resultList.add(property);
			}
		}
		return resultList;
	}

	/*****************************************************************
	 * jsp input form util /
	 *****************************************************************/

	public static boolean isNeedTableDoubleCols(Class uml2Class) {
		List<Property> pageCountInputPropertyList = new ArrayList<Property>();
		pageCountInputPropertyList.addAll(getViewInputPropertiesForSimple(uml2Class));
		pageCountInputPropertyList.addAll(getApplyM2OSelect(uml2Class));
		pageCountInputPropertyList.addAll(getApplyO2OSelect(uml2Class));
		pageCountInputPropertyList.addAll(getApplyM2OSelectPage(uml2Class));
		pageCountInputPropertyList.addAll(getApplyO2OSelectPage(uml2Class));
		if (pageCountInputPropertyList.size() > 6) {
			return true;
		}
		return false;
	}

	/**
	 * 获取简单input simple text属性例表//exclude id property
	 */
	public static List<Property> getSimpleInputProperty(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (EntityHelper.isIDProperty(property)) {// exclude id property
				continue;
			}
			if (isViewInput(property)) {
				if (isViewInputFile(property)) {// file
					continue;
				}
				if (isViewInputImage(property)) {// image
					continue;
				}
				if (isViewInputContent(property)) {// content
					continue;
				}
				if(isViewInputContentTab(property)){
					continue;
				}
				resultList.add(property);
				continue;
			}
			// if (isViewInputText(property)) {// text
			// resultList.add(property);
			// }
			// if (isViewInputTitle(property)) {// title
			// resultList.add(property);
			// }
			// if (isViewInputSelect(property)) {// select
			// resultList.add(property);
			// }
			// if (isViewInputDatePicker(property)) {// datePicker
			// resultList.add(property);
			// }
			// if (isViewInputTextarea(property)) {// texttarea
			// resultList.add(property);
			// }
			// if (isViewInputCheckbox(property)) {// checkbox
			// resultList.add(property);
			// }
			// if (isViewInputRadio(property)) {// radio
			// resultList.add(property);
			// }
			// if (isViewInputFile(property)) {// file
			// resultList.add(property);
			// }
			// if (isViewInputImage(property)) {// image
			// resultList.add(property);
			// }
			// if (isViewInputContent(property)) {// content
			// resultList.add(property);
			// }
			/******** rel property ********/
			if (isApplyM2OSelect(property)) {// M2OSelect
				resultList.add(property);
				continue;
			}
			if (isApplyM2OSelectPage(property)) {// M2OSelectPage
				resultList.add(property);
				continue;
			}
			if (isApplyO2OSelect(property)) {// O2OSelect
				resultList.add(property);
				continue;
			}
			if (isApplyO2OSelectPage(property)) {// O2OSelectPage
				resultList.add(property);
				continue;
			}
		}
		return resultList;
	}

	/**
	 * 获取简单input simple text属性例表//exclude id property
	 */
	public static List<Property> getFileSimpleInputProperty(Class uml2Class) {
		List<Property> result = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (EntityHelper.isIDProperty(property)) {// exclude id property
				continue;
			}
			if (isViewInput(property)) {
				if (isViewInputFile(property)) {// file
					continue;
				}
				if (isViewInputImage(property)) {// image
					continue;
				}
				if (isViewInputContent(property)) {// content
					continue;
				}
				if(FileStereotypeHelper.isProperty_FileExtention(property)){
					continue;
				}
				if(FileStereotypeHelper.isProperty_FileName(property)){
					continue;
				}
				if(FileStereotypeHelper.isProperty_FileSavePath(property)){
					continue;
				}
				if(FileStereotypeHelper.isProperty_FileSize(property)){
					continue;
				}
				if(FileStereotypeHelper.isProperty_FileType(property)){
					continue;
				}
				if(FileStereotypeHelper.isProperty_visitPath(property)){
					continue;
				}
				result.add(property);
				continue;
			}
			if (isApplyM2OSelect(property)) {// M2OSelect
				result.add(property);
				continue;
			}
			if (isApplyM2OSelectPage(property)) {// M2OSelectPage
				result.add(property);
				continue;
			}
			if (isApplyO2OSelect(property)) {// O2OSelect
				result.add(property);
				continue;
			}
			if (isApplyO2OSelectPage(property)) {// O2OSelectPage
				result.add(property);
				continue;
			}
		}
		return result;
	}

	/**
	 * 获取应用了View Input 的属性例表,包括m2o,o2o关联.
	 */
	public static List<Property> getInsertProperty(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			//if (isViewInput(property)) {// text
				if (ClassHelper.isSimple(property)) {
					resultList.add(property);
					continue;
				}
				if (ClassHelper.isOneToOne(property)) {// o2o
					resultList.add(property);
					continue;
				}
				if (ClassHelper.isManyToOne(property)) {// o2o
					resultList.add(property);
					continue;
				}
			//}
		}
		return resultList;
	}

	/**
	 * 获取简单input validate 属性例表
	 */
	public static List<Property> getInputPropertyForValidate(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			// if(EntityHelper.isIDProperty(property)){//exclude id property
			// continue;
			// }
			if (isViewInputText(property)) {// text
				resultList.add(property);
				continue;
			}
			if (isViewInputTitle(property)) {// title
				resultList.add(property);
				continue;
			}
			if (isViewInputSelect(property)) {// select
				resultList.add(property);
				continue;
			}
			if (isViewInputDatePicker(property)) {// datePicker
				resultList.add(property);
				continue;
			}
			if (isViewInputTextarea(property)) {// texttarea
				resultList.add(property);
				continue;
			}
			if (isViewInputCheckbox(property)) {// checkbox
				resultList.add(property);
				continue;
			}
			if (isViewInputRadio(property)) {// radio
				resultList.add(property);
				continue;
			}
			// if (isViewInputFile(property)) {// file
			// resultList.add(property);
			// }
			// if (isViewInputImage(property)) {// image
			// resultList.add(property);
			// }
			if (isViewInputContent(property)) {// content
				resultList.add(property);
				continue;
			}
			/******** rel property ********/
			if (isApplyM2OSelect(property)) {// M2OSelect
				resultList.add(property);
				continue;
			}
			if (isApplyM2OSelectPage(property)) {// M2OSelectPage
				resultList.add(property);
				continue;
			}
			if (isApplyO2OSelect(property)) {// O2OSelect
				resultList.add(property);
				continue;
			}
			if (isApplyO2OSelectPage(property)) {// O2OSelectPage
				resultList.add(property);
				continue;
			}
		}
		return resultList;
	}

//	private static void populateInputProperty(Class uml2Class) {
		// List<Property>
		// simpleList=ViewInputHelper.getViewInputPropertiesForSimple(uml2Class);
		//
		// List<Property>
		// titlePropertyList=ViewInputHelper.getViewInputTitle(uml2Class);
		// List<Property>
		// textPropertyList=ViewInputHelper.getViewInputText(uml2Class);
		// List<Property>
		// selectPropertyList=ViewInputHelper.getViewInputSelect(uml2Class);
		// List<Property>
		// datePropertyList=ViewInputHelper.getViewInputDatePicker(uml2Class);
		//
		// List<Property>
		// textareaPropertyList=ViewInputHelper.getViewInputTextarea(uml2Class);
		// List<Property>
		// checkboxPropertyList=ViewInputHelper.getViewInputCheckbox(uml2Class);
		// List<Property>
		// radioPropertyList=ViewInputHelper.getViewInputRadio(uml2Class);
		// List<Property>
		// filePropertyList=ViewInputHelper.getViewInputFile(uml2Class);
		// List<Property>
		// imagePropertyList=ViewInputHelper.getViewInputImage(uml2Class);
		// List<Property>
		// contentPropertyList=ViewInputHelper.getViewInputContent(uml2Class);

		/****** rel property ********/
		// List<Property>
		// M2MCheckboxsList=ViewInputHelper.getApplyM2MCheckboxs(uml2Class);
		// List<Property>
		// M2MCheckboxsTreeList=ViewInputHelper.getApplyM2MCheckboxsTree(uml2Class);
		// List<Property>
		// M2MCheckboxsTabList=ViewInputHelper.getApplyM2MCheckboxsTab(uml2Class);
		// List<Property>
		// M2MCheckboxsTreeTabList=ViewInputHelper.getApplyM2MCheckboxsTreeTab(uml2Class);
		//
		// List<Property>
		// M2OSelectList=ViewInputHelper.getApplyM2OSelect(uml2Class);
		// List<Property>
		// M2OSelectPageList=ViewInputHelper.getApplyM2OSelectPage(uml2Class);
		//
		// List<Property>
		// O2OSelectList=ViewInputHelper.getApplyO2OSelect(uml2Class);
		// List<Property>
		// O2OSelectPageList=ViewInputHelper.getApplyO2OSelectPage(uml2Class);

		// List<Property>
		// O2MManagerPageList=ViewInputHelper.getApplyO2MManagerPage(uml2Class);
//	}

	static public String getStyleClass(Property property) {
		String stereotype = MdaStereotype.view_Input;
		String attribute = InputAnnotations.cssClass.toString();
		String cssClass = (String) StereotypeHelper.getValue(property, stereotype, attribute);
		if (null == cssClass)
			return "text";
		return cssClass;
	}

	static public String getRelForListKey(Property property) {
		String listKey = null;
		if (isApplyM2OSelect(property)) {// M2OSelect
			listKey = (String) StereotypeUtil.getAppliedValue(property, MdaStereotype.M2OSelect, "listKey");
		}
		if (isApplyM2OSelectPage(property)) {// M2OSelectPage
			listKey = (String) StereotypeUtil.getAppliedValue(property, MdaStereotype.M2OSelectPage, "listKey");
		}
		if (isApplyO2OSelect(property)) {// O2OSelect
			listKey = (String) StereotypeUtil.getAppliedValue(property, MdaStereotype.O2OSelect, "listKey");
		}
		if (isApplyO2OSelectPage(property)) {// O2OSelectPage
			listKey = (String) StereotypeUtil.getAppliedValue(property, MdaStereotype.O2OSelectPage, "listKey");
		}
		return listKey;
	}

	/**
	 * 获取Tab 展现属性例表
	 */
	public static List<Property> getTabsProperty(Class uml2Class) {
		List<Property> resultList = new ArrayList<Property>();
		List<Property> propertyList = EntityHelper.getAllProperties(uml2Class);
		for (Property property : propertyList) {
			if (isViewInputContentTab(property)) {
				resultList.add(property);
			}
			/******** rel property ********/
			if (isApplyM2MCheckboxsTab(property)) {// M2OSelect
				resultList.add(property);
			}
			if (isApplyM2MCheckboxsTreeTab(property)) {// M2OSelectPage
				resultList.add(property);
			}
		}
		return resultList;
	}

}
