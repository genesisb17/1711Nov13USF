package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.FileDao;

public class Service 
{
	static DAO dao = new FileDao();
	
	public void connect() 
	{
		dao.connect();
	}
}
