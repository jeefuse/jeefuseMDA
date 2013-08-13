package net.taylor.mda.generator.parse.stereotype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.parse.StringUtils;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;

public class FileStereotypeHelper {

	final static String stereotype_File = MdaStereotype.model_File;
	final static String stereotype_Image = MdaStereotype.model_Image;
	final static String stereotype_FileExtention = MdaStereotype.property_FileExtention;
	final static String stereotype_FileName = MdaStereotype.property_FileName;
	final static String stereotype_FileSavePath = MdaStereotype.property_FileSavePath;
	final static String stereotype_FileSize = MdaStereotype.property_FileSize;
	final static String stereotype_FileType = MdaStereotype.property_FileType;

	/*****************************************************************
	 * apply stereotype stereotype_File /
	 *****************************************************************/

	private static boolean isApplyModelFile(Element element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype_File);
	}

	private static String getApplyModelFile_acceptExtentions(Element element) {
		String attribute = "acceptExtentions";
		Object value = StereotypeHelper.getValue(element, stereotype_File, attribute);
		return (String) value;
	}

	/*****************************************************************
	 * apply stereotype stereotype_Image /
	 *****************************************************************/

	private static boolean isApplyModelImage(Element element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype_Image);
	}

	private static String getApplyModelImage_acceptExtentions(Property element) {
		String attribute = "acceptExtentions";
		Object value = StereotypeHelper.getValue(element, stereotype_Image, attribute);
		return (String) value;
	}

	/*****************************************************************
	 * apply stereotype stereotype_FileExtention /
	 *****************************************************************/
	private static boolean isApplyFileExtention(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype_FileExtention);
	}

	/*****************************************************************
	 * apply stereotype stereotype_FileName /
	 *****************************************************************/
	private static boolean isApplyFileName(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype_FileName);
	}

	/*****************************************************************
	 * apply stereotype stereotype_FileSavePath /
	 *****************************************************************/
	private static boolean isApplyFileSavePath(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype_FileSavePath);
	}

	/*****************************************************************
	 * apply stereotype stereotype_FileSize /
	 *****************************************************************/
	private static boolean isApplyFileSize(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype_FileSize);
	}

	/*****************************************************************
	 * apply stereotype stereotype_FileType /
	 *****************************************************************/
	private static boolean isApplyFileType(Property element) {
		return StereotypeUtil.isAppliedStereotype(element, stereotype_FileType);
	}

	/*****************************************************************
	 * utils /
	 *****************************************************************/
	public static boolean isClass_file(Class element){
		return isApplyModelFile(element);
	}
	
	public static boolean isClass_Image(Class element){
		return isApplyModelImage(element);
	}

	public static Boolean isProperty_File(Property property){
		if (isApplyModelFile(property))
			return true;
		if (property.getName().equalsIgnoreCase("FilePath"))
			return true;
		return false;
	}
	
	/**
	 * 判断类是否有属性应用了File stereotype.不包括关联属性
	 */
	public static boolean hasProperty_File(Class element) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_File(property))
				return true;
		}
		return false;
	}
	
	/**
	 * 获取类第一个应用了File stereotype的属性.不包括关联属性
	 */
	public static Property getProperty_File(Class element) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_File(property))
				return property;
		}
		return null;
	}

	public static Boolean isProperty_Image(Property property){
		if (isApplyModelImage(property))
			return true;
		if (property.getName().equalsIgnoreCase("FilePath")||property.getName().equalsIgnoreCase("FileSavePath"))
			return true;
		return false;
	}
	
	/**
	 * 获取类第一个应用了File stereotype的属性.不包括关联属性
	 */
	public static List<Property> getProperties_FileAndImage(Class element) {
		List<Property> result=new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_File(property))
				result.add(property);
			if(isProperty_FileSavePath(property))
				result.add(property);
		}
		return result;
	}
	
	/**
	 * 判断类是否有属性应用了image stereotype.不包括关联属性
	 */
	public static boolean hasProperty_Image(Class element) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_Image(property))
				return true;
		}
		return false;
	}

	/**
	 * 获取类第一个应用了image stereotype的属性.不包括关联属性
	 */
	public static Property getProperty_Image(Class element) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_Image(property))
				return property;
		}
		return null;
	}

	public static Boolean isProperty_FileExtention(Property property){
		if (isApplyFileExtention(property))
			return true;
		if (property.getName().equalsIgnoreCase("FileExtention")||property.getName().equals("extension"))
			return true;
		return false;
	}
	
	public static Property getProperty_FileExtention(Class uml2Class) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_FileExtention(property))
				return property;
		}
		return null;
	}

	public static Boolean isProperty_FileName(Property property){
		if (isApplyFileName(property))
			return true;
		if (property.getName().equalsIgnoreCase("FileName"))
			return true;
		return false;
	}
	
	public static Property getProperty_FileName(Class uml2Class) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_FileName(property))
				return property;
		}
		return null;
	}

	
	public static Boolean isProperty_FileSavePath(Property property){
		if (isApplyFileSavePath(property))
			return true;
		if (property.getName().equalsIgnoreCase("FileSavePath")||property.getName().equalsIgnoreCase("SavePath"))
			return true;
		return false;
	}
	
	public static Boolean isProperty_visitPath(Property property){
		if (property.getName().equalsIgnoreCase("visitpath")||property.getName().equalsIgnoreCase("filevisitpath"))
			return true;
		return false;
	}
	
	public static Property getProperty_visitPath(Class uml2Class) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_visitPath(property))
				return property;
		}
		return null;
	}

	
	public static Property getProperty_FileSavePath(Class uml2Class) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_FileSavePath(property))
				return property;
		}
		return null;
	}

	public static Boolean isProperty_FileType(Property property){
		if (isApplyFileType(property))
			return true;
		if (property.getName().equalsIgnoreCase("FileType"))
			return true;
		return false;
	}
	
	public static Property getProperty_FileType(Class uml2Class) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_FileType(property))
				return property;
		}
		return null;
	}
	
	public static Boolean isProperty_FileSize(Property property){
		if (isApplyFileSize(property))
			return true;
		if (property.getName().equalsIgnoreCase("FileSize"))
			return true;
		return false;
	}

	public static Property getProperty_FileSize(Class uml2Class) {
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(uml2Class);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isProperty_FileSize(property))
				return property;
		}
		return null;
	}

	public static String getGallaryListContructArgs(Class uml2Class) {
//		Property propertyFileSavePath = FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
		Property propertyFileVisitPath = FileStereotypeHelper.getProperty_visitPath(uml2Class);
		Property propertyTitle = PropertyStereotypeHelper.getProperty_Title(uml2Class);
		Property propertyIntro = PropertyStereotypeHelper.getProperty_Intro(uml2Class);
		List<String> args=new ArrayList<String>();
		if(null!=propertyFileVisitPath){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyFileVisitPath);
			args.add("String "+propertyUncapSafeName);
		}
		if(null!=propertyTitle){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyTitle);
			args.add("String "+propertyUncapSafeName);
		}
		if(null!=propertyIntro){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyIntro);
			args.add("String "+propertyUncapSafeName);
		}
		return StringUtils.join(args, ",");
	}
	
	public static String getGallaryListContructArgsForHql(Class uml2Class) {
//		Property propertyFileSavePath = FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
		Property propertyFileVisitPath = FileStereotypeHelper.getProperty_visitPath(uml2Class);
		Property propertyTitle = PropertyStereotypeHelper.getProperty_Title(uml2Class);
		Property propertyIntro = PropertyStereotypeHelper.getProperty_Intro(uml2Class);
		List<String> args=new ArrayList<String>();
		if(null!=propertyFileVisitPath){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyFileVisitPath);
			args.add("m."+propertyUncapSafeName);
		}
		if(null!=propertyTitle){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyTitle);
			args.add("m."+propertyUncapSafeName);
		}
		if(null!=propertyIntro){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyIntro);
			args.add("m."+propertyUncapSafeName);
		}
		return StringUtils.join(args, ",");
	}
	public static String getGallaryADImageAttr(Class uml2Class) {
		Property propertyFileSavePath = FileStereotypeHelper.getProperty_FileSavePath(uml2Class);
		Property propertyTitle = PropertyStereotypeHelper.getProperty_Title(uml2Class);
		Property propertyIntro = PropertyStereotypeHelper.getProperty_Intro(uml2Class);
		List<String> args=new ArrayList<String>();
		if(null!=propertyFileSavePath){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyFileSavePath);
			args.add("String "+propertyUncapSafeName);
		}
		if(null!=propertyTitle){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyTitle);
			args.add("String "+propertyUncapSafeName);
		}
		if(null!=propertyIntro){
			String propertyUncapSafeName=NameHelper.uncapSafeName(propertyIntro);
			args.add("String "+propertyUncapSafeName);
		}
		return StringUtils.join(args, ",");
	}
}
