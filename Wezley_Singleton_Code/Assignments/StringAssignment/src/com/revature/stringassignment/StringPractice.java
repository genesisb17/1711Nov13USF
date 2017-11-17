package com.revature.stringassignment;

import java.util.Scanner;

public class StringPractice {

	public static void main(String[] args) {
		
		String a = "Welcome to Java Programming!";
		String b = "This will be fun";
		
		System.out.println("String 'a': " + a);
		System.out.println("String 'b': " + b);
		
		System.out.println("\nRunning replaceSubStringInString()...");
		replaceSubStringInString(a);
		
		System.out.println("\nRunning concatenateStrings()...");
		concatenateStrings(b);
		
		System.out.println("\nRunning getStringFromUserMakeLowerCase()...");
		getStringFromUserMakeLowerCase();
		
		
		
	}
	
	// replaces a defined String with a new String
	static String replaceSubStringInString(String x) {
		
		return x.replace("Java Programming", "Revature");
	}
	
	// concatenates the original String with a given String
	static String concatenateStrings(String x) {
		
		return x.concat("-ish");
		
	}
	
	// gets some input from the user and makes it lowercase
	static void getStringFromUserMakeLowerCase() {
		
		// creates a Scanner object to read from the console
		Scanner scan = new Scanner(System.in);
		
		// assigns the value entered by the user to the String 'userInput'
		String userInput = scan.nextLine();
		
		// makes the casing for 'userInput' lowercase
		System.out.println(userInput.toLowerCase());
			
	}
	
	// replaces all occurrences of a given character with a specified replacement
	static String replaceCharInString(String x) {
		
		return x.replace('m', 'x');
		
	}
	
}
