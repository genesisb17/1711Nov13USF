package com.revature.searchers;

import java.util.HashMap;

public class UsingSearchers {

	public static void main(String[] args) {
	
		useBinarySearcher();
		
		
	}
	
	static void useBinarySearcher() {

		HashMap<String, int[]> userInput;
		BinarySearcher binarySearcher = new BinarySearcher();
		
		try {
			userInput = binarySearcher.binarySearchSetup();
			binarySearcher.binarySearch.search(userInput);
		}
		
		catch (NumberFormatException nfe) {
			System.out.println("You have entered an invalid value. PLease try again...");
			useBinarySearcher();
		}
	}
}
