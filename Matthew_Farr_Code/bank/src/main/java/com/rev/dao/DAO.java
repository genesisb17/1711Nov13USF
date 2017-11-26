package com.rev.dao;

import java.util.List;

import com.rev.pojos.User;

public interface DAO {
	
	// Write list of users to storage media
	void writeUsers(List<User> users);
	
	// Retrieve the list of users from storage media
	List<User> getUsers();
	
}
