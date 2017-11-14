package com.revature.hello;

// import statements tell Java which packages to look in for classes
import java.util.Scanner;

public class HelloWorld {
	//this is a comment
	
	
	/*
	 * Every java program begins execution with its main method.
	 * A main() method is the gateway between the startup of a Java
	 * process, which is managed by the JVM, and the beginning of 
	 * the developer's code. 
	 */
	public static void main(String[] args) {
		String name = "Genesis Bonds";
		name.charAt(1);
		name.length();
		System.out.println(name);
		
		int x = 5;
		Integer ex = new Integer(5); // wrapper class
		ex = x;  // autoboxing
		
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		
		System.out.println("Hello " + text);
		 int y;
		
		int var[][] = new int[2][3];
		var[0][2] = 5;
		var[1][1] = 10;
		
		
	}
	
	/*
	 * this is a block comment aka multi-line comment
	 */


}
