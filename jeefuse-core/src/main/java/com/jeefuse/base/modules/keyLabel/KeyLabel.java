package com.jeefuse.base.modules.keyLabel;

/**
 * 显示key:label.常用于枚举类或需要显示键值对时,如radio,checkbox,select等.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface KeyLabel {

	/**
	 * @return the key
	 */
	public String getKey();

	/**
	 * @return the label
	 */
	public String getLabel();

}
