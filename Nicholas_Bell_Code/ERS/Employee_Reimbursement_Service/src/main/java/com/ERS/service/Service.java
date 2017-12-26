package com.ERS.service;

import java.util.ArrayList;

import com.ERS.DAO.ReimbursementDAO;
import com.ERS.DAO.ReimbursementDAO_Impl;
import com.ERS.DAO.UserDAO;
import com.ERS.DAO.UserDAO_Impl;
import com.ERS.pojos.ReimbRow;
import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;

public class Service {
	
	static ReimbursementDAO RDAO = new ReimbursementDAO_Impl();
	static UserDAO UDAO = new UserDAO_Impl();
	
	public User addUser(User u, boolean admin) {
		System.out.println("Adding user: " + u);
		User addedU = UDAO.addUser(u, admin);
		System.out.println("Added user: " + addedU);
		return addedU;
		
	}
	
	public User getUserbyUN(String username) {
		System.out.println("in service. get userbyU = " + username);
		User u = UDAO.getUserbyUN(username);
		return u;
	}
	
	public User getUserbyEMAIL(String email) {
		System.out.println("in service. get userbyE = " + email);
		User u = UDAO.getUserbyEMAIL(email);
		return u;
	}
	
	public ArrayList<ReimbRow> getTickets(User u){
		System.out.println("in service. Get array of Reimbs");
		ArrayList<ReimbRow> tickets = RDAO.getUserReimbursements(u);
		for(ReimbRow ticket : tickets) {
			System.out.println(ticket);
		}
		return tickets;
	}
	
	public ArrayList<ReimbRow> getAllTickets(){
		System.out.println("in service. Get array of Reimbs");
		ArrayList<ReimbRow> tickets = RDAO.getAllReimbursements();
		for(ReimbRow ticket : tickets) {
			System.out.println(ticket);
		}
		return tickets;
	}
	
	public Reimbursement addTicket(Reimbursement r, User u) {
		System.out.println("START service - ADD TICKET");
		Reimbursement re = RDAO.addReimbursement(r, u);
		System.out.println(re);
		return re;
	}
	
	public void resolve(int id, int status, User u) {
		RDAO.resolve(id, status, u);
	}
	

}
