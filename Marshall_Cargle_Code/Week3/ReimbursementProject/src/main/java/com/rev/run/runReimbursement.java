package com.rev.run;

import java.util.Scanner;

import com.rev.pojos.User;
import com.rev.service.Service;

public class runReimbursement {
	static Service service = new Service();

	public static void main(String[] args) {
		run();
	}

	static void run() {
		User u = new User();
		/*Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = scan.nextLine();
		System.out.println("Enter Password");
		String password = scan.nextLine();
		u = service.getUser(username, password);
		System.out.println(u.toString());*/
		u.setEmail("email");
		u.setFirstName("email");
		u.setLastName("email");
		u.setPassword("email");
		u.setUsername("email");
		System.out.println(u.toString());
		service.addUser(u);
	}
}
