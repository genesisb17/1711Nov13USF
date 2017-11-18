package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDao;
import com.rev.pojo.newUser;

public class Service 
{
	static DAO dao = new FileDao();
	public newUser addUser(newUser u)
	{
		dao.addUser(u);
		return u;
	}
	public static newUser getUser(String username, String pass)
	{
		return dao.getUser(username,pass);
	}
	
}
