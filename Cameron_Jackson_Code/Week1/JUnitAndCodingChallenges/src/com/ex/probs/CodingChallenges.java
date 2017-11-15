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
}
