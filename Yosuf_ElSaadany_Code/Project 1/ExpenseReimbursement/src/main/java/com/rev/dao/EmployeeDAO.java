package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementType;
import com.rev.pojos.User;

public interface EmployeeDAO {
	
	User Login(User u);
	Reimbursement AddReimbursement(Reimbursement r, User u);
	ArrayList<Reimbursement> viewPastTickets(User u);
	
}
