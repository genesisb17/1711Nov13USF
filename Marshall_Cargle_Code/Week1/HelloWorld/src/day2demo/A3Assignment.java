package day2demo;

import java.util.StringTokenizer;

public class A3Assignment {
	public static void main(String[] args) {
		// Create a StringBuilder object. Use at least three methods to manipulate the
		// String.
		StringBuilder str = new StringBuilder("helli");
		str.append(" world");
		str.replace(4, 5, "o");
		str.reverse();
		System.out.println(str);

		// Create a new String with delimited tokens,
		// such as “pickles:ketchup:mustard:onion”
		// and use StringTokenizer to parse out and print each token.
		String str2 = "burgers:hotdogs:sandwiches";
		StringTokenizer tokenStr2 = new StringTokenizer(str2, ":");
		while (tokenStr2.hasMoreTokens()) {
			System.out.println(tokenStr2.nextToken());
		}
		
		//Create two String objects with number values (i.e. “20). Write a method that adds the two.
		//Request garbage collection in your method.
		String num1="20";
		String num2="30";
		String added=addStrings(num1,num2);
		System.out.println(added);
		
		//Create a Runtime object and note at least three methods. Imagine how you would use them.
	}
	
	public static String addStrings(String num1, String num2) {
		String total="";
		total=(Integer.valueOf(num1)+Integer.valueOf(num2))+"";
		System.gc();//garbage collection
		return total;
	}
}
