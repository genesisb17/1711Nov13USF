package com.revature.searchers;

import java.util.HashMap;
import java.util.Scanner;

public class Searcher {

	public HashMap<String, int[]> binarySearchSetup() {
		
		HashMap<String, int[]> binarySearchSetup = new HashMap<String, int[]>();
		
		System.out.println("Please enter a list of integers, separated by a space:");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		String[] userArr = userInput.split(" ");
		int[] intArr = new int[userArr.length];
		
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(userArr[i]);
		}
		
		System.out.print("\nEnter the that value would you like to find in the collection: ");
		int[] searchValue = new int[1];
		searchValue[0] = scan.nextInt();
		
		binarySearchSetup.put("user_array", intArr);
		binarySearchSetup.put("search_value", searchValue);
		
		scan.close();
		
		return binarySearchSetup;
		
	}
	
}
