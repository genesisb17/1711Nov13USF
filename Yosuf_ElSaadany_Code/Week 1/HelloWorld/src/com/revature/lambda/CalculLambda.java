package com.revature.lambda;

public class CalculLambda {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Calculable add = (a, b) -> {
		return a + b;		
	};
	
	Calculable sub = (a, b) -> {
		return a - b;		
	};
	
	Calculable mult = (a, b) -> {
		return a * b;		
	};
	
	Calculable div = (a, b) -> {
		return a / b;		
	};
	
	int a = 1;
	int b = 2;
	double x = add.calculate(a, b);
	
	
	}
	
}

interface Calculable{
	double calculate(int a, int b);
}




