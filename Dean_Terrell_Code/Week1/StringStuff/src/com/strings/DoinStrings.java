package com.strings;
import java.util.StringTokenizer;


public class DoinStrings {

	public static void main(String[] args) {
		StringBuilder build = new StringBuilder("Holy crap it's a string!");
		System.out.println(build);
		build.append(true);
		System.out.println(build);
		build.reverse();
		System.out.println(build);
		build.replace(2, 5, "Yee");
		System.out.println(build);
		
		String tokens = "Sunshine:waffles:bacon";
		StringTokenizer token = new StringTokenizer(tokens, ":");
		while(token.hasMoreTokens())
			System.out.println(token.nextToken());
		
		String newString = "Yo this a different String";
		System.out.println(addStrings(tokens, newString));
		
		System.gc(); // Requesting garbage collection
		
	}

	public static String addStrings(String a, String b) {
		String c= a + b;
		return c;
	}
	

}
