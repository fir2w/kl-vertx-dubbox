package com.klwork.business.domain.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.klwork.common.dao.QueryParameter;
import com.klwork.common.domain.repository.MbDomainRepositoryImp;
import com.klwork.common.dto.vo.ViewPage;
import com.klwork.business.domain.model.Team;

/**
 * 
 * @version 1.0
 * @created ${plugin.now}
 * @author ww
 */
 
@Repository(value = "teamRepository")
public class TeamRepository extends
		MbDomainRepositoryImp<Team, Serializable> {

	@SuppressWarnings("unchecked")
	public <T extends QueryParameter> List<Team> findTeamByQueryCriteria(T query,
			ViewPage page) {
		List<Team> list = getDao().selectList(
				"selectTeamByQueryCriteria", query, page);
		if (page != null) {
			int count = findTeamCountByQueryCriteria(query);
			page.setTotalSize(count);
			// 总数
			page.setPageDataList(list);
		}
		return list;
	}

	/**
	 * 查询总数
	 * 
	 * @param query
	 * @return
	 */
	public Integer findTeamCountByQueryCriteria(Object query) {
		return (Integer) getDao().selectOne(
				"selectTeamCountByQueryCriteria", query);
	}
}
