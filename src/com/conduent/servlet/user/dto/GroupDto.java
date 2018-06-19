package com.conduent.servlet.user.dto;

import java.io.Serializable;

public class GroupDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String groupname;
	private String groupdescription;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getGroupdescription() {
		return groupdescription;
	}
	public void setGroupdescription(String groupdescription) {
		this.groupdescription = groupdescription;
	}
	@Override
	public String toString() {
		return "GroupDto [id=" + id + ", groupname=" + groupname + ", groupdescription=" + groupdescription + "]";
	}

}
