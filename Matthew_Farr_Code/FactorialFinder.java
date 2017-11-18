package com.revature.homework;

public class FactorialFinder {
	
	public static void main(String[] args) {
		
		FactorialFinder ff = new FactorialFinder();
		
		// Number to compute the factorial of
		int n = 6;
		
		System.out.println("Input number: " + n);
		
		if (n < 0) {
			System.out.println("Can only compute the factorial of positive integers.");
			return;
		}
		
		System.out.println(n + "! = " + ff.factorial(n));
		
	}
	
	int factorial(int n) {
		return (n==0 || n==1) ? 1 : n * factorial(n-1);
	}
	
}
