package com.real.dao;

import com.real.pojos.User;

public interface DAO {

	void updateBalance(User u, double newB);
	User addUser(User u);
	User getUser(String uName);
	
}