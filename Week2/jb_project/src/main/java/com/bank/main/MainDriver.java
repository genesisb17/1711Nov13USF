package com.bank.main;

//import com.bank.pojos.Users;
import com.bank.services.Services;

public class MainDriver {
	
	public static void main(String[] args) {
		
		run();
		
	}

	public static void run() {
		// TODO Auto-generated method stub
		Services serv = new Services();
		serv.addaUser();

	}
}
