package com.jeefuse.base.utils.charset.ibatis;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * IBATIS 对数据库中的编码 转换.
 * 
 * @author <a href="mailto:yonclv@gmail.com">yonclv</a>
 */
public class StringTypeHandler implements TypeHandlerCallback {
	private Logger logger = LoggerFactory.getLogger(TypeHandlerCallback.class);

	public Object getResult(ResultGetter getter) throws SQLException {
		String temp = "";
		try {
			if (null != getter && null != getter.getString()) {
				temp = new String(getter.getString().getBytes("iso-8859-1"), "GBK");
				logger.debug("Get:" + getter.getString());
			}
		} catch (UnsupportedEncodingException e) {
		}
		return temp;
	}

	public void setParameter(ParameterSetter setter, Object value)
			throws SQLException {
		String s = (String) value;
		String temp = "";
		try {
			// temp = new String(s.getBytes("GBK"), "iso-8859-1");
			temp = new String(s.getBytes(), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		logger.debug("Set:" + temp);
		setter.setString(s);

	}

	public Object valueOf(String value) {
		return value;
	}
}
