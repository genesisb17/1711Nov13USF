package day2demo;

public class Operators {
/*
 * A java operator is a special symbol that can be applied to a set of
 * variables, values, or literals-
 * referred to as operands - and that returns a result. There are three
 * types available in Java
 * unary - requires one operand
 * binary - requires 2 operands
 * ternary - requires 3 operands
 * must be carried out in the following order:
 */
	
	//post-unary operators
	int x = 10;
	x++; // same as x=x+1;
	System.out.println(x);
	x--; // x=x-1;
	System.out.println(x);
	
	//pre-unary operators
	++x;
	--x;
	
	//other unary operators ~, +, -, !
	int y=-x;
	y=+x;
	int z= ~4;
	//link for explanation of tilde in instructor notes
	System.out.println(z);
	
	//first order of binary operators from left to right --> *,/,%
	int test=100/10%2*5;
	System.out.println(test);
	
	//addition and subtraction
	int sum=2+3;
	
	//shift operator <<, >>, >>>
	int shift = 1<<5;
	System.out.println(shift);
	int shift3=100>>>2;
	
	//relational operators <, >, <=, >=, instanceof
	
	//equals ==, !=
	
	//logical operator &, |, ^(XOR)
	
	//short circuit operators &&, || 
	
	//ternar operator = [expression]?[if yes]:[if no] 
	int tern=shift <1 ? 5:2;
	System.out.println(tern);
	
	//assignment operators:
	//=, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
	
	shift3 >>>= 5;
	System.out.println(shift);
}
}