package com.rev.test;

import com.rev.dao.DAO;
import com.rev.dao.DAOimp;
import com.rev.dtos.UserReimbursementDTO;
import com.rev.pojos.ERSUser;
import com.rev.pojos.Reimbursement;
import com.rev.service.Service;

public class MainTest {
	
	public static void main(String[] args) {
		System.out.println("Hello ERS");
		DAO dao = new DAOimp();
		Service service = new Service();
		
		//ERSUser user =  service.checkUsernameExists("Hello");
		ERSUser user =  service.getUserByID(22);
		//System.out.println(user.toString());
		
		Reimbursement reimb = dao.getReimbursementByID(2);
		UserReimbursementDTO reimb2 = new UserReimbursementDTO(reimb);
		System.out.println(reimb.toString());
		System.out.println(reimb2.toString());
		//reimb = dao.resolveReimb(2, 43, 22);
		
	}
	
}
