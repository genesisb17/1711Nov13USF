package com.ex.angularbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.angularbank.model.Account;
import com.ex.angularbank.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImp implements AccountService {
	
	@Autowired
	private AccountRepository dao;	
	
	@Override
	public void addAccount(Account account) {
		dao.save(account);
	}

	@Override
	public Account findAccountByEmail(String email) {
		return dao.findAccountByEmail(email);
	}

	@Override
	public List<Account> findAllAccounts() {
		return dao.findAll();
	}

}
