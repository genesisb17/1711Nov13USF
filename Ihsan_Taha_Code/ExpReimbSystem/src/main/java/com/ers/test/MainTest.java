package com.ers.test;

import java.util.ArrayList;

import com.ers.pojos.Reimbursement;
import com.ers.pojos.User;
import com.ers.util.Service;

public class MainTest
{
	static Service service = new Service();
	static User user = new User();
	static User manager = new User();

	public static void main(String[] args)
	{
		// 1. Test add user
		/*
		 * user.setUserName("jackie_morrisa"); user.setPassWord("12345");
		 * user.setFirstName("Jackie"); user.setLastName("Morrisa");
		 * user.setUserEmail("jackie_morrisa@gmail.com"); user.setRoleId(1);
		 * service.addUser(user);
		 */

		// 2. Test get user by username and password
		/*
		 * user.setUserName("jack_morris"); user.setPassWord("12345");
		 * service.getUser(user); System.out.println(user.toString());
		 */

		// 3. Test add reimbursement
		/*
		 * Reimbursement reimb = new Reimbursement(); reimb.setReimbAmount(7.5);
		 * reimb.setReimbDescription("Yet another unfair late fee");
		 * reimb.setReimbAuthor(user.getUserId()); reimb.setReimbTypeId(1);
		 * service.addReimb(user, reimb);
		 */

		// 4. Test view past requests if user, otherwise view available requests
		// service.getAllReimb();

		// 5. Test update reimbursement

		user.setUserName("jack_morris");
		user.setPassWord("12345");
		service.getUser(user);

		manager.setUserName("ihsan_taha");
		manager.setPassWord("12345");
		service.getUser(manager);

		// int statusId = 3;
		// int reimbId = 2;
		// service.updateReimbByManager(manager, statusId, reimbId);

		// X. Test get all users
		// service.getAllUsers();

		// Y. Test get all reimbursements
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		reimbs = service.getReimbByUser(manager);
		
		for (int i = 0; i < reimbs.size(); i++)
		{
			System.out.println(reimbs.get(i).toString());
		}

	}

}
