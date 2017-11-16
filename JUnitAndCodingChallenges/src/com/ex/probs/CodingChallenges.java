package com.ex.probs;

public class CodingChallenges {
	static Object obj;
	int as;
	public static int factorial(int n) {
		return (n == 1) ? 1 : (n * factorial(n - 1));
		
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

public static void main(String[] args) throws Error {
	int x = factorial(5);
	System.out.println(x);
}
}