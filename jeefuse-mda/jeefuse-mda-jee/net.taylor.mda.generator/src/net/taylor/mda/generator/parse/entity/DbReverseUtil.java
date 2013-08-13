package net.taylor.mda.generator.parse.entity;

import net.taylor.mda.generator.parse.GenHelper;

/**
 * Db generated uml util.
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class DbReverseUtil {
	/**
	 * 是否需要应用net.jeefuse.mda.annotations.property.Show:input.
	 */
	public static boolean isApplyInput(String name){
		if(!GenHelper.isContainsIgnoreCase(ConventionConstants.excludeInputFieldName,name))
			return true;
		return false;
	}
	
	/**
	 * 是否需要应用net.jeefuse.mda.annotations.property.Show:input:readonly.
	 */
	public static boolean isApplyInputReadonly(String name){
		if(GenHelper.isContainsIgnoreCase(ConventionConstants.readonlyInputFieldName,name))
			return true;
		return false;
	}
	
	/**
	 * 是否需要应用stereotype:net.jeefuse.mda.annotations.view.Search.
	 */
	public static boolean isApplySearch(String name){
		if(!GenHelper.isContainsIgnoreCase(ConventionConstants.excludeSearchFieldName, name))
			return true;
		return false;
	}

	/**是否需要应用 stereotype:net.jeefuse.mda.annotations.view.List
	 */
	public static boolean isApplyList(String name) {
		if(!GenHelper.isContainsIgnoreCase(ConventionConstants.excludeListFieldName, name))
			return true;
		return false;
	}

	public static boolean isApplyListKind(String propertyName) {
		if(null!=propertyName){
			if(propertyName.endsWith("kind")||propertyName.endsWith("Kind"))
				return true;
		}
		return false;
	}

	public static boolean isApplySearch(String columnName, String columnJavaType, int columnSize) {
		if(!GenHelper.isContainsIgnoreCase(ConventionConstants.excludeSearchFieldName, columnName))
			return true;
		if("String".equalsIgnoreCase(columnJavaType)&&columnSize<Config.defaultTitlePropertyLength_Max)
			return true;
		return false;
	}
}
