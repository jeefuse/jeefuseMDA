package com.jeefuse.base.modules.condition.criteria.expression;

import java.util.ArrayList;
import java.util.List;

import com.jeefuse.base.modules.condition.criteria.JunctionType;
import com.jeefuse.base.modules.condition.criteria.NamedParam;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**
 * 复杂表达式构造.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
public class CompositeExpression implements Expression {
	private static final long serialVersionUID = -3398241461382759112L;
	private List<Expression> expressionList = null;//表达式例表
	private JunctionType junctionType = JunctionType.AND;//关联

	public CompositeExpression(JunctionType junctionType) {
		expressionList = new ArrayList<Expression>();
		this.junctionType = junctionType;
	}

	public CompositeExpression(JunctionType junctionType, Expression... expressions) {
		this.expressionList = new ArrayList<Expression>();
		for (Expression expression : expressions) {
			expressionList.add(expression);
		}
		this.junctionType = junctionType;
	}

	public CompositeExpression(JunctionType junctionType, Expression expression1, Expression expression2,
			Expression... moreExpressions) {
		this.expressionList = new ArrayList<Expression>();
		expressionList.add(expression1);
		expressionList.add(expression2);
		for (Expression expression : moreExpressions) {
			expressionList.add(expression);
		}
		this.junctionType = junctionType;
	}

	public List<Expression> getExpressionList() {
		return expressionList;
	}

	public JunctionType getJunctionType() {
		return junctionType;
	}

	public void add(Expression... expressions) {
		for (Expression expression : expressions) {
			expressionList.add(expression);
		}
	}

	public boolean isCompositeExpression() {
		return true;
	}

	public void clear() {
		expressionList.clear();
	}

	/*
	 * 构造hql表达式.
	 * 
	 * @seecom.jeefuse.base.modules.condition.criteria.expression.Expression#
	 * contructExpression
	 * (com.jeefuse.base.modules.condition.criteria.ParamValued)
	 */
	public String contructExpression(NamedParam paramValued) throws CriteriaQueryException {
		if (null == expressionList || expressionList.size() == 0)
			return "";
		else {
			StringBuilder sql = new StringBuilder(100);
			for (int i = 0; i < expressionList.size(); i++) {
				Expression expression = expressionList.get(i);
				if (i > 0) {
					sql.append(" ");
					sql.append(junctionType);
					sql.append(" ");
				}
				if (expression.isCompositeExpression()) {
					CompositeExpression comExpression = (CompositeExpression) expression;
					boolean needBracket = false;
					if (!(comExpression.getJunctionType() == this.junctionType)
							&& comExpression.expressionList.size() > 1) {
						needBracket = true;
					}
					if (needBracket) {
						sql.append("(");
					}
					sql.append(comExpression.contructExpression(paramValued));
					if (needBracket) {
						sql.append(")");
					}
				} else {
					sql.append(expression.contructExpression(paramValued));
				}
			}
			return sql.toString();
		}
	}



	/*
	 * 构造hql表达式.
	 * 
	 * @seecom.jeefuse.base.modules.condition.criteria.expression.Expression#
	 * contructExpression
	 * (com.jeefuse.base.modules.condition.criteria.ParamValued)
	 */
	//	public String contructExpression(ParamValued paramValued) throws CriteriaQueryException {
	//		if (null == expressionList || expressionList.size() == 0)
	//			return "";
	//		else {
	//			StringBuilder sql = new StringBuilder(100);
	//			for (int i = 0; i < expressionList.size(); i++) {
	//				Expression expression = expressionList.get(i);
	//				if (i > 0) {
	//					sql.append(" ");
	//					sql.append(junctionType);
	//					sql.append(" ");
	//				}
	//				if (expression instanceof CompositeExpression) {
	//					CompositeExpression comExpression = (CompositeExpression) expression;
	//					boolean needBracket = false;
	//					if (!(comExpression.getJunctionType() == this.junctionType)
	//							&& comExpression.expressionList.size() > 1) {
	//						needBracket = true;
	//					}
	//					if (needBracket) {
	//						sql.append("(");
	//					}
	//					sql.append(comExpression.contructExpression(paramValued));
	//					if (needBracket) {
	//						sql.append(")");
	//					}
	//				} else {
	//					sql.append(expression.contructExpression(paramValued));
	//				}
	//			}
	//			return sql.toString();
	//		}
	//	}
}
