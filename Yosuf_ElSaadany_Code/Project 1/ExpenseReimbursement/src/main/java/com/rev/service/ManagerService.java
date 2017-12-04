package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.ManagerDAO;
import com.rev.dao.ManagerDAOImpl;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;

public class ManagerService {
	
	static ManagerDAO manDAO = new ManagerDAOImpl();

	public ArrayList<Reimbursement> viewAllTickets() {
		ArrayList<Reimbursement> allTickets = new ArrayList<Reimbursement> ();
		allTickets = manDAO.viewAllTickets();
		if(allTickets == null) {
			System.out.println("NULL");
			return null;
		}
		return allTickets;
	}
	
	public ArrayList<Reimbursement> filterByStatus(ReimbursementStatus rs){
		ArrayList<Reimbursement> filteredTickets = new ArrayList<Reimbursement> ();
		filteredTickets = manDAO.filterByStatus(rs);
		if(filteredTickets == null) {
			System.out.println("NULL");
			return null;
		}
		return filteredTickets;
	}

	public int processRequest(int status_ID, int Reimb_ID) {
		int rows;
		rows = manDAO.processRequest(status_ID, Reimb_ID);
		return rows;
	}
	
}
