package com.jeefuse.base.web.rto;

/**
 * 请求传输对象,用于view 与 action之间传输参数.构造具体的实体对象或返回实体对象参数.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface GenericRTO<T> {


	/**
	 * 从请求中构造要保存的实体对象.
	 */
	public T getNewModel();

	/**
	 * 从请求中构造要更新的实体对象.
	 * 
	 * @param oldModel
	 *            要更新的实体对象.
	 */
	public T getModifiedModel(T oldModel);
}
