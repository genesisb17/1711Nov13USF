package com.ex.probs;

public class CodingChallenges {
	
	// Factorial using recursion
	public int factorial(int n) {
	
		if(n > 1) {
			
			return (n * factorial(n - 1));
		}
		return 1;	
	}	
	
	// Reverse String without using a temp string
	public String ReverseString(String S) {
		
		for(int i = 0; i < S.length(); i++) {
			
			S = S.substring(1, S.length() - i) 
			  + S.substring(0,1) 
			  + S.substring(S.length() - i, S.length());	
		}
		return S;
	}
	
}
