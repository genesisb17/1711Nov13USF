package com.ers.test;

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
		
		/*  user.setUserName("jack_morris"); user.setPassWord("12345");
		  user.setFirstName("Jack"); user.setLastName("Morris");
		  user.setUserEmail("jack_morris@gmail.com"); user.setRoleId(1);
		  
		  System.out.println("In MainTest, before adding user: " + user.toString());
		  
		  user = service.addUser(user);
		  if(user == null)
		  {
			  System.out.println("User already exists!");
			  // DO NOT CALL TOSTRING ON A FAILED RESULT - IT WILL CAUSE AN ERROR
			  //System.out.println("In MainTest, after failing to add user: " + user.toString());
		  }
		  else
		  {
			  System.out.println("In MainTest, after succedding to add user: " + user.toString());
		  }
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
		/*
		user.setUserName("jack_morris");
		user.setPassWord("12345");
		service.getUser(user);

		manager.setUserName("ihsan_taha");
		manager.setPassWord("12345");
		service.getUser(manager);
		
		int statusId = 3;
		int reimbId = 2;
		service.updateReimbByManager(manager, statusId, reimbId);
		*/

		  
		  
		// X. Test get all users
		// service.getAllUsers();

		  
		  
		// Y. Test get all reimbursements
		/*
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		reimbs = service.getReimbByUser(manager);
		
		for (int i = 0; i < reimbs.size(); i++)
		{
			System.out.println(reimbs.get(i).toString());
		}
		*/
		  
		// Z. Test get user by user id
		 int i = 8;
		 manager = service.getUserById(i);
		
		 System.out.println(manager.toString());

	}

}
