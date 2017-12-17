package com.rev.project1.test;

import java.util.List;

import com.rev.project1.domain.ReimbStatus;
import com.rev.project1.domain.ReimbType;
import com.rev.project1.domain.Reimbursement;
import com.rev.project1.domain.User;
import com.rev.project1.service.FormatTickets;
import com.rev.project1.service.Service;

public class RunERS {
	// create a service
	static Service service = new Service();
	static FormatTickets format = new FormatTickets();
	
	public static void main(String[] args) {
		// Create a user
//		User u1 = new User("sye", "123", "Shujun", "Ye", "sye2@ncsu.edu", 2);
//		// add u1 to the system
//		u1 = service.addUser(u1);
		
		// create a user with the same username - INVALID
//		User u2 = new User("sye", "123", "Shujun", "Ye", "sye3@ncsu.edu", 2);
//		System.out.println("null? " + service.addUser(u2));

		// create a user with the same email - INVALID
//		User u3 = new User("jy", "123", "S", "Y", "sye2@ncsu.edu", 1);
//		System.out.println("null? " + service.addUser(u3));
		
		// create a new user
//		User u4 = new User("jy", "123", "S", "Y", "shujun@gmail.com", 1);
//		service.addUser(u4);
		
		// check login
//		System.out.println("True? " + service.validateLogin("sye", "123"));
//		System.out.println("True? " + service.validateLogin("SyE", "123"));
//		System.out.println("False? " + service.validateLogin("sye", "pass"));
//		System.out.print("True? " + service.validateLogin("jy", "123"));
		
		// Create a new user
//		User u5 = new User("iud", "123", "I", "Hua", "hcy@gmail.com", 1);
//		u5 = service.addUser(u5);
//		System.out.println("u5 userid is " + u5.getUserId());
//		// submit request
		ReimbStatus s1 = ReimbStatus.PENDING;
		ReimbType t1 = ReimbType.LODGING;
//		Reimbursement r = new Reimbursement(298.50, u5.getUserId(), s1.getStatusId(), t1.getTypeId());
//		service.subRequest(r, u5);
		
		// new user
		// User u6 = service.addUser("uie", "pass", "Yu", "Lin", "yulin@gmail.com", 1);
//		t1 = ReimbType.FOOD;
//		Reimbursement r2 = new Reimbursement(90, null, 200003, s1.getStatusId(), t1.getTypeId());
//		r2 = service.subRequest(r2);
//		System.out.println("Time submitted: " + r2.getReimbSubmitted());
		
		// View pending ticket
//		System.out.println(service.viewPendingRequests(200003));
		// View all pending request
//		System.out.println(service.viewAllRequests());
		
		// deny ticket
//		Reimbursement r3 = new Reimbursement(90, null, 200003, s1.getStatusId(), t1.getTypeId());
//		service.authorizedRequest(r3, 200000, s1.DENIED);
//		System.out.println(service.viewPastTickets(200003));
//		System.out.println(((List<Reimbursement>)service.viewAllTickets(200001)).toString());
		Reimbursement r2 = new Reimbursement(150, "Test", 200003, s1.getStatusId(), t1.getTypeId());
		String json = format.userView(r2);
		System.out.println(json);
		
		
	}
}
