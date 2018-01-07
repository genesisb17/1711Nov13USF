package com.rev.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.banking.domain.User;
import com.rev.banking.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> findAllUsers(){
		return userRepo.findAll();
	}
	
	@Override
	public User findUserById(int id) {
		return userRepo.findOne(id);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		return userRepo.findUserByUsernameAndPassword(username, password);
	}

	@Override
	public void addUser(User u) {
		userRepo.save(u);
	}

	@Override
	public User updateUser(User u) {
		return userRepo.save(u);
		
	}
}
