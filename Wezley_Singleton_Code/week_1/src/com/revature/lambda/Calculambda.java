package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {
		
		Calculable add = (a, b) -> {
			return a + b;
		};
		
		Calculable subtract = (a, b) -> {
			return a - b;
		};
		
		Calculable divide = (a, b) -> {
			try {
				if (b == 0) {
					throw new DivideByZeroException();
				}
				
				return a / b;
			}
			
			catch (DivideByZeroException dbze) {
				System.out.println("Cannot divide by zero.");
				return 0;
			}
		};
		
		Calculable multiply = (a, b) -> {
			return a * b;
		};
		
		Calculable modulo = (a, b) -> {
			return a % b;
		};
	}
	
}

@FunctionalInterface
interface Calculable {
	double calculate(int a, int b);
}