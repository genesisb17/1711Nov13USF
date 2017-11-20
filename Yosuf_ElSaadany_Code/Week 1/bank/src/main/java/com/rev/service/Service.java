package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	static DAO dao = new FileDAO();

	public User addUser(User u) {
		User x = new User();
		x = dao.getUserByUsernameToCreateAccount(u.getUsername());
		if(x == null)
			return x;
		else {
			dao.addUser(u);
			return u;
		}
	}
	
	public User getUserByUsernameToLogin(String username) {
		User u = new User();
		u = dao.getUserByUsernameToLogin(username);
		if(u != null) {
			return u;
		}
		return null;
	}
	
	public User getUserByPasswordToLogin(String password, String username) {
		User s1 = new User();
		s1 = dao.getUserByPasswordToLogin(password, username);
		if(s1 != null) {
			return s1;
		}
		return null;
	}
	
	public User withdraw(User u, double d) {
		if(u.getBalance() >= d) {
			u.setBalance(u.getBalance() - d);
			dao.transaction(u);
			return u;
		}
		else 
			return null;
	}
	
	public User deposit(User u, double d) {
		u.setBalance(u.getBalance() + d);
		dao.transaction(u);
		return u;
	}
}