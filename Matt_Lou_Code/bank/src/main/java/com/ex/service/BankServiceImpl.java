package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.model.User;
import com.ex.repository.BankRepository;


@Service
@Transactional
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepository bankRepo;


	public void addUser(User u) {
		bankRepo.save(u);
	}


	public List<User> findAllUsers() {
		return bankRepo.findAll();
	}
	
	public User findUserById(Integer id) {
		return bankRepo.findOne(id);
	}

	public void updateUser(User user) {
		User u = bankRepo.findOne(user.getUser_id());
		u.setFirstname(user.getFirstname());
		u.setLastname(user.getLastname());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		bankRepo.save(u);
	}

	public void deposit(User user) {
		User u = bankRepo.findOne(user.getUser_id());
		u.setBalance(u.getBalance() + user.getBalance());
		bankRepo.save(u);
	}

	public void withdraw(User user) {
		User u = bankRepo.findOne(user.getUser_id());
		u.setBalance(u.getBalance() - user.getBalance());
		bankRepo.save(u);
	}

	public List<User> login(User user) {
		return bankRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());		
	}

	
	public List<User> findUserByEmail(String email) {
		return bankRepo.findUserByEmail(email);
		
	}
	
	
}




