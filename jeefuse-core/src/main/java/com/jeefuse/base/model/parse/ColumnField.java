package com.jeefuse.base.model.parse;


/**
 * 数据表中包含的表字段.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface ColumnField<T> {

	/**
	 * 字段名.
	 * 
	 * @return
	 */
	public String getFieldName();

	/**
	 * 字段标签.
	 * 
	 * @return
	 */
	public String getFieldLabel();

	/**
	 * 根据字段名获取字段标签.
	 */
	public String getFieldLabelByName(String fieldName);

	/**
	 * 字段长度.
	 */
	public int getLength();

	/**
	 * 是否可为空.
	 */
	public boolean isNullable();
}
