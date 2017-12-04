package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;

public interface ManagerDAO {

	ArrayList<Reimbursement> viewAllTickets();
	ArrayList<Reimbursement> filterByStatus(ReimbursementStatus rs);
	int processRequest(int status_ID, int Reimb_ID);
}
