package com.ex.probs;

public class CodingChallenges {
	
	
	
	
	public int factorial(int n) {
	
		if(n > 1) {
			
			return (n * factorial(n - 1));
		}
		return 1;	
	}	
	
	public String ReverseString(String S) {
		
		for(int i = 0; i < S.length(); i++) {
			
			S = S.substring(1, S.length() - i) 
			  + S.substring(0,1) 
			  + S.substring(S.length() - i, S.length());	
		}
		return S;
	}
	
	/*
	public String ReverseString(String S) {
		
		char[] X = new char[S.length()];
		
		for(int i = 0; i < S.length() - 1; i++) {
			X[i] = S[S.length() - i];
		}
	}
	*/
	
	
}
