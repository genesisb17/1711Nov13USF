package Factorial;

public class nFactorial {

	public static void main(String[] args) {
		/* 
		 * This program creates a method that performs N Factorial 
		 * based on given int value
		 */
		
		int fact = 5;
		System.out.println("Number were performing factorial function on: " + fact);
		fact = factorial(fact);
		System.out.println("Factorial value of given number: " + fact);
		
		
	}
	
	static int factorial(int n) {
		if (n<0) {
			System.out.println("Can't be negative");
			return 0;
		}
		else if (n == 0)
			return 1;
		else
			return(n * factorial(n-1));
	}

}
