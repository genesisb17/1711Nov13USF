package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {
		
		
		
		Calculable add = (a, b) -> {
			if(a < 0) {
				try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
			return a + b;
			
		};
		
		Calculable multiply = (a, b) -> {
			return a * b;
		};
		
		Calculable divide = (a, b) -> {
			return a / b;
		}; 
		
		Calculable myException = (a, b) -> {
			return a / 0;
		};
		
		
		
		
	}

}

interface Calculable {
	double calculate(int a, int b);
}






