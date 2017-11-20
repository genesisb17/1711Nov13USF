package com.rev.pojos;

/**
 * @author Marshall
 * User object for the bank
 */
public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double balance;

	/**
	 * User default empty creation method
	 */
	public User() {
	}

	/**
	 * User method to create a user with all values entered
	 * @param id the ID of the user
	 * @param firstname the first name the user gave
	 * @param lastname the last name the user gave
	 * @param email the email the user gave also used for logging in
	 * @param password the password for the account used to login
	 * @param balance the current balance of the user, starting at 0
	 */
	public User(int id, String firstname, String lastname, String email, String password, double balance) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	/**
	 * Returns the ID of the user
	 * @return the ID of the user
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the new ID of the user
	 * @param id the ID being set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the first name of the user
	 * @return the first name of the user
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the first name of the user
	 * @param firstname the first name the user gave
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Returns the last name of the user
	 * @return the last name of the user
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the last name of the user
	 * @param lastname the last name the user gave
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Returns the email of the user
	 * @return the email of the user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email of the user
	 * @param email the email the user gave
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the password of the user
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user
	 * @param password the password the user gave
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the balance of the user
	 * @return the balance of the user
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance of the user
	 * @param balance the balance being set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Used to write the info of the user to the file
	 * @return a string of the users info to be written
	 */
	public String toFile() {
		return id + ":" + firstname + ":" + lastname + ":" + email
				+ ":" + password + ":" + balance+"\n";
	}
	
	

}
