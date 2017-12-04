package com.revature.service;

import com.revature.dao.ERSDAO;
import com.revature.dao.ERSDatabaseDAO;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;

public class ERSService {
	static ERSDAO dao = new ERSDatabaseDAO();
	
	private boolean userExists(String username) {
		String existingUser = dao.findUsername(username);
		if (existingUser != null) 
			return true;
		
		return false;
	}
	
	public Users login(String username, String password) {
		Users u = null;
		if (userExists(username)) {
			if (password.equals(dao.findPassword(username)))
				u = dao.getUserByUsername(username);
		}
		return u;
	}
	
	public Users createAccount(Users newUser) {
		Users u = null;
		if (!userExists(newUser.getUsername()))
			u = dao.addUser(newUser);
		
		return u;
	}
	
	public Reimbursement getTicket(int reimbId) {
		Reimbursement ticket = null;
		ticket = dao.getTicket(reimbId);
		return ticket;
	}
	
	public Reimbursement addTicket(Reimbursement newTicket) {
		Reimbursement ticket = null;
		ticket = dao.addTicket(newTicket);
		return ticket;
	}
	
	public Reimbursement resolveTicket(int reimbId, ReimbursementStatus status, int resolverId) {
		Reimbursement ticket = null;
		ticket = dao.resolveTicket(reimbId, status, resolverId);
		return ticket;
	}
}
