package com.revature.Array;

import java.util.Scanner;

public class ArrayPractice {

	public static void main(String[] args) {
		/*
		 * array= area of memory on heap with
		 * space for a des number of elements
		 * var args are variable argumens
		 */
		
		System.out.println("Enter numbers to add separated by space ");
		Scanner scan = new Scanner(System.in);
		String nums = scan.nextLine();
		String[] numStrings = nums.split(" ");
		int[] numArr = new int[numStrings.length];
		
		for(int i=0; i<numStrings.length;i++){
			//trim gets rid of white space
			numStrings[i] = numStrings[i].trim();
			numArr[i] = Integer.parseInt(numStrings[i]);
		}
		
		System.out.println(sum(numArr));
		
	}
	
	//can have 0 to as many ints as you want. 
	//must be last parameter
	static int sum(int...nums){
		int s = 0;
		for (int i:nums){
			s = s+1;
		}
		return s;
	}

}
