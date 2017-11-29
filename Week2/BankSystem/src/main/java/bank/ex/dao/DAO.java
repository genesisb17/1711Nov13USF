package bank.ex.dao;



import bank.ex.pojos.*;

public interface DAO {
	
	public void viewAccounts(User client);
	public int accountAmount(User client);
	public int existingAccount(int accountID);
	public double accountBalance(int accountID);
	public User login(User client);
	public User addUser(User client);
	public void updateAccountBalance(double newBalance, int accountID);
	public void addAccount(User client, double balance);
	public void updateUser(User client);
	
}
