package com.revature.lambda;

public class Calculalambda {
	
	public static void main(String[] args) {
		
		Calculable add = (num1, num2) -> {
			return num1 + num2;
		};
		
		int x = 1, y = 5;
		System.out.println(add.calculate(x, y));
		
		
		
		// Assignment Example
		Dividable divide = (num1, num2) -> {
				try 
				{
					if (num2 == 0) throw new CannotDivideByZeroException();
				} catch (CannotDivideByZeroException e) {
					System.out.println("Cannot divide by zero!");
					return 0;
				}
			return num1/num2;
		};
		
		System.out.println(divide.divide(5, 0));
		System.out.println(divide.divide(5, 2));
		
	}

}

@FunctionalInterface
interface Calculable {
	int calculate(int a, int b);
}

@FunctionalInterface
interface Dividable {
	int divide(int a, int b);
}
