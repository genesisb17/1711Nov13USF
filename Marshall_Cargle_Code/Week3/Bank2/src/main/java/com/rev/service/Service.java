package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.JDBCDAO;
import com.rev.pojos.Account;
import com.rev.pojos.User;

public class Service {
	static DAO dao = new JDBCDAO();
	
	public User addUser(User u) {
		dao.addUser(u);
		return u;
	}
	
	public User getUser(String email, String password) {
		return dao.getUser(email, password);
	}
	
	public Account getAccount(int u) {
		return dao.getAccount(u);
	}
	
	public Double setBalance(int id, double money) {
		return dao.setBalance(id, money);
	}
}
