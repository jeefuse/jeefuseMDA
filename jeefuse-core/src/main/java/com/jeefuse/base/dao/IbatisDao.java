package com.jeefuse.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;

/**封装 ibatis 的通用DAO(Data Access Object)基类的接口.
 * @author  yonclv
 * @created 2009-7-27
 */
public interface IbatisDao {
	
	 /**
	 * 根据主键ID查询对象.
	 * @param sqlMapId 
	 * @param primaryKey
	 * @return
	 */
	public Object getById(String sqlMapId,Object primaryKey);

	 /**
	 * 新增对象.
	 * @param sqlMapId
	 * @param paramObject 参数对象
	 * @return
	 */
	public Object insert(String sqlMapId, Object paramObject);

	 /**
	 * 更新对象.
	 * @param sqlMapId
	 * @param paramObject 参数对象
	 * @return
	 */
	public int update(String sqlMapId, Object paramObject);

	 /**
	 * 批量删除对象.
	 * @param sqlMapId
	 * @param paramObject 参数对象
	 * @return
	 */
	public int delete(String sqlMapId, Object paramObject);

	 /**
	 * 查询唯一对象.
	 * @param sqlMapId
	 * @param paramObject 参数对象
	 * @return
	 */
	public Object queryForObject(String sqlMapId, Object paramObject);

	 /**
	 * 查询唯一对象.
	 * @param sqlMapId
	 * @param paramObject 参数对象
	 * @param resultObject  返回对象
	 * @return
	 */
	public Object queryForObject(String sqlMapId, Object paramObject, Object resultObject);

	 /**
	 * 查询对象.
	 * @param sqlMapId  
	 * @param paramObject  参数对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List queryForList(String sqlMapId, Object paramObject);
	 
	 /**
	 * 查询对象.
	 * @param sqlMapId
	 * @param paramObject  参数对象
	 * @param start  起始记录
	 * @param limit  查询记录数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List queryForList(String sqlMapId, Object paramObject, int start, int limit);

     /**
     * 查询对象返回map类型.
     * @param sqlMapId
     * @param paramObject 参数对象
     * @param keyProp
     * @return
     */
    @SuppressWarnings("unchecked")
	public Map queryForMap(String sqlMapId, Object paramObject, String keyProp);

	 /**
	 * 查询对象返回map类型.
	 * @param sqlMapId
	 * @param paramObject 参数对象
	 * @param keyProp
	 * @param valueProp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map queryForMap(String sqlMapId, Object paramObject, String keyProp, String valueProp);

	/**
	 * 批量执行,用于批量执行开始前调用.
	 */
	public void startBatch() throws DAOException;
	 
	/**
	 * 批量执行,配合startBatch()调用.
	 * @return
	 */
	public int executeBatch() throws DAOException;
	
	public SqlMapClient getSqlMapClient();
	
	public SqlMapClientTemplate getSqlMapClientTemplate();
}
