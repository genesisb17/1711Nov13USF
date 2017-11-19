package com.rev.dao;

import java.util.List;

import com.rev.pojos.User;

public interface DAO {

	void writeUsers(List<User> users);
	List<User> getUsers();
	
}
