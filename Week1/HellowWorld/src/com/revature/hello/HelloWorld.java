package com.revature.hello;

import java.util.Scanner;

public class HelloWorld {
	// this is a comment to indicate understanding of being able to write comments in a program
	public static void main(String[] args) {
		String name = "Felix Abreu";
		System.out.println(name);
		
		int x =5;
		Integer ex = new Integer(5); //wrapper class
		ex = x; // autoboxing, which allows you to call methods on object
		
		Scanner keyboard = new Scanner(System.in);
		String text = keyboard.nextLine();
		System.out.println("Hello " + text);
	
		int var[][]= new int [2][3];
		var[0][2] = 5;
		var[1][1] = 10;		
		
		System.out.println(var[0][0]);
	
	}
	
	/* 
	 * This is a multi-line comment
	 */
	

	
}
