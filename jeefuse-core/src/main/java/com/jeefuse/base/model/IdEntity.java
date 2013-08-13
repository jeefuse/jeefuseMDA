package com.jeefuse.base.model;

import java.io.Serializable;

/**
 * 访问实体的ID属性.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface IdEntity<T extends Serializable> {

	public T getId();

	public void setId(T id);

}
