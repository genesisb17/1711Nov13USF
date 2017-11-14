package day2demo;

import java.util.Arrays;
import java.util.Scanner;

public class UnderstadingArrays {
	
	public static void main(String[] args) {
	
		/*int a = sum();
		int b = sum(1, 5, 7, 8, 135, 2463, 4);
		int c = sum(5, 2);*/
		
		System.out.println("Enter numbers to add separated by space:");
		
		Scanner scan = new Scanner(System.in);
		
		String nums = scan.nextLine();
		
		String[] numStrings = nums.split(" ");
		//Arrays.stream(numStrings).map(Integer.parseInt());
		
		int[] numArr = new int[numStrings.length];
		
		for(int i = 0; i < numStrings.length; i++) {
			//numStrings[i] = numStrings[i].trim();
			numArr[i] = Integer.parseInt(numStrings[i]);
		}
		System.out.println(sum(numArr));
	
	}
	// Variable arguments
	static int sum(int... nums) {
		//int n = nums[0]; BAD, can lead to an exception
		int s = 0;
		for(int i:nums) {
	
			s = s + i;
		
		}
		return s;
	}

}