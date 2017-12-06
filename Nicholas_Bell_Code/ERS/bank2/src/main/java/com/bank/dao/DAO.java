package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {

		
		User addUser(User u);
		User getUser(String username);
		Account changeBalance(Account u, boolean c, double d);
		Account addAccount(User u);
		ArrayList<Account> getAccounts(User u);
		


}
