package com.rev.pojos;

/**
 * This class creates User Object.
 * @author Shujun Ye
 */
public class User {
	
	/** An unique user ID */
	private int id;
	/** An user's firstname */
	private String firstname;
	/** An user's lastname */
	private String lastname;
	/** An user's username */
	private String username;
	/** An user's password */
	private String password;
	/** An user's account balance */
	private double balance;
	
	/**
	 * Constructor with no-arg parameters.
	 */
	public User() {}
	
	/**
	 * Constructor that takes all user's info as parameters
	 * @param id user's ID
	 * @param firstname user's firstname
	 * @param lastname user's lastname
	 * @param username user's username
	 * @param password user's password
	 * @param balance user's account balance
	 */
	public User(int id, String firstname, String lastname, String username, String password, double balance) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	/**
	 * This method returns user ID.
	 * @return userID
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method sets user ID.
	 * @param id userID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method returns user's firstname
	 * @return user's firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * This method sets user's firstname
	 * @param firstname user's firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * This method returns user's lastname.
	 * @return user's lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * This method sets user's lastname.
	 * @param lastname user's lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * This method returns username.
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method sets username.
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method returns user's password
	 * @return user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method sets user's password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method returns user's account balance.
	 * @return user's account balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * This method set user's account balance.
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * This method returns user's info and separates by ":"
	 * @return user's info
	 */
	public String toFile() {
		return id + ":" + firstname + ":" + lastname + ":" + username
				+ ":" + password + ":" + balance + "\n";
	}

	/***
	 * This method overrides toString().
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", balance=" + balance + "]";
	}
}