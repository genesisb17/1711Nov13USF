package com.ers.pojos;

public class User
{
	private int userId;
	private int roleId;

	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String userEmail;

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public int getRoleId()
	{
		return roleId;
	}

	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", roleId=" + roleId + ", userName=" + userName + ", passWord=" + passWord
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", userEmail=" + userEmail + "]";
	}
}
