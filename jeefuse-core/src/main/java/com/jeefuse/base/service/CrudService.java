package com.jeefuse.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.utils.page.Page;

/**
 * 本类提供实体的基本CRUD操作管理.<br>
 * 默认注入hibernateDao DAO对象,<br>
 * 如果您需要不同的hibernateDao实现,可以重写方法<br>
 * <br>
 * <b>public void setHibernateDao(HibernateDao hibernateDao).</b>
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 * @param <T>
 *            实体类
 * @param <PK>
 *            实体主键
 */
public class CrudService<T, PK extends Serializable> {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected HibernateDao hibernateDao;// 通用DAO接口
	protected Class<T> entityClass;// 当前操作实体类

	
	/**传入需要CRUD操作的实体类.
	 * @param entityClass
	 */
	public CrudService(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * 基本CRUD操作管理构造方法.需要设置进行CRUD操作管理的实体类.
	 * 
	 * @param hibernateDao
	 *            需要在子类中注入hibernateDao DAO对象.
	 * @param entityClass
	 *            设置CRUD操作管理的实体类.
	 */
	public CrudService(final HibernateDao hibernateDao, final Class<T> entityClass) {
		this.hibernateDao = hibernateDao;
		this.entityClass = entityClass;
	}

	/**
	 * 注入hibernateDao,如有其它不同的hibernateDao,可以重载本函数.
	 */
	@Autowired
	public void setHibernateDao(HibernateDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}

	@Transactional(readOnly = true)
	public long countFind(Condition condition) {
		return hibernateDao.countFind(entityClass, condition);
	}

	@Transactional(readOnly = true)
	public long countFindByProperty(String propertyName, Object value) {
		return hibernateDao.countFindByProperty(entityClass, propertyName,
				value);
	}

	@Transactional(readOnly = true)
	public long countGetAll() {
		return hibernateDao.countGetAll(entityClass);
	}

	@Transactional
	public int deleteAll() {
		return hibernateDao.deleteAll(entityClass);
	}

	@Transactional
	public int delete(Condition condition) {
		return hibernateDao.delete(entityClass, condition);
	}

	@Transactional
	public void delete(List<T> entityList) {
		hibernateDao.delete(entityList);
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
	public int delete(final String sql, Map<String, Object> paramsValued){
		return hibernateDao.delete(sql, paramsValued);
	}
	
	@Transactional(readOnly = true)
	public boolean exists(PK id) {
		return hibernateDao.exists(entityClass, id);
	}

	@Transactional(readOnly = true)
	public List<T> find(Condition condition, Order... orders) {
		return hibernateDao.find(entityClass, condition, orders);
	}

	@Transactional(readOnly = true)
	public List<T> find(Condition condition, int start, int limit,
			Order... orders) {
		return hibernateDao.find(entityClass, condition, start, limit, orders);
	}

	@Transactional(readOnly = true)
	public Page<T> find(Page<T> page, Condition condition,Order... orders) {
		return hibernateDao.find(entityClass, page, condition,orders);
	}

	@Transactional(readOnly = true)
	public List<T> findByProperty(String propertyName, Object value) {
		return hibernateDao.findByProperty(entityClass, propertyName, value);
	}

	@Transactional(readOnly = true)
	public List<T> findByProperty(String propertyName, Object value, int start,
			int limit) {
		return hibernateDao.findByProperty(entityClass, propertyName, value,
				start, limit);
	}

	@Transactional(readOnly = true)
	public Page<T> findByProperty(Page<T> page, String propertyName,
			Object value) {
		return hibernateDao.findByProperty(entityClass, page, propertyName,value);
	}

	@Transactional(readOnly = true)
	public T findUniqueByProperty(String propertyName, Object value) {
		return hibernateDao.findUniqueByProperty(entityClass, propertyName,
				value);
	}

	@Transactional(readOnly = true)
	public T get(PK id) {
		return hibernateDao.get(entityClass, id);
	}

	@Transactional(readOnly = true)
	public List<T> getAll() {
		return hibernateDao.getAll(entityClass);
	}

	@Transactional(readOnly = true)
	public List<T> getAll(int start, int limit, Order... orders) {
		return hibernateDao.getAll(entityClass, start, limit, orders);
	}

	@Transactional(readOnly = true)
	public Page<T> getAll(Page<T> page) {
		return hibernateDao.getAll(entityClass, page);
	}

	@Transactional(readOnly = true)
	public boolean isPropertyUnique(String propertyName, Object value) {
		return hibernateDao.isPropertyUnique(entityClass, propertyName, value);
	}

	@Transactional
	public void save(T entity){
		hibernateDao.save(entity);
	}
	
	@Transactional
	public void save(List<T> entityList){
		hibernateDao.save(entityList);
	}
	
	@Transactional
	public void update(T entity){
		hibernateDao.update(entity);
	}
	
	@Transactional
	public void update(List<T> entityList){
		hibernateDao.update(entityList);
	}

}
