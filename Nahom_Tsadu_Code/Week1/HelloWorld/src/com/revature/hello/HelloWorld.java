package com.revature.hello;

import java.util.Scanner;

public class HelloWorld {
	
	//Below is a main method
	public static void main(String[] args) {
		/*
		 * This following code prints my full name
		 */
		String name = "Nahom Tsadu";
		System.out.println(name);
		
		int x = 5;
		Integer ex = new Integer(5); //Wrapper class
		ex = x;
		
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		
		System.out.println("Hello " + text);
		
		scan.close();
	}

}