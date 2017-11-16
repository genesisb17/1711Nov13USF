package com.ex.probs;

public class CodingChallenges {

	public int factorial(int n) {
		
		//int value;
		
		if(n<0) {
			
			System.out.println("can't be a negative number");
		}
		
		if(n==0)
			return 1;
	
		
		return (n * factorial(n-1));
		
	}
	
	
	public String reverseString(String s) {
		
		String reverse = "";
		char temp, temp2;
		int length = s.length();
		char[] array = new char[26];
		
		array = s.toCharArray();
		
		for(int i = 0; i < length - 1; i++) {
			
			temp = array[length-1];
			temp2 = array[i];
		
			
		}
		
		
		
		return reverse;
	}
	
	
	
}
