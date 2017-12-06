package com.rev.service;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;

public class Service {
	static DAO dao = new DAOImpl();
	
	public int addUser(User u) {
		

			return dao.addUser(u);

		
	}
	//funciton returns true if username is found and false if not
	public boolean findUser2(String uname) {
		
		return dao.findUser2(uname);
		
	}
	
	//function returns user when passed a string for username to search for
	public User findUser(String uname) {
		
		return dao.findUser(uname);
		
	}
	
	public boolean checkPass(User u,String pass) {
		
		return dao.checkPass(u,pass);
	}
	
	public void addRequest(Reimbursement reimb) {
		
		dao.addRequest(reimb);
	}
	
	public void returnTickets(User u) {
		
		dao.viewTickets(u);
		
	}
	
	

}
