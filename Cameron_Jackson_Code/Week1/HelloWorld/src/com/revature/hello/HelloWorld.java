package com.revature.hello;

import java.util.Scanner;


public class HelloWorld {
	
	//Main method
	public static void main(String[] args) {
		String name = "Cameron Jackson";
		name.charAt(1);
		name.length();
		System.out.println(name);
		
		int x = 5;
		Integer ex = new Integer(5); // wrapper class
		ex = x; // Auto-boxing
		
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		
		System.out.println("Hello " + text);
		
		// multi dimensional array
		int variable[][] = new int[2][3];
		variable[0][2] = 5;
		variable[1][1] = 10;
		
		System.out.println(variable[0][0]);
	}
	
}
