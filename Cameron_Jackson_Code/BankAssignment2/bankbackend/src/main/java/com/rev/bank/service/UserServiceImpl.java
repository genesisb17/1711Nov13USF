package com.rev.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.bank.domain.User;
import com.rev.bank.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository uRepo;

	@Override
	public User findUserByUsername(String username) {
		return uRepo.findUserByUsername(username);
	}
	
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		return uRepo.findUserByUsernameAndPassword(username, password);
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
	public User updateUser(User user) {
		return uRepo.save(user);
	}

}
