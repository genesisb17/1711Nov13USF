package com.rev.service;

import java.util.ArrayList;

import com.rev.DTOs.ManagerTicketInfo;
import com.rev.dao.ManagerDAO;
import com.rev.dao.ManagerDAOImpl;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;

public class ManagerService {
	
	static ManagerDAO manDAO = new ManagerDAOImpl();

/*	public ArrayList<Reimbursement> viewAllTickets() {
		ArrayList<Reimbursement> allTickets = new ArrayList<Reimbursement> ();
		allTickets = manDAO.viewAllTickets();
		if(allTickets == null) {
			System.out.println("NULL");
			return null;
		}
		return allTickets;
	}*/
	
	public ArrayList<ManagerTicketInfo> filterByStatus(ReimbursementStatus rs){
		ArrayList<ManagerTicketInfo> filteredTickets = new ArrayList<ManagerTicketInfo> ();
		filteredTickets = manDAO.filterByStatus(rs);
		if(filteredTickets == null) {
			System.out.println("NULL");
			return null;
		}
		return filteredTickets;
	}

	public int processRequest(int Status_ID, int Reimb_ID, int Resolver_ID) {
		int rows;
		rows = manDAO.processRequest(Status_ID, Reimb_ID, Resolver_ID);
		return rows;
	}
	
	public ArrayList<ManagerTicketInfo> managerTicketInfo(){
		ArrayList<ManagerTicketInfo> allTickets = new ArrayList<ManagerTicketInfo>();
		allTickets = manDAO.managerTicketInfo();
		if(allTickets == null) {
			return null;
		}
		return allTickets;
	}

}














