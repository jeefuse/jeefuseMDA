package com.jeefuse.base.modules.condition.criteria;

import java.util.ArrayList;
import java.util.List;

import com.jeefuse.base.modules.condition.criteria.expression.CompositeExpression;
import com.jeefuse.base.modules.condition.criteria.expression.Expression;
import com.jeefuse.base.modules.condition.exception.CriteriaQueryException;
import com.jeefuse.base.modules.condition.join.EntityJoin;
import com.jeefuse.base.modules.condition.join.RelatedJoin;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.condition.select.Select;

/**
 * 构造查询SQL语句. QuerySQL 查询构造对象类似于hibernate中的criteria对象,
 * 由于criteria与hibernate的session绑定在一起,故重新实现了 一套查询构造机制,其可以运用在任何实现了JPA的OR持久框架中.
 * <p>
 * <strong>用法：</strong>
 * <ul>
 * 例如一个学生的实体对象,要取出其中学生是姓王，且分数 大于90分的记录如下：
 * <p>
 * QuerySQL querySql=QuerySQL.query("student", "s")
 * <p>
 * .addCondition(Restrict.startsLike("s.name", "王"),Restrict.ge("s.score", 90))
 * <p>
 * .addOrder(Order.asc("s.score"));
 * <p>
 * 生成如下语句:
 * <p>
 * FROM student s WHERE s.name like :s_name AND s.score >= :s_score ORDER BY
 * s.score ASC
 * <p>
 * 其构造参数名值对可通过querySql.getParamValuedMap()获取.
 * <p>
 * 可进行嵌套条件和关联查询,详细请您查阅其说明文档.
 * </ul>
 * <p>
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 */
@SuppressWarnings("serial")
public class QuerySQL implements Criteria {

	/**
	 * 构造查询SQL语句.
	 * 
	 * @param entityName
	 *            实体名
	 * @return
	 */
	public static QuerySQL query(String entityName) {
		return new QuerySQL(entityName);
	}

	/**
	 * 构造查询SQL语句.
	 * 
	 * @param entityName
	 *            实体名
	 * @param alias
	 *            别名
	 * @return
	 */
	public static QuerySQL query(String entityName, String alias) {
		return new QuerySQL(entityName, alias);
	}

	private List<Select> selectList = new ArrayList<Select>(); // 查询字段
	private List<EntityJoin> entityList = new ArrayList<EntityJoin>(); // 查询实体
	private List<RelatedJoin> relatedJoinList = new ArrayList<RelatedJoin>(); // 关联
	private List<Order> orderList = new ArrayList<Order>(); // 排序
	private CompositeExpression compositeExpression = new CompositeExpression(JunctionType.AND);// 查询条件
	private NamedParam paramValued = new NamedParam();// 保存命名参数

	public QuerySQL(String entityName, String alias) {
		this.addEntity(EntityJoin.entity(entityName, alias));
	}

	public QuerySQL(String entityName) {
		this.addEntity(EntityJoin.entity(entityName));
	}

	/**
	 * 添加查询字段.
	 * 
	 * @param propertyNames
	 *            字段名
	 * @return
	 */
	public QuerySQL addSelect(String... propertyNames) {
		for (String propertyName : propertyNames) {
			selectList.add(Select.select(propertyName));
		}
		return this;
	}

	/**
	 * 添加查询字段.
	 * 
	 * @param selects
	 *            字段对象
	 */
	public QuerySQL addSelect(Select... selects) {
		for (Select select : selects) {
			selectList.add(select);
		}
		return this;
	}

	/**
	 * 添加查询实体.
	 * 
	 * @param entityName
	 *            实体名
	 * @return
	 */
	public QuerySQL addEntity(String entityName) {
		entityList.add(EntityJoin.entity(entityName));
		return this;
	}

	/***
	 * 添加查询实体.
	 * 
	 * @param entityName
	 *            实体名
	 * @param alias
	 *            别名
	 * @return
	 */
	public QuerySQL addEntity(String entityName, String alias) {
		entityList.add(EntityJoin.entity(entityName, alias));
		return this;
	}

	/**
	 * 添加查询实体.
	 * 
	 * @param entityJoins
	 *            不限制查询实体
	 */
	public QuerySQL addEntity(EntityJoin... entityJoins) {
		for (EntityJoin entityJoin : entityJoins) {
			entityList.add(entityJoin);
		}
		return this;
	}

	/**
	 * 添加关联.
	 * 
	 * @param relatedJoins
	 *            不限制关联
	 */
	public QuerySQL addJoin(RelatedJoin... relatedJoins) {
		for (RelatedJoin relatedJoin : relatedJoins) {
			relatedJoinList.add(relatedJoin);
		}
		return this;
	}

	/**
	 * 添加排序字段.
	 * 
	 * @param orders
	 *            不限制排序字段
	 */
	public QuerySQL addOrder(Order... orders) {
		for (Order order : orders) {
			orderList.add(order);
		}
		return this;
	}

