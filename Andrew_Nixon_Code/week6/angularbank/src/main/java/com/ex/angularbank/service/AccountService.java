package com.ex.angularbank.service;

import java.util.List;

import com.ex.angularbank.model.Account;

public interface AccountService {
	
	public void addAccount(Account account);
	public Account findAccountByEmail(String email);
	public List<Account> findAllAccounts();

}
