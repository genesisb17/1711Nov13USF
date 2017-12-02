package com.revature.test;

import com.revature.pojos.Users;
import com.revature.types.UserRoles;

public class TestPojos {

	public static void main(String[] args) {
		UserRoles roles = UserRoles.valueOf("MANAGER");
		
		System.out.println(roles.name());
	}

}
