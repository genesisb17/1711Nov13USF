package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Account;
import com.rev.pojos.User;

public interface DAO {

	public ArrayList<User> getUsers();

	public User addUser(User user);
	
	public ArrayList<Account> getAccounts(User user);
	
	public Account getAccount(int acc);

	public Account createAccount(User user);

	public Account updateDeposit(Account account, double dep);
	
	public Account updateWithdraw(Account account, double wd);
	
}
