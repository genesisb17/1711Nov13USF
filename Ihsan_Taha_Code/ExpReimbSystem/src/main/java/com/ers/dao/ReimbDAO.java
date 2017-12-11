package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;

public interface ReimbDAO
{
	public ArrayList<Reimbursement> getAllReimb();
	
	public ArrayList<Reimbursement> getReimbByUser(User user);

	public Reimbursement addReimb(User user, Reimbursement reimb);

	public Reimbursement getReimb(int reimb_id);
	
	public void updateReimb(Reimbursement reimb);
	
	public void updateReimbByManager(User manager, int statusId, int reimbId);

	public void deleteReimb(int reimb_id);
}
