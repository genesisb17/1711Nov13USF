package com.rev.test;

import com.rev.dao.DAO;
import com.rev.dao.DAOimp;
import com.rev.pojos.ERSUser;
import com.rev.service.Service;

public class MainTest {
	
	public static void main(String[] args) {
		System.out.println("Hello ERS");
		DAO dao = new DAOimp();
		Service service = new Service();
		
		ERSUser user =  service.checkUsernameExists("Hello");
		//ERSUser user =  service.getUserByID(22);
		System.out.println(user.toString());
		
		
		
	}
	
}
