package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {
		
		Calculable add = (a, b) -> {
			return a+b;
		};
		Calculable sub = (a, b) -> {
			return a-b;
		};
		
		Calculable multiply = (a, b) -> {
			return a*b;
		};
		
		Calculable divide = (a, b) -> {
			return a/b;
		};
		
		double i = add.calculate(1, 2);
	}

}

interface Calculable{
	double calculate(int a, int b);
}

interface Testing{
	int test1(int a);
}
