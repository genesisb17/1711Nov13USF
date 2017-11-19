package com.junitproject.programs;

/**
 * 
 * @author Ihsan Taha
 *
 *         The following program is an alternative implementation to the modulus
 *         operator to determine if a number is even, the minimum of two
 *         operands using the ternary operator. The program also uses JUnit to
 *         test cases.
 */
public class JUnitProject {

	// Modulo method
	public String modulo(int n) {
		String result;

		if ((n - n / 2) == n / 2) {
			result = "even";
		} else
			result = "odd";

		return result;
	}

	// Array List of prime numbers
	public boolean printPrimeNumbers(Integer n) {
		boolean isPrime = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				 isPrime = false;
				 return isPrime;
			}
		}
		return isPrime;
	}

	// Minimum of two operands with a ternary operator
	public int minimum(int x, int y) {
		return (x <= y) ? x : y;
	}

}
