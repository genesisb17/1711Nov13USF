package com.rev.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.EmployeeService;
import com.rev.service.ManagerService;

public class Main {

	static EmployeeService EmployeeService = new EmployeeService();
	static ManagerService ManagerService = new ManagerService();

	public static void main(String[] args) {
		
		//---------------- Testing Users Login Function -------------------//
		System.out.println("Please enter your username:");
		Scanner u1 = new Scanner(System.in);
		String username = u1.nextLine();
		System.out.println("Please enter you password:");
		Scanner p = new Scanner(System.in);
		String password = p.nextLine();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User u = new User();
		u = EmployeeService.Login(user);
		if(u != null) {
			System.out.println("Login Successful");
			System.out.println(u.toString());
		}
		else
			System.out.println("Username or Password incorrect");

		
		//-------------- Testing View Past Tickets Function -----------------//
/*		System.out.println("Please enter your username:");
		Scanner u = new Scanner(System.in);
		String username = u.nextLine();
		User user = new User();
		user.setUsername(username);
		ArrayList<Reimbursement> pastTickets = new ArrayList<Reimbursement>();
		pastTickets = EmployeeService.viewPastTickets(user);
		for(int i = 0; i < pastTickets.size(); i++) {
			System.out.println(pastTickets.get(i));
		}*/
		
		//-------------- Testing Add Reimbursement Function -----------------//
/*		System.out.println("Enter Amount:");
		Scanner reimb = new Scanner(System.in);
		double amount = reimb.nextDouble();
		
		System.out.println("Enter username:");
		Scanner name = new Scanner(System.in);
		String username = name.nextLine();
		
		System.out.println("Enter type of reimbursement\n(1) Food\n(2) Travel\n(3) Lodging\n(4) Other");
		Scanner ty = new Scanner(System.in);
		int type = ty.nextInt();
		
		Reimbursement r = new Reimbursement();
		User u = new User();
		
		u.setUsername(username);
		r.setAmount(amount);
		r.setType(type);
		EmployeeService.addReimbursement(r, u);*/
		
		//--------- Testing View All Reimbursements for All Employees ---------//
/*		ArrayList<Reimbursement> allTickets = new ArrayList<Reimbursement>();
		allTickets = ManagerService.viewAllTickets();
		for(int i = 0; i < allTickets.size(); i++) {
			System.out.println(allTickets.get(i));
		}*/
		
		//--------- Testing View Tickets Filtered by Status Employees ---------//
/*		ReimbursementStatus rs = new ReimbursementStatus();
		rs.setStatus("Pending");
		rs.setStatus_id(1);
		ArrayList<Reimbursement> filteredTickets = new ArrayList<Reimbursement>();
		filteredTickets = ManagerService.filterByStatus(rs);
		for(int i = 0; i < filteredTickets.size(); i++) {
			System.out.println(filteredTickets.get(i));
		}*/
		
		
		//--------------- Testing Process Reimbursement Tickets ---------------//
/*		int rows;
		rows = ManagerService.processRequest(2, 1);
		if(rows == 0)
			System.out.println("Row not updated");
		else
			System.out.println("Row updated");*/
		
	
/*		User u = new User();
		u.setUsername("Testingggg");
		u.setPassword("1234");
		u.setFirstname("WORK");
		u.setLastname("PLEASE");
		u.setEmail("sssgggg");
		u.setUserRole(1);
		int x = EmployeeService.Register(u);
		*/
		
	}
	
}
