package com.rev.test;

import java.util.ArrayList;

import com.rev.dao.DAO2;
import com.rev.dao.DAO2Impl;
import com.rev.pojos.BankAccount;
import com.rev.pojos.User2;

public class MainTest {

	public static void main(String[] args) {

		DAO2 dao = new DAO2Impl();
		
		ArrayList<User2> users = dao.getUsers();
		System.out.println(users.size());
		for (User2 u: users) {
			System.out.println(u.toString());
		}
		
		User2 testUser = dao.getUserById(1);
		System.out.println(testUser.toString());
		BankAccount testAccount = dao.getBankAccountById(1);
		System.out.println(testAccount.toString());				
		
		ArrayList<BankAccount> accounts = dao.getUsersBankAccounts(testUser);
		System.out.println(accounts.size());
		for (BankAccount ba: accounts) {
			System.out.println(ba.toString());
		}
		
		
	}

}
