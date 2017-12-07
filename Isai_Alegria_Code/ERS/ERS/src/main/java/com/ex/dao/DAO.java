package com.ex.dao;

import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;


public interface DAO {

	public int addUser(User u);
	public User findUser(String uname);
	public boolean findUser2(String uname);
	public boolean checkPass(User u, String pass);
	public void addRequest(Reimbursement reimb);
	public ArrayList<Reimbursement> returnTickets(User u);
	public ArrayList<Reimbursement> returnPendingTickets();
	public void approveDenyRequest(int rtID, int rStatus);
	
	
}
