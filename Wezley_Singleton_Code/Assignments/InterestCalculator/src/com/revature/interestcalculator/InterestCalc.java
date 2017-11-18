package com.revature.interestcalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  Write a program that calculates the simple interest on the principal, rate of interest and number of
 *  years provided by the user. Enter principal, rate and time through the console using the Scanner class.
 * 
 *  		Interest = Principal* Rate* Time
 *  
 */

public class InterestCalc {

	/*
	 *  HashMap is utilized to store user input values for principle and term length variables.
	 *  BigDecimal is utilized since working with monetary values.
	 */
	public static void main(String[] args) {

		printWelcome();
		HashMap<String, BigDecimal> userInputMap = getUserInput();
		BigDecimal accruedInterest = interestCalculator(userInputMap);
		
		System.out.println("\nThe amount of accrued interest you will have by the end of your term is: $" + accruedInterest);
		
	}

	static void printWelcome() {
		
		System.out.println("Welcome to MuhBank's Interest Calculator!\n\nHere you can enter an initial "
				+ "principle amount and the length\nof time you plan to put your money with us. Using "
				+ "this\ninformation, we can tell you what your accrued amount of\ninterest will be at "
				+ "the end of your term - at our current\nmonthly interest rate: 5.5%");
	}
	
	
	static HashMap<String, BigDecimal> getUserInput() {

		HashMap<String, BigDecimal> userInputMap = new HashMap<String, BigDecimal>();
		
		try (Scanner scan = new Scanner(System.in)) {

			System.out.print("\nEnter your starting principle amount: ");
			BigDecimal principleAmount = scan.nextBigDecimal();
			
			System.out.print("\nEnter your desired term length, in months: ");
			BigDecimal termLength = scan.nextBigDecimal();
			
			userInputMap.put("principle", principleAmount);
			userInputMap.put("term", termLength);

			return userInputMap;
			
		}
		
	}
	
	static BigDecimal interestCalculator(HashMap<String, BigDecimal>  userInputMap) {
		
		double interestRate = 0.055;
		double accruedInterest;
		BigDecimal accruedInterestBD;
		
		accruedInterest = userInputMap.get("principle").doubleValue() * userInputMap.get("term").doubleValue() * interestRate;
		
		accruedInterestBD = BigDecimal.valueOf(accruedInterest);
		return accruedInterestBD;
		
	}

}
