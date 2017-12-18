package com.rev.dao;

import java.util.List;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public interface ReimbursementDAO {
	
	public Reimbursement addReimbursement (User u, double amount, String description, int typeId);
	
	public List<Reimbursement> getUserReimbursements(User u);
	
	public List<Reimbursement> getReimbursements();
	
	public Reimbursement getReimbursement(int id);
	
	public void updateReimbursement(User manager, int reimbId, int statusId);
	
	public void deleteReimbursement(int reimbId);
	
}
