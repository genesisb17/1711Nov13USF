package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojo.newUser;

public interface DAO 
{
	void addUser(newUser u);
	newUser getUser(String username,String pass);
	void Delete(String username,ArrayList<String> a,String update);
	void change(String username, int o);
}
