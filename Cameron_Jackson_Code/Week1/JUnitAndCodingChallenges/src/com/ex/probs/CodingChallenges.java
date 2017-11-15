package com.ex.probs;

public class CodingChallenges {
	
	/*
	 * factorial()
	 * recursively call factorial function
	 */
	public int factorial(int n) {
		if (n > 0) {
			return n * factorial(n - 1);
		} else { // if n is 0, we've reached the end of the sequence, multiply a 1
			return 1;
		}
	}
	
	public String reverseString(String str) {
		int i = 0, j = str.length() - 1;
		char[] ch_arr = str.toCharArray();
		char temp;
		while (j > 0) {
			if (i != j) {
				temp = ch_arr[i];
				ch_arr[i] = ch_arr[j];
				ch_arr[j] = temp;
				++i;
				--j;
			}
		}
		return new String(ch_arr);
	}
}
