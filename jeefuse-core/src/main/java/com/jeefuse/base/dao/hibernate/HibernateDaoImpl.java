package com.jeefuse.base.dao.hibernate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.criteria.ParamValuedPair;
import com.jeefuse.base.modules.condition.criteria.ParamValuedType;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.utils.page.Page;

/**
 * 封装Hibernate 的通用DAO(Data Access Object)基类的实现.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class HibernateDaoImpl implements HibernateDao {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected SessionFactory sessionFactory;// 会话工厂

	/**
	 * 注入sessionFactory.
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public<T> long countGetAll(Class<T> entityClass) {
		final String hql = "SELECT count(*) FROM " + entityClass.getName();
		return Long.parseLong(createQuery(hql).uniqueResult().toString());
	}

	public long countFind(Class entityClass, final Condition condition) {
		StringBuilder sbhql = new StringBuilder(100);
		sbhql.append("SELECT count(*) FROM ");
		sbhql.append(entityClass.getName());
		List<ParamValuedPair> paramValues = null;
		if (null != condition && !condition.isEmpty()) {
			sbhql.append(" WHERE ");
			sbhql.append(condition.toSql());
			paramValues = condition.getParamValuedMap();
		}
		return Long.parseLong(createQuery(sbhql.toString(), paramValues).uniqueResult().toString());
	}

	public long countFindByProperty(Class entityClass, final String propertyName, final Object value) {
		Assert.hasText(propertyName);
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT count(*) FROM ");
		hql.append(entityClass.getName() + " m");
		hql.append(" WHERE");
		hql.append(" m." + propertyName + "=?");
		return Long.parseLong(createQuery(hql.toString(), value).uniqueResult().toString());
	}

	public int deleteAll(Class entityClass) {
		logger.debug("deleting all entity {}", entityClass.getSimpleName());
		final String hql = "delete " + entityClass.getName();
		return executeUpdate(hql);
	}

	public int delete(Class entityClass, final Serializable... ids) {
		logger.debug("deleting entity {},ids is {}", entityClass.getSimpleName(), Arrays.toString(ids));
		int i = 0;
		for (Serializable id : ids) {
			delete(get(entityClass, id));
			i++;
		}
		return i;
	}

	public void delete(Object entity) {
		Assert.notNull(entity, "deleted entity can't be null!");
		getSession().delete(entity);
		logger.debug("deleted entity: {}", entity);
	}

	public void delete(List entityList) {
		for (Object entity : entityList) {
			delete(entity);
		}
	}

	public int delete(Class entityClass, Condition condition) {
		final String hql = "delete " + entityClass.getName() + " where " + condition.toSql();
		logger.debug(hql);
		return executeUpdate(hql, condition.getParamValuedMap());
	}

	public int delete(final String hql, Map<String, Object> paramValued) {
		return executeUpdate(hql, paramValued);
	}

	public int delete(final String sql, Object... values) {
		return executeUpdate(sql, values);
	}

	public int executeUpdate(final String sql, final List<ParamValuedPair> paramValued) {
		return createQuery(sql, paramValued).executeUpdate();
	}

	public int executeUpdate(final String sql, final Object... values) {
		return createQuery(sql, values).executeUpdate();
	}

	public boolean exists(Class entityClass, final Serializable id) {
		Object entity = get(entityClass, id);
		return entity != null;
	}

	public <T> List<T> find(Class<T> entityClass, final Condition condition, final Order... orders) {
		return find(entityClass, condition, 0, 0, orders);
	}

	public <T> List<T> find(Class<T> entityClass, final Condition condition, final int start, final int limit,
			final Order... orders) {
		StringBuilder sbSql = new StringBuilder(100);
		sbSql.append("FROM ");
		sbSql.append(entityClass.getName());
		List<ParamValuedPair> paramValues = null;
		if (null != condition && !condition.isEmpty()) {
			sbSql.append(" WHERE " + condition.toSql());
			paramValues = condition.getParamValuedMap();
		}
		if (null != orders && orders.length > 0) {
			sbSql.append(" ORDER BY ");
			int orderListSize = orders.length;
			for (int i = 0; i < orderListSize; i++) {
				if (i != 0) {
					sbSql.append(",");
				}
				sbSql.append(orders[i].toSql());
			}
		}
		return createQuery(sbSql.toString(), paramValues, start, limit).list();
	}

	public <T> Page<T> find(Class<T> entityClass, Page<T> page, final Condition condition, final Order... orders) {
		List<T> resultList = find(entityClass, condition, page.getFirst(), page.getPageSize(), orders);
		page.setResult(resultList);
		if (page.isAutoCountTotal()) {
			long totalCount = countFind(entityClass, condition);
			page.setTotalCount(totalCount);
		}
		return page;
	}

	public<T> List<T> find(final String sql, final Object... values) {
		return createQuery(sql, values).list();
	}

	public<T> List<T> find(final String sql, final int start, final int limit, final Object... values) {
		return createQuery(sql, start, limit, values).list();
	}

	public<T> List<T> find(final String sql, final List<ParamValuedPair> paramValued) {
		return createQuery(sql, paramValued).list();
	}

	public<T> List<T> find(final String sql, final List<ParamValuedPair> paramValued, final int start, final int limit) {
		return createQuery(sql, paramValued, start, limit).list();
	}

	public <T> List<T> findByProperty(Class<T> entityClass, final String propertyName, final Object value,
			final Order... orders) {
		return findByProperty(entityClass, propertyName, value, 0, 0, orders);
	}

	public <T> List<T> findByProperty(Class<T> entityClass, final String propertyName, final Object value,
			final int start, final int limit, final Order... orders) {
		Assert.hasText(propertyName);
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("FROM ");
		sbSql.append(entityClass.getSimpleName() + " m");
		sbSql.append(" WHERE");
		sbSql.append(" m." + propertyName + "=?");
		if (null != orders && orders.length > 0) {
			sbSql.append(" ORDER BY ");
			int orderListSize = orders.length;
			for (int i = 0; i < orderListSize; i++) {
				if (i != 0) {
					sbSql.append(",");
				}
				sbSql.append(orders[i].toSql());
			}
		}
		return createQuery(sbSql.toString(), start, limit, value).list();
	}

	public <T> Page<T> findByProperty(Class<T> entityClass, Page<T> page, final String propertyName, final Object value) {
		List<T> resultList = findByProperty(entityClass, propertyName, value, page.getFirst(), page.getPageSize());
		page.setResult(resultList);
		if (page.isAutoCountTotal()) {
			long totalCount = countFindByProperty(entityClass, propertyName, value);
			page.setTotalCount(totalCount);
		}
		return page;
	}

	public Integer findInt(final String sql, final Object... values) {
		return Integer.parseInt(findUnique(sql, values).toString());
	}

	public Integer findInt(String sql, final List<ParamValuedPair> paramValued) {
		return Integer.parseInt(createQuery(sql, paramValued).uniqueResult().toString());
	}

	public Long findLong(final String sql, final Object... values) {
		return Long.parseLong(findUnique(sql, values).toString());
	}

	public Long findLong(String sql, final List<ParamValuedPair> paramValued) {
		return Long.parseLong(createQuery(sql, paramValued).uniqueResult().toString());
	}

	public Object findUnique(final String sql, final Object... values) {
		return createQuery(sql, values).uniqueResult();
	}

	public <T> T findUniqueByProperty(Class<T> entityClass, final String propertyName, final Object value) {
		Assert.hasText(propertyName);
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("FROM ");
		sbSql.append(entityClass.getName() + " m");
		sbSql.append(" WHERE");
		sbSql.append(" m." + propertyName + "=?");
		return (T) createQuery(sbSql.toString(), value).uniqueResult();
	}

	public <T> T get(Class<T> entityClass, final Serializable id) {
		Assert.notNull(id, "loaded entity identity can't not be null.");
		return (T) getSession().get(entityClass, id);
	}

	public <T> List<T> getAll(Class<T> entityClass, final Order... orders) {
		return getAll(entityClass, 0, 0, orders);
	}

	public <T> List<T> getAll(Class<T> entityClass, final int start, final int limit, final Order... orders) {
		StringBuilder sbSql = new StringBuilder(32);
		sbSql.append("FROM " + entityClass.getName());
		if (null != orders && orders.length > 0) {
			sbSql.append(" ORDER BY ");
			int ordersSize = orders.length;
			for (int i = 0; i < ordersSize; i++) {
				if (i != 0) {
					sbSql.append(",");
				}
				sbSql.append(orders[i].toSql());
			}
		}
		return createQuery(sbSql.toString(), start, limit).list();
	}

	public <T> Page<T> getAll(Class<T> entityClass, Page<T> page, Order... orders) {
		List<T> resultList = getAll(entityClass, page.getFirst(), page.getPageSize(), orders);
		page.setResult(resultList);
		if (page.isAutoCountTotal()) {
			long totalCount = countGetAll(entityClass);
			page.setTotalCount(totalCount);
		}
		return page;
	}

	public boolean isPropertyUnique(Class entityClass, final String propertyName, final Object value) {
		if (null == value || StringUtils.isBlank(value.toString()))
			return false;
		long count = countFindByProperty(entityClass, propertyName, value);
		return count == 0;
	}
	
	public void save(Object entity) {
		Assert.notNull(entity, "saved entity cont't be null!");
		getSession().save(entity);
		logger.debug("save entity: {}", entity);
	}

	public void save(List entityList) {
		for (int i = 0; i < entityList.size(); i++) {
			save(entityList.get(i));
			if (i % 20 == 0) {
				getSession().flush();
				getSession().clear();
			}
		}
	}

	public void saveOrUpdate(Object entity) {
		Assert.notNull(entity, "saved entity cont't be null!");
		getSession().saveOrUpdate(entity);
		logger.debug("save entity: {}", entity);
	}

	public void saveOrUpdate(List entityList) {
		for (int i = 0; i < entityList.size(); i++) {
			saveOrUpdate(entityList.get(i));
			if (i % 20 == 0) {
				getSession().flush();
				getSession().clear();
			}
		}
	}

	public void update(Object entity) {
		Assert.notNull(entity);
		getSession().update(entity);
		logger.debug("update entity: {}", entity);
	}

	public void update(List entityList) {
		for (int i = 0; i < entityList.size(); i++) {
			update(entityList.get(i));
			if (i % 20 == 0) {
				getSession().flush();
				getSession().clear();
			}
		}
	}

	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 
	 * @param queryString
	 *            查询HQL
	 * @param values
	 *            数量可变的参数
	 * @return
	 */
	protected Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString);
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 
	 * @param queryString
	 *            查询HQL
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @param values
	 *            数量可变的参数
	 * @return
	 */
	protected Query createQuery(final String queryString, final int start, final int limit, final Object... values) {
		Query query = createQuery(queryString, values);
		if (start > 0) {
			query.setFirstResult(start);
		}
		if (limit > 0) {
			query.setMaxResults(limit);
		}
		return query;
	}

	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 
	 * @param queryString
	 *            查询HQL
	 * @param paramValued
	 *            参数名值对
	 * @return
	 */
	protected Query createQuery(final String queryString, final List<ParamValuedPair> paramValued) {
		Assert.hasText(queryString);
		Query query = getSession().createQuery(queryString);
		if (null != paramValued) {
			for (ParamValuedPair paramValuedPair : paramValued) {
				ParamValuedType valuedType=paramValuedPair.getParamValueType();
				switch (valuedType) {
				case STRING:
					query.setString(paramValuedPair.getParamName(), (String) paramValuedPair.getParamValue());
					break;
				case INTEGER:
					query.setInteger(paramValuedPair.getParamName(), (Integer) paramValuedPair.getParamValue());
					break;
				case LONG:
					query.setLong(paramValuedPair.getParamName(), (Long) paramValuedPair.getParamValue());
					break;
				case DATE:
					query.setDate(paramValuedPair.getParamName(), (Date) paramValuedPair.getParamValue());
					break;
				case TIMESTAMP:
					query.setTimestamp(paramValuedPair.getParamName(), (Date) paramValuedPair.getParamValue());
					break;
				case ARRAY:
					query.setParameterList(paramValuedPair.getParamName(), (Object[])paramValuedPair.getParamValue());
					break;
				case COLLECTION:
					query.setParameterList(paramValuedPair.getParamName(), (Collection)paramValuedPair.getParamValue());
					break;
				case BOOLEAN:
					query.setBoolean(paramValuedPair.getParamName(), (Boolean) paramValuedPair.getParamValue());
					break;
				case DOUBLE:
					query.setDouble(paramValuedPair.getParamName(), (Double) paramValuedPair.getParamValue());
					break;
				case CHARACTER:
					query.setCharacter(paramValuedPair.getParamName(), (Character) paramValuedPair.getParamValue());
					break;
				case BYTE:
					query.setByte(paramValuedPair.getParamName(), (Byte) paramValuedPair.getParamValue());
					break;
				case OBJECT:
					query.setParameter(paramValuedPair.getParamName(), paramValuedPair.getParamValue());
					break;
				}
			}
		}
		return query;
	}

	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 
	 * @param queryString
	 *            查询HQL
	 * @param paramValued
	 *            参数名值对
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @return
	 */
	protected Query createQuery(final String queryString, final List<ParamValuedPair> paramValued, final int start,
			final int limit) {
		Query query = createQuery(queryString, paramValued);
		if (start > 0) {
			query.setFirstResult(start);
		}
		if (limit > 0) {
			query.setMaxResults(limit);
		}
		return query;
	}

	public SQLQuery CreateNativeSql(String localSql) {
		return getSession().createSQLQuery(localSql);
	}

	public void sessionClear() {
		getSession().clear();
	}

	public void sessionFlush() {
		getSession().flush();
	}

	public Query createQuery(String hql) {
		Assert.hasText(hql, "查询语名不能为空");
		Query query = getSession().createQuery(hql);
		return query;
	}

	public int update(String hql, final List<ParamValuedPair> paramValued) {
		return createQuery(hql, paramValued).executeUpdate();
	}


}
