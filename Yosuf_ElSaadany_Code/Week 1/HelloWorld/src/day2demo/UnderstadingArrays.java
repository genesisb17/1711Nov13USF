package day2demo;

import java.util.Arrays;
import java.util.Scanner;

public class UnderstadingArrays {
	
	public static void main(String[] args) {
	
		/*int a = sum();
		int b = sum(1, 5, 7, 8, 135, 2463, 4);
		int c = sum(5, 2);*/
		
		// Read numbers separated by space
		System.out.println("Enter numbers to add separated by space:");
		Scanner scan = new Scanner(System.in);
		String nums = scan.nextLine();
		
		// Convert string to array of strings
		String[] numStrings = nums.split(" ");
		
		// Create array of int with same size of the array of strings
		int[] numArr = new int[numStrings.length];
		
		// Parse the array of strings to an array of int
		for(int i = 0; i < numStrings.length; i++) {
			//numStrings[i] = numStrings[i].trim();
			numArr[i] = Integer.parseInt(numStrings[i]);
		}
		// Call function and print sum
		System.out.println(sum(numArr));
		
	}
	// Variable arguments
	static int sum(int... nums) {
		//int n = nums[0]; BAD, can lead to an exception
		int s = 0;
		for(int i:nums)
			s = s + i;
		
		return s;
	}
	
	public void c (int x, char c) {
		
		System.out.println(x);
	}

}