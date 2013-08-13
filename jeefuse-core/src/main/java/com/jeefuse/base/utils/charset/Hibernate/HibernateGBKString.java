package com.jeefuse.base.utils.charset.Hibernate;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * 用于 Hibernate 对数据库中的编码 'iso-8859-1' 转换为 'GBK'.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class HibernateGBKString implements UserType {

	public HibernateGBKString() {
		super();
	}

	public int[] sqlTypes() {
		return new int[] { oracle.jdbc.OracleTypes.VARCHAR };
	}

	@SuppressWarnings("unchecked")
	public Class returnedClass() {
		return String.class;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return (x == y) || (x != null && y != null && (x.equals(y)));
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		String val = rs.getString(names[0]);
		if (null == val) {
			return null;
		} else {
			try {
				val = new String(val.getBytes("iso-8859-1"), "GBK");
			} catch (UnsupportedEncodingException e) {
				throw new HibernateException(e.getMessage());
			}
			return val;
		}
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, oracle.jdbc.OracleTypes.VARCHAR);
		} else {
			String val = (String) value;
			try {
				val = new String(val.getBytes("GBK"), "iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				throw new HibernateException(e.getMessage());
			}
			st.setObject(index, val, oracle.jdbc.OracleTypes.VARCHAR);
		}
	}

	public Object deepCopy(Object value) throws HibernateException {
		if (value == null)
			return null;
		return new String((String) value);
	}

	public boolean isMutable() {
		return false;
	}

	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public int hashCode(Object arg0) throws HibernateException {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
