package day2demo;

import java.util.Scanner;

public class ControlFlow {

	/*
	 *  A Java statement is a complete unit of execution
	 *  with a semicolon following it.
	 *  
	 *  A control flow statement breaks up the flow of 
	 *  execution by using decision making, looping, & branching,
	 *  allowing the application to selectively execute
	 *  particular segments of code
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Enter a number:");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		// IF-STATEMENT
		System.out.println("\nIF-STATEMENT...");
		if(x < 10) {
			System.out.println("Hello");
		}
		else if (x < 100){
			System.out.println("World");
		}
		else {
			System.out.println("Goodbye");
		}
		
		// TERNARY
		System.out.println(x < 10 ? "Hello" : "Goodbye");
		
		// WHILE
		System.out.println("\nWHILE...");
		while (x < 5) {
			x++;
			if( x == 3) continue; //skips remainder of code body and proceeds with the next iteration of the loop
			System.out.println(x);
		}
		
		// DO-WHILE
		System.out.println("\nDO-WHILE...");
		do {
			System.out.println(x);
			x++;
		}
		while (x < 3);
		
		// FOR-LOOP
		
		/*
		 * the three components of a for loop: initialization, conditional, update
		 * these statements can be blank (though the semicolons are still required)
		 * 
		 * quick notes:
		 * 1. initialization statement executes
		 * 2. if conditional == true, else exit loop
		 * 3. execute code body
		 * 4. execute update statement
		 * 5. return to step 2
		 */
		
		System.out.println("\nFOR-LOOP...");
		for(int i = 0; i < x; i++) {
			System.out.println(i);
		}
		
		// FOR-EACH LOOP (ADVANCED FOR-LOOP)
		// 		used to iterate over a collection easily without referencing index locations
		 
		System.out.println("\nFOR-EACH LOOP...");
		int[] nums = {2, 4, 5, 7, 2, 351, 53, 13};
		int sum = 0;
		
		for (int y : nums) {
			sum += y;
		}
		
		System.out.println(sum);
		
		// SWITCH-STATEMENT
		/*
		 * can hold int, byte, short, char, String, enum
		 */
		System.out.println("\nSWITCH-STATEMENT...");
		// reset 'x' for switch statement
		x = 5;
		
		switch(x) {
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
			System.out.println("x is neither 1, 5, nor 10");
		}
	
		Operations op = Operations.ADD;
		System.out.println(op.calculate(10, 10));
	}
}
