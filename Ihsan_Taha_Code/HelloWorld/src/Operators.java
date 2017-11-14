
public class Operators {
	/*
	 * A Java operator is a special symbol that can be applied to a set of variables, values, or literals
	 * referred to as operands - and that returns a result. There are three types available in Java.
	 * unary - requires 1 operand
	 * binary - requires 2 operands
	 * ternary - requires 3 operands
	 */
	
	public static void main(String[] args)
	{
		int x = 10;
		System.out.println("++x:\t" + ++x);	// pre-unary
		System.out.println("x:\t" + x);
		System.out.println("x++:\t" + x++);	// post-unary
		System.out.println("x:\t" + x);
		
		int y = -x, z = +x, w = ~y;
		System.out.println("y:\t" + y);
		System.out.println("w:\t" + w);
		
		// relational operators <, >, <=, >=, instanceof
		
		// equals ==, !=
		
		// logical operator &, |, ^
		
		// short circuit operators &&, ||
		
		// assignment operators: =, -=, +=, *=, /=?
		
		int modulo = 100/10%2*5;
		System.out.println("modulo: " + modulo);
		
		// shift operators <<, >>, >>>
		int shift = 1 << 5;	
		System.out.println("shift:\t" + shift);
		
		// ternary operator = [expression] ? [if true] : [if false]
		int tern = shift < 1 ? 5: 2;
		System.out.println(("tern:\t" + tern));
	}
}
