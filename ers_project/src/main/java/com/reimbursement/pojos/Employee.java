package com.reimbursement.pojos;

public class Employee {
	private Integer userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Integer userRoleId;
//	private String userRole;
	public Employee() {
		
	}
	
//	public Employee(Integer userId, String userName, String password, String firstName, String lastName, String email,
//			Integer userRoleId, String userRole) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.userRoleId = userRoleId;
//		this.userRole = userRole;
//	}


	public Employee(String userName, String password,
			String firstName, String lastName, String email, Integer userRoleId) {
		super();		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleId = userRoleId;
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
//	
//	public String getUserRole() {
//		return userRole;
//	}
//
//	public void setUserRole(String userRole) {
//		this.userRole = userRole;
//	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", userRoleId=" + userRoleId
				+ "]";
	}

}

