package com.ERS.DAO;

import java.util.ArrayList;

import com.ERS.pojos.User;

public interface UserDAO {
	User addUser(User u, boolean admin);
	User getUser(String username);
	ArrayList<User> getAllUsers();
	

}
