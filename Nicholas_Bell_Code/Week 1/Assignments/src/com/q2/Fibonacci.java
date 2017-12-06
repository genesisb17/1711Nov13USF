package com.q2;

public class Fibonacci {
	
	
	
	public static void main(String[] args) {
		
		fibonacci(25);
		
	}
	
	static void fibonacci(int n) {
		int f1 = 0;  //Fib[0]
		int f2 = 1;  //fib[1]
		
		//Handles base cases of fib sequence
		if (n >= 0) {
			System.out.print(f1 + " ");
		}//end if
		if (n >= 1) {
			System.out.print(f2 + " ");
		}//end if
		
		//
		if ( n >=2 ) {
			int i = 2;
			int next;
			while(i < n) {
				next = f1 + f2;
				f1 = f2;
				f2 = next;
				System.out.print(next + " ");
				i++;
			}
			
		}
	}
}
