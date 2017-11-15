package com.revature.day2;

public class Operators {
	public static void main(String[] args) {
/*
		
		 * A java operator is specified by the
		 
		// post-unary operators
		int x = 10;
		x++;// same as x=x+1;
		System.out.println(x);
		x--;// same as x=x-1;
		System.out.println(x);

		// pre-unary operators
		++x;
		--x;

		// other unary operators ~, +, -, !
		int y = -x;
		y = +x;
		int z = ~4;
		System.out.println(z);

		// first order of binary operators from left to right --> *,/,%
		int test = 100 / 10 % 2 * 5;
		System.out.println(test);

		// addition and subtractions
		int sum = 2 + 3;

		// shift operators <<, >>, >>>
		int shift = 1 << 2;
		System.out.println(shift);*/
		Operations op=Operations.ADD;
		System.out.println(op.calculate(5, 5));
	}
}
