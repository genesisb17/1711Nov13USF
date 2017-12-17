package com.rev.dao;

import java.util.ArrayList;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementNames;
import com.rev.pojos.Users;

public interface DAO {
	Users addUser(Users u);
	Users getUser(String username);
	void update(int user_id, int status_id, int reimb_id);
	ArrayList<ReimbursementNames> getTable();
}
