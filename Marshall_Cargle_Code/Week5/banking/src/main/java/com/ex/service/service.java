package com.ex.service;

import java.util.List;

import com.ex.domain.User;

public interface service {

	
	public User addUser(User u);
	public List<User> findAllUsers();
	public User findUserByEmail(String email);
	public User findUserById(Integer id);
	public void updateUser(User u);
}
