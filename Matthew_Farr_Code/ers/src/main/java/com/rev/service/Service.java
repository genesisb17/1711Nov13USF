package com.rev.service;

import java.util.List;

import com.rev.dao.ReimbursementDAO;
import com.rev.dao.ReimbursementDAOImpl;
import com.rev.dao.UserDAO;
import com.rev.dao.UserDAOImpl;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public class Service {
	
	private static UserDAO userDAO = new UserDAOImpl();
	private static ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();
	
	
	/* * * * * * * * * * * * *
	 * User service methods
	 * * * * * * * * * * * * */
	
	public User validateUser(String username) {
		User user = userDAO.getUser(username);
		return user; // will return user if username in database, null if not
	}
	
	public User login(int id, String password) {
		User user = userDAO.getUser(id);
		if (user == null) return null;
		return (user.getPassword().equals(password)) ? user : null ;
	}
	
	public User addUser(User u) {
		int id = userDAO.addUser(u.getFirstname(), u.getLastname(), u.getUsername(), u.getPassword(),
							 u.getEmail(), u.getRoleId());
		u.setUserId(id);
		return u;
	}
	
	/* * * * * * * * * * * * * * * * *
	 * Reimbursement service methods
	 * * * * * * * * * * * * * * * * */
	
	public Reimbursement addReimbursement (User u, double amount, String description, int typeId) {
		return reimbDAO.addReimbursement (u, amount, description, typeId);
	}
	
	public List<Reimbursement> getReimbursements() {
		return reimbDAO.getReimbursements();
	}
	
	public List<Reimbursement> getUserReimbursements(User u) {
		return reimbDAO.getUserReimbursements(u);
	}
	
	public void updateReimbursement(User manager, int reimbId, int statusId) {
		reimbDAO.updateReimbursement(manager, reimbId, statusId);
	}
	
}
