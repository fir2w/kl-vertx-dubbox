package com.klwork.common.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.klwork.common.dto.vo.ViewPage;

@SuppressWarnings("unchecked")
public class BaseMybaitsDao extends SqlSessionDaoSupport {
	
	// select
	// ///////////////////////////////////////////////////////////////////
	public Object selectEntityByModel(String sqlMapId, Object obj) {
		return getSqlSession().selectOne(sqlMapId, obj);
	}

	public Object selectEntityByMap(String sqlMapId, Map<String, String> map) {
		return getSqlSession().selectOne(sqlMapId, map);
	}

	public List selectListByMap(String sqlMapId, Map<String, String> map) {
		return getSqlSession().selectList(sqlMapId, map);
	}

	@SuppressWarnings("unchecked")
	public List selectList(String statement, Object parameter) {
		List loadedObjects = getSqlSession().selectList(statement, parameter);
		return loadedObjects;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends QueryParameter> List selectList(String statement, T parameter, ViewPage page) {
		
		if (page != null) {
			parameter.setLimit(page.getPageSize());
			if(page.getStart() > 0){
				parameter.setStart(page.getStart());
			}else{
				parameter.setStart(page.getCurrentPage() * page.getPageSize());
			}
		}
		
		List loadedObjects = getSqlSession().selectList(statement, parameter);
		return loadedObjects;
	}
	

	@SuppressWarnings("unchecked")
	public List selectListMem(String statement, Object parameter, ViewPage page) {
		List loadedObjects = Collections.EMPTY_LIST;
		if (page != null) {
			loadedObjects = getSqlSession().selectList(statement, parameter,
					new RowBounds(page.getStart(), page.getPageSize()));
		} else {
			loadedObjects = getSqlSession().selectList(statement, parameter);
		}
		return loadedObjects;
	}

	public Object selectOne(String statement, Object parameter) {
		Object result = getSqlSession().selectOne(statement, parameter);
		return result;
	}
	
	 

	// insert
	// ///////////////////////////////////////////////////////////////////
	public int insert(String sqlMapId, Object obj) {
		return getSqlSession().insert(sqlMapId, obj);
	}

	// update
	// ///////////////////////////////////////////////////////////////////
	public int update(String sqlMapId, Object obj) {
		return getSqlSession().update(sqlMapId, obj);
	}

	// delete
	// ///////////////////////////////////////////////////////////////////
	public int delete(String deleteStatement, Object persistentObjectId) {
		return getSqlSession().delete(deleteStatement, persistentObjectId);
	}

}