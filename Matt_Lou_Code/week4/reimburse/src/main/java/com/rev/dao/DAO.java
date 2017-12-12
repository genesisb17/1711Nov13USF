package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.Users;

public interface DAO {
	Users addUser(Users u);
	Users getUser(String username);
	Users update(Users u, Reimbursement reimb);
	ArrayList<Reimbursement> getTable();
}
