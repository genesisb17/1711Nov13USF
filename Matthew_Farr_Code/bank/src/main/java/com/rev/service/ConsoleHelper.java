package com.rev.service;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleHelper {
	
	Scanner scanner;
	
	public ConsoleHelper(Scanner scanner) {
		this.scanner = scanner;
	}
	
	/*
	 * Prints a prompt instructing the user to input a string, then returns the String the user inputs
	 */
	public String getStringFromPrompt(String str) {
		System.out.println(str);
		return scanner.nextLine();
	}
	
	/*
	 * Prints a prompt instructing the user to input a string, then returns a trimmed version of the
	 * String the user inputs
	 */
	public String getTrimmedStringFromPrompt(String str) {
		System.out.println(str);
		return scanner.nextLine().trim();
	}
	
	/*
	 * Prints a prompt instructing the user to input an int and returns the input int
	 */
	public int getIntFromPrompt(String str) {
		while (true) {
			try {
				System.out.println(str);
				int result = Integer.parseInt(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Not a valid integer input. Please try again.");
			}
		}
	}
	
	public BigDecimal getBigDecimalFromPrompt(String str) {
		while (true) {
			try {
				System.out.println(str);
				BigDecimal result = new BigDecimal(scanner.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Not a valid decimal number input. Please try again");
			}
		}
	}
}
