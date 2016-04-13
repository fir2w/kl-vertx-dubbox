package com.klwork.spring.vertx.domain.model;


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
	private String name;
	/**
	 *  
	 */
	private String des;

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
	 * @param des
	 */
	public void setDes(String des){
		this.des = des;
	}
	/**
	 * 
	 *
	 * @return
	 */	
	public String getDes(){
		return des;
	}
}