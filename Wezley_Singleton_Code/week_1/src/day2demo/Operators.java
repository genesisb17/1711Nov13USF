package day2demo;

public class Operators {
	
	/*
	 *  A Java operator is a special symbol that can be
	 *  applied to a set of variables, values, or literals -
	 *  referred to as operands - and that returns a result.
	 *  There are three types available in Java:
	 *  	unary - requires 1 operand (increment/decrement)
	 *  	binary - requires 2 operands
	 *  	ternary - requires 3 operands
	 */
	
	public static void main(String[] args) {
		
		// post-unary operators
		int x = 10;
		
		x++; // same as x = x + 1;
		System.out.println(x);
		
		x--; // same as x = x - 1;
		System.out.println(x);
		
		
		// pre-unary operators
		++x;
		--x;
		
		
		// other unary operators: ~, +, -, !
		int y = -x;	// indicates that x is negative
		y = +x;		// indicates that x is positive
		
		int z = ~4; // bitwise operator that takes the number (in binary) and flips the 0s and 1s.
		System.out.println(z);
		
		
		// first order of binary operators from left to right: *, /, %
		int test = 100 / 10 % 2 * 5; // same as: (((100 / 10) % 2) * 5)
		System.out.println(test);
		
		// addition and subtraction
		int sum = 2 + 3;
		
		// shift operators: <<, >>, >>>
		int shift1 = 1 << 5;	// shifts the bits to the left by the number of bits designated by the second operand
		System.out.println(shift1);
		
		int shift2 = 32 >> 2; // shifts the bits to the right by the number of bits designated by the second operand
		System.out.println(shift2);
		
		int shift3 = 100 >>> 2; // shifts a zero into the leftmost position
		System.out.println(shift3);
		
		// relational operators: <, >, <=, >=, instanceof
		
		// equivalence operators: ==, !=
		
		// logical operators: &, |, ^(XOR)
		
		// short circuit logical operators: &&, ||
		
		// ternary operator: [expression] ? [if true] : [if false]
		int tern = shift1 < 1 ? 5 : 2; // is 'shift1' less than 1? if so assign 5 to 'tern', otherwise assign 2
		
		// assignment operators:
		//		=, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
		
		shift3 >>>= 5;
		System.out.println(shift3);
	}
}
