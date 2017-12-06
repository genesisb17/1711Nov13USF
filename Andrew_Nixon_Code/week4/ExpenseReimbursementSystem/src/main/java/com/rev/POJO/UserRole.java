package com.rev.POJO;

public class UserRole {
	
	private int roleID;
	private String user;
	
	public UserRole() {}
	
	public UserRole(int roleID, String user) {
		super();
		this.roleID = roleID;
		this.user = user;
	}



	public int getRoleID() {
		return roleID;
	}



	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", user=" + user + "]";
	}
	
	

}
