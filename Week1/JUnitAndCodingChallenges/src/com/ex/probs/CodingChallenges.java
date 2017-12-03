package com.ex.probs;

public class CodingChallenges {
	
	public int factorial(int n){
		if(n < 0){ System.out.println("cannot be negative"); return 0;}
		else if(n == 0) return 1;
		else{
			return n*factorial(n-1);
		}
	}
	
	public String reverseString(String s){

		return null;
	}

}
