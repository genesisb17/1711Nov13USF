package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.domain.User;
import com.rev.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User addUser(User u) {
		return userRepo.save(u);
	}
	
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	public User findUserById(Integer id) {
		return userRepo.findUserByUserId(id);
	}

	public User updateUser(User u) {
		return userRepo.save(u);
	}
	
	public void delete(Integer id) {
		userRepo.delete(id);
	}
}
