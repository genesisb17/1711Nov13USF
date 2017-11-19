package com.revature.searchers;

import java.util.Arrays;
import java.util.HashMap;

public class BinarySearcher extends Searcher {
	
	// lambda expression overriding method in functional interface Searchable
	Searchable binarySearch = (HashMap<String, int[]> userInput) -> {
		
		int[] intArr = userInput.get("user_array");
		int[] searchValue = userInput.get("search_value");
		
		// sort the given array in ascending order, print to confirm
		Arrays.sort(intArr);
		
		System.out.print("\nYour values, sorted in ascending order: {");
		for (int i = 0; i < intArr.length; i++) {
			
			if (i == intArr.length - 1) {
				System.out.print(intArr[i]);
				System.out.print("}\n");
			}
			else {
				System.out.print(intArr[i] + ", ");
			}
			
		}
		
		// represents the first element of the given substring
		int p = 0;
		
		// represents the last element of the given substring
		int r = intArr.length;
		
		// using a while loop we can iterate over the following steps to determine if the value is in the array
		while (p <= r) {
			
			/* 
			 *  establish the midpoint index position of the given substring, using the first and last 
			 *  considered index positions
			 */
			int midpoint = (p + r) / 2;
			
			// if the value of the midpoint index position is equal to the sought value, print success.
			if (intArr[midpoint] == searchValue[0]) {
				System.out.println("\nThe element within the array, with a value of " + searchValue[0]
						+ " is located at index position " + midpoint + ".");
				
				// causes the while loop to discontinue
				p = 0; 
				r = -1;
			}
			
			/*
			 *  if the value of the midpoint index position is less than the sought value, shift the last 
			 *  element to the index position before the current midpoint index position.
			 */
			else if (intArr[midpoint] > searchValue[0]) {
				r = midpoint - 1;
			}
			
			/*
			 *  if the value of the midpoint index position is greater than the sought value, shift the first 
			 *  element to the index position after the current midpoint index position.
			 */
			else if (intArr[midpoint] < searchValue[0]) {
				p = midpoint + 1;
			}
			
			// the value is not present in the given array
			if (p == r) {
				System.out.println("The value, " + searchValue[0] + " is not present in the given array.");
				
				p = 0;
				r = -1;
			}
			
		}
		
		
		
	};
}
