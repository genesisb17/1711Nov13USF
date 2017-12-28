package com.bank3.service;

import java.util.List;

import com.bank3.model.Account;

public interface AccountService {

	public void addAccount(Account account);
	public List<Account> findAllAccounts();
	public Account findAccountById(Integer id);
	public Account login(String username, String password);
	public void deposit(Account account);
	public void withdraw(Account account);
//	public Account findAccountByUsernameAndPassword(String username, String password);
//	public boolean updateAccountBalance(Account account, Double amount);
}
