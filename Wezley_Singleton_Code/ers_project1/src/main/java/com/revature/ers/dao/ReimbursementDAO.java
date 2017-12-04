package com.revature.ers.dao;

import java.util.ArrayList;

import com.revature.ers.pojos.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement addReimbursement(Reimbursement newReimbursement);
	Reimbursement getReimbursementById(int reimbursementId);
	ArrayList<Reimbursement> getAllReimbursements();
	ArrayList<Reimbursement> getReimbursementsByAuthor(int authorId);
	ArrayList<Reimbursement> getReimbursementsByResolver(int resolverId);
	ArrayList<Reimbursement> getReimbursementsByType(int typeId);
	ArrayList<Reimbursement> getReimbursementByStatus(int statusId);
	Reimbursement updateReimbursement(int reimbursementId, Reimbursement reimbursement);
	void removeReimbursement(int reimbursementId);

}