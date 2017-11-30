package com.rev.dao;

import com.rev.pojos.Account;
import com.rev.pojos.User;

public interface DAO {
	User addUser(User u);

	User getUser(String email, String password);

	Account getAccount(int U_id);
	
	Account addAccount(User u);
	
	Double setBalance(int id, double money);
}
