package net.taylor.mda.generator.parse.page;

import net.taylor.mda.generator.parse.StereotypeUtil;
import net.taylor.mda.generator.parse.entity.EntityHelper;
import net.taylor.mda.generator.util.NameHelper;
import net.taylor.mda.generator.util.StereotypeHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.jeefuse.mda.annotations.view.OrderByAnnotations;

/**
 * stereotype:view_OrderBy define.
 *
 */
public class OrderByHelper {

	/*****************************************************************
	 * stereotype:view_OrderBy define
	/*****************************************************************/

	public static boolean isApplyOrderBy(Class element) {
		String stereotype=MdaStereotype.view_OrderBy;
		return StereotypeUtil.isAppliedStereotype(element, stereotype);
	}
	
	
	static public String getOrderBy_orderField(Class element) {
		String stereotype=MdaStereotype.view_OrderBy;
		String attribute=OrderByAnnotations.orderField.toString();
		Object value=StereotypeHelper.getValue(element, stereotype, attribute);
		return (String)value;
	}
	
	public static String getOrderBy_orderMode(Class element){
		String stereotype=MdaStereotype.view_OrderBy;
		String attribute=OrderByAnnotations.orderMode.toString();
		String value=StereotypeUtil.getAppliedValueForString(element, stereotype, attribute);
		return value;
	}
	
	public static String getViewListOrderField(Class element) {
		String value= OrderByHelper.getOrderBy_orderField(element);
		return (String)value;
	}
	
	/*****************************************************************
	 * for view list
	/*****************************************************************/

	
	public static String getOrderField(Class element){
		String orderField=getViewListOrderField(element);
		if(null==orderField||orderField.trim().equals("")){
			Property idProperty=EntityHelper.getIDProperty(element);
			orderField= NameHelper.getUncapName(idProperty);
		}
		return orderField;
	}

	public static String getOrderMode(Class element){
		String orderMode=getOrderBy_orderMode(element);
		if(null==orderMode||orderMode.trim().equals("")){
			return "desc";
		}
		return orderMode;
	}
}
