package com.revature.dto;

import com.revature.pojos.Users;

public class UserValidator {

	private Users user;
	private String message;
	
	public UserValidator() {}

	public UserValidator(Users user, String message) {
		super();
		this.user = user;
		this.message = message;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserValidator [user=" + user + ", message=" + message + "]";
	}
	
}
