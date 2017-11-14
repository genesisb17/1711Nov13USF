package day2demo;

import java.util.Scanner;

public class UnderstandingArrays {

	/*
	 *  An array is an area of memory on the heap with space
	 *  for a designated number of elements.
	 *  
	 *  Var args are variable arguments
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Enter numbers to add, separated by a space: ");
		
		// creates a Scanner object and then waits for user input to be loaded into 'nums'
		Scanner scan = new Scanner(System.in);
		String nums = scan.nextLine();
		
		// splices the users input into an array of Strings, using the space as a separator
		String[] numStrings = nums.split(" ");
		
		// creates an array of integers, with the same length of the 'numStrings' array
		int[] numArr = new int[numStrings.length];
		
		// for every index in 
		for(int i = 0; i < numStrings.length; i++) {
			
			// removes excess whitespace on the beginning and end of the given String (not in the middle)
			//numStrings[i] = numStrings[i].trim();
			
			numArr[i] = Integer.parseInt(numStrings[i]);
		}
		
		System.out.println(sum(numArr));
	}
	
	/*
	 *  using '...' indicates that you are passing in zero or more variable arguments
	 */
	
	static int sum(int... nums) {
		
		//int n = nums[0];	//BAD; can lead to an exception if nothing exists at the first index
		int s = 0;
		
		for(int i : nums) {
			s += i;
		}
		
		return s;
	}
}
