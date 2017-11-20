package com.rev.dao;

import com.rev.pojos.User;

public interface DAO {
	
	User addUser(User u);
	User getUser(String userName);
	User updateUser(User u);
	User removeUser(User u);

}
