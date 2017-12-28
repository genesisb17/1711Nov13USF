package com.boot.service;

import java.util.List;

import com.boot.model.User;

public interface UserService {

	public void addUser(User user);
	public List<User> findAllUsers();
	public User findUserByEmail(String email);
	public User findUserByEmailAndPassword(String email, String password);
	
}
