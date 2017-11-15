package day2;

import java.util.Scanner;

public class ControlFlow {

	/*
	 * A java statement is a complete unit of execution
	 * with a semicolon following it
	 * 
	 * A control flow statement breaks up the flow of
	 * execution by using decision making, looping, & branching,
	 * allowing the application to selectively execute
	 * particular segments of code
	 */
	public static void main(String[] args) {
		System.out.println("Enter a number:");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		if(x<10) {
			System.out.println("Hello");
		}
		else if(x < 100){
			System.out.println("Worlds");
		}
		else {
			System.out.println("Goodbye");
		}
		//ternary
		System.out.println(x < 10 ? "Hello" : "World");
		
		//while
		while(x<5) {
			x++;
			if(x == 3) continue;
			System.out.println("WHILE STATEMENT: " + x);
		}
		
		do { 
			System.out.println("DO-WHILE STATEMENT: " + x);
			x++;
		} while(x<5);
		
		// for(init statement; conditional; update statement){stuff}   *only for( ; ; ){} necessary
		for(int i = 0; i < x; ) {
			System.out.println("WOOOO " + i);
			i++;
		}
		/*
		 * notes about for loop:
		 * 1. initialization statement executes
		 * 2. if booleanexp == true, else exit loop
		 * 3. execute body
		 * 4. execute update statement
		 * 5. return to 2
		 */
		
		//FOR-EACH AKA ADVANCED FOR LOOP
		int[] nums = {2, 4 ,5, 6, 2, 351, 53, 13};
		int sum = 0;
		for(int y : nums) {
			sum += y;
		}
		System.out.println(sum);
		
		//SWITCH
		/*
		 * can hold int, byte, short, char, Strings, enum
		 */
		x=5;
		switch(x){
		case 1:
			System.out.println("x is 1");
			break;
			
		case 5:
			System.out.println("x is 5");
			break;
			
		case 10:
			System.out.println("x is 10");
			break;
			
		default:
			System.out.println("blah");
		}
			
	Operations op = Operations.ADD;
	System.out.print(op.calculate(10, 10));
	
	}
}
