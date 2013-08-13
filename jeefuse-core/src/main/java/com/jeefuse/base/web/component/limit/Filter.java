package com.jeefuse.base.web.component.limit;

import java.io.Serializable;

/**
 * 属性过滤.
 * 
 * @author yonclv
 * @created 2009-7-23
 */
@SuppressWarnings("serial")
public class Filter implements Serializable, Comparable<Filter> {
	/**
	 * 多个属性间OR关系的分隔符.
	 */
	public static final String OR_SEPARATOR = "|";

	private int position = 0;
	private String propertyName;
	private String value;
	private MatchType matchType = MatchType.LIKESTART;

	/**
	 * 属性过滤.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @param matchType
	 *            匹配类型
	 */
	public Filter(final String propertyName, final String value,
			final MatchType matchType) {
		this.propertyName = propertyName;
		this.value = value;
		this.matchType = matchType;
	}

	/**
	 * 属性过滤.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @param matchType
	 *            匹配类型
	 * @param position
	 *            位置
	 */
	public Filter(final String propertyName, final String value,
			final MatchType matchType, int position) {
		this.propertyName = propertyName;
		this.value = value;
		this.matchType = matchType;
		this.position = position;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	/**
	 * 获取属性名.
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * 设置属性名.
	 */
	public void setPropertyName(final String propertyName) {
		this.propertyName = propertyName;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * 比较排序位置,小于返回"-1",相等返回"0",大于返回"1";
	 * 
	 * @param sort
	 * @return
	 */
	public int compareTo(Filter filter) {
		if (this.getPosition() < filter.getPosition()) {
			return -1;
		}

		if (this.getPosition() == filter.getPosition()) {
			return 0;
		}

		return 1;
	}
}
