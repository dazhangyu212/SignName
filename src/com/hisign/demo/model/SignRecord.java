package com.hisign.demo.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author octopus
 * @description 
 *
 */
@DatabaseTable(tableName="SignRecord")
public class SignRecord extends BaseModel {
	@DatabaseField(columnName = "ID")
	private String ID;
	@DatabaseField(columnName = "StartTime")
	private String startTime;
	@DatabaseField(columnName = "EndTime")
	private String endTime;
	@DatabaseField(columnName = "Description")
	private String description;
	@DatabaseField(columnName = "Remark")
	private String remark;
	@DatabaseField(columnName = "UserId")
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
