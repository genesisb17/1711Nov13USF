package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.BankAccount;
import com.rev.pojos.User2;

public interface DAO2 {
	
	public User2 createUserAccount(User2 user);
	public User2 getUserById(int uid);
	public BankAccount getBankAccountById(int aid);
	public ArrayList<User2> getUsers();
	public ArrayList<BankAccount> getUsersBankAccounts(User2 user);
	public double adjustBalance(BankAccount bankAccount, double amount);
	public User2 getUserByUnameAndPassword(String userName, String password);
	public BankAccount createBankAccount(BankAccount account);
	public User2 getUserByUname(String userName);

}
