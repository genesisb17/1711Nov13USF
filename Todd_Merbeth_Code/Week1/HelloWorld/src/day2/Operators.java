package day2;

public class Operators {
	
	/*
	 * A Java operator is a special symbol that can be
	 * applied to a set of variables, values, or literals-
	 * referred to as operands - and that returns a result. 
	 * There are three types available in Java
	 * unary - requires 1 operand
	 * binary - requires 2 operands
	 * ternary - requires 3 operands
	 */
	public static void main(String[] args) {
		
	//post-unary operators
	int x = 10;
	System.out.println(x++);
	System.out.println(x--);
	
//	pre-unary operators
	System.out.println(++x);
	System.out.println(--x);
	
	// other unary operators ~, +, -, !
	System.out.println(x);
	int y = -x;
	System.out.println(y);
	y = +y;
	System.out.println(y);
	int z = ~4;
	// www.joezimjs.com/javascript/great-mystery-of-the-tilde/
	System.out.println(z);
	
	// first order of binary operators from left to right --> *, /, %
	int test = 100/10%2*5;
	System.out.println(test);
	
	// add and subtract
	int sum = 2 + 3;
	
	// shift operators <<, >>, >>>
	int shift = 1 << 5;
	int shift3 = 100 >>> 2;
	System.out.println(shift);
	System.out.println(shift3);
	
	// relational operators <, >, <=, >= instanceof
	
	// equals ==, !=
	
	// logical operator &, |, ^(XOR)
	
	// short circuit operators &&, ||
	
	// ternary operator = [expression] ? [if yes] : [if no]
	int tern = shift < 1 ? 5 : 2;
	System.out.println(tern);
	
	// assignment operators:
	// =, +=, -+, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=   do the change and then assign value
	
	shift3 >>>= 5;
	System.out.println(x);
	
	
	
	}
}
