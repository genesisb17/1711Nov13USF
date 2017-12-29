package com.bank3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank3.model.Account;
import com.bank3.repository.AccountRepository;

@Service
@Transactional
public class accountServiceImpl implements AccountService {

	@Autowired
	public AccountRepository accRepo;

	public Account addAccount(Account account) {
		System.out.println("service saving " + account);
		accRepo.save(account);
		return account;
	}
	
	public Account login(String username, String password) {
		return accRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<Account> findAllAccounts() {
		return accRepo.findAll();
	}

	@Override
	public Account findAccountById(Integer id) {
		return accRepo.findOne(id);
	}

	@Override
	public Account deposit(int id, double amount) {
		System.out.println(id + "   " + amount);
		Account acc = accRepo.findOne(id);
		acc.setBalance(acc.getBalance() + amount);
		accRepo.save(acc);
		return acc;
	}
	
	@Override
	public Account withdraw(int id, double amount) {
		Account acc = accRepo.findOne(id);
		acc.setBalance(acc.getBalance() - amount);
		accRepo.save(acc);
		return acc;
	}



	// @Override
	// public boolean updateAccountBalance(Account account, Double amount) {
	// return accRepo.updateAccountBalance(account, amount);
	// }

}
