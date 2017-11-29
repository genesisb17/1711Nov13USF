package com.revature.lambda;

public class Calculambda {

	public static void main(String[] args) {

		
		

//		Calculable add = (a, b) -> {
//				return a + b;
//		};

		
		Calculable divide = (a, b) ->{
			//if (b < 0) throw new NumberFormatException();
			//else
				return a/b;
		};
		
		divide.calculate(5, 2);
	}

}

@FunctionalInterface
interface Calculable {
	double calculate(int a, int b) throws NumberFormatException;
}
