package com.jeefuse.base.model.userType;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;


public class StringClobType implements UserType
{
	  public int[] sqlTypes()
	    {
	        return new int[] { Types.CLOB };
	    }

	    @SuppressWarnings("unchecked")
		public Class returnedClass()
	    {
	        return String.class;
	    }

	    public boolean equals(Object x, Object y)
	    {
	        return (x == y)
	            || (x != null
	                && y != null
	                && (x.equals(y)));
	    }

	    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
	        throws HibernateException, SQLException
	    {
	        Clob clob = rs.getClob(names[0]);
	       // return clob.getSubString(1, (int) clob.length());
			if (null == clob) {
				return null;
			} else {
				String val=clob.getSubString(1, (int) clob.length());
				try {
					val = new String(val.getBytes("iso-8859-1"), "GBK");
				} catch (UnsupportedEncodingException e) {
					throw new HibernateException(e.getMessage());
				}
				return val;
			}
	    }

	    public void nullSafeSet(PreparedStatement st, Object value, int index)
	        throws HibernateException, SQLException
	    {
        st.setClob(index, Hibernate.createClob((String) value));
//			if (value == null) {
//				st.setNull(index, oracle.jdbc.OracleTypes.CLOB);
//			} else {
//				String val = (String) value;
//				try {
//					val = new String(val.getBytes("GBK"), "iso-8859-1");
//				} catch (UnsupportedEncodingException e) {
//					throw new HibernateException(e.getMessage());
//				}
//				st.setClob(index,clob);
//			}
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
