package com.jeefuse.base.model.parse;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import com.jeefuse.base.exception.DataNoExistException;

/**
 * 根据属性名,获取对象的属性值.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class DefaultPropertyValueGet<T> implements PropertyValueGet<T> {

	/**
	 * 获取对象属性值.
	 * 
	 * @param model
	 *            模型对象
	 * @param property
	 *            属性名
	 * @return
	 */
	public Object getValue(T model, String propertyName) throws DataNoExistException {
		try {
			return PropertyUtils.getProperty(model, propertyName);
		} catch (IllegalAccessException e) {
			throw new DataNoExistException(e);
		} catch (InvocationTargetException e) {
			throw new DataNoExistException(e);
		} catch (NoSuchMethodException e) {
			throw new DataNoExistException(e);
		}
	}
}
