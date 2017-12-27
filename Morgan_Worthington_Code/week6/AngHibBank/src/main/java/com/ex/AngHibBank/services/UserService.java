package com.ex.AngHibBank.services;

import java.util.List;
import java.util.Optional;

import com.ex.AngHibBank.model.User;

public interface UserService {
	
	public void addUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUserById(int id);
	public User getUserByUsername(String username);
	public void updateUser(User user);
	
}
