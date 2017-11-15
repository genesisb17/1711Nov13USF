package com.ex.probs;

public class CodingChallenges {

	public int factorial(int n) {
		int original = n;
		int total = 1;
		for (int i = 0; i < original; i++) {
			total *= n;
			n--;
		}
		return total;
	}
	
	public String reverseString(String s) {
		for(int i=0; i<s.length();i++)
			s=s.substring(1, s.length()-i)+s.substring(0,1)+s.substring(s.length()-i);
		return s;
	}
}
