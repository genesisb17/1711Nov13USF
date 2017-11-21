package com.revature.lambda;

public class Calculambda {
	public static void main(String[] args) {
		
		Calculable add = (a, b) -> {
			if(a < 0) {
				throw new Exception();
			}
			else {
				return a + b;
			}
		};
		
		Calculable multiply = (a, b) -> {
			if(a < 0) {
				throw new Exception();
			}
			else {
				return a * b;
			}
		};
		
	}
}

@FunctionalInterface
interface Calculable{
	double calculate(int a, int b) throws Exception;
}
