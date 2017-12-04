package com.revature.ers.dao;

import java.util.ArrayList;

import com.revature.ers.pojos.User;

public interface UserDAO {
	
	User addUser(User newUser);
	User getUserById(int userId);
	User getUserByUsername(String username);
	User getUserByEmailAddress(String emailAddress);
	ArrayList<User> getAllUsers();
	ArrayList<User> getUsersByRole(int roleId);
	User updateUser(int userId, User user);
	
}