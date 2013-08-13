package com.jeefuse.base.service;

import java.io.Serializable;
import java.util.List;

import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.utils.page.Page;

/**
 * 提供实体的基本CRUD操作管理.
 * 
 * @author yonclv mailTo:yonclv@gmail.com
 * @param <T>
 *            实体类
 * @param <PK>
 *            实体主键
 */
public interface GenericService<T ,PK extends Serializable> {

	/**
	 * 判断指定实体主键id的对象是否存在.
	 * 
	 * @param id
	 *            对象的主键id
	 * @return
	 */
	public boolean exists(PK id);


	/**
	 * 按主键id获取对象.
	 * 
	 * @param id
	 *            对象的主键id
	 * @return
	 */
	public T get(PK id);

	/**
	 * 获取全部对象.
	 * 
	 * @return
	 */
	public List<T> getAll(Order... orders);


	/**
	 * 分页,获取全部对象.
	 * 
	 * @param page
	 *            分页参数及查询结果封装.
	 * @return
	 */
	public Page<T> getAll(Page<T> page, Order... orders);

	/**
	 * 取得查询全部对象的记录总数.
	 * 
	 * @return
	 */
	public long countGetAll();

	/**
	 * 按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            参数值
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value);

	/**
	 * 分页,按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            参数值
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value, int start,
			int limit);

	/**
	 * 分页,按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param page
	 *            分页参数及查询结果封装.
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            参数值
	 * @return
	 */
	public Page<T> findByProperty(Page<T> page, String propertyName,Object value);

	/**
	 * 取得所查询到的记录总数:按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            参数值
	 * @return
	 */
	public long countFindByProperty(String propertyName, Object value);

	/**
	 * 按属性查找唯一对象,匹配方式为相等.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return
	 */
	public T findUniqueByProperty(String propertyName, Object value);

	/**
	 * 判断对象的属性值在数据库内是否唯一.唯一则返回true,否则返回false.
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return
	 */
	public boolean isPropertyUnique(String propertyName, Object value);

	/**
	 * 保存新增的对象.
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 保存新增的对象.
	 * 
	 * @param entityList
	 */
	public void save(List<T> entityList);

	/**
	 * 保存修改的对象.
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 保存修改的对象.
	 * 
	 * @param entityList
	 */
	public void update(List<T> entityList);
	
	/**
	 * 删除指定实体主键id的对象.
	 * 
	 * @param ids
	 *            不定数的实体主健id
	 */
	public int delete(PK... ids);

	/**
	 * 删除对象.
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 删除所有对象.
	 */
	public int deleteAll();

}
