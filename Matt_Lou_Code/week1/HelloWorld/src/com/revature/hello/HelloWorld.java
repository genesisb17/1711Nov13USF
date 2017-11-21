package com.revature.hello;

import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		
		String name = "Matt Lou";
		System.out.println(name);
		
		int x = 5;
		Integer ex = new Integer(5); //wrapper class
		ex = x; // autoboxing
		
		// control hover a class to see implementation
		Scanner scan = new Scanner(System.in); // ctrl shift O to import class
		String text = scan.nextLine();
		
		// sysout ctrl space for shortcut
		System.out.println("Hello " + text);
	}
	
}
