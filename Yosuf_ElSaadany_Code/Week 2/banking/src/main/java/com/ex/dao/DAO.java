package com.ex.dao;

import com.ex.pojos.Accounts;
import com.ex.pojos.Users;

public interface DAO {
	
	Users addUser(Users u);
	
	Users VerifyUsernameToLogin(String username);
	
	Users VerifyPasswordToLogin(String password, String username);

	Users withdraw(Users u, Accounts a, double d);
	
	Users deposit(Users u, Accounts a, double d);

	Accounts viewBalance(Users u);


}
