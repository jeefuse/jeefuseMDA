package com.jeefuse.base.modules.keyLabel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyLabelUtil {

	/**
	 * 获取实体集合中的ID,并组合成List.如果keyLableList为空则返回null.
	 * 
	 * @param identities
	 * @return
	 */
	public static <T extends KeyLabel> List<String> toKeyList(Collection<T> keyLabelList) {
		List<String> list = null;
		if (null != keyLabelList && !keyLabelList.isEmpty()) {
			list = new ArrayList<String>();
			for (T item : keyLabelList) {
				list.add(item.getKey());
			}
		}
		return list;
	}

	/**
	 * 获取实体集合中的ID,并组合成List.如果keyLableList为空则返回null.
	 * 
	 * @param identities
	 * @return
	 */
	public static <T extends KeyLabel> String[] toKeyArray(List<T> keyLabelList) {
		String[] arr = null;
		if (null != keyLabelList && !keyLabelList.isEmpty()) {
			int size=keyLabelList.size();
			arr = new String[size];
			int i = 0;
			for (T item : keyLabelList) {
				arr[i++] = item.getKey();
			}
		}
		return arr;
	}

	/**
	 * 转化为Map对象,KeyLabel对象中的key字段为map的key,label字段为map中的value.
	 * 
	 * @param <T>
	 * @param keyLabelList
	 * @return
	 */
	public static <T extends KeyLabel> Map<String, String> toKeyValueMap(List<T> keyLabelList) {
		if (null == keyLabelList||keyLabelList.isEmpty())
			return null;
		Map<String,String> map=new HashMap<String,String>();
		for (T item : keyLabelList) {
			map.put(item.getKey(), item.getLabel());
		}
		return map;
	}
}
