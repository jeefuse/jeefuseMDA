package net.taylor.mda.generator.parse.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些约定成俗的常量.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ConventionConstants {

	/**
	 * 系统自动创建时间的字段名.
	 */
	public static List<String> autoCreateDateFieldName = new ArrayList<String>();
	static {
		autoCreateDateFieldName.add("createDate");
		autoCreateDateFieldName.add("updateDate");
		autoCreateDateFieldName.add("auditDate");
		autoCreateDateFieldName.add("lastLoginDate");
	}

	public static List<String> excludeInputFieldName = new ArrayList<String>();
	static {
		excludeInputFieldName.add("id");
		excludeInputFieldName.add("guid");
		// excludeInputFieldName.add("createDate");
		// excludeInputFieldName.add("updateDate");
		// excludeInputFieldName.add("create_Date");
		// excludeInputFieldName.add("update_Date");
		// excludeInputFieldName.add("createTime");
		// excludeInputFieldName.add("updateTime");
		// excludeInputFieldName.add("create_Time");
		// excludeInputFieldName.add("update_Time");
		// excludeInputFieldName.add("auditDate");
		// excludeInputFieldName.add("lastLoginDate");
		// excludeInputFieldName.add("SORT_NUM");
		// excludeInputFieldName.add("sortNum");
		// excludeInputFieldName.add("ORDER_NUM");
		// excludeInputFieldName.add("orderNum");
	}

	public static List<String> readonlyInputFieldName = new ArrayList<String>();
	static {
		readonlyInputFieldName.add("id");
		readonlyInputFieldName.add("guid");
		readonlyInputFieldName.add("createDate");
		readonlyInputFieldName.add("updateDate");
		readonlyInputFieldName.add("create_Date");
		readonlyInputFieldName.add("update_Date");
		readonlyInputFieldName.add("createTime");
		readonlyInputFieldName.add("updateTime");
		readonlyInputFieldName.add("create_Time");
		readonlyInputFieldName.add("update_Time");
		readonlyInputFieldName.add("auditDate");
		readonlyInputFieldName.add("lastLoginDate");
		// readonlyInputFieldName.add("SORT_NUM");
		// readonlyInputFieldName.add("sortNum");
		// readonlyInputFieldName.add("ORDER_NUM");
		// readonlyInputFieldName.add("orderNum");
		readonlyInputFieldName.add("layerCode");
	}

	/**
	 * 默认需要查询字段名.
	 */
	public static List<String> searchFieldName = new ArrayList<String>();
	static {
		searchFieldName.add("name");
		searchFieldName.add("title");
	}

	/**
	 * 默认不需要查询字段名.
	 */
	public static List<String> excludeSearchFieldName = new ArrayList<String>();
	static {
		excludeSearchFieldName.add("id");
		excludeSearchFieldName.add("guid");
		excludeSearchFieldName.add("layerCode");
		excludeSearchFieldName.add("parentId");
		excludeSearchFieldName.add("orderNum");
		excludeSearchFieldName.add("photoPath");
		excludeSearchFieldName.add("filePath");
		excludeSearchFieldName.add("imagePath");
		excludeSearchFieldName.add("attachFilePath");
		excludeSearchFieldName.add("photo");
		excludeSearchFieldName.add("photoPath");
		excludeSearchFieldName.add("image");
		excludeSearchFieldName.add("imagePath");
	}

	public static List<String> excludeListFieldName = new ArrayList<String>();
	static {
		excludeListFieldName.add("id");
		excludeListFieldName.add("guid");
	}

}
