package com.jeefuse.base.modules.condition.criteria;

import java.util.Collection;
import java.util.Date;

import com.jeefuse.base.modules.condition.criteria.expression.BetweenExperssion;
import com.jeefuse.base.modules.condition.criteria.expression.CompositeExpression;
import com.jeefuse.base.modules.condition.criteria.expression.DateExpression;
import com.jeefuse.base.modules.condition.criteria.expression.Expression;
import com.jeefuse.base.modules.condition.criteria.expression.InCollectionExpression;
import com.jeefuse.base.modules.condition.criteria.expression.InExpression;
import com.jeefuse.base.modules.condition.criteria.expression.NotInExpression;
import com.jeefuse.base.modules.condition.criteria.expression.NotNullExpression;
import com.jeefuse.base.modules.condition.criteria.expression.NullExpression;
import com.jeefuse.base.modules.condition.criteria.expression.PropertyExpression;
import com.jeefuse.base.modules.condition.criteria.expression.SimpleExpression;
import com.jeefuse.base.modules.condition.util.MatchLike;

/**
 * 通用表达式构造.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public class Restrict {

	/**
	 * 等于 e.g "="
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression eq(final String propertyName, final Boolean value) {
		return new SimpleExpression(propertyName, Operator.EQ, value, ParamValuedType.BOOLEAN);
	}

	/**
	 * 等于 e.g "="
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression eq(final String propertyName, final String value) {
		return new SimpleExpression(propertyName, Operator.EQ, value, ParamValuedType.STRING);
	}

	/**
	 * 等于 e.g "="
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression eq(final String propertyName, final Object value, ParamValuedType paramValuedType) {
		return new SimpleExpression(propertyName, Operator.EQ, value, paramValuedType);
	}

	/**
	 * 等于 e.g "="
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression eq(final String propertyName, final Date value) {
		return new DateExpression(propertyName, Operator.EQ, value);
	}

	/**
	 * 不等于 e.g "<>"
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression ne(final String propertyName, final Object value, ParamValuedType paramValuedType) {
		return new SimpleExpression(propertyName, Operator.NE, value, paramValuedType);
	}

	/**
	 * 大于 e.g ">"
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression gt(final String propertyName, final Object value, ParamValuedType paramValuedType) {
		return new SimpleExpression(propertyName, Operator.GT, value, paramValuedType);
	}

	/**
	 * 大于 e.g ">"
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression gt(final String propertyName, final long value) {
		return new SimpleExpression(propertyName, Operator.GT, value, ParamValuedType.LONG);
	}

	/**
	 * 大于等于 e.g ">="
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression ge(final String propertyName, final Object value, ParamValuedType paramValuedType) {
		return new SimpleExpression(propertyName, Operator.GE, value, paramValuedType);
	}

	/**
	 * 大于等于 e.g ">="
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression ge(final String propertyName, final Date value) {
		return new DateExpression(propertyName, Operator.GE, value);
	}

	/**
	 * 大于等于 e.g ">="
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression ge(final String propertyName, final long value) {
		return new SimpleExpression(propertyName, Operator.GE, value, ParamValuedType.LONG);
	}

	/**
	 * 小于 e.g "<"
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression lt(final String propertyName, final Object value, ParamValuedType paramValuedType) {
		return new SimpleExpression(propertyName, Operator.LT, value, paramValuedType);
	}

	/**小于 e.g "<"
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression lt(final String propertyName, final Date value) {
		return new DateExpression(propertyName, Operator.LT, value);
	}

	/**
	 * 小于等于 e.g "<="
	 * 
	 * @param propertyName
	 * @param alias
	 * @param value
	 * @return
	 */
	public static Expression le(final String propertyName, final Object value, ParamValuedType paramValuedType) {
		return new SimpleExpression(propertyName, Operator.LE, value, paramValuedType);
	}

	/**
	 * 小于等于 e.g "<="
	 * 
	 * @param propertyName
	 * @param alias
	 * @param value
	 * @return
	 */
	public static Expression le(final String propertyName, final Date value) {
		return new DateExpression(propertyName, Operator.LE, value);
	}

	/**
	 * propertyName is null
	 * 
	 * @param propertyName
	 * @return
	 */
	public static Expression isNull(final String propertyName) {
		return new NullExpression(propertyName);
	}

	/**
	 * propertyName is not null
	 * 
	 * @param propertyName
	 * @return
	 */
	public static Expression isNotNull(String propertyName) {
		return new NotNullExpression(propertyName);
	}

	/**
	 * in (values)
	 * 
	 * @param name
	 * @param values
	 * @return
	 */
	public static Expression in(final String name, final Object[] values) {
		return new InExpression(name, values);
	}

	/**
	 * in (values)
	 * 
	 * @param name
	 * @param values
	 * @return
	 */
	public static Expression in(final String name, final Collection<String> values) {
		return new InCollectionExpression(name, values);
	}

	/**
	 * not in (values)
	 * 
	 * @param propertyName
	 * @param values
	 * @return
	 */
	public static Expression notIn(String propertyName, final Object[] values) {
		return new NotInExpression(propertyName, values);
	}

	/**
	 * not in (values)
	 * 
	 * @param propertyName
	 * @param values
	 * @return
	 */
	public static Expression notIn(final String propertyName, final Collection<?> values) {
		return new NotInExpression(propertyName, values.toArray());
	}

	/**
	 * between value1 and value2
	 * 
	 * @param propertyName
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Expression between(final String propertyName, final Object value1, final Object value2) {
		return new BetweenExperssion(propertyName, value1, value2);
	}

	/**
	 * propertyName like value
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression like(final String propertyName, final String value) {
		return new SimpleExpression(propertyName, Operator.LIKE, MatchLike.toMatchExact(value), ParamValuedType.STRING);
	}

	/**
	 * propertyName like "'"+value+"%'".
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression startsLike(final String propertyName, String value) {
		return new SimpleExpression(propertyName, Operator.LIKE, MatchLike.toMatchStart(value), ParamValuedType.STRING);
	}

	/**
	 * propertyName like "'%"+value+"'".
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression endsLike(final String propertyName, String value) {
		return new SimpleExpression(propertyName, Operator.LIKE, MatchLike.toMatchEnd(value), ParamValuedType.STRING);
	}

	/**
	 * propertyName like "'%"+value+"%'".
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static Expression containsLike(final String propertyName, String value) {
		return new SimpleExpression(propertyName, Operator.LIKE, MatchLike.toMatchAnyWhere(value), ParamValuedType.STRING);
	}

	/**
	 * 自定义 propertyName op value
	 * 
	 * @param propertyName
	 * @param op
	 * @param value
	 * @return
	 */
	public static Expression custom(final String propertyName, final Operator op, final Object value, ParamValuedType paramValuedType) {
		return new SimpleExpression(propertyName, op, value, paramValuedType);
	}

	/**
	 * 比较属性 等于
	 * 
	 * @param propertyName
	 * @param otherPropertyName
	 * @return
	 */
	public static PropertyExpression eqProperty(String propertyName, String otherPropertyName) {
		return new PropertyExpression(propertyName, otherPropertyName, Operator.EQ.toParam());
	}

	/**
	 * 比较属性 不等于
	 * 
	 * @param propertyName
	 * @param otherPropertyName
	 * @return
	 */
	public static PropertyExpression neProperty(String propertyName, String otherPropertyName) {
		return new PropertyExpression(propertyName, otherPropertyName, Operator.NE.toParam());
	}

	/**
	 * 比较属性 小于
	 * 
	 * @param propertyName
	 * @param otherPropertyName
	 * @return
	 */
	public static PropertyExpression ltProperty(String propertyName, String otherPropertyName) {
		return new PropertyExpression(propertyName, otherPropertyName, Operator.LT.toParam());
	}

	/**
	 * 比较属性 小于等于
	 * 
	 * @param propertyName
	 * @param otherPropertyName
	 * @return
	 */
	public static PropertyExpression leProperty(String propertyName, String otherPropertyName) {
		return new PropertyExpression(propertyName, otherPropertyName, Operator.LE.toParam());
	}

	/**
	 * 比较属性 大于
	 * 
	 * @param propertyName
	 * @param otherPropertyName
	 * @return
	 */
	public static PropertyExpression gtProperty(String propertyName, String otherPropertyName) {
		return new PropertyExpression(propertyName, otherPropertyName, Operator.GT.toParam());
	}

	/**
	 * 比较属性 大于等于
	 * 
	 * @param propertyName
	 * @param otherPropertyName
	 * @return
	 */
	public static PropertyExpression geProperty(String propertyName, String otherPropertyName) {
		return new PropertyExpression(propertyName, otherPropertyName, Operator.GE.toParam());
	}

	/**
	 * OR表达式组合
	 * 
	 * @param expressions
	 * @return
	 */
	public static Expression or(Expression expression1, Expression expression2, Expression... moreExpressions) {
		return new CompositeExpression(JunctionType.OR, expression1, expression2, moreExpressions);
	}

	/**
	 * AND表达式组合
	 * 
	 * @param expressions
	 * @return
	 */
	public static Expression and(Expression expression1, Expression expression2, Expression... moreExpressions) {
		return new CompositeExpression(JunctionType.AND, expression1, expression2, moreExpressions);
	}
}
