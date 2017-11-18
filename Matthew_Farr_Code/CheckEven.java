package com.revature.homework;

public class CheckEven {
	
	public static void main(String[] args) {
		
		CheckEven ce = new CheckEven();
		
		int n = -9;
		
		System.out.println(n + " is even? " + ce.isEven(n));
		
	}
	
	boolean isEven(int n) {
		return (n & 1) == 0;
	}
	
}
