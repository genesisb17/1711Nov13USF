package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.EmployeeDAO;
import com.rev.dao.EmployeeDAOImpl;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public class EmployeeService {
	
	static EmployeeDAO empdao = new EmployeeDAOImpl();

	public User Login(User u) {
		User user = new User();
		user = empdao.Login(u);
		if(user == null)
			return null;
		return user;
	}
	
	public ArrayList<Reimbursement> viewPastTickets(User u) {
		ArrayList<Reimbursement> pastTickets = new ArrayList<Reimbursement> ();
		pastTickets = empdao.viewPastTickets(u);
		if(pastTickets == null) {
			System.out.println("NULL");
			return null;
		}
		return pastTickets;
	}
	
	public Reimbursement addReimbursement(Reimbursement r, User u) {
		//User x = (User) req.getsession().getAttribute();
		Reimbursement y = new Reimbursement();
		y = empdao.AddReimbursement(r, u);
		if(y == null) {
			System.out.println("NULL");
			return null;
		}
		System.out.println(y.toString());
		return y;
	}
	
	public int Register(User u) {
		System.out.println(u.toString());
		int x = empdao.Register(u);
		if(x == 0) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public User Update(User newuser, User olduser) {
		User u = new User();
		u = empdao.UpdateInfo(newuser, olduser);
		if(u == null) 
			return null;
		else 
			return u;
	}
}


