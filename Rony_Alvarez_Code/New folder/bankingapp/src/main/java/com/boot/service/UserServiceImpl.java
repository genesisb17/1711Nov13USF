package com.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.model.User;
import com.boot.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void addUser(User user) {
		userRepo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		return userRepo.findUserByEmailAndPassword(email, password);
	}
	
	

}
