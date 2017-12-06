package com.revature.Andy;

import java.util.Arrays;
import java.util.Scanner;

public class UnderstandArrays {
	
	public static void main(String[] args) {
		System.out.println("Enter numbers by to add by using spaces:");
		Scanner scan = new Scanner(System.in);
		String nums = scan.nextLine();
		String[] numStrings = nums.split(" ");
		int[] numArr = new int[numStrings.length];
		for(int i = 0; i< numStrings.length; i++) {
			numArr[i] = Integer.parseInt(numStrings[i]);
		}	
		
		System.out.println(sum(numArr));
	}
	
	
	
	public static int sum(int... nums) {
		//int n = nums[0];
		int s = 0;
		for (int i:nums) {
			s = s + 1;
		}
		return s;
	
	}public static int sum(int x, int... nums) {
		int s = 0;
		for (int i:nums) {
			s = s + 1;
		}
		return s;
	}

}
