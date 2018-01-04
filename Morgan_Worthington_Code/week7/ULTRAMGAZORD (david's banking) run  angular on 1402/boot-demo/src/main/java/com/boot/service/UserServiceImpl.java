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
	private UserRepository uRepo;
	
	
	public void addUser(User u) {
		uRepo.save(u);
	}

	public List<User> findAllUsers() {
		return uRepo.findAll();
	}

	public User findUserByUsername(String u) {
		return uRepo.findUserByUsername(u);
	}
	public User updateUser(User user) {
		return uRepo.save(user);
	}



}
