package com.revature.hello;

public class AboutStrings {

	public static void main(String[] args) {
		String first = "This is the first string!";
		String second = "Second string here.";
		System.out.println(first.concat(second));
		
		if(first.isEmpty())
			System.out.printf("First is empty!");
		else
			System.out.printf("First is not empty!\n");
		
		System.out.println(first.replace("i", "z"));
		System.out.println(first.toUpperCase());
		System.out.println(first.toLowerCase());

	}
	
	static String test(String x) {
		return x.substring(2);
	}
}