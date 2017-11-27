package com.rev.services;

import java.util.Scanner;

public class ConsoleHandler {
	
	private static Scanner sc;
	
	static {
		sc = new Scanner(System.in);
	}
	
	public ConsoleHandler() {
		super();
	}

	/*
	 * Outputs the provided String and returns the user's response as a String
	 */
	public String promptString(String s) {
		System.out.println(s);
		return sc.nextLine();
	}
	
	public String getString() {
		return sc.nextLine();
	}

	/*
	 * Outputs the provided String and returns the users response as an int
	 */
	public int promptInt(String s) {
		int result = 0;
		boolean tryAgain;
		do { // keep trying if the user inputs an invalid int
			tryAgain = false;
			try {
				result = Integer.parseInt(promptString(s));
			}catch(NumberFormatException e) {
				System.out.println("That is not a valid input.");
				tryAgain = true;
			}
		}while(tryAgain);
		return result;
	}
	
	public int getInt() {
		int result = 0;
		boolean tryAgain;
		do { // keep trying if the user inputs an invalid int
			tryAgain = false;
			try {
				result = Integer.parseInt(getString());
			}catch(NumberFormatException e) {
				System.out.println("That is not a valid input.");
				tryAgain = true;
			}
		}while(tryAgain);
		return result;
	}

	/*
	 * Outputs the provided String and returns the users response as a double
	 */
	public double promptDouble(String s) {
		double result = 0;
		boolean tryAgain;
		do { // keep trying if the user inputs an invalid double
			tryAgain = false;
			try {
				result = Double.parseDouble(promptString(s));
			}catch(NumberFormatException e) {
				System.out.println("That is not a valid input.");
				tryAgain = true;
			}
		}while(tryAgain);
		return result;
	}
	
	public double getDouble() {
		double result = 0;
		boolean tryAgain;
		do { // keep trying if the user inputs an invalid double
			tryAgain = false;
			try {
				result = Double.parseDouble(getString());
			}catch(NumberFormatException e) {
				System.out.println("That is not a valid input.");
				tryAgain = true;
			}
		}while(tryAgain);
		return result;
	}

}
