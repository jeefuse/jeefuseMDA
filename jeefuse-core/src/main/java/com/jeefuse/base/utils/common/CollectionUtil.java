package com.jeefuse.base.utils.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;


/**集合操作的Utils函数集合.使用反射获取集合属性,不建议使用在要求高性能或高并发的环境下.
 * @author  yonclv
 * @created 2009-8-4
 */
public class CollectionUtil {

	private CollectionUtil() {
	}

	/**
	 * 提取集合中的对象的属性,组合成列表.
	 * 
	 * @param collection 来源集合.
	 * @param propertityName 要提取的属性名.
	 */
	@SuppressWarnings("unchecked")
	public static List fetchPropertyToList(Collection collection, String propertyName) throws Exception {

		List list = new ArrayList();

		for (Object obj : collection) {
			list.add(PropertyUtils.getProperty(obj, propertyName));
		}

		return list;
	}

	/**
	 * 提取集合中的对象的属性,组合成由分割符分隔的字符串.
	 * 
	 * @param collection 来源集合.
	 * @param propertityName 要提取的属性名.
	 * @param separator 分隔符.
	 */
	@SuppressWarnings("unchecked")
	public static String fetchPropertyToString(Collection collection, String propertyName, String separator)
			throws Exception {
		List list = fetchPropertyToList(collection, propertyName);
		return StringUtils.join(list, separator);
	}

	/**
	 * 根据对象ID集合,整理合并集合.
	 * 
	 * 整理算法为：在源集合中删除不在ID集合中的元素,创建在ID集合中的元素并对其ID属性赋值并添加到源集合中.
	 * 多用于根据http请求中的id列表，修改对象所拥有的子对象集合.
	 * 
	 * @param collection
	 *            源对象集合
	 * @param retainIds
	 *            目标集合
	 * @param clazz
	 *            集合中对象的类型
	 * 
	 * @see #retainById(Collection, Collection, String, Class)
	 */
	public static <T, ID> void mergeByCheckedIds(Collection<T> collection, Collection<ID> checkedIds, Class<T> clazz)
			throws Exception {
		mergeByCheckedIds(collection, checkedIds, "id", clazz);
	}

	/**
	 * 根据对象ID集合,整理合并集合.
	 * 
	 * http请求发送变更后的子对象id列表时，hibernate不适合删除原来子对象集合再创建一个全新的集合
	 * 需采用以下整合的算法：
	 * 在源集合中删除不在ID集合中的元素,创建在ID集合中的元素并对其ID属性赋值并添加到源集合中.
	 * 
	 * @param collection 源对象集合
	 * @param retainIds  目标集合
	 * @param idName 对象中ID的属性名 
	 * @param clazz  集合中对象的类型
	 */
	public static <T, ID> void mergeByCheckedIds(Collection<T> collection, Collection<ID> checkedIds, String idName,
			Class<T> clazz) throws Exception {

		if (checkedIds == null) {
			collection.clear();
			return;
		}

		Iterator<T> it = collection.iterator();

		while (it.hasNext()) {
			T obj = it.next();
			if (checkedIds.contains(PropertyUtils.getProperty(obj, idName))) {
				checkedIds.remove(PropertyUtils.getProperty(obj, idName));
			} else {
				it.remove();
			}
		}

		for (ID id : checkedIds) {
			T obj = clazz.newInstance();
			PropertyUtils.setProperty(obj, idName, id);
			collection.add(obj);
		}
	}

	/**
	 * 获取集合中从start到end位置的记录;
	 * 
	 * @param <T>
	 * @param collection
	 * @param start
	 * @param end
	 * @return
	 */
	public static<T> List<T> subCollection(Collection<T> collection, int start, int end) {
		if(null==collection||collection.isEmpty())
			return null;
		int count=0;
		List<T> result = new ArrayList<T>();
		for(T item:collection){
			if (start >= count && count < end) {
				result.add(item);
			}
			count++;
		}
		return result;
	}

	public static <T> List<T> subList(List<T> list, int first, int end) {
		if(null==list||list.isEmpty())
			return null;
		int size = list.size();
		int fromIndex = first;
		int toIndex = end;
		if (fromIndex < 0) {
			toIndex=0;
		}
		if (toIndex > size) {
			toIndex = size;
		}
		if (fromIndex > toIndex)
			return null;
		return list.subList(fromIndex, toIndex);
	}
}
