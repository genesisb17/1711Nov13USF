package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public interface EmployeeDAO {
	
	User Login(User u);
	int Register(User u);
	Reimbursement AddReimbursement(Reimbursement r, User u);
	ArrayList<Reimbursement> viewPastTickets(User u);
	User UpdateInfo(User new_u, User old_user);
}
