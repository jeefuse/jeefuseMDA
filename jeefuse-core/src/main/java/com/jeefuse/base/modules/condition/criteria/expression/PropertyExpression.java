package com.jeefuse.base.modules.condition.criteria.expression;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class PropertyExpression implements Expression {
	private static final long serialVersionUID = 8891320838876385650L;
	private final String propertyName;
	private final String otherPropertyName;
    private final String op;

	public PropertyExpression(String propertyName, String otherPropertyName,
			String op) {
		this.propertyName = propertyName;
		this.otherPropertyName = otherPropertyName;
		this.op = op;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getOtherPropertyName() {
		return otherPropertyName;
	}

	public String getOp() {
		return op;
	}

	public String contructExpression(NamedParam paramValued)
			throws CriteriaQueryException {
		return propertyName +" "+this.op+" "+otherPropertyName;
	}

	public boolean isCompositeExpression() {

		return false;
	}

}
