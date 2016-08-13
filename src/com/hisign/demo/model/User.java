package com.hisign.demo.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author octopus
 * @description 
 *
 */
@DatabaseTable(tableName = "User")
public class User  extends BaseModel{
	
	@DatabaseField(columnName="UserName")
	private String userName;
	@DatabaseField(columnName="Password")
	private String password;
	@DatabaseField(columnName="TrueName")
	private String trueName;
	@DatabaseField(columnName="AuthType")
	private String authType;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
	
	
	
	
}
