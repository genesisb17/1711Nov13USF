package com.rev.pojos;

public class User2 {
	
	private int uid;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	public User2() {}
	
	public User2(String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	public User2(int uid, String firstName, String lastName, String userName, String password) {
		super();
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User2 [uid=" + uid + ", firstName=" + firstName + ", lastName=" + lastName + 
				", userName=" + userName + ", password=" + password + "]";
	}
	
	

}
