package com.rev.run;

import com.ex.dao.DAO;
import com.ex.dao.DAOImpl;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.service.Service;

public class Driver {
	
	static Service service = new Service();
	
	public static void main(String[] args) {
		
//		User temp = service.findUser("eesighee");
//		if(temp == null)
//			System.out.println("didn't find anything");
//		else {
//			System.out.println(temp.getFirstName());
//		}
		
		Reimbursement reim = new Reimbursement();
		reim.setReimbID(0);
		reim.setReimbAmount(100);
		//reim.setReimbSubmitted("2017-01-01");
		reim.setReimbDescription("Food for relocation");
		reim.setReimbAuthor(1);
		reim.setReimbStatusID(2);		
		reim.setReimbTypeID(1);
		service.addRequest(reim);
		
		
		
	}

}
