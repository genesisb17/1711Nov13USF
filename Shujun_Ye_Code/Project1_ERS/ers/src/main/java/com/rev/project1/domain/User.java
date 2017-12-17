package com.rev.project1.domain;

/**
 * User POJO
 * @author Shujun Ye
 */
public class User {

	/** User Id auto-generates by DB */
	private int userId;
	/** Unique username for the account */
	private String username;
	/** Password associated with the username */
	private String password;
	/** User's firstname */
	private String firstname;
	/** User's lastname */
	private String lastname;
	/** User's email address */
	private String email;
	/** User's role id */
	private int roleId;
	
	/** User constructor with no-arg */
	public User(){}

	/**
	 * User constructor with parameters
	 * @param username user's username
	 * @param password user's password
	 * @param firstname user's firstname
	 * @param lastname user's lastname
	 * @param email user's email address
	 * @param roleId user's role id
	 */
	public User(String username, String password, String firstname, String lastname, String email, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.roleId = roleId;
	}

	/**
	 * Return user's id
	 * @return User's Id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Set user's id
	 * @param userId user's id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Return username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set username
	 * @param username user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Return user's password
	 * @return user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set user's password
	 * @param password user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Return user's firstname
	 * @return user's firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Set user's firstname
	 * @param firstname user's firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Return user's lastname
	 * @return user's lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Set user's lastname
	 * @param lastname user's lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Return user's email address
	 * @return user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set user's email address
	 * @param email user's email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Return user's role id
	 * @return user's role id
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Set user's role id
	 * @param roleId user's role id
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * Return user's all info
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", roleId=" + roleId + "]";
	}
}
