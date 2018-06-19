package com.conduent.servlet.user.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable {

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int id;
	private Date creationdate;
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname=lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserDto [firstname=" + firstname + ", lastname="+ lastname +",username=" + username + ", password=" + password + "]";
	}
	
	


	
}
