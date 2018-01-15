package com.reimb.service;

import java.util.Scanner;

import com.reimb.dao.DAO;
import com.reimb.dao.DAOImpl;
//import com.reimb.pojos.Reimburse;
import com.reimb.pojos.User;
public class Service {
	// input and validation done here. 
	static DAO dao= new DAOImpl();
	
	public User getUserbyId1(int id){
		return (dao.getUserById(id));
	}
	public User ServaddUser(User u){
		dao.addUser(u.getName(), u.getLastname(), u.getUsername(), u.getPassword(), u.getEmail(), u.getRole());
	return u;
	}
	
	
	public boolean addUser(Scanner in) {
		String name,Lastname, username, password,email;
		System.out.println("Enter your First Name");
		name=in.nextLine();
		System.out.println("Enter your Last Name");
		Lastname=in.nextLine();
		System.out.println("Enter your User Name");
		username=in.nextLine();
		System.out.println("Enter your Password");
		password=in.nextLine();
		System.out.println("Enter your email");
		email=in.nextLine();
		if (dao.addUser(name, Lastname, username, password,email,1))
		{
			System.out.println("yay, user created");
			System.out.println(dao.getUserByUname(username));
		}
		return(false);
	}
	
	//search for user using username // store user in return // 
	// do checks in servlets for actual checks ? i geuss that's what in the example 
	// shouldn't we run checks in serv?
	public User loginValidate(String username){ 
		User temp = dao.getUserByUname(username);
		return temp;
		
	}
	public User login(Scanner in){
		System.out.println("Enter your username");
		String username = in.nextLine();
		System.out.println("Enter your Password");
		String password = in.nextLine();
		return (dao.doLogin(username, password));
	}
	public User findUser(String username){
		return(dao.getUserByUname(username));
	}
	public User findUserEmail(String email){
		return(dao.getUserByEmail(email));
	}
	public User updateUser(User u){
		dao.updateAccount(u);
		return u;
		
	}
}