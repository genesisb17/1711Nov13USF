package com.revature.day3;

import java.util.StringTokenizer;

public class StringsAssignment {
	/*
	 * Create a StringBuilder object. Use at least three methods to manipulate the String.
	 * Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” 
	 * 		and use StringTokenizer to parse out and print each token.
     * Create two String objects with number values (i.e. “20). Write a method that adds the two.
     * Request garbage collection in your method.
     * Create a Runtime object and note at least three methods. Imagine how you would use them.
	 */
	
	public static void main(String[] args) {
		StringBuilder strBldr = new StringBuilder("syzygy");
		System.out.println(strBldr);
		strBldr.delete(1, strBldr.length()-1);
		System.out.println(strBldr);
		strBldr.insert(1, true);
		System.out.println(strBldr);
		
		System.out.println("\nTokenizer test: ");
		String delimitedString = "Portland, Oregon;Honolulu, Hawaii;New York, New York;Tampa, Florida";
		StringTokenizer tokenizer = new StringTokenizer(delimitedString, ";");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			System.out.println(token);
		}
		
		String num1 = "420";
		String num2 = "69";
		System.out.println("\nString Number Addition Test: ");
		System.out.println(num1 + " + " + num2 + " = " + AddStrings(num1, num2));
	}
	
	static int AddStrings(String str1, String str2) {
		int num1;
		int num2;
		
		num1 = Integer.parseInt(str1);
		num2 = Integer.parseInt(str2);
		
		str1 = null;
		str2 = null;
		System.gc();
		
		return num1 + num2;
	}
}
