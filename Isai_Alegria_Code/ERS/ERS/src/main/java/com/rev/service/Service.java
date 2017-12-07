package com.rev.service;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

import java.util.ArrayList;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;

public class Service {
	static DAO dao = new DAOImpl();
	
	public int addUser(User u) {
		

			return dao.addUser(u);

		
	}
	//function returns true if username is found and false if not
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
	
	public ArrayList<Reimbursement> returnTickets(User u) {
		
		return dao.returnTickets(u);
		
	}
	
	public ArrayList<Reimbursement> returnPendingTickets(){
		
		return dao.returnPendingTickets();
	}
	
	public void approveDenyRequest(int requestID, int reimStatus) {
		
		dao.approveDenyRequest(requestID,reimStatus);
		
	}

}
