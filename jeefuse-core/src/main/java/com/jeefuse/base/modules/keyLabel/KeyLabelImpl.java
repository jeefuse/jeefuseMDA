package com.jeefuse.base.modules.keyLabel;


/**
 * 显示key:label.常用于枚举类或需要显示键值对时,如radio,checkbox,select等.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class KeyLabelImpl implements KeyLabel {

	private String key;
	private String label;

	public KeyLabelImpl(String key, String label) {
		this.key = key;
		this.label = label;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
