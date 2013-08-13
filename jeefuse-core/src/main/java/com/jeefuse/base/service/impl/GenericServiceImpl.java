package com.jeefuse.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;

/**
 * 提供实体的基本CRUD操作管理.
 * <p>
 * 需要注入hibernateDao DAO对象并设置CRUD操作管理的实体类.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 * @param <T>
 *            实体类
 * @param <PK>
 *            实体主键
 */
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected HibernateDao hibernateDao;// 通用DAO接口
	protected Class<T> entityClass;// 当前操作实体类

	/**
	 * 基本CRUD操作管理构造方法.需要设置进行CRUD操作管理的实体类.
	 * 
	 * @param hibernateDao
	 *            需要在子类中注入hibernateDao DAO对象.
	 * @param entityClass
	 *            设置CRUD操作管理的实体类.
	 */
	public GenericServiceImpl(final HibernateDao hibernateDao, final Class<T> entityClass) {
		this.hibernateDao = hibernateDao;
		this.entityClass = entityClass;
	}

	public long countFind(Condition condition) {
		return hibernateDao.countFind(entityClass, condition);
	}

	public long countFindByProperty(String propertyName, Object value) {
		return hibernateDao.countFindByProperty(entityClass, propertyName, value);
	}

	public long countGetAll() {
		return hibernateDao.countGetAll(entityClass);
	}

	public boolean exists(PK id) {
		return hibernateDao.exists(entityClass, id);
	}

	public List<T> findByProperty(String propertyName, Object value) {
		return hibernateDao.findByProperty(entityClass, propertyName, value);
	}

	public List<T> findByProperty(String propertyName, Object value, int start, int limit) {
		return hibernateDao.findByProperty(entityClass, propertyName, value, start, limit);
	}

	public Page<T> findByProperty(Page<T> page, String propertyName, Object value) {
		return hibernateDao.findByProperty(entityClass, page, propertyName, value);
	}

	public T findUniqueByProperty(String propertyName, Object value) {
		return hibernateDao.findUniqueByProperty(entityClass, propertyName, value);
	}


	public T get(PK id) {
		return hibernateDao.get(entityClass, id);
	}

	public List<T> getAll(Order... orders) {
		return hibernateDao.getAll(entityClass, orders);
	}

	public Page<T> getAll(Page<T> page, Order... orders) {
		return hibernateDao.getAll(entityClass, page, orders);
	}

	public boolean isPropertyUnique(String propertyName, Object value) {
		return hibernateDao.isPropertyUnique(entityClass, propertyName, value);
	}

	@Transactional
	public void save(T entity) {
		hibernateDao.save(entity);
	}

	@Transactional
	public void save(List<T> entityList) {
		hibernateDao.save(entityList);
	}

	@Transactional
	public void update(T entity) {
		hibernateDao.update(entity);
	}

	@Transactional
	public void update(List<T> entityList) {
		hibernateDao.update(entityList);
	}

	@Transactional
	public int delete(PK... ids) {
		return hibernateDao.delete(entityClass, ids);
	}

	@Transactional
	public void delete(T entity) {
		hibernateDao.delete(entity);
	}

	@Transactional
	public int deleteAll() {
		return hibernateDao.deleteAll(entityClass);
	}

}
