package com.klwork.business.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klwork.common.dto.vo.ViewPage;
import com.klwork.business.domain.model.Team;
import com.klwork.business.domain.model.TeamQuery;
import com.klwork.business.domain.repository.TeamRepository;


/**
 * 
 * @version 1.0
 * @created ${plugin.now}
 * @author ww
 */

@Service
public class TeamService {
	@Autowired
	private TeamRepository rep;

	public int createTeam(Team team) {
		team.setId(rep.getNextId());
		return rep.insert(team);
	}

	public int deleteTeam(Team team) {
		return rep.delete(team);
	}

	public int updateTeam(Team team) {
		return rep.update(team);
	}

	public List<Team> findTeamByQueryCriteria(TeamQuery query,
			ViewPage<Team> page) {
		return rep.findTeamByQueryCriteria(query, page);
	}

	public Team findTeamById(String id) {
		return rep.find(id);
	}
	
	public int count(TeamQuery query) {
		return rep.findTeamCountByQueryCriteria(query);
	}
}