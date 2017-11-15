package com.ex.probs;

public class CodingChallenges {
	
	public int factorial(int n) {
		return (n == 0) ? 1 : (n * factorial(n - 1));
		
	}
	
	public String reverseString(String x) {
		int len = x.length();
		char y[] = x.toCharArray();
		char z[] = x.toCharArray();
		int count = 0;

			for(int j = len-1; j >= 0; j--) {
				z[count] = y[j];
				count++;
			}
			
		String a = new String(z);
		
		return a;
		
	}
	
//public static void main(String[] args) {
//	
//	String k = "token";
//	System.out.println(reverseString(k));
//
//}
}
