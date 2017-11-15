package com.ex.probs;

import java.util.Arrays;

public class CodingChallenges {
	
	public static void main(String[] args) {
		int result = 0;
		String str = "Word";
		
		result = factorial(5);
		
		
		System.out.println(result);
		System.out.println(reverseString("Word"));
	}

	public static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}
	
	public static String reverseString(String str) {
		int strlen = str.length();
		char[] reversedStr = new char[strlen];

		for (int i = 0; i <= strlen / 2; i++) {
			reversedStr[i] = str.charAt(strlen - 1 - i);
			reversedStr[strlen - 1 - i] = str.charAt(i);

		}
		
		return new String(reversedStr);

	}

}
