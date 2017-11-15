package com.revature.hello;

public class StringMethods {
	
	public static void main(String[] args) {
		String testString = "test  ";
		
		// Methods to call on test string
		System.out.println("Is Empty: " + testString.isEmpty() + ".");
		System.out.println("Replace first character with '&': " + testString.replace(testString.charAt(0), '&') + ".");
		System.out.println("To Upper: " + testString.toUpperCase() + ".");
		System.out.println("Trim: " + testString.trim() + ".");
		System.out.println("Length: " + testString.length() + ".");
	}
	
}
