package com.revature.test;

import java.util.ArrayList;

import com.revature.dao.BankDAO;
import com.revature.dao.BankDatabaseDAO;
import com.revature.pojos.Account;
import com.revature.pojos.AccountType;
import com.revature.pojos.User;


/*
 * Testing the DAO functions
 */
public class TestDAO {

	public static void main(String[] args) {
		BankDAO dao = new BankDatabaseDAO();

		//		ArrayList<User> users = dao.getAllUsers();
		//		for (User u : users) {
		//			System.out.println(u);
		//		}

		User u = dao.getUserById(1);
		System.out.println(u);

		//		User u = dao.getUserByUname("cpj");
		//		System.out.println(u);

		//		User u = dao.updatePassword("password", 3);
		//		System.out.println(u);

		//		ArrayList<Account> accounts = dao.getAllAccounts();
		//		for (Account acc : accounts) {
		//			System.out.println(acc);
		//		}


		ArrayList<Account> accounts = dao.getUserAccounts(u);
		for (Account acc : accounts) {
			System.out.println(acc);
		}

		//				Account acc = new Account();
		//				acc.setUserId(25);
		//				acc.setAccountType(AccountType.SAVINGS);
		//				
		//				acc = dao.addAccount(acc);
		//				System.out.println(acc);

		//		Account acc = dao.updateAccountBalance(12.00, 123407);
		//		System.out.println(acc);

		//		Account acc = dao.getAccount(123406);
		//		System.out.println(acc);
	}
}
