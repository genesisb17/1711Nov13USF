package com.revature.ers.pojos;

public enum Role {
	
	EMPLOYEE, MANAGER, ADMIN;
	
	@Override
	public String toString() {
		
		switch(this) {
			case EMPLOYEE:	return "employee";
			case MANAGER:	return "manager";
			case ADMIN:		return "admin";
			default:		return "";
		}
	}
}