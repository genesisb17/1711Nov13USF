package com.rev.service;

import java.util.ArrayList;

import com.rev.dao.DAO;
import com.rev.dao.DBDAO;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public class Service {

//	private DAO dao = new DBDAO();
	
	public static void main (String[] args) {
		DAO dao = new DBDAO();
//		User u = new User();
//		u.setUsername("jusertest1");
//		u.setPassword("juserpass1");
//		u.setFirstname("jtestfirst1");
//		u.setLastname("jtestlast1");
//		u.setEmail("jtestemail1");
//		u.setRole(1);
		
		Reimbursement r = new Reimbursement();
//		r.setAmount(1000.00);
//		r.setDescription("New Computer");
//		r.setAuthor(101);
//		r.setType(4);
		
//		ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
//		reimbursements = dao.getPendingReimbursements();
//		for (Reimbursement temp:reimbursements) {
//			System.out.println(temp.toString());
//		}
		r = dao.updateReimbursement(503, 101, 1);
		System.out.println(r.toString());
		
	}
}
