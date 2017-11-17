package com.revature.evenOdd;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  Write a program to determine if an integer is even without using the modulus operator (%), 
 *  and write a jUnit test case.
 */

public class EvenOddNoMod {
	
	public static void main(String[] args) {
		
		int userInput = getUserInput();
		
		String result = determineEvenOdd(userInput);
		
		System.out.println("The value you entered, " + userInput + ", is " + result + ".");
		
	}
	
	public static int getUserInput() {

		Scanner scan = new Scanner(System.in);
		
		try {
			
			System.out.print("Please enter a integer: ");
			int input = scan.nextInt();
			
			return input;
		}
		
		catch (InputMismatchException ime) {
			
			System.out.println("Invalid input. Please try again.\n");
			int tryAgain = getUserInput();
			return tryAgain;
			
		}
		
		catch (Exception e) {
			
			System.out.println("Something went wrong...");
			e.printStackTrace();
			int tryAgain = getUserInput();
			return tryAgain;
			
		}
		
		finally {
			scan.close();
		}
	
		
	}
	
	public static String determineEvenOdd(int input) {
		
		String evenOdd;
		
		if ( (input / 2) * 2 == input) {
			evenOdd = "even";
		}
		
		else {
			evenOdd = "odd";
		}
		
		return evenOdd;
	}
	
	
	
}
