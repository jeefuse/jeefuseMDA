package net.taylor.mda.generator.parse.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.StringUtils;
import net.taylor.mda.generator.parse.UmlHelper;
import net.taylor.mda.generator.parse.entity.Config;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.parse.stereotype.KeyLabelStereotypeHelper;
import net.taylor.mda.generator.util.ClassHelper;
import net.taylor.mda.generator.util.MathHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;
import net.taylor.mda.generator.util.TypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.view.ListAnnotations;

/**
 * view input define.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ViewListHelper {

	/*****************************************************************
	 * stereotype:view_List define /
	 *****************************************************************/

	/**
	 * 是否应用了view_List stereotype.
	 */
	public static boolean isApplyViewList(Property property) {
		return EntityHelper.isStereotypeApplied(property, MdaStereotype.view_List);
	}

	/**
	 * 获取view_List stereotype:liskLabel 属性值.
	 */
	public static String getApplyViewList_ListLabel(Property property) {
		String stereotype = MdaStereotype.view_List;
		String attribute = ListAnnotations.listLabel.toString();
		String value = (String) StereotypeHelper.getValue(property, stereotype, attribute);
		return value;
	}
	
	/*****************************************************************
	 * stereotype 处理
	/*****************************************************************/

	/**
	 * 获取view_List stereotype:width 属性值.
	 */
	public static int getViewListWidth(Property property) {
		String stereotype = MdaStereotype.view_List;
		String attribute = ListAnnotations.width.toString();
		Object width = StereotypeHelper.getValue(property, stereotype, attribute);
		if (null == width||Integer.parseInt(width.toString())==0)
			return Config.defaultDateGridPixed;
		return Integer.parseInt(width.toString());
	}

	public static int getTotalWidth(List<Property> properties){
		if(null==properties||properties.isEmpty()){
			return 0;
		}
		int count=0;
		String stereotype = MdaStereotype.view_List;
		String attribute = ListAnnotations.width.toString();
		for(Property property:properties){
			Object width = StereotypeHelper.getValue(property, stereotype, attribute);
			int w=Integer.parseInt(width.toString());
			count+=w;
		}
		return count;
	}
	
	public static double getPropertyWidthPercentage(Property property,int totalWidth){
		String stereotype = MdaStereotype.view_List;
		String attribute = ListAnnotations.width.toString();
		Object width = StereotypeHelper.getValue(property, stereotype, attribute);
		int w=Integer.parseInt(width.toString());
		if(w==0){
			return 0;
		}
		return getWidthPercentage(w,totalWidth);
	}
	
	public static double getWidthPercentage(int w1,int w2){
		if(w2==0){
			return 0;
		}
		return MathHelper.mul(MathHelper.div(w1, w2), 100,0);
	}
	/**
	 * 获取view_List stereotype:sortable 属性值.
	 */
	public static boolean isSortable(Property property) {
		String stereotype = MdaStereotype.view_List;
		String attribute = ListAnnotations.sortable.toString();
		Object sortable = StereotypeHelper.getValue(property, stereotype, attribute);
		if (null == sortable) {
			return false;
		}
		return "true".equalsIgnoreCase(sortable.toString());
	}

	/**
	 * 获取view_List stereotype:liskLabel 属性名.
	 */
	public static String getViewListLabelRelPropertyName(Property element) {
		Property property=getProperty_listLabel(element);
		if(null==property){
			//return "name";
			return null;
		}
		return NameHelper.uncapSafeName(property);
	}

	/**
	 * 获取view_List stereotype:liskLabel 属性名.
	 */
	public static String getViewListLabelRelPropertyComment(Property element) {
		Property property=getProperty_listLabel(element);
		if(null==property){
			//return "名称";
			return null;
		}
		return TypeHelper.getDocumentationOrName(property);
	}
	
	/**
	 * 获取view_List stereotype:liskLabel 属性名.
	 */
	public static String getViewListLabelRelPropertyGetAccessorName(Property element) {
		Property property=getProperty_listLabel(element);
		if(null==property){
			return "getName";
		}
		return ClassHelper.getGetAccessor(property);
	}
	
	/**
	 * 获取stereotype:listLabel 值对应的属性.
	 */
	public static Property getProperty_listLabel(Property element) {
		Property listLabelProperty = null;
		String stereotypeValue = getApplyViewList_ListLabel(element);
		if (element.getType() instanceof org.eclipse.uml2.uml.Class) {
			Class propertyType=(Class)element.getType();
			if(StringUtils.isNotBlank(stereotypeValue)){
				listLabelProperty = UmlHelper.getPropertyElement(propertyType, stereotypeValue);
			}
			if(null==listLabelProperty){
				listLabelProperty = KeyLabelStereotypeHelper.getProperty_listLabel(propertyType);
			}
			//默认
			if(null==listLabelProperty){
				listLabelProperty=UmlHelper.getPropertyElement(propertyType,"name" );
			}
		}
		return listLabelProperty;
	}

	/**
	 * 获取所有非关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getViewListPropertiesFromSimple(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		Iterator<Property> i = ClassHelper.getAllSimpleProperties(element);
		for (; i.hasNext();) {
			Property property = (Property) i.next();
			if (isApplyViewList(property))
				propertyList.add(property);
		}
		return propertyList;
	}

	/**
	 * 获取所有多对一关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getViewListPropertiesFromM2o(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		// m2o relation
		List<Property> m20List = EntityHelper.getAllManyToOneProperties(element, false);
		for (Property property : m20List) {
			if (isApplyViewList(property)) {
				propertyList.add(property);
			}
		}
		return propertyList;
	}

	/**
	 * 获取所有多对一关联且应用了view_List版型的属性例表.
	 */
	public static List<Property> getViewListPropertiesFromO2o(Class element) {
		List<Property> propertyList = new ArrayList<Property>();
		// o2o relation
		List<Property> o2oList = EntityHelper.getAllOneToOneProperties(element, false);
		for (Property property : o2oList) {
			if (isApplyViewList(property)) {
				propertyList.add(property);
			}
		}
		return propertyList;
	}

}