	/**
	 * 添加查询条件,支持任意复杂的嵌套.
	 * 
	 * @param condition
	 * @return
	 */
	public QuerySQL addCondition(Expression... expressions) {
		compositeExpression.add(expressions);
		return this;
	}

	/**
	 * 添加命名参数值对,采用JPA QUERY命名参数机制.
	 * 
	 * @param paramName
	 * @param value
	 * @return
	 */
	public String populateParamAddGetParamName(String paramName, Object value, ParamValuedType paramValuedType) {
		return paramValued.populateParamAddGetParamName(paramName, value, paramValuedType);
	}

	/**
	 * 获取添加的命名参数名值对,采用JPA QUERY命名参数机制.
	 * 
	 * @return
	 */
	public List<ParamValuedPair> getParamValuedMap() {
		return paramValued.getParamValuedList();
	}

	/**
	 * 构造查询SELECT语句.
	 * 
	 * @return
	 */
	public String toSql() throws CriteriaQueryException {
		StringBuilder sql = new StringBuilder(100);
		// construct select field
		if (null != selectList && selectList.size() > 0) {
			sql.append("SELECT");
			int selectListSize = selectList.size();
			for (int i = 0; i < selectListSize; i++) {
				Select select = selectList.get(i);
				if (i != 0) {
					sql.append(",");
				}
				sql.append(" ");
				sql.append(select.toSql());
			}
		}
		if (null == entityList || entityList.size() == 0)
			throw new CriteriaQueryException("error:无查询实体!请添加查询实体");
		// construct from entity
		sql.append(" FROM");
		int entityListSize = entityList.size();
		for (int i = 0; i < entityListSize; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append(" ");
			sql.append(entityList.get(i).toSql());
		}
		// construct related join entity
		if (null != relatedJoinList && relatedJoinList.size() > 0) {
			for (RelatedJoin relatedJoin : relatedJoinList) {
				sql.append(" ");
				sql.append(relatedJoin.toSql());
				// related join entity condition
				if (null != relatedJoin.getCompositeExpression()) {
					CompositeExpression joinExpression = relatedJoin.getCompositeExpression();
					if (null != joinExpression.getExpressionList() && joinExpression.getExpressionList().size() > 0) {
						sql.append(" ON ");
						sql.append(joinExpression.contructExpression(paramValued));
					}
				}
			}
		}
		// construct condition
		if (null != compositeExpression && compositeExpression.getExpressionList().size() > 0) {
			sql.append(" WHERE ");
			sql.append(compositeExpression.contructExpression(paramValued));
		}
		// construct order by
		if (null != orderList && orderList.size() > 0) {
			sql.append(" ORDER BY");
			int orderListSize = orderList.size();
			for (int i = 0; i < orderListSize; i++) {
				if (i != 0) {
					sql.append(",");
				}
				sql.append(" ");
				sql.append(orderList.get(i).toSql());
			}
		}
		return sql.toString();
	}

	/**
	 * 构造查询SELECT count(*)语句,获取查询记录返回总数.
	 * 
	 * @return
	 * @throws CriteriaQueryException
	 */
	public String toCountSql() throws CriteriaQueryException {
		StringBuilder sql = new StringBuilder(100);
		sql.append("SELECT count(*)");
		if (null == entityList || entityList.size() == 0)
			throw new CriteriaQueryException("error:无查询实体!请添加查询实体");
		// construct from entity
		sql.append(" FROM");
		int entityListSize = entityList.size();
		for (int i = 0; i < entityListSize; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append(" ");
			sql.append(entityList.get(i).toSql());
		}
		// construct related join entity
		if (null != relatedJoinList && relatedJoinList.size() > 0) {
			for (RelatedJoin relatedJoin : relatedJoinList) {
				sql.append(" ");
				sql.append(relatedJoin.toSql());
				// related join entity condition
				if (null != relatedJoin.getCompositeExpression()) {
					CompositeExpression joinExpression = relatedJoin.getCompositeExpression();
					if (null != joinExpression.getExpressionList() && joinExpression.getExpressionList().size() > 0) {
						sql.append(" ON ");
						sql.append(joinExpression.contructExpression(paramValued));
					}
				}
			}
		}
		// construct condition
		if (null != compositeExpression && compositeExpression.getExpressionList().size() > 0) {
			sql.append(" WHERE ");
			sql.append(compositeExpression.contructExpression(paramValued));
		}
		return sql.toString();
	}

	public List<Select> getSelectList() {
		return selectList;
	}

	public List<EntityJoin> getEntityList() {
		return entityList;
	}

	public List<RelatedJoin> getRelatedJoinList() {
		return relatedJoinList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public CompositeExpression getCompositeExpression() {
		return compositeExpression;
	}
}
