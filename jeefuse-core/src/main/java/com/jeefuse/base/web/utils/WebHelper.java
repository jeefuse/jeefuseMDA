package com.jeefuse.base.web.utils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.WebUtils;

import com.jeefuse.base.model.IdEntity;
import com.jeefuse.base.web.utils.PropertyFilter.MatchType;

/**
 * 针对Web应用的处理集合、参数、过滤等常用辅助类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class WebHelper {

	/**
	 * 根据对象ID集合,整理合并集合.
	 * 
	 * 页面发送变更后的子对象id列表时,删除原来的子对象集合再根据页面id列表创建一个全新的集合这种看似最简单的做法是不行的.
	 * 因此需采用如此的整合算法：在源集合中删除id不在ID集合中的对象,根据ID集合中的id创建对象并添加到源集合中.
	 * 
	 * @param srcObjects
	 *            源对象集合,对象必需继承Entityable.
	 * @param checkedIds
	 *            目标ID集合
	 * @param clazz
	 *            集合中对象的类型
	 */
	public static <T extends IdEntity> void mergeByCheckedIds(Collection<T> srcObjects, final Collection<String> checkedIds,
			final Class<T> clazz) throws Exception {
		Collection<T> curSrcObject = srcObjects;
		if (null == curSrcObject) {
			curSrcObject = new HashSet<T>();
		}
		// 目标ID集合为空,删除源集合中所有对象后直接返回.
		if (checkedIds == null) {
			srcObjects.clear();
			return;
		}
		// 遍历源集合,如果其id不在目标ID集合中的对象,进行删除.
		// 同时,在目标ID集合中删除已在源集合中的id,使得目标ID集合中剩下的id均为源集合中没有的ID.
		Iterator<T> srcIterator = srcObjects.iterator();
		while (srcIterator.hasNext()) {
			T element = srcIterator.next();
			Object id = element.getId();
			if (!checkedIds.contains(id)) {
				srcIterator.remove();
			} else {
				checkedIds.remove(id);
			}
		}
		for (String id : checkedIds) {
			T obj = clazz.newInstance();
			obj.setId(id);
			srcObjects.add(obj);
		}
	}

	/**
	 * 实体集合转换为实体ID集合.
	 * 
	 * @param identities
	 * @return
	 */
	public static <T extends IdEntity> List<Serializable> toCheckedIds(Collection<T> identities) {
		List<Serializable> list = new ArrayList<Serializable>();
		if (null != identities) {
			for (IdEntity identity : identities) {
				list.add(identity.getId());
			}
		}
		return list;
	}


	/**
	 * 请求参数填充对象属性.
	 */
	public Object fillRequestParam(HttpServletRequest request, Object bean) {
		// 取得所有参数列表
		Enumeration<?> params = request.getParameterNames();
		// 遍历所有参数列表
		while (params.hasMoreElements()) {

			String name = (String) params.nextElement();
			String value = request.getParameter(name);
			try {
				// 取得这个参数在Bean中的数据类开
				// Class<?> cls = PropertyUtils.getPropertyType(bean, name);
				// 把相应的数据转换成对应的数据类型
				// Object beanValue =
				// ConvertUtils.convert(request.getParameter(name), cls);
				// 添冲Bean值
				PropertyUtils.setProperty(bean, name, value);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

}
