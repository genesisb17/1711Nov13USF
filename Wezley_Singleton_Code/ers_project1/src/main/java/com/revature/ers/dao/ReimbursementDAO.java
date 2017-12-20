package com.revature.ers.dao;

import java.util.ArrayList;

import com.revature.ers.pojos.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement addReimbursement(Reimbursement newReimbursement);
	Reimbursement getReimbursementById(int reimbursementId);
	ArrayList<Reimbursement> getAllReimbursements();
	ArrayList<Reimbursement> getReimbursementsByAuthorId(int authorId);
	ArrayList<Reimbursement> getPendingReimbursementsByAuthorId(int authorId);
	ArrayList<Reimbursement> getResolvedReimbursementsByAuthorId(int authorId);
	ArrayList<Reimbursement> getReimbursementsByResolverId(int resolverId);
	ArrayList<Reimbursement> getReimbursementsByTypeId(int typeId);
	ArrayList<Reimbursement> getReimbursementByStatusId(int statusId);
	Reimbursement updateReimbursement(int reimbursementId, Reimbursement reimbursement);
	Reimbursement updateReimbursementStatusById(int reimbursementId, int statusId, int resolverId);
	void closeReimbursement(int reimbursementId);

}