package com.revature.hello;

import java.util.Scanner;

public class StringStuff {
	
	
public static void main(StringStuff[] args) {
	
	System.out.println("Please enter a string: ");
	
	Scanner in = new Scanner(System.in);
	String myString = in.nextLine();
	
	System.out.println("The input string in lowercase: " + 	myString.toLowerCase());
	
	System.out.println("The length of the string is " + myString.length() + " characters.");
	
	System.out.println("The first character of the string is " + myString.charAt(0) + ".");
	
	System.out.println("Is the string you typed cat?, " + myString.equals("cat"));
}

	
}
