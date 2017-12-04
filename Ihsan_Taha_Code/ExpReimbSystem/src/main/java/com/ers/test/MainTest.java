package com.ers.test;

import com.ers.pojos.User;
import com.ers.util.Service;

public class MainTest
{
	static Service service = new Service();
	static User user = new User();
	
	public static void main(String[] args)
	{
		// 1. Test add user
		/*
		user.setUserName("jackie_morrisa");
		user.setPassWord("12345");
		user.setFirstName("Jackie");
		user.setLastName("Morrisa");
		user.setUserEmail("jackie_morrisa@gmail.com");
		user.setRoleId(1);
		service.addUser(user);
		*/
		
		
		// 2. Test get all users
		// service.getAllUsers();
		
		
		// 3. Test get user
		user.setUserName("jack_morris");
		user.setPassWord("12345");
		service.getUser(user);	
		System.out.println(user.toString());
		
		
	}

}
