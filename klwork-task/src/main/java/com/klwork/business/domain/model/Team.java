package com.klwork.business.domain.model;


import java.io.Serializable;

/**
 * 
 * @version 1.0
 * @created ${plugin.now}
 * @author ww
 * 
 */
public class Team implements Serializable 
 {
 	private static final long serialVersionUID = 1L;
 	public Team() {
 	}
 

	/**
	 *  
	 */
	private String id;
	/**
	 *  
	 */
	private String ownUser;
	/**
	 *  
	 */
	private String name;
	/**
	 *  
	 */
	private java.util.Date lastUpdate;
	/**
	 *  
	 */
	private String type;
	/**
	 *  
	 */
	private java.util.Date createdAt;
	/**
	 *  
	 */
	private java.util.Date updatedAt;

	/**
	 * 
	 *
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public String getId(){
		return id;
	}
	/**
	 * 
	 *
	 * @param ownUser
	 */
	public void setOwnUser(String ownUser){
		this.ownUser = ownUser;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public String getOwnUser(){
		return ownUser;
	}
	/**
	 * 
	 *
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public String getName(){
		return name;
	}
	/**
	 * 
	 *
	 * @param lastUpdate
	 */
	public void setLastUpdate(java.util.Date lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public java.util.Date getLastUpdate(){
		return lastUpdate;
	}
	/**
	 * 
	 *
	 * @param type
	 */
	public void setType(String type){
		this.type = type;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public String getType(){
		return type;
	}
	/**
	 * 
	 *
	 * @param createdAt
	 */
	public void setCreatedAt(java.util.Date createdAt){
		this.createdAt = createdAt;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public java.util.Date getCreatedAt(){
		return createdAt;
	}
	/**
	 * 
	 *
	 * @param updatedAt
	 */
	public void setUpdatedAt(java.util.Date updatedAt){
		this.updatedAt = updatedAt;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public java.util.Date getUpdatedAt(){
		return updatedAt;
	}
}