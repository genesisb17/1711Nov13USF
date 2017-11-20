package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {
	void addBackUser(User u);
	void addNewUser(User u);
	User getUser(String username);
}
