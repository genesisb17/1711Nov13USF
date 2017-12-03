package com.revature.test;

import java.util.ArrayList;

import com.revature.dao.ERSDAO;
import com.revature.dao.ERSDatabaseDAO;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.Users;
import com.revature.types.ReimbursementStatus;
import com.revature.types.ReimbursementType;
import com.revature.types.UserRoles;

public class TestDAO {

	/*
	 * Uncomment tests as needed
	 */
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
		
//		Users nu = new Users(0, "unclesnoop", "Snoop", "Dogg", "snoop@email.com", UserRoles.EMPLOYEE.ordinal()+1);
//		Users newUser = dao.addUser(nu, "passphrase");
//		System.out.println(newUser);
		
//		System.out.println(dao.findPassword("sirwian"));
		
//		System.out.println(dao.getTicket(123460));
		
//		ArrayList<Reimbursement> tickets = dao.getPastTickets(7320);
//		for (Reimbursement reimb : tickets) {
//			System.out.println(reimb);
//		}
		
//		ArrayList<Reimbursement> tickets = dao.getAllTickets();
//		for (Reimbursement reimb : tickets) {
//			System.out.println(reimb);
//		}
		
//		System.out.println(dao.getStatus(3));
//		System.out.println(dao.getType(1));
		
//		Reimbursement reimb = new Reimbursement();
//		reimb.setAmount(20);
//		reimb.setDescription("generic descr.");
//		reimb.setAuthor(7342);
//		reimb.setStatusId(ReimbursementStatus.PENDING.ordinal()+1);
//		reimb.setTypeId(ReimbursementType.OTHER.ordinal()+1);
//		System.out.println(reimb);
//		System.out.println(dao.addTicket(reimb));
		
//		System.out.println(dao.resolveTicket(123456, ReimbursementStatus.DENIED, 7321));
		
	}
}
