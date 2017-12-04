package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public interface DAO {
	User getUserById(int id);
	User getUserByUsername(String username);
	Reimbursement getReimbById(int id);
	ArrayList<Reimbursement> getReimbByAuthor(int auth);
	ArrayList<Reimbursement> getReimbursements();
	ArrayList<User> getUsers();
	void addNewUser(String username, String password, String fn, String ln, String email, int role);
	void addNewReimbursement(int amount, String description, String receipt, int author, int typeId);
	void updateStatus(Reimbursement r, int newStatus, int resolver);
}
