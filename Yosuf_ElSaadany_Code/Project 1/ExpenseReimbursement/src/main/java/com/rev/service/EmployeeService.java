package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.EmployeeDAO;
import com.rev.dao.EmployeeDAOImpl;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public class EmployeeService {
	
	static EmployeeDAO empdao = new EmployeeDAOImpl();

	public User Login(User u) {
		if(empdao.Login(u) == null)
			return null;
		return u;
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
}
