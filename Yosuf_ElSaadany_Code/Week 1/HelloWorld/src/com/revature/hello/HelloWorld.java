package com.revature.hello;

import java.util.Scanner;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		String name = "Genesis Bonds";
		name.charAt(1);
		System.out.println(name);
		
		int x = 5;
		
		Integer ex = new Integer(5); // wrapper class
		ex = x; //autoboxing
		
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		
		System.out.println("Hello " + text);
		
		
		
	}
}
