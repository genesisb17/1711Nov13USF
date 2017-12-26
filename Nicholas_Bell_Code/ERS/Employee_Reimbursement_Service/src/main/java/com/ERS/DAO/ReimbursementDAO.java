package com.ERS.DAO;

import java.util.ArrayList;

import com.ERS.pojos.ReimbRow;
import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;

public interface ReimbursementDAO {
	
	Reimbursement addReimbursement(Reimbursement ri, User u);
	ArrayList<ReimbRow> getAllReimbursements();
	ArrayList<ReimbRow> getUserReimbursements(User u);
	void resolve(int id, int status, User u);
	

}
