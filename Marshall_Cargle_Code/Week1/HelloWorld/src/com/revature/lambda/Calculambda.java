package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {
		Calculable add = (a, b) -> {
			return a + b;
		};
		Calculable multiply = (a, b) -> {
			return a * b;
		};
		Calculable divide = (a, b) -> {
			if (b == 0)
				throw new CustomException("No Zeros on bottom");
			else
				return a / b;
		};
	}
}

interface Calculable {
	double calculate(int a, int b) throws Exception;
}
