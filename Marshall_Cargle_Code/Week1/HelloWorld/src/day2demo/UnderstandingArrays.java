package day2demo;

import java.util.Arrays;
import java.util.Scanner;

public class UnderstandingArrays {
	
	/*
	 * An array is an area of memory on the heap with space 
	 * for a designated number of elements
	 * Var args are variable arguments
	 */
	
	
	
	public static void main(String[] args) {
		System.out.println("Enter numbers to add separated by space:");
		
		Scanner scan = new Scanner(System.in);
		
		String nums = scan.nextLine();
		
		String[] numStrings = nums.split(" ");
		
		int[] numArr = new int[numStrings.length];
		
		for(int i=0;i<numStrings.length;i++){
			//numStrings[i] = numStrings[i].trim();
			numArr[i] = Integer.parseInt(numStrings[i]);
		}
		
		System.out.println(sum(numArr));
	}
	
	
	static int sum(int... nums){
		//int n = nums[0]; // BAD; can lead to an exception
		int s = 0;
		for(int i:nums){
			s = s + i;
		}
		return s;
		
	}
	
}
