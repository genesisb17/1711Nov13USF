package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {

	User addUser(User u);
	User getUser(String username, String password);
	User addMoney(double amount);
	User getBalance(String username, String password);
	
}
