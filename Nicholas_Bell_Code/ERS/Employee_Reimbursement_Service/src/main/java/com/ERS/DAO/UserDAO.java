package com.ERS.DAO;

import java.util.ArrayList;

import com.ERS.pojos.User;

public interface UserDAO {
	User addUser(User u, boolean admin);
	User getUserbyUN(String username);
	User getUserbyEMAIL(String username);
	ArrayList<User> getAllUsers();
	

}
