package com.ERS.service;

import com.ERS.DAO.ReimbursementDAO;
import com.ERS.DAO.ReimbursementDAO_Impl;
import com.ERS.DAO.UserDAO;
import com.ERS.DAO.UserDAO_Impl;
import com.ERS.pojos.User;

public class Service {
	
	static ReimbursementDAO RDAO = new ReimbursementDAO_Impl();
	static UserDAO UDAO = new UserDAO_Impl();
	
	public User getUser(String username) {
		System.out.println("in service. get user = " + username);
		User u = UDAO.getUser(username);
		return u;
	}

}
