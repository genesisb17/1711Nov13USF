package dao;

import java.util.List;

import pojos.Account;
import pojos.User;

public interface DAO {
	
	public User addUser(String email, String password, String fname, String lname);
	public Account addAccount(User u);
	
	public User getUser(String email);
	public boolean hasUser(String email);
	
	public List<Account> getAccounts(User u);
	public Account depositToAccount(Account a, double deposit);
	
	public Account addUserToAccount(Account a, User u);
	
}
