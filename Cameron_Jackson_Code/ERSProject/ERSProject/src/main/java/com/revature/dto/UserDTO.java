package com.revature.dto;

import com.revature.pojos.Users;

public class UserDTO {

	private Users user;
	private String[] message;
	
	public UserDTO() {}

	public UserDTO(Users user, String[] message) {
		super();
		this.user = user;
		this.message = new String[message.length];
		for (int i = 0; i < message.length; ++i) {
			this.message[i] = message[i];
		}
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = new String[message.length];
		for (int i = 0; i < message.length; ++i) {
			this.message[i] = message[i];
		}
	}

	@Override
	public String toString() {
		return "UserDTO [user=" + user + ", message=" + message + "]";
	}
	
}
