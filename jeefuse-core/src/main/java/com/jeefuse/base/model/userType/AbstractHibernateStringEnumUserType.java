package com.jeefuse.base.model.userType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;


/**
 * hibernate用户自定义的Varchar枚举映射类型.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class AbstractHibernateStringEnumUserType<T extends EnumStringValue> implements UserType {

	private Class<T> clazz = null;

	private static final int[] SQL_TYPES = { Types.VARCHAR };

	/** 告诉Hibernate要使用什么SQL列类型生成DDL */
	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	/**
	 * @param c
	 *            用来映射的数据类型
	 */
	public AbstractHibernateStringEnumUserType(Class<T> c) {
		this.clazz = c;
	}

	/**
	 * 告诉Hibernate这个UserType用来映射的数据类型
	 */
	public Class<T> returnedClass() {
		return clazz;
	}

	/*
	 * 用于Hibernate缓存生成的快照.
	 */
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	/*
	 * 类型是否可变.
	 */
	public boolean isMutable() {
		return false;
	}

	/*
	 * 从二级缓存中取这个对象数据时要调用的方法
	 */
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	/*
	 * hibernate把这个数据放入二级缓存时要调用的方法
	 */
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	/*
	 * 处理脱管对象状态的合并.
	 */
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return x == y;
	}

	/** 从JDBC的ResultSet读取属性值。这个方法是在从数据库查询数据时用到。 */
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		String name = rs.getString(names[0]);
		return instanceOfValue(name);
	}

	/** 将属性的值设置到PreparedStatement。 */
	@SuppressWarnings("unchecked")
	public void nullSafeSet(PreparedStatement ps, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			ps.setNull(index, Types.VARCHAR);
		} else {
			ps.setString(index, ((T) value).getValue());
		}
	}

	/**
	 * 获取值为value的对象实例.
	 */
	protected abstract T instanceOfValue(String value);
}
