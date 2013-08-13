package com.jeefuse.base.modules.condition;

import com.jeefuse.base.model.parse.ColumnField;

/**
 * 简单SQL语句拼装.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class SqlBuilder {
	public static final String blank = " ";
	public static final String SELECT = "SELECT";
	public static final String WHERE = "WHERE";
	public static final String ORDER_BY = "ORDER BY";
	public static final String FROM = "FROM";
	public static final String DELETE = "DELETE";
	public static final String UPDATE = "UPDATE";

	/**
	 * 创建SqlBuilder实例.
	 */
	static public final SqlBuilder INSTANCE() {
		return new SqlBuilder();
	}

	/**
	 * 创建SqlBuilder实例.
	 */
	static public final SqlBuilder INSTANCE(int capacity) {
		return new SqlBuilder(capacity);
	}

	private SqlBuilder() {
		builder = new StringBuilder(100);
	}

	public SqlBuilder(int capacity) {
		builder = new StringBuilder(capacity);
	}

	/**
	 * add any sql.
	 */
	public SqlBuilder append(String text) {
		if (text != null) {
			builder.append(text);
		}
		return this;
	}

	/**
	 * add select Field<code>...</code>.
	 */
	public SqlBuilder field(ColumnField<?>... columnFields) {
		for (ColumnField<?> columnField : columnFields) {
			blank();
			builder.append(columnField.getFieldName());
		}
		return this;
	}

	/**
	 * add select Field.
	 */
	public SqlBuilder field(String... fields) {
		for (String field : fields) {
			blank();
			builder.append(field);
		}
		return this;
	}

	/**
	 * add select Field with alias.
	 */
	public SqlBuilder fieldWithAlias(String field, String alias) {
		blank();
		builder.append(field);
		blank();
		builder.append(alias);
		return this;
	}

	/**
	 * add space ' '.
	 */
	public SqlBuilder blank() {
		builder.append(blank);
		return this;
	}

	/**
	 * 'SELECT' clause.
	 */
	public SqlBuilder select() {
		builder.append(SELECT);
		return this;
	}

	/**
	 * 'UPDATE' clause.
	 */
	public SqlBuilder update() {
		builder.append(UPDATE);
		return this;
	}

	/**
	 * 'DELETE' clause.
	 */
	public SqlBuilder delete() {
		builder.append(DELETE);
		return this;
	}

	/**
	 * add ' FROM' clause.
	 */
	public SqlBuilder from() {
		builder.append(FROM);
		return this;
	}

	/**
	 * add ' FROM '+text clause.
	 */
	public SqlBuilder from(String text) {
		builder.append(FROM);
		builder.append(text);
		return this;
	}

	/**
	 * add ' WHERE' clause.
	 */
	public SqlBuilder where() {
		builder.append(WHERE);
		return this;
	}

	/**
	 * add ' ORDER BY' clause.
	 */
	public SqlBuilder orderBy() {
		builder.append(ORDER_BY);
		return this;
	}

	@Override
	public String toString() {
		return builder.toString();
	}

	private StringBuilder builder;
}
