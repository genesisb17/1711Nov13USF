package com.reimb.dao;
//import java.util.ArrayList;
//import java.util.HashMap;

import java.util.ArrayList;

import com.reimb.pojos.Reimburse;
import com.reimb.pojos.ReimburseLog;
//import com.reimb.pojos.Reimburse;
import com.reimb.pojos.User;

public interface DAO {

	public User getUserById(int id); // out: user in : id # associated with user  // depreciated use getuserbyuname
	public User getUserByUname(String username); // out: user in: username associated with account 
	public User doLogin(String usern, String passw);// out: user in: login information , username/ password 
	public boolean addUser(String name, String Lastname, String username, String password, String email, int role); //out: true if successful , false if not in : members of user object
	public User getUserByEmail(String email); // out: user in: email associated with account 
	public User updateAccount(User user); //in: user(request modified with session/frontend) out: user updated 
	public boolean addReimb(Reimburse reimb); // in: riemb (request modified with session/frontend) out: boolean of success !
	public ArrayList<Reimburse> getReimbByUser(User u); // in: user from session out: list of reimbursements(parsed further on frontend)
	public ArrayList<ReimburseLog> getReimb();// in : nothing out: all reimbursementsLOG class (a modified riembursement class for logging) 
	public boolean updateRiemb (Reimburse reimb); // in: reimbursement(request modified by session/frontend) out: boolean of success!
}