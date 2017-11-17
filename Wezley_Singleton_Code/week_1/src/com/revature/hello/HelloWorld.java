package com.revature.hello;

import java.util.Scanner;

public class HelloWorld {
	
	// Line 8 is the main method
	public static void main(String args[]) {
		String name = "Wezley Singleton";
		System.out.println(name);
		
		int x = 5;
		Integer ex = new Integer(5);	// wrapper class
		ex = x; // autoboxing

		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		
		System.out.println("Hello " + text);
		
		int variable[][] = new int[2][3];
		
		System.out.println(variable[0][0]);
	
	}
	
}
