package com.rev.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.rev.pojos.Account;
import com.rev.pojos.User;

public interface DAO {
	
	public HashMap<Integer, String> getEmails();
	public User getUserById(int id);
	public int addUser(String fn, String ln, String email, String pass);
	public Account createAccount(User u, int typeId);
	public ArrayList<Account> getAccountsByUser(User u);
	public double getBalance(int id);
	public void updateBalance(int id, double amt);
	public User getUser(String username);
}
