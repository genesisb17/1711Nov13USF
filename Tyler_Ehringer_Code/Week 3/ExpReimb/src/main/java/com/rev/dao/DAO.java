package com.rev.dao;

import java.sql.SQLException;
import java.util.List;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public interface DAO {
	
	public boolean hasUsername(String username) throws SQLException;
	public boolean hasEMail(String email) throws SQLException;
	
	public User addUser(User u) throws SQLException;
	
	public User getUserByUsername(String username) throws SQLException;
	public User getUserByEmail(String email) throws SQLException;
	public User getUserById(int id) throws SQLException;
	
	public List<Reimbursement> getReimbursementsForUser(int userId) throws SQLException;
	public List<Reimbursement> getReimbursements() throws SQLException;
	
	public Reimbursement addReimbursement(Reimbursement r) throws SQLException;
	
	public Reimbursement updateReimbursement(Reimbursement r, int resolver_id, int reimbursementStatus, String description) throws SQLException;
}
