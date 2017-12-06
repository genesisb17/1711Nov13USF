package com.revature.Andy;

public class UnderstandOperators {
	/*
	 * java operators is a special symbol that can be applied to a set of variables, values or 
	 * literals referred to as operands and that returns a result. there are available in java 
	 * unary- 1 operand
	 * binary- 2 operands
	 * ternary- 3
	 * must be carried out in the following order
	 */
	
	public static void main(String[] args) {
		//post-uneray
		int x = 10;
		x++;
		x--;
		
		//pre-unerary
		++x;
		--x;
		
		// other unary operators ~. +. -, !
		int y = -x;
		y = +x;
		int z = ~4;
		
		//first order of binary operators from left to right *, /, %
		
		int test = 100/10%2*5;
		//this equals 0
		
		//shift operators <<, >>, >>>
		int shift = 1 >> 2;
		
		
		//relation <, > <=, >=, instanceof
		
		//equals ==, != 
		
		//logical operator &, |, ^(XOR)
		
		//Short Circuit operators &&, ||
		
		//ternary operators = [expression] ? [if yes] : [if no]
		int tern = shift < 1 ? 5 : 2;
		
		//assignment operators
		//+=, -=
	}

}
