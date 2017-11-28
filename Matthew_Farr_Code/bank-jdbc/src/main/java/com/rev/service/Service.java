package com.rev.service;

import java.math.BigDecimal;
import java.util.List;

import com.rev.dao.DAO;
import com.rev.dao.DAOImpl;
import com.rev.pojos.User;
import com.rev.pojos.Account;

public class Service {
	
	private DAO dao;
	
	public Service() {
		super();
		dao = new DAOImpl();
	}
	
	public User createUser(String firstname, String lastname, String username, String password) {
		return dao.addUser(new User(firstname, lastname, username, password));
	}
	
	public User getUser(String username) {
		return dao.getUser(username);
	}
	
	public boolean hasUser(String username) {
		return dao.getUser(username) != null;
	}
	
	public List<Account> getUserAccounts(User u) {
		return dao.getUserAccounts(u);
	}
	
	public Account addAccount(User u, BigDecimal balance) {
		Account a = new Account(u.getId(), balance);
		return dao.addAccount(a);
	}
	
	public Account deposit(Account a, BigDecimal deposit) {
		return dao.deposit(a, deposit);
	}
	
	public Account withdraw(Account a, BigDecimal withdrawal) {
		return dao.withdraw(a, withdrawal);
	}

}
