package com.revature.homework;

public class PrintFibonacci {
	
	// Initialize seed numbers
	private static int n = 0;
	private static int n1 = 1;
	
	public static void main(String[] args) {
		PrintFibonacci pf = new PrintFibonacci();
		
		System.out.print(n + ", " + n1);
		
		for (int i=3; i<= 25; i++) {
			pf.computeNextFibonacci();
			System.out.print(", " + n1);
		}
	}
	
	void computeNextFibonacci() {
		int temp = n1;
		n1 = n1 + n;
		n = temp;
	}
	
}
