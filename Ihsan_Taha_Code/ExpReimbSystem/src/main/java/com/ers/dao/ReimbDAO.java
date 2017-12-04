package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;

public interface ReimbDAO
{
	public ArrayList<Reimbursement> getAllReimb(User user);
	
	public ArrayList<Reimbursement> getReimbById(User user);

	public Reimbursement addReimb(User user, Reimbursement reimb);

	public Reimbursement getReimb(int reimb_id);
	
	public void updateReimb(Reimbursement reimb);

	public void deleteReimb(int reimb_id);
}
