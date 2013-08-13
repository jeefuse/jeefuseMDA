package com.jeefuse.base.modules.condition.criteria;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.base.modules.condition.criteria.expression.CompositeExpression;
import com.jeefuse.base.modules.condition.criteria.expression.Expression;
import com.jeefuse.base.modules.condition.criteria.expression.SimpleExpression;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * 
 * 构造查询条件.
 * <p>
 * 构造查询where了句.
 * <p>
 * <strong>用法:</strong>
 * <ul>
 * 例如一个学生的实体对象,要取出其中学生年龄大于25,姓王或姓孙,且分数 大于90分的记录,构造条件如下：
 * <p>
 * Condition condition=Condition.conjunction()
 * <p>
 * .add(Restrict.gt("age", 25))
 * <p>
 * .add(Restrict.or(Restrict.startsLike("name", "王"),Restrict.startsLike("name",
 * "孙")))
 * <p>
 * .add(Restrict.ge("score", 90));
 * <p>
 * 其构造SQL(condition.toSql)结果如下：
 * <p>
 * WHERE age > :age AND (name like :name OR name like :name_1) AND score >=
 * :score
 * <p>
 * 其构造参数名值对可通过condition.getParamValuedMap()获取.
 * <p>
 * 可进行嵌套条件和关联查询.
 * </ul>
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class Condition {

	/**
	 * 查询条件为AND连接
	 * 
	 * @return
	 */
	public static Condition conjunction() {
		return new Condition(JunctionType.AND);
	}

	/**
	 * 查询条件为OR连接
	 * 
	 * @return
	 */
	public static Condition disjunction() {
		return new Condition(JunctionType.OR);
	}

	/**
	 * 查询条件为AND连接
	 * 
	 * @return
	 */
	public static Condition and() {
		return new Condition(JunctionType.AND);
	}

	/**
	 * 查询条件为OR连接
	 * 
	 * @return
	 */
	public static Condition or() {
		return new Condition(JunctionType.OR);
	}

	private NamedParam paramValued = null;
	private CompositeExpression compositeExpression = null;
	private boolean isContruct = false;
	private String contructSQL = null;

	public Condition(JunctionType junctionType) {
		this.paramValued = new NamedParam();
		this.compositeExpression = new CompositeExpression(junctionType);
	}

	/**
	 * 添加查询表达式.
	 * 
	 * @param expressions
	 */
	public Condition add(Expression... expressions) {
		compositeExpression.add(expressions);
		isContruct = false;
		return this;
	}

	public Condition add(String propertyName, Operator op, Object value, ParamValuedType paramValuedType) {
		return add(new SimpleExpression(propertyName, op, value, paramValuedType));
	}

	public Condition addIfNotBlank(String propertyName, Operator op, String value) {
		if(StringUtils.isNotBlank(value))
			return add(new SimpleExpression(propertyName, op, value,ParamValuedType.STRING));
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "=".
	 */
	public Condition addEq(final String propertyName, String value) {
		return add(Restrict.eq(propertyName, value, ParamValuedType.STRING));
	}

	/**
	 * 添加表达式,匹配操作符 "=".
	 */
	public Condition addEq(final String propertyName, Long value) {
		return add(Restrict.eq(propertyName, value, ParamValuedType.LONG));
	}

	/**
	 * 添加表达式,匹配操作符 "=".
	 */
	public Condition addEq(final ColumnField<?> columnField, String value) {
		return add(Restrict.eq(columnField.getFieldName(), value, ParamValuedType.STRING));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "=".
	 */
	public Condition addEqIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return add(Restrict.eq(propertyName, value, ParamValuedType.STRING));
		return this;
	}

	/*
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "=".
	 */
	public Condition addEqIfNotBlank(final String propertyName, Long value) {
		if (null != value)
			return addEq(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "=".
	 */
	public Condition addEqIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addEq(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "=".
	 */
	public Condition addEqIfNotBlank(String fieldName, Boolean value) {
		if (null != value)
			return addEq(fieldName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "=".
	 */
	public Condition addEq(String fieldName, Boolean value) {
		return add(Restrict.eq(fieldName, value));
	}

	/**
	 * 添加表达式,匹配操作符 ">=".
	 */
	public Condition addGe(final String propertyName, String value) {
		return add(Restrict.ge(propertyName, value, ParamValuedType.STRING));
	}

	/**
	 * 添加表达式,匹配操作符 ">=".
	 */
	public Condition addGe(final String propertyName, long value) {
		return add(Restrict.ge(propertyName, value, ParamValuedType.LONG));
	}

	/**
	 * 添加表达式,匹配操作符 ">=".
	 */
	public Condition addGe(final String propertyName, Date value) {
		return add(Restrict.ge(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 ">=".
	 */
	public Condition addGe(final ColumnField<?> columnField, String value) {
		return add(Restrict.ge(columnField.getFieldName(), value, ParamValuedType.STRING));
	}

	/**
	 * 添加表达式,匹配操作符 ">=".
	 */
	public Condition addGe(final ColumnField<?> columnField, long value) {
		return add(Restrict.ge(columnField.getFieldName(), value, ParamValuedType.LONG));
	}


	/**
	 * 添加表达式,匹配操作符 ">=".
	 */
	public Condition addGe(final ColumnField<?> columnField, Date value) {
		return add(Restrict.ge(columnField.getFieldName(), value));
	}

	/**
	 * 添加表达式,匹配操作符 ">=".
	 */
	public Condition addGeIfNotBlank(final ColumnField<?> columnField, Date value) {
		return add(Restrict.ge(columnField.getFieldName(), value));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 ">=".
	 */
	public Condition addGeIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addGe(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 ">=".
	 */
	public Condition addGeIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addGe(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 ">".
	 */
	public Condition addGt(final String propertyName, String value) {
		return add(Restrict.gt(propertyName, value, ParamValuedType.STRING));
	}

	public Condition addGt(final String propertyName, long value) {
		return add(Restrict.gt(propertyName, value, ParamValuedType.LONG));
	}

	/**
	 * 添加表达式,匹配操作符 ">".
	 */
	public Condition addGt(final ColumnField<?> columnField, String value) {
		return add(Restrict.gt(columnField.getFieldName(), value, ParamValuedType.STRING));
	}

	/**
	 * 添加表达式,匹配操作符 ">".
	 */
	public Condition addGt(final ColumnField<?> columnField, long value) {
		return add(Restrict.gt(columnField.getFieldName(), value, ParamValuedType.LONG));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 ">".
	 */
	public Condition addGtIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addGt(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 ">".
	 */
	public Condition addGtIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addGt(columnField.getFieldName(), value);
		return this;
	}

/**
	 * 添加表达式,匹配操作符  "<".
	 */
	public Condition addLt(final String propertyName, String value) {
		return add(Restrict.lt(propertyName, value, ParamValuedType.STRING));
	}

/**
	 * 添加表达式,匹配操作符  "<".
	 */
	public Condition addLt(final String propertyName, long value) {
		return add(Restrict.lt(propertyName, value, ParamValuedType.LONG));
	}

/**
	 * 添加表达式,匹配操作符  "<".
	 */
	public Condition addLt(final ColumnField<?> columnField, String value) {
		return add(Restrict.lt(columnField.getFieldName(), value, ParamValuedType.STRING));
	}


/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符  "<".
	 */
	public Condition addLtIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addLt(propertyName, value);
		return this;
	}

/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符  "<".
	 */
	public Condition addLtIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addLt(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "<=".
	 */
	public Condition addLe(final String propertyName, String value) {
		return add(Restrict.le(propertyName, value, ParamValuedType.STRING));
	}

	/**
	 * 添加表达式,匹配操作符 "<=".
	 */
	public Condition addLe(final String propertyName, long value) {
		return add(Restrict.le(propertyName, value, ParamValuedType.LONG));
	}

	/**
	 * 添加表达式,匹配操作符 "<=".
	 */
	public Condition addLe(final String propertyName, Date value) {
		return add(Restrict.le(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 "<=".
	 */
	public Condition addLe(final ColumnField<?> columnField, String value) {
		return add(Restrict.le(columnField.getFieldName(), value, ParamValuedType.STRING));
	}

	/**
	 * 添加表达式,匹配操作符 "<=".
	 */
	public Condition addLe(final ColumnField<?> columnField, long value) {
		return add(Restrict.le(columnField.getFieldName(), value, ParamValuedType.LONG));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "<=".
	 */
	public Condition addLeIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addLe(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "<=".
	 */
	public Condition addLeIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addLe(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "<>".
	 */
	public Condition addne(final String propertyName, String value) {
		return add(Restrict.ne(propertyName, value, ParamValuedType.STRING));
	}

	/**
	 * 添加表达式,匹配操作符 "<>".
	 */
	public Condition addne(final ColumnField<?> columnField, long value) {
		return add(Restrict.ne(columnField.getFieldName(), value, ParamValuedType.LONG));
	}

	/**
	 * 添加表达式,匹配操作符 "<>".
	 */
	public Condition addneIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addne(propertyName, value);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "<>".
	 */
	public Condition addneIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addne(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,若较小的不为空则添加<=lessValue,若较大的不为空则添加>=moreValue.
	 */
	public Condition addCompareIfNotBlank(final String propertyName, String lessValue, String moreValue) {
		if (!StringUtils.isBlank(lessValue)) {
			addGe(propertyName, lessValue);
		}
		if (!StringUtils.isBlank(moreValue)) {
			addLe(propertyName, moreValue);
		}
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,若较小的不为空则添加<=lessValue,若较大的不为空则添加>=moreValue.
	 */
	public Condition addCompareIfNotBlank(final ColumnField<?> columnField, String lessValue, String moreValue) {
		if (!StringUtils.isBlank(lessValue)) {
			addGe(columnField.getFieldName(), lessValue);
		}
		if (!StringUtils.isBlank(moreValue)) {
			addLe(columnField.getFieldName(), moreValue);
		}
		return this;
	}

	/**
	 * 如果两个属性值都不为空(空格作空处理).则添加表达式,匹配操作符 "betweeen".
	 */
	public Condition addBetweenIfNotNull(final String propertyName, Object value1, Object value2) {
		if (null != value1 && null != value2)
			return addBetweeen(propertyName, value1, value2);
		return this;
	}

	/**
	 * 如果两个属性值都不为空(空格作空处理).则添加表达式,匹配操作符 "betweeen".
	 */
	public Condition addBetweenIfNotNull(final ColumnField<?> columnField, Object value1, Object value2) {
		if (null != value1 && null != value2)
			return addBetweeen(columnField.getFieldName(), value1, value2);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "betweeen".
	 */
	public Condition addBetweeen(final String propertyName, Object value1, Object value2) {
		return add(Restrict.between(propertyName, value1, value2));
	}

	/**
	 * 添加表达式,匹配操作符 "betweeen".
	 */
	public Condition addBetweeen(final ColumnField<?> columnField, Object value1, Object value2) {
		return add(Restrict.between(columnField.getFieldName(), value1, value2));
	}

	/**
	 * 添加表达式,匹配操作符 "in".
	 */
	public Condition addin(final String propertyName, Object[] value) {
		return add(Restrict.in(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 "in".
	 */
	public Condition addin(final ColumnField<?> columnField, Object[] value) {
		return add(Restrict.in(columnField.getFieldName(), value));
	}

	/**
	 * 添加表达式,匹配操作符 "in".
	 */
	public Condition addin(final String propertyName, Collection<String> values) {
		return add(Restrict.in(propertyName, values));
	}

	/**
	 * 添加表达式,匹配操作符 "in".
	 */
	public Condition addin(final ColumnField<?> columnField, Collection<String> values) {
		return add(Restrict.in(columnField.getFieldName(), values));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "in".
	 */
	public Condition addInIfNotBlank(final String propertyName, Object[] value) {
		if (null != value && value.length > 0) {
			addin(propertyName, value);
		}
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "in".
	 */
	public Condition addInIfNotBlank(final ColumnField<?> columnField, Object[] value) {
		if (null != value && value.length > 0) {
			addin(columnField.getFieldName(), value);
		}
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "not in".
	 */
	public Condition addNotin(final String propertyName, Object[] value) {
		return add(Restrict.notIn(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 "not in".
	 */
	public Condition addNotin(final ColumnField<?> columnField, Object[] value) {
		return add(Restrict.notIn(columnField.getFieldName(), value));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "in".
	 */
	public Condition addNotinIfNotBlank(final String propertyName, Object[] value) {
		if (null != value && value.length > 0) {
			addNotin(propertyName, value);
		}
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "in".
	 */
	public Condition addNotinIfNotBlank(final ColumnField<?> columnField, Object[] value) {
		if (null != value && value.length > 0) {
			addNotin(columnField.getFieldName(), value);
		}
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "null".
	 */
	public Condition addNull(final String propertyName) {
		return add(Restrict.isNull(propertyName));
	}

	/**
	 * 添加表达式,匹配操作符 "null".
	 */
	public Condition addNull(final ColumnField<?> columnField) {
		return add(Restrict.isNull(columnField.getFieldName()));
	}

	/**
	 * 添加表达式,匹配操作符 "propertyName is not null".
	 */
	public Condition addNotNull(final String propertyName) {
		return add(Restrict.isNotNull(propertyName));
	}

	/**
	 * 添加表达式,匹配操作符 "propertyName is not null".
	 */
	public Condition addNotNull(final ColumnField<?> columnField) {
		return add(Restrict.isNotNull(columnField.getFieldName()));
	}

	/**
	 * 添加表达式,匹配操作符 "like".
	 */
	public Condition addLike(final String propertyName, String value) {
		return add(Restrict.like(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 "like".
	 */
	public Condition addLike(final ColumnField<?> columnField, String value) {
		return add(Restrict.like(columnField.getFieldName(), value));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like".
	 */
	public Condition addLikeIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addLike(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like".
	 */
	public Condition addLikeIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addLike(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "like '"+value+"%'".
	 */
	public Condition addStartsLike(final String propertyName, String value) {
		return add(Restrict.startsLike(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 "like '"+value+"%'".
	 */
	public Condition addStartsLike(final ColumnField<?> columnField, String value) {
		return add(Restrict.startsLike(columnField.getFieldName(), value));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like '"+value+"%'".
	 */
	public Condition addStartsLikeIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addStartsLike(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like '"+value+"%'".
	 */
	public Condition addStartsLikeIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addStartsLike(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "like "'%"+value+"'".
	 */
	public Condition addEndsLike(final String propertyName, String value) {
		return add(Restrict.endsLike(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 "like "'%"+value+"'".
	 */
	public Condition addEndsLike(final ColumnField<?> columnField, String value) {
		return add(Restrict.endsLike(columnField.getFieldName(), value));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like "'%"+value+"'".
	 */
	public Condition addEndsLikeIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addEndsLike(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like "'%"+value+"'".
	 */
	public Condition addEndsLikeIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addEndsLike(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 添加表达式,匹配操作符 "like "'%"+value+"%'".
	 */
	public Condition addContainsLike(final String propertyName, String value) {
		return add(Restrict.containsLike(propertyName, value));
	}

	/**
	 * 添加表达式,匹配操作符 "like "'%"+value+"%'".
	 */
	public Condition addContainsLike(final ColumnField<?> columnField, String value) {
		return add(Restrict.containsLike(columnField.getFieldName(), value));
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like "'%"+value+"%'".
	 */
	public Condition addContainsLikeIfNotBlank(final String propertyName, String value) {
		if (!StringUtils.isBlank(value))
			return addContainsLike(propertyName, value);
		return this;
	}

	/**
	 * 如果属性值不为空(空格作空处理).则添加表达式,匹配操作符 "like "'%"+value+"%'".
	 */
	public Condition addContainsLikeIfNotBlank(final ColumnField<?> columnField, String value) {
		if (!StringUtils.isBlank(value))
			return addContainsLike(columnField.getFieldName(), value);
		return this;
	}

	/**
	 * 添加查询表达式.表达式之间使用AND连接,
	 * 
	 * @param expressions
	 */
	public Condition and(Expression expression1, Expression expression2, Expression... moreExpressions) {
		compositeExpression.add(Restrict.and(expression1, expression2, moreExpressions));
		isContruct = false;
		return this;
	}

	/**
	 * 添加查询表达式.表达式之间使用OR连接,
	 * 
	 * @param expressions
	 */
	public Condition or(Expression expression1, Expression expression2, Expression... moreExpressions) {
		compositeExpression.add(Restrict.or(expression1, expression2, moreExpressions));
		isContruct = false;
		return this;
	}

	/**
	 * 构造表达式.
	 * 
	 * @return
	 */
	private void contructExpress() {
		if (null != compositeExpression && compositeExpression.getExpressionList().size() > 0) {
			contructSQL = compositeExpression.contructExpression(paramValued);
		}
		isContruct = true;
	}

	/**
	 * 获取添加的命名参数与值对
	 * 
	 * @return
	 */
	public List<ParamValuedPair> getParamValuedMap() {
		if (!isContruct) {
			contructExpress();
		}
		return paramValued.getParamValuedList();
	}

	/**
	 * 如果之前已经构造,将直接返回已构造的语句。 表达式生成查询
	 * SQL语句,相关命名参数配置在paramValuedMap中,您可通过本对象的getParamValuedMap()方法获得.
	 * 
	 * @return
	 */
	public String toSql() throws CriteriaQueryException {
		if (!isContruct) {
			contructExpress();
		}
		return contructSQL;
	}

	/**
	 * 构造条件语名是否为空.
	 */
	public boolean isEmpty() {
		if (null != compositeExpression && compositeExpression.getExpressionList().size() > 0)
			return false;
		return true;
	}

}
