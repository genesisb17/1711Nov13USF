package com.revature.test;

import java.util.ArrayList;

import com.revature.dao.ERSDAO;
import com.revature.dao.ERSDatabaseDAO;
import com.revature.pojos.Users;
import com.revature.types.UserRoles;

public class TestDAO {

	public static void main(String[] args) {
		ERSDAO dao = new ERSDatabaseDAO();
//		UserRoles roles = UserRoles.valueOf("MANAGER");
//		System.out.println(roles.name());
		
//		Users u = dao.getUserByUsername("jdoe");
//		System.out.println(u);
//		
//		u = dao.getUserById(7321);
//		System.out.println(u);
		
//		ArrayList<Users> allUsers = dao.getAllUsers();
//		for (Users u : allUsers) {
//			System.out.println(u);
//		}
		
//		Users nu = new Users(0, "sirwin", "Steve", "Irwin", "sirwin@email.com", UserRoles.EMPLOYEE.ordinal()+1);
//		Users newUser = dao.addUser(nu, "passphrase");
//		System.out.println(newUser);
	}

}
