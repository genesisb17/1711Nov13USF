package com.rev.banking.service;

import java.util.List;

import com.rev.banking.domain.User;

public interface UserService {

	List<User> findAllUsers();
	User findUserById(int id);
	User findUserByUsername(String username);
	User findUserByEmail(String email);
	User findUserByUsernameAndPassword(String username, String password);
	void addUser(User u);
	User updateUser(User u);
}
