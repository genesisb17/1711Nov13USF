package com.revature.homework;

public class InterfaceTest implements InterfacePractice {

	@Override
	public void addition(int a, int b) {
		System.out.println(a + b);

	}

	@Override
	public void subtraction(int a, int b) {
		System.out.println(a - b);
	}

	@Override
	public void multiplication(int a, int b) {
		System.out.println(a * b);
	}

	@Override
	public void division(int a, int b) {
		System.out.println(a/b);
	}

}
