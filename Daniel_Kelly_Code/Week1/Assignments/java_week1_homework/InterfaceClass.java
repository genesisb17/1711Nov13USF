package com.revature.homework;

public class InterfaceClass {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		InterfaceTest it = new InterfaceTest();
		it.addition(a, b);
		it.subtraction(a, b);
		it.division(a, b);
		it.multiplication(a, b);

	}

}
