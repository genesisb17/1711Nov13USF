package com.xchange.services;

import java.util.List;

import com.xchange.models.User;

public interface UserService {
	
	public User addUser(User newUser);
	public List<User> findAllUsers();
	public User findUserById(Long id);
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
	public User updateUserById(Long userId, User updatedUser);

}
