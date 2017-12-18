package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.DAOimp;
import com.rev.dtos.ManagerReimbursementsDTO;
import com.rev.pojos.ERSUser;
import com.rev.pojos.Reimbursement;

public class Service {
	
	static DAO dao = new DAOimp();
	
	public ERSUser checkUsernameExists(String username) {
		return dao.getERSUserByUsername(username);
	}
	
	public ERSUser getUserByID(int userID) {
		return dao.getUserByID(userID);
	}

	public ArrayList<Reimbursement> getReimbsByAuthor(int userid) {
		return dao.getReimbursementsByAuthorID(userid);
	}

	public ERSUser addUser(ERSUser u) {
		u.setEmail(u.getFirstName().toLowerCase() + "." + u.getLastName().toLowerCase() + "@demoture.com");
		return dao.addUser(u);
	}

	public Reimbursement addReimbursement(Reimbursement r) {
		//can enhance later by getting more generated keys...probably confirm with genesis
		Reimbursement temp = dao.addReimbursement(r);
		return dao.getReimbursementByID(temp.getReimbID());
	}

	public ArrayList<Reimbursement> getReimbsByStatus(int i) {
		return dao.getReimbursementsByStatus(i);
	}

	public ArrayList<Reimbursement> getAllReumbs() {
		return dao.getReimbursements();
	}

	public Reimbursement validateReimbursement(int reimbID) {
		return dao.getReimbursementByID(reimbID);
	}

	public Reimbursement resolve(int reimbID, int userID, int statusID) {
		return dao.resolveReimb(reimbID, userID, statusID);
	}

	public ArrayList<ManagerReimbursementsDTO> getManagerReimbursements() {
		return dao.getManagerReimbursements();
	}
	
	

}
