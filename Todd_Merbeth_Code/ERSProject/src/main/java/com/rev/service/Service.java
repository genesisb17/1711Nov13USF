package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.DBDAO;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public class Service {
	static DAO dao = new DBDAO();
	
	public ArrayList<Reimbursement> getUserReimbursements(int u_id){
		return dao.getUserReimbursements(u_id);
	}
	
	public Reimbursement addReimbursement(Reimbursement r) {
		return dao.addReimbursement(r);
	}
	
	public ArrayList<Reimbursement> getAllReimbursements(){
		return dao.getReimbursements();
	}
	
	public ArrayList<Reimbursement> getPendingReimbursements(){
		return dao.getPendingReimbursements();
	}
	
	public Reimbursement updateReimbursement(int r_id, int r_res, int r_status) {
		return dao.updateReimbursement(r_id, r_res, r_status);
	}
	
	public User addUser(User user) {
		return dao.addUser(user);
	}
	
	public User getUser(String username, String password) {
		return dao.getUser(username, password);
	}
	
	public String getR_Status(int r_id) {
		return dao.getR_Status(r_id);
	}
	
	public String getR_Type(int r_id) {
		return dao.getR_Type(r_id);
	}
	
	public String getUser_Role(int u_id) {
		return dao.getUser_Role(u_id);
	}
	
	public String getFirstAndLastById(int id) {
		return dao.getFirstAndLastById(id);
	}
}
