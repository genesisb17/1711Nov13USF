package com.revature.ControlFlow;

import java.util.Scanner;

import com.revature.Enum.Operations;

public class ControlFlow {

	public static void main(String[] args) {
		/*
		 * a java statement is a complete unit of execution
		 * with a semicolon following it
		 * 
		 * A control flow statement breaks up the flow of
		 * execution using decision making, looping, & branching,
		 * allowing the application to selectively execute
		 * particular segments of code
		 */
		
		System.out.println("Enter a number ");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		//IF-STATEMENT
		if(x<10){
			System.out.println("Hello");
		}
		else if(x<100){
			System.out.println("World");
		}
		else{
			System.out.println("Goodbye");
		}
		
		//TERNARY
		System.out.println(x<10 ? "Hello" : "Goodbye");
		
		//WHILE
		while(x<5){
			x++;
			if(x==3)continue;
			System.out.println("WHILE STATEMENT: " + x);
		}
		
		do{
			System.out.println("DO WHILE STATEMENT: " + x);
			x++;
		}while(x<5);
		
		//FOR-LOOP
		for(int i = 0; i < x; i++){
			System.out.println("WOOOOOO " + i);
		}
		/*
		 * notes about for loop:
		 * 1. initialization statement executes
		 * 2. if boolean expression == true, else exit loop
		 * 3. execute body
		 * 4. execute update statement
		 * 5. return to 2
		 */
		
		//FOR_EACH LOOP AKA ENHANCED FOR LOOP
		int[] nums = {2, 4, 5, 6, 7, 2, 351};
		int sum = 0;
		for(int y : nums){
			sum += y;
		}
		System.out.println("Sum " + sum);
		
		//SWITCH
		/*
		 * can hold int, byte, short, char, String, enum
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
				break;
		}
		
		Operations op = Operations.ADD;
		System.out.println(op.calculate(10,10));

	}

}
