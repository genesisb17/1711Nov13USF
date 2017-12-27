package com.xchange.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xchange.models.User;
import com.xchange.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public User addUser(User user) {
		repo.save(user);
		return repo.findUserByUsername(user.getUsername());
	}
	
	public List<User> findAllUsers() {
		return repo.findAll();
	}
	
	@Override
	public User findUserById(Long id) {
		return repo.getOne(id);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return repo.findUserByUsername(username);
	}
	
	@Override
	public User findUserByEmail(String email) {
		return repo.findUserByEmail(email);
	}
	
	@Override
	public User updateUserById(Long userId, User updatedUser) {
		return repo.save(updatedUser);
	}
		
}
