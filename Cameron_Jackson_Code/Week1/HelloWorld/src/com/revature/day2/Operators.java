package com.revature.day2;

public class Operators {
	/* 
	 * A Java Operator is a special symbol that can be 
	 * applied to a set of variables, values, or literals-
	 * referred to as operands - and that returns a result.
	 * There are three types of operands available in Java
	 * unary - requires 1 operand
	 * binary - requires 2 operands
	 * ternary - requires 3 operands
	 * must be carried out in the following order:
	 */
	
	public Operators() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// post-unary operators
		int x = 10;
		x++; // same as x = x + 1
		System.out.println(x);
		x--; // x = x - 1
		System.out.println(x);
		
		// pre-unary operators
		++x;
		--x;
		
		// other unary operators ~, +, -, !
		int z = ~5;
		System.out.println("z: " + z);
		
		// binary operators left to right --> *, /, %
		int test = 100/10%2*5;
		System.out.println("test: " + test);
		
		// addition and attraction
		x = 2 + 3;
		
		// shift operators 
		int shift = 1 << 5; 
		int shift3 = 100 >>> 2; // shifts zero to leftmost position
		System.out.println("shift3: " + shift3);
		
		// relational operators <, >, <=. >=, instanceof
		
		// equals ==, !=
		
		// logical operator &, |, ^(XOR)
		
		// short circuit operators &&, ||
		
		// ternary operator = [expression] ? [if yes] : [if no]
		int tern = shift < 1 ? 5 : 2;
		System.out.println(tern);
		
		// assignment operators:
		// =, +=, -=, /=, *=, %=, &=, ^=, |=, <<=, >>=, >>>=
		
		//
	}

}
