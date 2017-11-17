package com.revature.lambda;

import java.lang.Exception;

public class Calculambda {

	public static void main(String[] args) throws Exception{
		
		Calculable add  = (a, b) -> {
			return a + b;
		};
		Calculable divide  = (a, b) -> {
			if(b == 0) {
				throw new Exception();
			}
			else return a / b;
			
		};
		Calculable multiply  = (a, b) -> {
			return a * b;
		};
		
		multiply.calculate(3, 2);
	}
}

interface Calculable {
	double calculate(int a, int b);
}