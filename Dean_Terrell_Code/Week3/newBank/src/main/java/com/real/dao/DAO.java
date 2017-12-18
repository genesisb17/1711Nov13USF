package com.real.dao;

import java.util.ArrayList;

import com.real.pojos.TableRow;
import com.real.pojos.User;

public interface DAO {

	User addUser(User u);
	User getUser(String uName);
	void addReimbursement(User u, String[] rb);
	ArrayList<TableRow> getReimbursements(User user);
	void updateReimbursement(String[] vals);
	
}
