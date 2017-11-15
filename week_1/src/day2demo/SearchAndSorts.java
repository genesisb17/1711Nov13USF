package day2demo;

import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSorts {

	/*
	 * Implement the following:
	 * 		- binary search			//done
	 * 		- breadth first search
	 * 		- depth first search
	 * 		- bubble sort
	 * 		- merge sort
	 * 		- insertion sort 
	 * 
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Please enter a list of integers, separated by a space.");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		String[] userArr = userInput.split(" ");
		int[] intArr = new int[userArr.length];
		
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(userArr[i]);
		}
		
		binarySearch(13, intArr);
		scan.close();
	}
	
	static void binarySearch(int value, int... intArr) {
		
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
			if (intArr[midpoint] == value) {
				System.out.println("\nThe element within the array, with a value of " + value
						+ " is located at index position " + midpoint + ".");
				
				// causes the while loop to discontinue
				p = 0; 
				r = -1;
			}
			
			/*
			 *  if the value of the midpoint index position is less than the sought value, shift the last 
			 *  element to the index position before the current midpoint index position.
			 */
			else if (intArr[midpoint] > value) {
				r = midpoint - 1;
			}
			
			/*
			 *  if the value of the midpoint index position is greater than the sought value, shift the first 
			 *  element to the index position after the current midpoint index position.
			 */
			else if (intArr[midpoint] < value) {
				p = midpoint + 1;
			}
		}
		
	}
}
