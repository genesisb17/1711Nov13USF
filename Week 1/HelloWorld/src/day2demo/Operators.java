package day2demo;


public class Operators {
	/* 
	 * Unary: 1 operand
	 * binary: 2 operands
	 * ternary: 3
	 */
	public static void main(String[] args) {
		
		// Post-unary operators
		int x = 10;
		x++;
		System.out.println(x);
		x--;
		System.out.println(x);
		
		// Pre-unary operators
		++x;
		--x;
		
		// Other unary operators ~ (bitwise) , +, -, !
		int y = -x;
		y = +x;
		int z = ~4;
		System.out.println(z);
		
		// First order of binary operators from left to right --> *, /, %
		int test = 100 / 10 % 2 * 5;
		System.out.println(test);
		
		// Addition and Subtraction
		int sum = 2 + 3;
		
		// Shift operators <<, >>, >>>
		int shift = 1 << 5;
		System.out.println(shift);
		int shift3 = 100 >>> 2;
		System.out.println(shift3);
		
		// Relational operators <, >, <=, >=, instanceof
		
		// equals ==, !=
		
		// logical operator &, |, ^ (XOR)
		
		// short circuit operators, &&, ||
		
		// ternary operator
		int tern = shift < 1 ? 5 : 2;
		System.out.println(tern);
		
		// assignment operators
		// =, +=, -=, *=, /=, %=, &=, |=, <<=, >>=, >>>=
		
		shift3 >>>= 5;
		System.out.println(shift);
					
	}

}
