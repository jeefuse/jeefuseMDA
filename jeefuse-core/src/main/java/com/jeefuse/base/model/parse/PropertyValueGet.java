package com.jeefuse.base.model.parse;

import com.jeefuse.base.exception.DataNoExistException;

/**
 * 根据属性名,获取对象的属性值.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface PropertyValueGet<T> {

	/**
	 * 获取对象属性值.
	 * 
	 * @param model
	 *            模型对象
	 * @param property
	 *            属性名
	 * @return
	 */
	public Object getValue(T model, String propertyName) throws DataNoExistException;

}
