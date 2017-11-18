package com.revature.homework;

import java.util.ArrayList;

public class PrintPrimes {
	
	public static void main(String[] args) {
		ArrayList<Integer> arrLst = new ArrayList<Integer>();
		for (int i=1; i<=100; i++)
			arrLst.add(i);
		
		for (int n : arrLst) {
			if (isPrime(n))
				System.out.println(n + " ");
		}
	}
	
	static boolean isPrime(int n) {
		if (n < 2) // check if less than 2 since negative numbers and 1 aren't prime
			return false;
		if (n > 2 && (n & 1) == 0) // check if greater than 2 and even
			return false;
		for (int i=3; i < n/2; i++) { // check for even divisors
			if (n%i == 0)
				return false;
		}
		
		return true;
	}
	
}
