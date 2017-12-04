package com.revature.ers.pojos;

public class UserRole {
	
	private int roleId;
	private Role role;
	
	/*
	 * No args constructor
	 */
	public UserRole() {
		super();
	}
	
	/**
	 * @param roleId
	 * @param role
	 */
	public UserRole(int roleId, Role role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
}
