package com.revature.hello;

import java.util.Scanner;

public class StringStuff {

	public static void main(String[] args) {
		System.out.println("Please input a string with three or more characters:");
		Scanner in = new Scanner(System.in);
		String myString = in.nextLine();
		
		System.out.println("The number of characters in the string inputted is " + myString.length() + ".");
		
		System.out.println("The first letter of " + myString + " is " + myString.charAt(0) + ".");
		
		System.out.println("The string in all uppercase is " + myString.toUpperCase() + " .");
				
		System.out.println("The first three characters of " + myString + " is " + myString.substring(0, 3) + ".");
		
		System.out.println("Is the string inputted empty? " + myString.isEmpty() + ".");
	}

}
