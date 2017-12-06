package com.q4;

import java.util.Scanner;

//calculates
public class Factorial {
	
	@SuppressWarnings("serial")
	class factorialException extends Exception {
		public factorialException() {}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int thisFactorial = 0;
		try {
			thisFactorial = new Factorial().factorial(n);
		}
		catch(factorialException fe){
			n = 0;
			System.out.println("Factorials require positive numbers.\nReturning 0.");
			fe.printStackTrace();		
		}

		
		System.out.printf("The factorial of %d is %d", n, thisFactorial);
	}
	
	public int factorial(int n) throws factorialException{
		if (n < 0) {
			n = 0;
			throw new factorialException();
		}
		if (n == 0) return 1;
		if (n == 1) return n;
		else
			return n * factorial (n-1);
	}

}
