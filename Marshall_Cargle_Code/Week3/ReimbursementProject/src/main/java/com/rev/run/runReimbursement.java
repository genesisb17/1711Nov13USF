package com.rev.run;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rev.pojos.SpecTicket;
import com.rev.pojos.Ticket;
import com.rev.pojos.User;
import com.rev.service.Service;

public class runReimbursement {
	static Service service = new Service();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	public static void main(String[] args) {
		run();
	}

	static void run() {
		//Timestamp t=new Timestamp(System.currentTimeMillis());
		//User u = new User();
		//Ticket l=new Ticket(1, 50, t, t, "testing", 21, 0, 1, 1);
		/*Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = scan.nextLine();
		System.out.println("Enter Password");
		String password = scan.nextLine();
		u = service.getUser(username, password);
		System.out.println(u.toString());
		u.setEmail("email");
		u.setFirstName("email");
		u.setLastName("email");
		u.setPassword("email");
		u.setUsername("email");
		System.out.println(u.toString());
		service.addUser(u);*/
		//System.out.println(sdf.format(t.getTime()));
		//service.addTicket(l);
		/*List<SpecTicket> testing = new ArrayList<>();
		testing=service.getTickets();
		for(SpecTicket a:testing)
			System.out.println(a.toString());*/
		System.out.println(service.getUser("9", "asd"));
	}
}