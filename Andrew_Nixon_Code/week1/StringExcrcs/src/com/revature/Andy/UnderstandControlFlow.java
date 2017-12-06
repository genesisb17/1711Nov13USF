package com.revature.Andy;

import java.util.Scanner;

public class UnderstandControlFlow {

	public static void main(String[] args) {
		
		/*
		 * a java statement is a complete unit of execution with a semicolon following it
		 * 
		 * a control flow statement breaks up the flow of execution  by using decision making, 
		 * looping & branching, allowing the application to selectively execute particular 
		 * segments of code
		 */
		
		System.out.println("Enter a number");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		//if statement
		if (x < 10) {
			System.out.println("Hello");
		}
		else if(x < 100) {
			System.out.println("Hi");
		}
		else {
			System.out.println("bye");
		}
		
		//Ternary
		System.out.println(x<10 ? "yo" : "sup");
		
		//while 
		while(x > 5) {
			System.out.println("while statemnt: x = " + x);
			x--;
		}
		
		do {
			System.out.println("do while statement: x = " + x);
			x++;	
		}while(x < 10);
		
		//for-loop
		//for([initial statement], [conditional statement], [update statement] { }
		
		/*
		 * Notes about for-loop
		 * 1. initialization statement executes
		 * 2. if bollean == true, else exit loop
		 * 3. execute body
		 * execute update
		 * return to 2
		 */
		
		//for-each-loop aka enhanced for-loop
		/*
		 * can hold int, byte short, char String, enum
		 */
		int[] nums = {2, 4, 6, 8, 10, 12};
		int sum = 0;
		for(int a : nums) {
			sum += a;
		}
		
		switch(x) {
		case 1: System.out.println("case 1");
		break;
		case 5: System.out.println("case 5");
		break;
		case 10: System.out.println("case 10");
		break;
		default: System.out.println("blah");
		}
		
		UnderstandingEnum op = UnderstandingEnum.ADD;
		System.out.println(op.calculate(10, 10));
		
		

	}

}
