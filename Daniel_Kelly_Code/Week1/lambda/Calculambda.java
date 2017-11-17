package com.revature.lambda;

public class Calculambda {
	
	public static void main(String[] args) {
		
		//Calculable add = (a,b) -> {return a + b};
		
		
	}

}

@FunctionalInterface
interface Calculable{
	double calculate(int a, int b);
}
