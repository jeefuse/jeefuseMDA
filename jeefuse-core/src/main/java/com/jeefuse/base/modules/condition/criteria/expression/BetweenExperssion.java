package com.jeefuse.base.modules.condition.criteria.expression;

import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.criteria.Operator;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class BetweenExperssion implements Expression {
	private static final long serialVersionUID = -739545989034338954L;
	private final String propertyName;
	private final Object lo;
	private final Object hi;

	public BetweenExperssion(String propertyName, Object lo, Object hi) {
		this.propertyName = propertyName;
		this.lo = lo;
		this.hi = hi;
	}

	@Override
	public String toString() {
		return propertyName + " between " + lo + " and " + hi;
	}

	public String contructExpression(NamedParam paramValued)
			throws CriteriaQueryException {
		String loNamed = paramValued.populateParamAddGetParamName(propertyName, lo, ParamValuedType.OBJECT);
		String hiNamed = paramValued.populateParamAddGetParamName(propertyName, hi, ParamValuedType.OBJECT);
		return propertyName+" "+Operator.BETWEEN.toParam()+" :" + loNamed + " "+Operator.AND+" :" + hiNamed;
	}

	public boolean isCompositeExpression() {

		return false;
	}

}
