package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.User;

public interface DAO {
	User addUser(User u);
	User getUserByUsernameToCreateAccount(String username);
	User getUserByUsernameToLogin(String username);
	User getUserByPasswordToLogin(String password, String username);
	User transaction(User u);
	ArrayList<User> getAllUsers();
}