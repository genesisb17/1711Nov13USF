package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.FileDAO;
import com.rev.pojos.User;

public class Service {
	static DAO dao = new FileDAO();
	public User addUser(User u){
		//validate username doesn't exist possibly in dao 
		//assuming doesn't exist 
		dao.addUser(u);
		return u;
		
	}
	public User update(String username,double update)
	{
		//System.out.println("i  am in service ");
		return dao.updateUser(username, update);
	}
	
	
	
}
