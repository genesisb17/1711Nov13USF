package com.rev.bank.service;

import java.util.List;

import com.rev.bank.domain.User;

public interface UserService {
	public User findUserByUsername(String username);
	// Get user (by ID)
	public User findUserById(int userId);
	// Get all users
	public List<User> findAllUsers();
	// Add user
	public User addUser(User user);

}
