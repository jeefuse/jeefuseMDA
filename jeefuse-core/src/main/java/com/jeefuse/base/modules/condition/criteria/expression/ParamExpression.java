package com.jeefuse.base.modules.condition.criteria.expression;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * 命名参数构造 .
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ParamExpression implements Expression {
	private static final long serialVersionUID = 1L;
	private final String hql;
	private final String paramName;
	private final Object value;
	private final ParamValuedType paramValueType;

	public ParamExpression(String hql, String paramName, Object value, ParamValuedType paramValueType) {
		this.hql = hql;
		this.paramName = paramName;
		this.value = value;
		this.paramValueType = paramValueType;
	}

	public String contructExpression(NamedParam paramValued) throws CriteriaQueryException {
		paramValued.populateParamAddGetParamName(paramName, value, paramValueType);
		return hql;
	}

	public boolean isCompositeExpression() {
		return false;
	}

	public String getHql() {
		return hql;
	}

	public String getParamName() {
		return paramName;
	}

	public Object getValue() {
		return value;
	}

	public ParamValuedType getParamValueType() {
		return paramValueType;
	}
}
