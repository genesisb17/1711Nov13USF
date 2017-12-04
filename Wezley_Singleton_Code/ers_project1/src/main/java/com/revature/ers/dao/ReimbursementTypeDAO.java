package com.revature.ers.dao;

import java.util.ArrayList;

import com.revature.ers.pojos.ReimbursementType;

public interface ReimbursementTypeDAO {

	ReimbursementType addReimbursementType(ReimbursementType newReimbursementType);
	ReimbursementType getReimbursementTypeById(int typeId);
	ArrayList<ReimbursementType> getAllReimbursementTypes();
	ReimbursementType updateReimbursementType(int typeId, ReimbursementType reimbursementType);
	void removeReimbursementType(int typeId);
	
}