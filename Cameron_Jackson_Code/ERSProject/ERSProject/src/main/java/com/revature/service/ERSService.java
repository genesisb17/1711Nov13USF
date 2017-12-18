package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.ERSDAO;
import com.revature.dao.ERSDatabaseDAO;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;
import com.revature.types.ReimbursementType;

public class ERSService {
	static ERSDAO dao = new ERSDatabaseDAO();

	public boolean userExists(String username) {
		String existingUser = dao.findUsername(username);
		if (existingUser != null) 
			return true;

		return false;
	}

	public boolean correctPassword(String username, String password) {
		String existingPass = dao.findPassword(username);
		if (userExists(username) && existingPass.equals(password)) 
			return true;

		return false;
	}

	public boolean uniqueEmail(String email) {
		String existingEmail = dao.findEmail(email);
		if (existingEmail != null) 
			return false;

		return true;
	}

	public Users login(String username, String password) {
		Users u = null;
		if (userExists(username) && correctPassword(username, password)) 
			u = dao.getUserByUsername(username);

		return u;
	}

	public Users createAccount(Users newUser) {
		Users u = null;
		if (!userExists(newUser.getUsername()))
			u = dao.addUser(newUser);

		return u;
	}

	public Users updateAccount(Users user) {
		Users u = null;
		if ((user.getUsername() != null) && (user.getPassword() != null) && (user.getEmail() != null))
			u = dao.updateAccount(user);

		return u;
	}

	public Users getUser(int userId) {
		Users u = null;
		u = dao.getUserById(userId);
		return u;
	}

	public Users getUserByUsername(String username) {
		Users u = null;
		u = dao.getUserByUsername(username);
		return u;
	}

	public Users getUserByEmail(String email) {
		Users u = null;
		u = dao.getUserByEmail(email);
		return u;
	}

	public Reimbursement getTicket(int reimbId) {
		Reimbursement ticket = null;
		ticket = dao.getTicket(reimbId);
		return ticket;
	}

	public ArrayList<Reimbursement> getPastTickets(int userId) {
		ArrayList<Reimbursement> tickets = dao.getPastTickets(userId);
		if (tickets.isEmpty())
			return null;

		return tickets;
	}

	public ArrayList<Reimbursement> getAllTickets() {
		ArrayList<Reimbursement> tickets = dao.getAllTickets();
		if (tickets.isEmpty())
			return null;

		return tickets;
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

	public String getStatus(int statusId) {
		ReimbursementStatus status = dao.getStatus(statusId);
		return status.name();
	}

	public String getType(int typeId) {
		ReimbursementType type = dao.getType(typeId);
		return type.name();
	}
}
