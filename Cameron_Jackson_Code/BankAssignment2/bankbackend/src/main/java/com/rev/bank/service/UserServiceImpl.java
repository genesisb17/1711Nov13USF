package com.rev.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.bank.domain.User;
import com.rev.bank.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uRepo;

	@Override
	public User findUserByUsername(String username) {
		return uRepo.findUserByUsername(username);
	}

	@Override
	public User findUserById(int userId) {
		return uRepo.findOne(userId);
	}

	@Override
	public List<User> findAllUsers() {
		return uRepo.findAll();
	}

	@Override
	public User addUser(User user) {
		return uRepo.save(user);
	}
	


}
