package com.hisign.demo.model;

import com.j256.ormlite.field.DatabaseField;

/**
 *
 * @author octopus
 * @description 
 *
 */
public class BaseModel {
	@DatabaseField(columnName = "ID", id = true)
	private String id;
	@DatabaseField(columnName = "Reserver1")
	private String reserver1;
	@DatabaseField(columnName = "Reserver2")
	private String reserver2;
	@DatabaseField(columnName = "Reserver3")
	private String reserver3;
	@DatabaseField(columnName = "Reserver4")
	private String reserver4;
	@DatabaseField(columnName = "Reserver5")
	private String reserver5;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReserver1() {
		return reserver1;
	}
	public void setReserver1(String reserver1) {
		this.reserver1 = reserver1;
	}
	public String getReserver2() {
		return reserver2;
	}
	public void setReserver2(String reserver2) {
		this.reserver2 = reserver2;
	}
	public String getReserver3() {
		return reserver3;
	}
	public void setReserver3(String reserver3) {
		this.reserver3 = reserver3;
	}
	public String getReserver4() {
		return reserver4;
	}
	public void setReserver4(String reserver4) {
		this.reserver4 = reserver4;
	}
	public String getReserver5() {
		return reserver5;
	}
	public void setReserver5(String reserver5) {
		this.reserver5 = reserver5;
	}
	
	
	
}
