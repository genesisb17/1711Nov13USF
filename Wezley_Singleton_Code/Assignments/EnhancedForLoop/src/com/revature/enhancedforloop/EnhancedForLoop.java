package com.revature.enhancedforloop;

import java.util.ArrayList;

/*
 *  Write a program to store numbers from 1 to 100 in an array. 
 *  Print out all the even numbers from the array. Use the enhanced 
 *  FOR-loop for printing out the numbers.
 */

public class EnhancedForLoop {

	public static void main(String[] args) {

		ArrayList<Integer> intArrList = generateArrayList();

		ArrayList<Integer> evenArrList = generateEvenArrListFromIntArrList(intArrList);
		
		printEvensFromEvenArrList(evenArrList);


	}

	public static ArrayList<Integer> generateArrayList() {

		ArrayList<Integer> intArrList = new ArrayList<>();

		// using standard for-loop to generate 'intArrList', containing values 1 - 100.
		for (int i = 1; i <= 100; i++) {
			intArrList.add(i);
		}

		return intArrList;

	}

	public static ArrayList<Integer> generateEvenArrListFromIntArrList(ArrayList<Integer> intArrList) {

		ArrayList<Integer> evenArrList = new ArrayList<>();

		/*
		 *  using an enhanced for loop to iterate through 'intArrList' to generate the 'evenArrList',
		 *  containing all even values 1 - 100.
		 */
		for(int element : intArrList) {

			if(isEven(element)) {
				evenArrList.add(element);
			}

		}

		return evenArrList;
	}

	public static boolean isEven(int input) {

		boolean isEven;

		// the ternary operator can be used to replace simple if-statements; makes code more concise/readable
		isEven = ((input / 2) * 2 == input) ? true : false;

		return isEven;
	}
	
	public static void printEvensFromEvenArrList(ArrayList<Integer> evenArrList) {
		
		// using enhanced for-loop to iterate through the 'evenArrList' to print the elements to the console
		for(int element : evenArrList) {
			System.out.println(element);
		}
	}

}
