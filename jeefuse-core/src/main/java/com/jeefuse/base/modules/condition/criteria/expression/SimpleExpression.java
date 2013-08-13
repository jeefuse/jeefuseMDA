package com.jeefuse.base.modules.condition.criteria.expression;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class SimpleExpression implements Expression {
	private static final long serialVersionUID = 6027755082427066136L;
	private final String propertyName;
	private final Object value;
	private final Operator op;
	private final ParamValuedType paramValuedType;


	public SimpleExpression(String propertyName, Operator op, Object value, ParamValuedType paramValuedType) {
		this.propertyName = propertyName;
		this.value = value;
		this.op = op;
		this.paramValuedType = paramValuedType;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public Object getValue() {
		return value;
	}

	public Operator getOp() {
		return op;
	}

	public String contructExpression(NamedParam paramValued) throws CriteriaQueryException {
		// 取得命名参数
		String paramNamed = paramValued.populateParamAddGetParamName(propertyName, value, paramValuedType);
		return propertyName + " " + this.op.toParam() + ":" + paramNamed;
	}

	public boolean isCompositeExpression() {

		return false;
	}

}
