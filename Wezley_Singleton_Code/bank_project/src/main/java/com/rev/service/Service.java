package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.AccountDAO;
import com.rev.dao.AccountDAOImpl;
import com.rev.dao.AccountRegistrarDAO;
import com.rev.dao.AccountRegistrarDAOImpl;
import com.rev.dao.UserDAO;
import com.rev.dao.UserDAOImpl;
import com.rev.pojos.Account;
import com.rev.pojos.AccountRegistrar;
import com.rev.pojos.User;

public class Service {

	static UserDAO userDao = new UserDAOImpl();
	static AccountDAO accountDao = new AccountDAOImpl();
	static AccountRegistrarDAO accountRegistrarDao = new AccountRegistrarDAOImpl();

	/**
	 * 
	 * @return User; null if new user creation is unsuccessful, 
	 * 				 newly created user (with id) if new user creation is successful
	 */
	public User createNewUser(User user) {

		User newUser = null;

		boolean emailAddressAvailable = isEmailAvailable(user.getEmailAddress());
		boolean usernameAvailable = isUsernameAvailable(user.getUsername());

		if (emailAddressAvailable && usernameAvailable) {
			newUser = userDao.addUser(user);
		}

		return newUser;

	}

	/**
	 * @param scan
	 * @return User; user with matching userId, if no user matches given userId - returns null
	 */
	public User getUserById(int userId) {

		User soughtUser = userDao.getUserById(userId);
		return soughtUser;

	}

	/**
	 * @param scan
	 * @return User; user with matching username, if no user matches given username - returns null
	 */
	public User getUserByUsername(String username) {

		User soughtUser = userDao.getUserByUsername(username);
		return soughtUser;

	}

	/**
	 * 
	 * @param scan
	 * @return
	 */
	public User getUserByEmailAddress(String emailAddress) {

		User soughtUser = userDao.getUserByEmailAddress(emailAddress);
		return soughtUser;
		
	}

	/**
	 * 
	 * @return User; updated user if successfully updated, null if update fails
	 */
	public User updateUser(User userForUpdate) {

		User updatedUser = userDao.updateUser(userForUpdate.getId(), userForUpdate);
		return updatedUser;

	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return User; the user profile if login is successful, null if login is unsuccessful
	 */
	public User loginUser(String username, String password) {

		User loggedInUser = null;

		// stores returned User object from getUserByUsername() based on given username; ignores case
		User usernameMatch = userDao.getUserByUsername(username.toLowerCase());

		if (usernameMatch.getUsername() != null) {

			if (usernameMatch.getPassword().equals(password)) {
				loggedInUser = usernameMatch;
			}

			else {
				System.out.println("\nInvalid login credentials: password incorrect\nReturning to main menu.");
			}
		}

		else {
			System.out.println("\nNo records found for username: " + username + "\nReturning to main menu...");
		}

		return loggedInUser;
	}

	/**
	 * prints all users to the console (ADMIN ONLY)
	 */
	public void printAllUsers() {

		ArrayList<User> users = userDao.getAllUsers();

		System.out.println();
		users.forEach(user -> System.out.println(user));
		System.out.println();

	}

	/**
	 * 
	 * @param username
	 * @return boolean; true if username is available, false if username is unavailable
	 */
	public boolean isUsernameAvailable(String username) {

		ArrayList<User> users = userDao.getAllUsers();

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				System.out.println("That username is already in use!\nPlease try again...");
				return false;
			}
		}

		System.out.println("Username, " + username + ", is available!");
		return true;

	}

	/**
	 * 
	 * @param emailAddress
	 * @return boolean; true if email address is available, false if email address is unavailable
	 */
	public boolean isEmailAvailable(String emailAddress) {

		ArrayList<User> users = userDao.getAllUsers();

		for (User user : users) {
			if (user.getEmailAddress().equalsIgnoreCase(emailAddress)) {
				System.out.println("\nThat email address is already in use!\nPlease try again...");
				return false;
			}
		}

		System.out.println("Email address, " + emailAddress + ", is available!");
		return true;

	}

	/**
	 * 
	 * @param user
	 * @return Account; returns newly created Account if creation is successful, otherwise returns null
	 */
	public Account createNewAccount(String accountType) {

		Account newAccount = new Account();
		
		newAccount.setAcctType(accountType);
		newAccount.setBalance(0.0);
		
		newAccount = accountDao.addAccount(newAccount);
		
		return newAccount;

	}
	
	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public Account getAccountById(int accountId) {
		
		Account soughtAccount = accountDao.getAccountById(accountId);
		return soughtAccount;
		
	}
	
	/**
	 * 
	 * @param accountForUpdate
	 * @return
	 */
	public Account updateAccountBalance(Account accountForUpdate) {
		
		Account updatedAccount = accountDao.updateBalance(accountForUpdate.getAcctId(), accountForUpdate.getBalance());
		return updatedAccount;
		
	}
	
	/**
	 * 
	 * @param user
	 * @param account
	 * @param userPrivilege
	 * @return
	 */
	public AccountRegistrar registerAccountToUser(User user, Account account, String userPrivilege) {
		
		AccountRegistrar registeredUserAccount = new AccountRegistrar();
		
		registeredUserAccount.setUserId(user.getId());
		registeredUserAccount.setAcctId(account.getAcctId());
		registeredUserAccount.setUserPrivilege(userPrivilege);
		
		registeredUserAccount = accountRegistrarDao.registerUserToAccount(registeredUserAccount);
		
		return registeredUserAccount;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public ArrayList<AccountRegistrar> getUserAccounts(User user) {
		
		ArrayList<AccountRegistrar> userAccounts = accountRegistrarDao.getUserAccounts(user.getId());
		return userAccounts;
		
	}
	
	public ArrayList<AccountRegistrar> getUsersOnAccount(Account acct) {
		
		ArrayList<AccountRegistrar> usersOnAccount = accountRegistrarDao.getUsersOnAccount(acct.getAcctId());
		return usersOnAccount;
		
	}
}
