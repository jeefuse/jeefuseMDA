package com.jeefuse.base.utils.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.jeefuse.base.model.IdEntity;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.modules.tree.TreeNodeable;

/**
 * 常用的字符串转换工具.
 * 
 * @author yonclv
 * @created 2009-8-4
 */
public class ChangeUtil {

	/**
	 * 返回是否数组中包含name,包含返回true,否则返回false.数组为空返回false.
	 */
	public static boolean isContains(String[] strArray, String name) {
		if (null != strArray && strArray.length > 0) {
			for (String str : strArray) {
				if (str.equals(name))
					return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * 返回集合中对象的id不在excludeIds中的集合对象.
	 * 
	 * @param <T>
	 *            IdEntity实体对象
	 * @param collections
	 *            集合例表
	 * @param excludeIds
	 *            需要排除的id数组
	 * @return
	 */
	public static <T extends IdEntity> Collection<T> excludeIdEntityIds(Collection<T> collections, String... excludeIds) {
		if (null == collections)
			return null;
		if (null == excludeIds || excludeIds.length == 0)
			return collections;
		Iterator<T> it = collections.iterator();
		while (it.hasNext()) {
			T obj = it.next();
			for (String id : excludeIds) {
				if (obj.getId().equals(id)) {
					it.remove();
				}
			}
		}
		return collections;
	}

	/**
	 * 返回集合中对象的id不在excludeIds中的集合对象.
	 * 
	 * @param <T>
	 *            TreeNodeable树形对象
	 * @param collections
	 *            集合例表
	 * @param excludeIds
	 *            需要排除的id数组
	 */
	public static <T extends TreeNodeable> Collection<T> excludeTreeIds(Collection<T> collections, String... excludeIds) {
		if (null == collections)
			return null;
		if (null == excludeIds || excludeIds.length == 0)
			return collections;
		Iterator<T> it = collections.iterator();
		while (it.hasNext()) {
			T obj = it.next();
			for (String id : excludeIds) {
				if (obj.getId().equals(id)) {
					it.remove();
				}
			}
		}
		return collections;
	}

	/**
	 * 返回集合中对象的id不在excludeIds中的集合对象.
	 * 
	 * @param <T>
	 *            TreeNodeable树形对象
	 * @param collections
	 *            集合例表
	 * @param excludeIds
	 *            需要排除的id数组
	 */
	public static <T extends KeyLabel> void excludeKeys(Collection<T> collections, String... excludeKeys) {
		if (null == collections)
			return;
		if (null == excludeKeys || excludeKeys.length == 0)
			return;
		Iterator<T> it = collections.iterator();
		while (it.hasNext()) {
			T obj = it.next();
			for (String id : excludeKeys) {
				if (obj.getKey().equals(id)) {
					it.remove();
				}
			}
		}
		return;
	}

	/**
	 * 返回集合src中的对象不在dst集合中的对象.
	 * 
	 */
	public static List<String> exclude(List<String> src, List<String> dst) {
		if (src == null || src.isEmpty())
			return null;
		if (dst == null || dst.isEmpty())
			return src;
		List<String> result = new ArrayList<String>();
		for (String m : src) {
			if (!dst.contains(m)) {
				result.add(m);
			}
		}
		return result;
	}

	/**
	 * 把list集合中对象的id为键,对象为值转换成map类型.
	 * 
	 * @param <T>
	 * @param srcList
	 * @return
	 */
	public static <T extends IdEntity> Map<String, T> changeListToMapWithIdKey(List<T> srcList) {
		Map<String, T> map = new HashMap<String, T>();
		if (null != srcList) {
			for (T obj : srcList) {
				map.put(obj.getId().toString(), obj);
			}
		}
		return map;
	}

	/**
	 * 把字符串按分割转换成字符串集合.不包含相同的字符串.
	 * 
	 * @param str
	 *            分割字符串
	 * @param delimeter
	 *            分割符
	 * @param isTrim
	 *            是否去掉两边空格
	 * @return
	 */
	public static List<String> stringToCollection(String str, String delimeter, boolean isTrim) {
		if (StringUtils.isBlank(str))
			return null;
		String[] strs = StringUtils.split(str, delimeter);
		List<String> list = new ArrayList<String>();
		for (String s : strs) {
			if (!s.trim().equals("")) {
				if (isTrim) {
					s = s.trim();
				}
				if (!list.contains(s)) {
					list.add(s);
				}
			}
		}
		return list;
	}

	/**
	 * 把字符串按分割转换成字符串数组.
	 * 
	 * @param str
	 * @param isTrim
	 *            是否去掉两边空格
	 * @return 若传入字符串为空则返回null值
	 */
	public static String[] split(String str, String delimeter, boolean isTrim) {
		if (StringUtils.isBlank(str))
			return null;
		String[] strs = StringUtils.split(str, delimeter);
		if (isTrim) {
			for (int i = 0, len = strs.length; i < len; i++) {
				strs[i] = strs[i].trim();
			}
		}
		return strs;
	}

	/**
	 * 获取实体集合中的ID,并组合成List.
	 * 
	 * @param identities
	 * @return
	 */
	public static <T extends IdEntity> List<Serializable> toIdsList(Collection<T> identities) {
		List<Serializable> list = new ArrayList<Serializable>();
		if (null != identities) {
			for (T identity : identities) {
				list.add(identity.getId());
			}
		}
		return list;
	}

	/**
	 * 获取实体集合中的ID,并组合成Array.
	 * 
	 * @param <T>
	 * @param identities
	 * @return
	 */
	public static <T extends IdEntity> String[] toIdsArray(Collection<T> identities) {
		List<Serializable> list = toIdsList(identities);
		return list.toArray(new String[list.size()]);
	}

	/**
	 * String集合转换成String数组.
	 * 
	 * @param <T>
	 * @param identities
	 * @return
	 */
	public static String[] toStringArray(Collection<String> collections) {
		String[] strs = null;
		if (null != collections && !collections.isEmpty()) {
			strs = new String[collections.size()];
			int i = 0;
			for (String str : collections) {
				strs[i++] = str;
			}
		}
		return strs;
	}

	/**
	 * 获取实体集合中的ID,并组合成字符串.
	 * 
	 * @param <T>
	 * @param identities
	 * @param separator
	 * @return
	 */
	public static <T extends IdEntity> String toIdsString(Collection<T> identities, String separator) {
		List<Serializable> list = toIdsList(identities);
		return StringUtils.join(list, separator);
	}

	/**
	 * The value needs to be a String[]. A String, Null, or List will be
	 * converted to a String[]. In addition it will attempt to do a String
	 * conversion for other object types.
	 * 
	 * @param value
	 *            The value to convert to an String[]
	 * @return A String[] value.
	 */
	public static String[] getValueAsArray(Object value) {
		if (value == null)
			return new String[] {}; // put in a placeholder
		if (value instanceof String[])
			return (String[]) value;
		else if (value instanceof List) {
			List<?> valueList = (List<?>) value;
			return valueList.toArray(new String[valueList.size()]);
		}

		return new String[] { value.toString() };
	}

}
