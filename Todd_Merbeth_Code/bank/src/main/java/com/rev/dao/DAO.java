package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.User;

public interface DAO {

	User addUser(User u);
	void updateUserData(ArrayList<User> users);
	ArrayList<User> updateUserList(ArrayList<User> names);
	
}
