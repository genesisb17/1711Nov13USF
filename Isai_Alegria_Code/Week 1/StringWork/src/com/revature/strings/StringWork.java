package com.revature.strings;

public class StringWork {
	
	public static void main(String[] args) {
	
		//return length of string
		String blah = "Isai is cool";
		int len = blah.length();
		System.out.println("the length of string is " + len);
	
		//add another string to initial string
		String blah2 = ", oh yeah!";
		System.out.println("First string is" + blah);
		System.out.println("Second string is " + blah2);
		System.out.println("The two strings added is: " + blah.concat(blah2));
		
		//replace some characters in string
		System.out.println("Replace some I with W in initial string: ");
		System.out.println(blah.replace('I', 'W'));
		
		
	
	}	
	

}
