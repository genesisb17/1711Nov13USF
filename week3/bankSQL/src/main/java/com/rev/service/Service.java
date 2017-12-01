package com.rev.service;



import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.SQLDAO;
import com.rev.pojos.Account;
import com.rev.pojos.User;

public class Service {

	private static DAO dao = new SQLDAO();

	public boolean addUser(String firstname, String lastname, String username, String password) {
		boolean safeToAdd=!userExists(username);
		if(safeToAdd) {
			dao.addNewUser(firstname, lastname, username, password);
		} 
		return safeToAdd;
	}
	
	public void addAccount(String username, double bal) {
		User u=dao.getUserByUsername(username);
		int userId=u.getId();
		dao.addNewAccount(userId, bal);
	}
	
	public double getBalanceByAccId(int id) {
		Account acc=dao.getAccountById(id);
		return acc.getBalance();
	}
	
	public double depositByAccId(double dep,int id) {
		Account account=dao.getAccountById(id);
		return dao.updateBalance(dep, account);
	}
	
	public double withdrawByAccId(double with,int id) {
		Account account=dao.getAccountById(id);
		return dao.updateBalance(-with, account);
	}
	
	public String getNamefromUsername(String username) {
		User u=dao.getUserByUsername(username);
		return u.getFirstname();
	}
	
	public int numAccountsfromUsername(String username) {
		User u=dao.getUserByUsername(username);
		return u.getAccounts().size();
	}
	
	public int getAccIdInManage(String username, int accNum) {
		User u=dao.getUserByUsername(username);
		ArrayList<Account> accounts=u.getAccounts();
		return accounts.get(accNum-1).getAccountId();
	}

	public boolean userExists(String username) {
		boolean exists=false;
		ArrayList<User> users=dao.getUsers();
		for(User u:users) {
			if(u.getUsername().equals(username)) {
				exists=true;
			}
		}
		return exists;
	}

	public boolean passwordCorrect(String username,String password) {
		boolean correct=false;
		User u=dao.getUserByUsername(username);
		if(u.getPassword().equals(password)) {
			correct=true;
		}
		return correct;
	}
}
