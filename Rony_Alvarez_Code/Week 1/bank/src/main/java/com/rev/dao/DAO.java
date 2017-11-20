package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {

	User addUser(User u);
	User getUser(String username, String password);
	User addMoney(String username, String password, String amount);
	User getBalance(String username, String password);
	User withdrawMoney(String username, String password, String amout);
	
}
