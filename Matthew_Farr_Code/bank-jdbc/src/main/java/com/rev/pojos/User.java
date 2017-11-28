package com.rev.pojos;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User() {
		super();
	}

	// Constructor using fields
	public User(int id, String firstName, String lastName, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	/*
	 * No id constructor
	 * used for creating users before the auto-generated user id from the table is created
	 */
	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	@Override
	/**
	 * toString method for outputting contents of User object to the command line
	 */
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}

	/*
	 * Getters and setters for private fields 
	 */
	public int getId() {return id;}
	
	public void setId(int id) {this.id = id;}
	
	public String getFirstName() {return firstName;}
	
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public String getLastName() {return lastName;}
	
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public String getUsername() {return username;}
	
	public void setUsername(String username) {this.username = username;}
	
	public String getPassword() {return password;}
	
	public void setPassword(String password) {this.password = password;}
	
}
