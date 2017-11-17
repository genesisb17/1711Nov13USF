package com.revature.Operators;

public class Operators {

	public static void main(String[] args) {
		/*
		 * Java operator is special symbol that can be
		 * applied to a set of variables, values, or literals -
		 * referred to as operands - and that returns a
		 * result. There are 3 types available in Java
		 * unary - requires 1 operand
		 * binary - req 2 "
		 * ternary - req 3 "
		 * must be carried out in following order:
		 */
		
		//post-unary ops
		int x = 10;
		x++;
		System.out.println(x);
		x--;
		System.out.println(x);
		
		//pre-unary ops
		++x;
		--x;
		
		//other unary ops ~, +, -, !
		int y = -x;
		y = +x;
		int z = ~50;
		System.out.println(z);
		
		//first order of binary operators from left to right --> *, /, %
		int test = 100/10%2*5;
		System.out.println(test);
		
		//addition and subtraction
		int sum = 2+3;
		
		//shift operators <<, >>, >>>
		int shift = 1 << 2;
		int shift3 = 100 >>> 2;
		System.out.println(shift3);
		System.out.println(shift);

		//relational operators <, >, <=, >=, instanceof
		
		//equals ==, !=
		
		//logical operator &, |, ^(XOR)
		
		//short circuit operators &&, ||
		
		//ternary operator = [expression] ? [if yes--this] : [if no -- this]
		int tern = shift < 1 ? 5 : 2;
		System.out.println(tern);
		
		//assignment operators
		//=, +=, -+, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
		
	}

}
