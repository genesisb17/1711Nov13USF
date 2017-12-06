package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DAOimpl;
import com.bank.pojos.*;

public class Service {
	
	static DAO dao = new DAOimpl();
	
	public User getUser(String username) {
		return dao.getUser(username);
	}
	
	public User addUser(User u) {
		
		
		return dao.addUser(u);
		
	}
	
	public ArrayList<Account> getAccounts(User u){
		return dao.getAccounts(u);
	}
	
	public Account addAccount(User u) {
		return dao.addAccount(u);
	}
	
	public boolean userNameExists(String name) {
		
		User temp = dao.getUser(name);
		
		if(temp == null) return false;
		else			 return true;
	}

	public boolean checkPassword(User u, String password) {

		if (u.getPassword().equals(password)) return true;
		else 								  return false;
		
	}
	
	
	public boolean canWithdraw(Account a, double d) {
		if(a.getBalance() < d) return false;
		else return true;
	}
	
	public Account withdrawFunds(Account a, double d) {
		
			return dao.changeBalance(a, false, d);
			
	}
	
	public Account depositFunds(Account a, double d) {
			return dao.changeBalance(a, true, d);
	}
		
	

}
