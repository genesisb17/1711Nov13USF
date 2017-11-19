package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {

	void addUser(User u);
	User getUser(String username);
	
}
