package com.rev.dao;

import java.util.List;

import com.rev.pojos.User;

public interface UserDAO {
	
	public List<User> getUsers();
	
	public User getUser(int id);
	
	public User getUser(String username);
	
	public int addUser(String fn, String ln, String un, String em, String pw, int roleId);
	
	public void deleteUser(int id);
	
}
