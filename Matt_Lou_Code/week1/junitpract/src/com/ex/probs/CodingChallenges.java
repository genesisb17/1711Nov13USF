package com.ex.probs;

public class CodingChallenges {
	public int factorial(int n) {
		if(n <= 1) {
			return 1;
		}
		else {
			return n * factorial(n - 1);
		}
	}
	
	public String reverseString(String s) {
		StringBuilder rev = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--) {
			rev.append(s.charAt(i));
		}
		return rev.toString();
	}
}
