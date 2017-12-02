package com.revature.dao;

import java.sql.Blob;
import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;
import com.revature.types.ReimbursementType;

public interface ERSDAO {
	// User related functions
	public Users getUserByUsername(String username);
	public Users getUserById(int userId);
	public ArrayList<Users> getAllUsers();
	public Users addUser(Users newUser);
	public ArrayList<Reimbursement> getPastTickets(Users employee);
	public String findUsername(String username);
	public String findPassword(String username);
	
	// Reimbursement ticket related functions
	public Reimbursement getTicket(int reimbId);
	public ArrayList<Reimbursement> getAllTickets(Users manager);
	public Reimbursement addTicket(Reimbursement newTicket);
	public Reimbursement resolveTicket(int reimbId, ReimbursementStatus status, int resolverId);
	
	// May add later
//	public Reimbursement addReceipt(int reimbId, Blob receipt);
	
}
