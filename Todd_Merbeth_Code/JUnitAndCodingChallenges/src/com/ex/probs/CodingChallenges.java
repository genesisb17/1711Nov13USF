package com.ex.probs;

public class CodingChallenges {

	public int factorial(int n) {
		if(n < 0) {
			System.out.println("cannot be negative");
			return -1;
		}
		if(n == 1 || n == 0) {
			return n;
		}
		n = n * factorial(n-1);	
		return n;
	}
	
	public String reverseString(String str) {
		if(str.length() == 0 || str.length() == 1) {
			return str;
		}
		char c;
		char[] chars = new char[str.length()];
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			chars[chars.length-i-1] = c;
		}
		str = new String(chars);
		return str;
	}
	
}
