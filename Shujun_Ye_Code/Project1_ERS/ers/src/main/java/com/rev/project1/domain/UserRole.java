package com.rev.project1.domain;

/**
 * Different user roles in the company.
 * @author Shujun Ye
 */
public enum UserRole {
	EMPLPOYEE(1),
	MANAGER(2)
	;
	
	/** Role id associated with different users */
	private final int roleId;
	
	/**
	 * UserRole Constructor 
	 * @param roleId id asscoiated with different types of users
	 */
	UserRole(int roleId){
		this.roleId = roleId;
	}
	
	/**
	 * Return user role id
	 * @return user role id
	 */
	public int getRoleId() {
		return roleId;
	}
}
 


