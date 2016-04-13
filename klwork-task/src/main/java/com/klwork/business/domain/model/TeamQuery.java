package com.klwork.business.domain.model;

import com.klwork.common.dao.QueryParameter;

/**
 * 
 * @version 1.0
 * @created ${plugin.now}
 * @author ww
 * 
 */
public class TeamQuery extends QueryParameter{
 	private static final long serialVersionUID = 1L;
 	
 	public TeamQuery() {
 	
 	}

	public static TeamQuery build() {
		TeamQuery query = new TeamQuery();
		return query;
	}
 	
 	/**
	 *  
	 */
	private String name;
	

	/**
	 * 
	 *
	 * @param name
	 */
	public TeamQuery setName(String name){
		this.name = name;
		return this;
	}
	
	/**
	 * 
	 *
	 * @return
	 */	
	public String getName(){
		return name;
	}
	

}