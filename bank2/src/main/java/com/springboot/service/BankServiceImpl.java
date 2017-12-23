package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Users;
import com.springboot.repository.BankRepository;

@Service
@Transactional
public class BankServiceImpl implements BankService{

	
	@Autowired
	private BankRepository bRepo;
	
	public void addBank(Users u) {
		// TODO Auto-generated method stub
		bRepo.save(u);
	}

	public List<Users> findAllBank() {
		// TODO Auto-generated method stub
		return bRepo.findAll();
	}

	public Users findBankByUsername(String Username) {
		// TODO Auto-generated method stub
		return bRepo.findUserByUsername(Username);
	}
}
