package com.rev.dao;

import com.rev.pojos.Account;

public interface AccountDAO {
	
	Account addAccount(Account acct);
	Account getAccountById(int acctId);
	Account updateBalance(int acctId, double newBalance);
	
}
