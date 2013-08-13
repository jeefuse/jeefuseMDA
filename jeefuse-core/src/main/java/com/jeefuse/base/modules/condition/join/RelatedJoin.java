package com.jeefuse.base.modules.condition.join;

import com.jeefuse.base.modules.condition.criteria.Criteria;
import com.jeefuse.base.modules.condition.criteria.JunctionType;
import com.jeefuse.base.modules.condition.criteria.expression.CompositeExpression;
import com.jeefuse.base.modules.condition.criteria.expression.Expression;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;

/**查询关联实体
 * @author yonclv
 * mailTo:yonclv@gmail.com
 */
public class RelatedJoin  implements Criteria{
	private static final long serialVersionUID = -6723915977454301892L;
	private String relatedProperty;
	private String joinType;
	private String alias = null;
	private CompositeExpression compositeExpression = new CompositeExpression(JunctionType.AND);//查询条件
	
	/**构造关联
	 * @param relatedProperty 关联属性(实体)
	 * @param joinType 关联类型
	 * @param alias 别名
	 */
	public RelatedJoin(String relatedProperty, String joinType, String alias) {
		this.relatedProperty = relatedProperty;
		this.joinType = joinType;
		this.alias = alias;
	}
	/**构造关联
	 * @param relatedProperty 关联属性(实体)
	 * @param joinType   关联类型
	 * @param alias     别名
	 * @param expressions  条件
	 */
	public RelatedJoin(String relatedProperty, String joinType, String alias,Expression... expressions) {
		this.relatedProperty = relatedProperty;
		this.joinType = joinType;
		this.alias = alias;
		compositeExpression.add(expressions);
	}
	public String toSql() throws CriteriaQueryException {
		StringBuilder joinSql=new StringBuilder();
		joinSql.append(joinType);
		joinSql.append(" ");
		joinSql.append(relatedProperty);
		joinSql.append(" ");
		if(null!=this.alias){
			joinSql.append(this.alias);
		}
		return joinSql.toString();
	}
	public CompositeExpression getCompositeExpression() {
		return compositeExpression;
	}
}
