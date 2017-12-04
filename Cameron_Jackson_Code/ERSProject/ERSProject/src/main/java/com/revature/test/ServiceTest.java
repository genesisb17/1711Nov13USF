package com.revature.test;


import com.revature.pojos.Users;
import com.revature.service.ERSService;

public class ServiceTest {
	static ERSService service = new ERSService();
	
	public static void main(String[] args) {
//		Users u = service.login("imanage", "psswrd");
//		System.out.println(u);
		
		Users u = new Users();
		u.setFirstName("Arnie");
		u.setLastName("Geddon");
		u.setUsername("jdoe");
		u.setPassword("password");
		u.setEmail("email@email.com");
		u.setRoleId(2);
		System.out.println(service.createAccount(u));
	}
}
