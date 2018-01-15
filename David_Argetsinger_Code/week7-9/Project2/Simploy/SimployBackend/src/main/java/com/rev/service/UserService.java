package com.rev.service;

import java.util.List;

import com.rev.domain.User;

public interface UserService {
	public User addUser(User u);
	public List<User> findAllUsers();
	public User findUserByEmail(String email);
	public User findUserById(Integer id);
	public User updateUser(User u);
}
