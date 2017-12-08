package com.rev.test;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

public class Testing {
	static Service service = new Service();
	public static void main(String[] args) {
		User u = service.getUser("SQLUSER", "SQLPASS");
		System.out.println(u);
		System.out.println(service.getFirstAndLastById(u.getId()));
		for (Reimbursement r : service.getUserReimbursements(u.getId())){
			System.out.println(r.toString());
		}
	}
}
