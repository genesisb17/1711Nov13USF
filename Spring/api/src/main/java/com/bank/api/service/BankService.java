	package com.bank.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.api.domain.User;
import com.bank.api.repository.BankRepository;

@Service
@Transactional 
public class BankService {
	
	@Autowired
	private BankRepository bankRepository;
	
	
	public User addUser(User u) {
		return bankRepository.save(u);
	}
	
	public List<User> getAll(){
		return bankRepository.findAll();
	}

	public User findByEmail(String email) {
		return bankRepository.findUserByEmail(email);
	}
	
	public User findById(Integer id) {
		return bankRepository.findOne(id);
	}
	
	public boolean exists(String email) {
		return bankRepository.existsByEmail(email);
	}
	
}
