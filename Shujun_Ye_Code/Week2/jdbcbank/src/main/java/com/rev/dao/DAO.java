package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.User;

public interface DAO {

	User addUser(User u);
	User getUser(String username);
	// self
	ArrayList<User> getAllUsers();
	double depositMoney(User u, double money);
	double withdrawMoney(User u, double money);
}