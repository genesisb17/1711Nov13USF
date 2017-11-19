package com.rev.dao;

import java.util.List;

import com.rev.pojos.User;

public interface DAO {

	/*
	 * Writes the list of users to the storage location
	 */
	void writeUsers(List<User> users);
	
	/*
	 * Retrieves the list of users from the storage location
	 */
	List<User> getUsers();
	
}
