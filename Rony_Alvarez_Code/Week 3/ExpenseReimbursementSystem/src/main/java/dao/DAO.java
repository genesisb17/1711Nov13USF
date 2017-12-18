package dao;

import java.util.ArrayList;

import pojos.Reimbursement;
import pojos.User;
import pojos.UserReimbursement;

public interface DAO {

	User getUserByUsername(String username);
	User getUserById(int id);
	int login(String username, String password);
	void signup(String username, String password, String firstname, String lastname, String email);
	ArrayList<Reimbursement> getAllReimbursements(String username);
	ArrayList<UserReimbursement> getUserReimbursements(int id);
	Reimbursement updateStatus(int reimbid, int statusid);
	Reimbursement newReimbursement(int amount, String description, int author, int statusId, int typeId);
	
}
