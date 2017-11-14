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
		int[] numArr = new int[userArr.length];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(userArr[i]);
		}
		
		binarySearch(13, numArr);
	}
	
	static void binarySearch(int value, int... nums) {
	
		// sorts the given array and prints it to the console
		Arrays.sort(nums);
		System.out.print("\nThe sorted array of integers given: ");
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			System.out.print(" ");
		}
		
		// determines the midpoint index position of the given array
		int midpoint = nums.length / 2;
		
		// conditionals to determine the location of the desired value
		if (nums[midpoint] == value) {
			System.out.println("\nResult: " + value);
		}
		
		else if (nums[midpoint] > value) {
			
			int[] x = Arrays.copyOfRange(nums, 0, midpoint);
			binarySearch(value, x);
			
		}
		
		else if (nums[midpoint] < value) {
			
			int[] y = Arrays.copyOfRange(nums, (midpoint), (nums.length - 1));
			binarySearch(value, y);
		
		}
		
		else {
			System.out.println("The value is not present within the given array.");
		}
		
	}
}
