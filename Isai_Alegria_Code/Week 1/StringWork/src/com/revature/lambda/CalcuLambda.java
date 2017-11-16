package com.revature.lambda;

public class CalcuLambda {
	
	public static void main(String[] args) {
		
		Calculable add = (a,b) -> {
			return a + b;
		};
		
		Calculable substract = (a,b) -> {
			return a - b;
		};
		
		Calculable division = (a,b) -> {
			
			return a/b;
		};
	}
	
	@FunctionalInterface
	interface Calculable{
		double calculate(int a, int b) throws Exception;
	}
	
	class divideByZeroException extends Exception{
		divideByZeroException(String s){
			super(s);
		}
	}

}
