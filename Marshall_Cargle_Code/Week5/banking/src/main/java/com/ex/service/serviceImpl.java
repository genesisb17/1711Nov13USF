package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ex.domain.User;
import com.ex.repository.UserRepository;

@Service
@Transactional
public class serviceImpl implements service {

	@Autowired
	private UserRepository userRepo;
	
	public User addUser(User u) {
		return userRepo.save(u);
	}

	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}
	
	@Override
	public User findUserById(Integer id) {
		return userRepo.findOne(id);
	}
	
	public void updateUser(User u) {
		userRepo.save(u);
	}

	


}
