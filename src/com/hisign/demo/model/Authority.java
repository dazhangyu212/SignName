package com.hisign.demo.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author octopus
 * @description 
 *
 */
@DatabaseTable(tableName = "Authority")
public class Authority extends BaseModel {
	@DatabaseField(columnName = "ID")
	private String id;
	@DatabaseField(columnName = "TypeName")
	private String typeName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
