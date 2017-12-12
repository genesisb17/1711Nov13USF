package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.R_Status;
import com.rev.pojos.R_Type;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public interface DAO {

	//For employees
	public ArrayList<Reimbursement> getUserReimbursements(int u_id); 
	
	public Reimbursement addReimbursement(Reimbursement r);
	
	public ArrayList<R_Type> getAllRTypes();
	
	//For managers
	public ArrayList<Reimbursement> getReimbursements();
	
	public ArrayList<R_Status> getAllRStatus();
	
//	public ArrayList<Reimbursement> getReimbursementsByStatus(); // Maybe need later? Depends on how decide to show data
	
	public ArrayList<Reimbursement> getPendingReimbursements();
	
	public Reimbursement getReimbursement(int r_id);
	
	public Reimbursement updateReimbursement(int r_id, int r_res, int r_status);
	//For both
	public User addUser(User user); // Optional
	
	public boolean checkUsername(String username); // Optional for new user
	
	public boolean checkEmail(String email); // Optional for new user
	
	public User getUser(String username, String password); // For login
	
	public String getR_Status(int r_id);
	
	public String getR_Type(int r_id);
	
	public String getUser_Role(int u_id);
	
	public String getFirstAndLastById(int id);
	
	
}
