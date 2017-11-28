package com.rev.dao;

import java.math.BigDecimal;
import java.util.List;

import com.rev.pojos.Account;
import com.rev.pojos.User;

public interface DAO {
	
	public List<User> getUsers();
	public List<Account> getAccounts();
	public List<Account> getUserAccounts(User u);
	public User getUser(int id);
	public User getUser(String username);
	public Account getAccount(int id);
	
	public User addUser(User u);
	public Account addAccount(Account a);
	
	public Account deposit(Account a, BigDecimal deposit);
	public Account withdraw(Account a, BigDecimal withdrawal);
	
}
