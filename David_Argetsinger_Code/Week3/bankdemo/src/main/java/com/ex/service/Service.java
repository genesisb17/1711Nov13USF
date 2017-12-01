package com.ex.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.ex.pojos.Account;
import com.ex.pojos.User;

public class Service {

	static DAO dao = new DAOImpl();

	//don't follow 
	public int validateUser(String email){
		int id = -1;
		HashMap<Integer, String> users = dao.getEmails();
		System.out.println("in validate user");
		for(Integer n:users.keySet()){
			if(users.get(n).equalsIgnoreCase(email)){
				id = n;
			}
		}

		return id;
	}

	public User login(int id, String pass){
		User u = dao.getUserById(id);
		if(u.getPassword().equalsIgnoreCase(pass)){
			return u;
		}
		else return null;
	}

	public User addUser(User u){
		int id = dao.addUser(u.getFirstname(), u.getLastname(), u.getEmail(), u.getPassword());
		u.setId(id);
		return u;
	}

	public Account addAccount(User u, String type){
		int id;
		if(type.equalsIgnoreCase("checking")){
			id = 1;
		}
		else if(type.equalsIgnoreCase("savings")){
			id = 2;
		}
		else if(type.equalsIgnoreCase("credit")){
			id = 3;
		}
		else{
			return null;
		}

		return dao.createAccount(u, id);
	}

	public ArrayList<Account> getUserAccounts(User u){
		return dao.getAccountsByUser(u);
	}


	public double withdraw(Account acc, double amt){
		double bal = dao.getBalance(acc.getId());
		if(amt>bal){
			//amount is too high
			return -1;
		}
		else{
			bal = bal-amt;
			dao.updateBalance(acc.getId(), bal);
		}

		return bal;
	}
}
