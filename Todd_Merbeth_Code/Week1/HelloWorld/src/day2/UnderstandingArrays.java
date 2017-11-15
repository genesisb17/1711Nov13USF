package day2;

import java.util.Arrays;
import java.util.Scanner;

public class UnderstandingArrays {

	public static void main(String[] args) {
		System.out.println("Enter numbers to add separated by space;");
		Scanner scan = new Scanner(System.in);
		String nums = scan.nextLine();
		String[] numStrings = nums.split(" ");
		int[] numArr = new int [numStrings.length];
		for (int i = 0; i < numStrings.length; i++) {
			numStrings[i] = numStrings[i].trim(); // trim only works on front and back
			numArr[i] = Integer.parseInt(numStrings[i]);
			
		}
		System.out.println(sum(numArr));
	}
	static int sum(int... nums) {
		//int n = nums[0]; // BAD; can lead to exception
		int s = 0;
		for(int i:nums) {
			s=s + i;
		}
		return s;
	}

}
