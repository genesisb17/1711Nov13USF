package com.rev.service;

import java.util.Scanner;

public class ConsoleHandler {
	
	Scanner sc;
	
	public ConsoleHandler(Scanner sc) {
		this.sc = sc;
	}

	public String promptString(String s) {
		System.out.println(s);
		return sc.nextLine();
	}

	public int promptInt(String s) {
		int result = 0;
		boolean tryAgain;
		do {
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

	public double promptDouble(String s) {
		double result = 0;
		boolean tryAgain;
		do {
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

}
