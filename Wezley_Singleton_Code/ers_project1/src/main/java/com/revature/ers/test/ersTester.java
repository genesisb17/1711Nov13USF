package com.revature.ers.test;

import com.revature.ers.dao.ReimbursementDAO;
import com.revature.ers.dao.ReimbursementDAOImpl;
import com.revature.ers.dao.UserDAO;
import com.revature.ers.dao.UserDAOImpl;
import com.revature.ers.dao.UserRoleDAO;
import com.revature.ers.dao.UserRoleDAOImpl;
import com.revature.ers.pojos.Role;
import com.revature.ers.pojos.User;
import com.revature.ers.pojos.UserRole;

public class ersTester {

	static UserDAO userDao = new UserDAOImpl();
	static UserRoleDAO userRoleDao = new UserRoleDAOImpl();
	static ReimbursementDAO reimbursementDao = new ReimbursementDAOImpl();
	
	public static void main(String[] args) {
		
	}

}
