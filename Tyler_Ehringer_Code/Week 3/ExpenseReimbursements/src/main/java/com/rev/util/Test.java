package com.rev.util;

import java.sql.SQLException;

import com.rev.dao.DAO;
import com.rev.dao.DAOImplementation;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;

public class Test {
	
	public static void main(String[] args) {
		
		DAO dao = new DAOImplementation();
		User currentUser;
		User newUser = new User(User.ROLE_EMPLOYEE, "bobvila", "bob", "bobvila@gmail.com", "Robert", "Vila");
		try {
			currentUser = dao.getUserByUsername("tyler918273");
			Reimbursement currentReimbursement = dao.getReimbursementsForUser(currentUser.getId()).get(0);
			System.out.println(currentReimbursement.getDescription());
			dao.addUser(newUser);
			Reimbursement newReimbursement = new Reimbursement(newUser.getId(), Reimbursement.TYPE_FOOD, 29.45f, "Pizza");
			dao.updateReimbursement(newReimbursement, currentUser.getId(), Reimbursement.STATUS_APPROVED, "enjoy");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
