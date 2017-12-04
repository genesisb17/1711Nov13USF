package com.revature.ers.dao;

import java.util.ArrayList;

import com.revature.ers.pojos.UserRole;

public interface UserRoleDAO {
	
	UserRole addUserRole(UserRole newUserRole);
	UserRole getUserRoleById(int roleId);
	ArrayList<UserRole> getAllUserRoles();
	UserRole updateUserRole(int roleId, UserRole userRole);
	void removeUserRole(int roleId);

}