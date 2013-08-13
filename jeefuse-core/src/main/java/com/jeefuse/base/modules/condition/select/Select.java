package com.jeefuse.base.modules.condition.select;

import com.jeefuse.base.modules.condition.criteria.Criteria;

/**
 * 查询字段
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public class Select implements Criteria {

	private static final long serialVersionUID = 6291635523698131338L;

	/**
	 * 选取多个字段
	 * 
	 * @param selects
	 * @return
	 */
	public static Select[] selects(Select... selects) {
		return selects;
	}

	/**
	 * 选取字段
	 * 
	 * @param name
	 *            选取属性名
	 * @return
	 */
	public static Select select(String name) {
		return new Select(name);
	}

	/**
	 * 选取字段
	 * 
	 * @param name
	 *            选取属性名
	 * @param alias
	 *            别名
	 * @return
	 */
	public static Select select(String name, String alias) {
		return new Select(name, alias);
	}

	/**
	 * 选取distinct字段
	 * 
	 * @param name
	 *            字段名
	 * @param distinct
	 *            是否唯一
	 * @param alias
	 *            别名
	 * @return
	 */
	public static Select select(String name, String alias, boolean distinct) {
		return new Select(name, alias, distinct);
	}

	private boolean distinct = false;
	private String name;
	private String alias = null;

	public Select(String name) {
		this.distinct = false;
		this.name = name;
	}

	public Select(String name, String alias) {
		this.distinct = false;
		this.name = name;
		this.alias = alias;
	}

	public Select(String name, String alias, boolean distinct) {
		this.distinct = distinct;
		this.name = name;
		this.alias = alias;
	}

	public String toSql() {
		if (null == alias)
			return !distinct ? name : "distinct " + name;
		return !distinct ? name + " " + alias : "distinct " + name + " " + alias;
	}

	@Override
	public String toString() {
		return String.format("Select %s %s", this.name, this.distinct);
	}
}
