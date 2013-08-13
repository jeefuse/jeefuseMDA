package com.jeefuse.base.modules.condition.criteria.expression;

import java.util.Date;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * 日期表达式.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public class DateExpression implements Expression {
	private static final long serialVersionUID = 6027755082427066136L;
	private final String propertyName;
	private final Date value;
	private final Operator op;

	public DateExpression(String propertyName, Operator op, Date value) {
		this.propertyName = propertyName;
		this.value = value;
		this.op = op;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public Date getValue() {
		return value;
	}

	public Operator getOp() {
		return op;
	}

	public String contructExpression(NamedParam paramValued) throws CriteriaQueryException {
		// 取得命名参数
		String paramNamed = paramValued.populateParamAddGetParamName(propertyName, value, ParamValuedType.TIMESTAMP);
		return propertyName + " " + this.op.toParam() + " :" + paramNamed;
	}

	public boolean isCompositeExpression() {
		return false;
	}

}
