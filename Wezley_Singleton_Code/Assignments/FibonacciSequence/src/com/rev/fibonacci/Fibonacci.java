package com.rev.fibonacci;

import java.util.Scanner;

public class Fibonacci {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		printSequenceToConsole(fibSequencer(getUserInput()));
		scan.close();

	}

	static String getUserInput() {

		String userInput;
		
		
		System.out.print("Please enter the index position of the Fibonacci number you would like to print to: ");
		userInput = scan.nextLine();
		
		return userInput;

	}

	static long[] fibSequencer(String userInput) {

		try {
			int fibIndex = Integer.parseInt(userInput);
			long[] fibSequence = new long[fibIndex];

			fibSequence[0] = 0;
			fibSequence[1] = 1;
			
			for(int i = 2; i < fibIndex; i++) {
				
				fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];
				
			}

			return fibSequence;
		}

		catch (NumberFormatException nfe) {
			System.out.println("You have entered an incorrect value. Please try again.\n");
			getUserInput();
		}

		return null;

	}

	static void printSequenceToConsole(long[] fibSequence) {

		if(fibSequence != null) {

			for(long element : fibSequence) {
				System.out.print(element + " ");
			}	

		}
		
		else {
			System.out.println("Something went wrong...");
		}

	}

}
