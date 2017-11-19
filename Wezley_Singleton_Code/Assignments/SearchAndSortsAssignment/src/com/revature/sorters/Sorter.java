package com.revature.sorters;

import java.util.Scanner;

public class Sorter {
	
	public int[] sorterSetup() {
		
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
	
	public void printArrayToConsole(int[] arr) {
		
		System.out.print("{");
		
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
