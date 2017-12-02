package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.User;

public interface UserDAO
{

	public ArrayList<User> getAllUsers();

	public User addUser(User user);

	public User getUser(User user);

	public void deleteUser(int user_id);

}
