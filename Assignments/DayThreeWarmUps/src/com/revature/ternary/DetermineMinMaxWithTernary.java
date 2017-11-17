package com.revature.ternary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DetermineMinMaxWithTernary {

	public static void main(String[] args) {
		ArrayList<Integer> userInput = getUserInput();
		
		for(int element : userInput) {
			System.out.println(element);
		}
	}
	
	public static ArrayList<Integer> getUserInput() {
		
		ArrayList<Integer> userInput = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		
		try {
		
			System.out.println("Enter numbers to add, separated by a space: ");
			String input = scan.nextLine();
			
			String[] inputStrings = input.split(" ");
			
			for(int i = 0; i < inputStrings.length; i++) {
				userInput.add(Integer.parseInt(inputStrings[i]));
			}
			
			return userInput;
		
		}
		
		catch (NumberFormatException nfe) {
			
			System.out.println("Invalid input. Please try again.\n");
			ArrayList<Integer> tryAgain = getUserInput();
			return tryAgain;
			
		}
		
		catch (Exception e) {
			
			System.out.println("Something went wrong...");
			e.printStackTrace();
			ArrayList<Integer> tryAgain = getUserInput();
			return tryAgain;
			
		}
		
		finally {
			scan.close();
		}
	
	}
	
	public static int determineMinWithTernary(ArrayList<Integer> userInput) {
	
		for(int element : userInput) {
			
		}
		
		return 0;
		
	}
	
}
 