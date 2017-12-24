package com.rev.bank.service;

import java.util.List;

import com.rev.bank.domain.User;

public interface UserService {
	public User findUserByUsername(String username);
	public User findUserByUsernameAndPassword(String username, String password);
	public User findUserById(int userId);
	public List<User> findAllUsers();
	public User updateUser(User user);

}
