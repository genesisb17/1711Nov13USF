package com.revature.hello;

import java.util.Scanner;

public class StringMethods {
	
	public static void main(String[] args) {
		
		String a = "Hello ";
		String b = "Todd";
		String d = "Hello Todd";
		
		// Method 1: Concatenation
		String c = a + b;
		System.out.println(c);
		
		// Method 2: To Lower Case
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		System.out.println(text.toLowerCase());
		
		// Method 3: Is Empty
		System.out.println(a.isEmpty());
		
		// Method 4: Compare to
		System.out.println(d.compareTo(a));
		
		// Method 5: Concatenate then contains
		System.out.println(a.concat(b).contains(d));
		
	}
	

}
