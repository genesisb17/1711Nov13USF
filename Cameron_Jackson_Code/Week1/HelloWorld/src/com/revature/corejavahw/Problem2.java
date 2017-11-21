package com.revature.corejavahw;

public class Problem2 {
	
	public static void main(String[] args) {
		fibonacci(25);
	}
	
	public static void fibonacci(int max) {
		int p0 = 0;
		int p1 = 1;
		int p3;
		System.out.print(p0 + " ");
		System.out.print(p1 + " ");
		for (int count = 1; count < max; ++count) {
			p3 = p1+p0;
			System.out.print(p3 + " ");
			p0 = p1;
			p1 = p3;
		}
		System.out.println("");
	}
}
