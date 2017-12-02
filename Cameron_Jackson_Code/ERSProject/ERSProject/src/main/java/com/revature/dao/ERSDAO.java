package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;

public interface ERSDAO {
	public Users getUserByUsername(String username);
	public Users getUserById(int userId);
	public Users addUser(Users newUser);
	public ArrayList<Reimbursement> getPastTickets(Users employee);
	public 
}
