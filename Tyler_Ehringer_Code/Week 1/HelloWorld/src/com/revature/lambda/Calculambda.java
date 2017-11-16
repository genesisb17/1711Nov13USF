package com.revature.lambda;


public class Calculambda {
	
	Calculable add = (a, b) -> a + b;
	Calculable subtract = (a, b) -> a - b;
	Calculable multiply = (a, b) -> a * b;
	Calculable divide = (a, b) -> {
		if(b == 0) throw new MyException("You fool! A zero in the denominator?");
		return a / b;
	};
}

@FunctionalInterface
interface Calculable{
	double calculate(int a, int b) throws MyException;
}
