package com.revature.dto;

import com.revature.pojos.Users;

public class UserDTO {

	private Users user;
	private String message;
	
	public UserDTO() {}

	public UserDTO(Users user, String message) {
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
		return "UserDTO [user=" + user + ", message=" + message + "]";
	}
	
}
