package com.ERS.DAO;

import java.util.ArrayList;

import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;

public interface ReimbursementDAO {
	
	Reimbursement addReimbursement(Reimbursement ri, User u);
	ArrayList<Reimbursement> getAllReimbursements();
	

}
