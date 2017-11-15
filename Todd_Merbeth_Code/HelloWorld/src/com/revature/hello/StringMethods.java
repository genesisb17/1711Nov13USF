package com.revature.hello;

public class StringMethods {

	public static void main(String[] args) {
		
		String a = "Hello";
		String b = "Todd";
		System.out.println(a+" "+b);
		//1
		System.out.println((a+ " " +b).toLowerCase());
		//2
		String c = a.concat(" " + b);
		//3
		System.out.println(c.substring(2,9));
		//4
		System.out.println(c.toUpperCase().startsWith(a));
		//5
		System.out.println(c.toUpperCase().startsWith(a.toUpperCase()));

		
		

	}

}
