package service;

import java.util.ArrayList;
import dao.DAO;
import dao.FileDAO;
import pojos.Reimbursement;
import pojos.User;
import pojos.UserReimbursement;

public class Service {

	static DAO dao = new FileDAO();
	
	public User getUserByUsername(String username) {
		
		User user = new User();
		
		user = dao.getUserByUsername(username);
	
		return user;
		
	}
	
	public int login(String username, String password) {
		
		int number = dao.login(username, password);
	
		return number;
		
	}
	
	public ArrayList<Reimbursement> getAllReimbursements(String username) {
		
		ArrayList<Reimbursement> reimArray = new ArrayList<Reimbursement>();
		
		reimArray = dao.getAllReimbursements(username);
		
		return reimArray;
		
	}
	
	public ArrayList<UserReimbursement> getUserReimbursements(int id) {
		
		ArrayList<UserReimbursement> reimArray = new ArrayList<UserReimbursement>();
		
		reimArray = dao.getUserReimbursements(id);
		
		return reimArray;
		
	}
	
	public Reimbursement updateStatus(int reimbid, int statusid) {
		
		dao.updateStatus(reimbid, statusid);
		
		return null;
		
	}
	
	public Reimbursement newReimbursement(int amount, String description, int author, int statusId, int typeId) {
		
		dao.newReimbursement(amount, description, author, statusId, typeId);
		
		return null;
		
	}
	
	public void signup(String username, String password, String firstname, String lastname, String email) {
		
		dao.signup(username, password, firstname, lastname, email);
		
	}
	
}

