package com.jeefuse.base.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 通用IBATIS DAO.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class BaseIbatisDao extends SqlMapClientDaoSupport{

	public int delete(String sqlMapId, Object paramObject) {

		return getSqlMapClientTemplate().delete(sqlMapId, paramObject);

	}

	public Object getById(String sqlMapId, Object primaryKey) {

		return getSqlMapClientTemplate().queryForObject(sqlMapId, primaryKey);

	}

	public Object insert(String sqlMapId, Object paramObject) {

		return getSqlMapClientTemplate().insert(sqlMapId, paramObject);

	}

	@SuppressWarnings("unchecked")
	public List queryForList(String sqlMapId, Object paramObject) {

		return getSqlMapClientTemplate().queryForList(sqlMapId, paramObject);

	}

	@SuppressWarnings("unchecked")
	public List queryForList(String sqlMapId, Object paramObject,int startRecord, int maxRecord) {

		return getSqlMapClientTemplate().queryForList(sqlMapId, paramObject,startRecord, maxRecord);

	}

	@SuppressWarnings("unchecked")
	public Map queryForMap(String sqlMapId, Object paramObject, String keyProp) {

		return getSqlMapClientTemplate().queryForMap(sqlMapId, paramObject,keyProp);

	}

	@SuppressWarnings("unchecked")
	public Map queryForMap(String sqlMapId, Object paramObject, String keyProp,
			String valueProp) {

		return getSqlMapClientTemplate().queryForMap(sqlMapId, paramObject,keyProp, valueProp);

	}

	public Object queryForObject(String sqlMapId, Object paramObject) {

		return getSqlMapClientTemplate().queryForObject(sqlMapId, paramObject);

	}

	public Object queryForObject(String sqlMapId, Object paramObject,
			Object resultObject) {

		return getSqlMapClientTemplate().queryForObject(sqlMapId, paramObject,resultObject);

	}

	public void startBatch() throws DAOException {
		try {
			getSqlMapClient().startBatch();
		} catch (SQLException e) {
			throw new DAOException(" Ibatis SqlMapClient start batch excute exception !", e);
		}
	}

	public int executeBatch() throws DAOException {
		try {
			return getSqlMapClient().executeBatch();
		} catch (SQLException e) {
			throw new DAOException(" Ibatis SqlMapClient  batch excute exception !", e);
		}

	}

	public int update(String sqlMapId, Object paramObject) {

		return getSqlMapClientTemplate().update(sqlMapId, paramObject);

	}

}
