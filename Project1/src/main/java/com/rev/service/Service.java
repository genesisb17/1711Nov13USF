package com.rev.service;
import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDao;

public class Service 
{
	static DAO dao = new FileDao();
	
	void addRStatus(String s)
	{
		dao.addRStatus(s);
	}
	void adders_users(String user, String pass, String first, String last, String email)
	{
		dao.adders_users(user, pass, first, last, email);
	}
	public void addRtype(String s)
	{
		dao.addRStatus(s);
	}
	void adders_user_roles(String s)
	{
		dao.adders_user_roles(s);
	}
}
