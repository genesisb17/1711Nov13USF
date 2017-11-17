package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {
		
		
		
		Calculable add = (a,b) -> {
			return a + b;
		};
		
		Calculable mult = (a,b) -> {
			return a*b;
		};
		
		Calculable div = (a,b) -> {
			try {
				return a/b;
			}
			catch(ArithmeticException e)
			{
				e.printStackTrace();
			}
			return a/b;
		};

		
		
	}

}
@FunctionalInterface
interface Calculable{
	double calculate(int a, int b) throws ArithmeticException;
}