package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.newUser;

public interface DAO 
{
	void addUser(newUser u);
	newUser getUser(String username,String pass);
	void change(String username, int o);
	void change1(String old, String n);
}
