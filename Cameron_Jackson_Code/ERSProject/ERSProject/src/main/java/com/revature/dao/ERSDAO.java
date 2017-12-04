package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;
import com.revature.types.ReimbursementType;
import com.revature.types.UserRoles;

public interface ERSDAO {
	// User related functions
	public Users getUserByUsername(String username);
	public Users getUserById(int userId);
	public ArrayList<Users> getAllUsers();
	public UserRoles getRole(int roleId);
	public Users addUser(Users newUser);
	public String findUsername(String username);
	public String findPassword(String username);
	
	// Reimbursement ticket related functions
	public Reimbursement getTicket(int reimbId);
	public ArrayList<Reimbursement> getPastTickets(int employeeId);
	public ArrayList<Reimbursement> getAllTickets();
	public Reimbursement addTicket(Reimbursement newTicket);
	public Reimbursement resolveTicket(int reimbId, ReimbursementStatus status, int resolverId);
	public ReimbursementStatus getStatus(int statusId);
	public ReimbursementType getType(int typeId);
	
	// May add later
//	public Reimbursement addReceipt(int reimbId, Blob receipt);
	
}
