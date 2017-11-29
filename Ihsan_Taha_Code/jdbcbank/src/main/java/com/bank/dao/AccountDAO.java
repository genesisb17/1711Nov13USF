package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface AccountDAO
{

	public ArrayList<Account> getAllAccounts(User user);

	public ArrayList<Account> getAccountsByUserId(User user);

	public Account addAccount(User user);

	public Account getAccount(int acc_id);

	public void updateAccount(Account account);

	public void deleteAccount(int acc_id);

}
