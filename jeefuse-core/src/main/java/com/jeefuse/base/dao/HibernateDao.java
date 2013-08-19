package com.jeefuse.base.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.criteria.ParamValuedPair;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.utils.page.Page;

/**
 * 通用数据访问对象(DA0)接口.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface HibernateDao {

	/**
	 * 按主键id获取对象.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param id
	 *            对象的主键id
	 */
	public <T> T get(Class<T> entityClass, Serializable id);

	/**
	 * 获取全部对象.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param orders
	 *            可变的排序
	 * @return
	 */
	public <T> List<T> getAll(Class<T> entityClass, Order... orders);

	/**
	 * 分页获取对象.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @param orders
	 *            可变的排序
	 * @return
	 */
	public <T> List<T> getAll(Class<T> entityClass, int start, int limit, Order... orders);

	/**
	 * 分页获取对象.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param page
	 *            分页排序参数及查询结果封装.
	 * @return
	 */
	public <T> Page<T> getAll(Class<T> entityClass, Page<T> page, Order... orders);

	/**
	 * 取得所有对象总数.
	 * 
	 * @param entityClass
	 *            实体类
	 * @return
	 */
	public<T> long countGetAll(Class<T> entityClass);

	/**
	 * 判断指定实体主键id的对象是否存在.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param id
	 *            对象的主键id
	 * @return true if it exists, false if it doesn't
	 */
	public<T> boolean exists(Class<T> entityClass, Serializable id);

	/**
	 * 保存新增对象.
	 * 
	 * @param entity
	 *            要保存对象
	 * @return
	 */
	public void save(Object entity);

	/**
	 * 保存新增对象.
	 * 
	 * @param entityList
	 *            要保存对象例表
	 * @return
	 */
	public<T> void save(List<T> entityList);

	/**
	 * 保存修改的对象.
	 * 
	 * @param entity
	 *            要保存修改的对象
	 * @return
	 */
	public void update(Object entity);

	/**
	 * 保存修改的对象.
	 * 
	 * @param entityList
	 *            要保存修改的对象例表
	 * @return
	 */
	public<T> void update(List<T> entityList);

	/**
	 * 保存新增或修改的对象.
	 * 
	 * @param entity
	 *            要保存或修改的对象
	 */
	public void saveOrUpdate(Object entity);

	/**
	 * 保存新增或修改的对象.
	 * 
	 * @param entityList
	 *            要保存或修改的对象例表
	 */
	public<T> void saveOrUpdate(List<T> entityList);

	/**
	 * 删除所有实体对象.
	 * 
	 * @param entityClass
	 *            实体类
	 */
	public<T> int deleteAll(Class<T> entityClass);

	/**
	 * 删除指定实体主键id的对象.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param ids
	 *            可变的对象主键id
	 */
	public<T> int delete(Class<T> entityClass, final Serializable... ids);

	/**
	 * 删除对象.
	 * 
	 * @param entity
	 *            对象必须是session中的对象或含id属性的transient对象.
	 */
	public void delete(Object entity);

	/**
	 * 删除对象.
	 * 
	 * @param entityList
	 *            对象必须是session中的对象或含id属性的transient对象.
	 */
	public<T> void delete(List<T> entityList);

	/**
	 * 按条件批量删除对象.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param condition
	 *            条件构造
	 * @return 删除的对象个数
	 */
	public<T> int delete(Class<T> entityClass, Condition condition);

	/**
	 * 批量删除对象.
	 * 
	 * @param hql
	 *            删除Hql语句
	 * @param paramValued
	 *            命名参数
	 * @return
	 */
	public int delete(final String hql, Map<String, Object> paramValued);

	/**
	 * 批量删除对象.
	 * 
	 * @param hql
	 *            删除语句
	 * @param values
	 *            可变的参数值
	 * @return
	 */
	public int delete(final String hql, Object... values);

	/**
	 * 按属性查找唯一对象,匹配方式为相等.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return
	 */
	public <T> T findUniqueByProperty(Class<T> entityClass, String propertyName, Object value);

	/**
	 * 按Hql语句查询唯一对象. 返回对象类型不能确定时,可用此方法查询.
	 * 
	 * @param hql
	 *            查询语句
	 * @param values
	 *            可变的参数值
	 * @return
	 */
	public Object findUnique(String hql, Object... values);

	/**
	 * 按Hql查询Integer类型结果.
	 * 
	 * @param hql
	 *            查询语句
	 * @param values
	 *            可变的参数值
	 * @return
	 */
	public Integer findInt(String hql, Object... values);

	/**
	 * 按Hql查询Integer类型结果.
	 * 
	 * @param hql
	 *            查询语句
	 * @param paramValued
	 *            查询参数名值对
	 * @return
	 */
	public Integer findInt(String hql, final List<ParamValuedPair> paramValued);

	/**
	 * 按Hql查询Long类型结果.
	 * 
	 * @param hql
	 *            查询语句
	 * @param values
	 *            可变的参数值
	 * @return
	 */
	public Long findLong(String hql, Object... values);

	/**
	 * 按Hql查询Long类型结果.
	 * 
	 * @param hql
	 *            查询语句
	 * @param paramValued
	 *            查询参数名值对
	 * @return
	 */
	public Long findLong(String hql, final List<ParamValuedPair> paramValued);

	/**
	 * 按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @param orders
	 *            可变的排序
	 * @return
	 */
	public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value, Order... orders);

	/**
	 * 分页,按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @param orders
	 *            可变的排序
	 * @return
	 */
	public <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value, int start, int limit,
			Order... orders);

	/**
	 * 分页,按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param page
	 *            分页排序参数及查询结果封装.
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return
	 */
	public <T> Page<T> findByProperty(Class<T> entityClass, Page<T> page, String propertyName, Object value);

	/**
	 * 取得所查询到的记录总数:按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return
	 */
	public<T> long countFindByProperty(Class<T> entityClass, String propertyName, Object value);

	/**
	 * 按构造条件查询对象列表.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param condition
	 *            查询条件
	 * @param orders
	 *            可变的排序对象
	 * @return
	 */
	public <T> List<T> find(Class<T> entityClass, Condition condition, Order... orders);

	/**
	 * 分页,按构造条件查询对象列表.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param condition
	 *            查询条件
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @param orders
	 *            可变的排序对象
	 * @return
	 */
	public <T> List<T> find(Class<T> entityClass, Condition condition, int start, int limit, Order... orders);

	/**
	 * 分页,按构造条件查询对象列表.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param page
	 *            分页排序参数及查询结果封装.
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public <T> Page<T> find(Class<T> entityClass, Page<T> page, Condition condition, Order... orders);

	/**
	 * 取得所查询到的记录总数:按构造条件查询所有对象.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param condition
	 *            查询条件
	 *            <p>
	 *            构造查询where了句,类似于hibernate中criteria的criterion.
	 *            <p>
	 *            <strong>用法:</strong>
	 *            <ul>
	 *            例如一个学生的实体对象,要取出其中学生年龄大于25,姓王或姓孙,且分数 大于90分的记录,构造条件如下：
	 *            <p>
	 *            Condition condition=Condition.conjunction()
	 *            <p>
	 *            .add(Restrict.gt("age", 25))
	 *            <p>
	 *            .add(Restrict.or(Restrict.startsLike("name",
	 *            "王"),Restrict.startsLike("name", "孙")))
	 *            <p>
	 *            .add(Restrict.ge("score", 90));
	 *            <p>
	 *            其构造SQL(condition.toSql)结果如下：
	 *            <p>
	 *            WHERE age > :age AND (name like :name OR name like :name_1)
	 *            AND score >= :score
	 *            <p>
	 *            其构造参数名值对可通过condition.getParamValuedMap()获取.
	 *            <p>
	 *            可进行嵌套条件和关联查询,详细请您查阅其说明文档.
	 *            </ul>
	 * @return
	 */
	public<T> long countFind(Class<T> entityClass, Condition condition);

	/**
	 * 按sql查询对象列表. 返回对象类型不能确定时,可用此方法灵活查询.
	 * 
	 * @param hql
	 *            查询语句
	 * @param values
	 *            可变的参数值
	 * @return
	 */
	public<T> List<T> find(String hql, Object... values);

	/**
	 * 分页,按sql查询对象列表. 返回对象类型不能确定时,可用此方法灵活查询.
	 * 
	 * @param hql
	 *            查询语句
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @param values
	 *            可变的参数值
	 * @return
	 */
	public<T> List<T> findWithLimit(String hql, int start, int limit, Object... values);

	/**
	 * 根据命名参数查据所有记录, 返回对象类型不能确定时,可用此方法灵活查询.
	 * 
	 * @param hql
	 *            查询语句
	 * @param paramValued
	 *            查询参数名值对
	 * @return
	 */
	public<T> List<T> find(String hql, final List<ParamValuedPair> paramValued);

	/**
	 * 分页,根据命名参数查据所有记录, 返回对象类型不能确定时,可用此方法灵活查询.
	 * 
	 * @param hql
	 *            查询语句
	 * @param paramValued
	 *            查询参数名值对
	 * @param start
	 *            起始记录行
	 * @param limit
	 *            获取记录数
	 * @return
	 */
	public<T> List<T> find(String hql, final List<ParamValuedPair> paramValued, final int start, final int limit);

	/**
	 * 判断对象的属性值在数据库内是否唯一.唯一则返回true,否则返回false.
	 * 
	 * @param entityClass
	 *            实体类
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return
	 */
	public<T> boolean isPropertyUnique(Class<T> entityClass, String propertyName, Object value);

	/**
	 * 执行更新操作.
	 * 
	 * @param hql
	 *            查询语句
	 * @param paramValued
	 *            查询参数名值对
	 * @return
	 */
	public int executeUpdate(String hql, final List<ParamValuedPair> paramValued);

	/**
	 * 执行更新操作.
	 * 
	 * @param hql
	 *            查询语句
	 * @param values
	 *            可变的参数值
	 * @return
	 */
	public int executeUpdate(String hql, Object... values);

	/**
	 * 创建hibernate Native sql,用于直接执行原生sql语句.
	 * 
	 * @param localSql
	 * @return
	 */
	public SQLQuery CreateNativeSql(String localSql);

	/**
	 * 刷新会话.
	 */
	public void sessionFlush();

	/**
	 * 清空会话.
	 */
	public void sessionClear();

	/*
	 * 根据查询HQL创建Query对象.
	 */
	public Query createQuery(final String hql);

	/**
	 * 执行更新语句.
	 * 
	 * @param hql
	 *            hibernate hql语句
	 * @param paramValued
	 *            命名参数.
	 * @return
	 */
	public int update(String hql, final List<ParamValuedPair> paramValued);

}
