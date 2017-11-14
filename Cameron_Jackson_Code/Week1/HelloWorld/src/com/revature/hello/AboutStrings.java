package com.revature.hello;

import java.util.Scanner;

public class AboutStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "hello";
		String b = "Hello";
		String c = new String("hello"); // new instance of "hello"
		String d = a;
		String e = "hello"; // points to 'a' since duplicated.
		
/*		System.out.println("1: " + a.equals(c)); // compares values
		System.out.println("2: " + (a == c)); // checks if same object (similar to 'is' in C. don't use)
		System.out.println("3: " + a.equals(e));
		System.out.println("4: " + (a == e));
		System.out.println("5: " + a.equalsIgnoreCase(b));*/
		test(a);
		System.out.println(a);
		
		// Assignment functions
		System.out.println(encode("hash this"));
		capitalize();
		getChar();
	}
	
	static String test(String x) {
		return x.substring(2);
	}
	
	static int encode(String x) {
		int y = x.hashCode();
		return y;
	}
	
	static String capitalize() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String y = input.nextLine();
		return y.toUpperCase();
	}
	
	static int getChar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String y = input.nextLine();
		System.out.println("Enter a char: ");
		int find = input.nextInt();
		return y.indexOf(find);
	}

}
