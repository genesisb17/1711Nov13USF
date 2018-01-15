package com.reimb.service;
// get ready to change reimb instances to riemb log instances  
import java.util.ArrayList;
import java.util.Scanner;

import com.reimb.dao.DAO;
import com.reimb.dao.DAOImpl;
import com.reimb.pojos.Reimburse;
import com.reimb.pojos.ReimburseLog;
//import com.reimb.pojos.Reimburse;
import com.reimb.pojos.User;
public class Service {
	// input and validation done here. 
	static DAO dao= new DAOImpl();
	
	public User getUserbyId1(int id){
		return (dao.getUserById(id));
	}
	public User ServaddUser(User u){
		dao.addUser(u.getName(), u.getLastname(), u.getUsername(), u.getPassword(), u.getEmail(), u.getRole());
	return u;
	}
	
	
	public User loginValidate(String username){ 
		User temp = dao.getUserByUname(username);
		return temp;
		
	}
	public User findUser(String username){
		return(dao.getUserByUname(username));
	}
	public User findUserEmail(String email){
		return(dao.getUserByEmail(email));
	}
	public User updateUser(User u){
		dao.updateAccount(u);
		return u;
		
	}
	public boolean addReim(Reimburse reimb)
	{
		return dao.addReimb(reimb);
	}
	public boolean updateReim(Reimburse reimb)
	{
		return dao.updateRiemb(reimb);
	}
	public ArrayList<Reimburse> usersRiembs(User u){
		
	return dao.getReimbByUser(u);
	}
	public ArrayList<ReimburseLog> adminRiembs(){
		
	return dao.getReimb();
	}
	
	 
}