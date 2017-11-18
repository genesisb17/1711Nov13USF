package com.revature.bubblesort;

import java.util.Scanner;

/*
 *  This works, but if there are two values in the array with the same value the second
 *  value does not get sorted properly. (FIX THIS)
 * 
 */

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] userInput = bubbleSortSetup();
		
		// Print the unsorted array to screen
		System.out.print("Your unsorted array: {");
		printArrayToConsole(userInput);
		
		int[] sortedResult = bubbleSorter(userInput);
		
		// Print the sorted array to screen
		System.out.print("Your sorted array: {");
		printArrayToConsole(sortedResult);
		
	}
	
	static int[] bubbleSortSetup() {
		
		System.out.println("Please enter a list of integers, separated by a space.");
		
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		String[] userArr = userInput.split(" ");
		int[] intArr = new int[userArr.length];
		
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(userArr[i]);
		}
		
		scan.close();
		
		return intArr;
	}
	
	static int[] bubbleSorter(int[] userInput) {
		
		int length = userInput.length;
		int temp = 0;
		
		for(int i = 0; i < length; i ++) {
			
			for(int j = 1; j < length; j++) {
				
				if(userInput[j-1] > userInput[j]) {
					
					temp = userInput[j-1];
					userInput[j-1] = userInput[j];
					userInput[j] = temp;
				}
				
				else if(userInput[j-1] == userInput[j]) {
					
				}
			}
		}
		
		int[] sortedUserInput = userInput;
		
		return sortedUserInput;
	}
	
	static void printArrayToConsole(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {

			if(i != (arr.length - 1)) {
				System.out.print(arr[i] + ", ");
			}

			else {
				System.out.println(arr[i] + "}");
			}

		}
	}
}
