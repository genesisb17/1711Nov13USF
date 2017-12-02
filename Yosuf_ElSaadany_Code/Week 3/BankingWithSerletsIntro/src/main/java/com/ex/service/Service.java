package com.ex.service;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Accounts;
import com.ex.pojos.Users;

public class Service {
	
	static DAO dao = new DAOImpl();

	public Users createAccount(Users u) {
		if(dao.addUser(u) == null)
			return null;
		return u;
	}

	public Users VerifyUsernameToLogin(String username) {
		Users u = new Users();
		u = dao.VerifyUsernameToLogin(username);
		if(u == null)
			return null;
		return u;
	}

	public Users VerifyPasswordToLogin(String password, String username) {
		Users u = new Users();
		u = dao.VerifyPasswordToLogin(password, username);
		if(u == null)
			return null;
		return u;
	}

	public Users withdraw(Users u, Accounts a, double d) {
		u = dao.withdraw(u, a, d);
		if(u == null) {
			return null;
		}
		return u;
	}

	public Users deposit(Users u, Accounts a, double d) {
		u = dao.deposit(u, a, d);
		if(u == null) {
			return null;
		}
		return u;
	}

	public Accounts viewBalance(Users u) {
		Accounts a = new Accounts();
		a = dao.viewBalance(u);
		if(a == null) {
			return null;
		}
		return a;
	}
}
