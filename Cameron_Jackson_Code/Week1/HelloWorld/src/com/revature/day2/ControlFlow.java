package com.revature.day2;

import java.util.Scanner;

public class ControlFlow {

	public static void main(String[] args) {
		/*
		 * A java statement is a complete unit of execution
		 * with a semicolon following it
		 * 
		 * A control flow statement breaks up the flow of
		 * execution by using decision making, looping, & branching
		 * allowing the application to selectively execute
		 * particular segments of code
		 */

		System.out.println("Enter a number:");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		//IF-STATEMENT
		if (x < 10) {
			System.out.println("Hello");
		}
		else if (x < 100) {
			System.out.println("World");
		}
		else {
			System.out.println("Goodbye");
		}
		
		//TERNARY
		System.out.println(x<10 ? "Hello" : "Goodbye");
		
		//WHILE
		while (x < 5) {
			System.out.println(x);
			x++;
		}
		
		do {
			System.out.println("DO-WHILE STATEMENT: " + x);
			x++;
		} while (x < 5);
		
		//FOR LOOP
		for (int i = 0; i < x; i++) {
			System.out.println("Wooooop: " + i);
		}
		/*
		 * some notes about for loop:
		 * 1. initialization statement executes
		 * 2. if boolean expression is true, else exit loop
		 * 3. execute body
		 * 4. update statement executes
		 * 5. return to 2. 
		 */
		
		//FOR-EACH LOOP (ENHANCED FOR-LOOP)
		int[] nums = {2, 4, 10, 11, 10232, 13, 19, 21, 492};
		int sum = 0; 
		for (int y : nums) {
			sum += y;
		}
		
		System.out.println("AT SWITCH STATEMENT");
		x = 5;
		//SWITCH STATEMENT
		switch (x) {
		case 1:
			System.out.println("x is 1");
			break;
		case 2: 
			System.out.println("x is 2");
			break;
		case 5:
			System.out.println("x is 5");
			break;
		default:
			System.out.println("x is " + x);
		}
		/*
		 * switch statements can switch off of anything that can be
		 * cast to an (int)
		 * int, byte, short, char
		 */
		
		Operations z = Operations.ADD;
		System.out.println(z.calculate(10, 10));
	}

}
