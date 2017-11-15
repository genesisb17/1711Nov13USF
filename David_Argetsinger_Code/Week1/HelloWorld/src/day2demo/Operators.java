package day2demo;

public class Operators {
	/*
	 * java operator is a special symbol that can be 
	 * applied to a set of variables values or literals 
	 * refferd to as ooperands this returns and result
	 * there are three types in java 
	 * unary binary ternary (1 2 3 operands ) 
	 * must be carried out i nthe followin order:
	 *  
	 */
	public static void main(String[] args) {
		//post unary operators 
		int x = 10;
		x++;//x=x+1
		System.out.println(x);
		x--;
		System.out.println(x);
		//preunary ops
		++x;
		--x;
		//other unary operators ~,+,-,! 
		int y = -x;
		y=+x;
		int z = ~4;
		System.out.println(z);
		//add one turns neg, good for binary 
		
		//binary operators order --> *,/,%
		int test = 100/10%2*5;
		System.out.println(test);
		// addition and subtraction
		int sum =2+3;
		// shift operators <<, >>, >>> 
		int shift= 1<<5;
		int shift3= 100>>>2;
		System.out.println(shift);
		System.out.println(shift3);
		
		//relational operators  < > <= >= instanceof
		//equals ==!=
		//logial operator &, |, ^(XOR exclusive or) when you want to still increment
		
		// short circuit && ||
		//ternary operators  [expression]? [if yes]: [if no]
		int tern= shift<1 ? 5: 2;
		// if shift less than 1 if yes 5 if no 2 
		System.out.println(tern);
		
		//assignment operators: 
		// =, +=, -=, *=, /=, %=.&=,^=,|=, <<=,>>=,>>>
		shift3 >>>= 5; //shifts 5 spaces 
		System.out.println(shift);
		
		
		
	}
	
	
}
