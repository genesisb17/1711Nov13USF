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

	public void addAccount(Account account) {
		System.out.println("service saving " + account);
		accRepo.save(account);
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
	public void deposit(Account account) {
		Account acc = accRepo.findOne(account.getId());
		acc.setBalance(acc.getBalance() + account.getBalance());
		accRepo.save(acc);
	}

	@Override
	public void withdraw(Account account) {
		Account acc = accRepo.findOne(account.getId());
		acc.setBalance(acc.getBalance() - account.getBalance());
		accRepo.save(acc);
	}

	// @Override
	// public boolean updateAccountBalance(Account account, Double amount) {
	// return accRepo.updateAccountBalance(account, amount);
	// }

}
