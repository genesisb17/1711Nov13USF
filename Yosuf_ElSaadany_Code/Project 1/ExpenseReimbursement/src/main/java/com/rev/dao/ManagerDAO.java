package com.rev.dao;

import java.util.ArrayList;

import com.rev.DTOs.ManagerTicketInfo;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;

public interface ManagerDAO {
	
	ArrayList<ManagerTicketInfo> managerTicketInfo();
	ArrayList<ManagerTicketInfo> filterByStatus(ReimbursementStatus rs);
	int processRequest(int status_ID, int Reimb_ID, int Resolver_ID);
}
