package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) throws DivideByZeroException {
		
		Calculable add = (a, b) -> {
			
			return a + b;
			
		};
		
		Calculable subtract = (a, b) -> {
			
			return a - b;
			
		};
	}
	
	
	
}

interface Calculable{
	double calculate(int a, int b);

}