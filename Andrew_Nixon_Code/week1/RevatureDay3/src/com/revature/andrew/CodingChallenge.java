package com.revature.andrew;

public class CodingChallenge {
	
	public int factorial(int n) {
		int result = 1;
		
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
	
	public String reverseString(String string) {
		
		char[] result = string.toCharArray();
		int al = string.length();
		for (int i = 0; i < al/2; i++) {
			char temp = result[i];
			result[i] = result[al-i-1];
			result[al-i-1] = temp;
			
			//char temp = string.charAt(i);
			//string.
			//System.out.println(result[al -]);
		}
		
		System.out.println(new String(result));
		return new String(result);
		
	}

}
