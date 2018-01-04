package com.boot.service;

import java.util.List;

import com.boot.model.User;


public interface UserService {

	public void addUser(User u);
	public List<User> findAllUsers();
	public User findUserByUsername(String Username);
	public User updateUser(User user);

}
