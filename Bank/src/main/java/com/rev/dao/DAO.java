package com.rev.dao;

import com.rev.pojo.newUser;

public interface DAO 
{
	void addUser(newUser u);
	newUser getUser(String username);
	void DeleteUser(String username);
}
