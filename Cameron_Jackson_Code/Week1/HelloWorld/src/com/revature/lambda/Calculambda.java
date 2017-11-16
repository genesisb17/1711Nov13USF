package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculable add = (a, b) -> {
			return a + b;
		};
		
		// Can also write as: 
		// Calculable add = (a, b) -> a + b;
		
		// Multiplication
		Calculable multiply =  (a, b) -> a * b;
		
		// Division
		// TODO: add exception handling
		Calculable divide = (a, b) -> {
			if (b == 0) throw new DivideByZeroException("Cannot divide by zero");
			return a / b;
		};
		
	}

}

@FunctionalInterface
interface Calculable {
	double calculate(int a, int b) throws DivideByZeroException;
}