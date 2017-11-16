package com.revature.day3;

public class CodingChallenges {
	
	public int factorial (int n) {
		if (n < 0) {
			System.out.println("Factorial cannot be negative");
			return -1;
		}
		
		return (n==0 || n==1) ? 1 : n * factorial(n-1);
		
		//return (n == 0 || n == 1) ? 1 : n * factorial(n-1);
		
		/*if (n==0 || n==1)
			return 1;
		else
			return n * factorial(n-1);*/
		
		/*
		int temp = 1;
		if (n==0)
			return temp;
		for (int i=1; i<=n; i++) {
			temp *= i;
		}
		return temp;*/
	}
	
	public String reverseString(String s) {
		char[] arr = s.toCharArray();
		for (int i=0; i<arr.length/2; i++) {
			char temp = arr[arr.length-1-i];
			arr[arr.length-1-i] = arr[i];
			arr[i] = temp;
		}
		return new String(arr);
	}
	
}
