package com.revature.ers.dao;

import java.util.ArrayList;

import com.revature.ers.pojos.ReimbursementStatus;

public interface ReimbursementStatusDAO {
	
	ReimbursementStatus addReimbursementStatus(ReimbursementStatus newReimbursementStatus);
	ReimbursementStatus getReimbursementStatusById(int statusId);
	ArrayList<ReimbursementStatus> getAllReimbursementStatuses();
	ReimbursementStatus updateReimbursementStatus(int statusId, ReimbursementStatus reimbursementStatus);
	void removeReimbursementStatus(int statusId);
	
}