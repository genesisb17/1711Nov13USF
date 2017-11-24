package com.rev.main.interfaces;

import com.rev.pojos.User;

public interface BankOperations extends Runnable{
	void run();
	User login();
	User createAccount();
	void makeDeposit();
	void makeWithdrawal();
}
