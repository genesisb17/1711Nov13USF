package dao;

import java.util.ArrayList;

import pojos.Reimbursement;
import pojos.User;

public interface DAO {

	User getUserByUsername(String username);
	int login(String username, String password);
	User signup(User u);
	ArrayList<Reimbursement> getAllReimbursements(String username);
}
