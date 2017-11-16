package day4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaLab {
	// Warmup Exercises:

	public static void main(String[] args) {
//		printPrimes();
//		System.out.println(findMin(10, 10));
//		switchCase(1);
//		switchCase(2);
//		switchCase(3);
	}

	// Write a program to determine if an integer is even without using the modulus
	// operator (%) , and write a jUnit test case
	public static boolean checkEven(int num) {
		if ((num / 2) * 2 == num) {
			return true;
		} else
			return false;
	}

	// Write a program that creates an ArrayList which stores numbers from 1 to 100
	// and prints out all the prime numbers to the console.
	public static void printPrimes() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			a.add(i);
			int check = 1;
			for(int j = 2; j < i; j++) {
		        if(i % j == 0)
		            check = 0;
		    }
		    if(check == 1) {
		    	System.out.println(i);
		    }
		}
	}
	
	// Find the minimum of two numbers using ternary operators.
	public static int findMin(int n1, int n2) {
		int min = (n1 < n2 ? n1 : n2);
		return min;
	}
	
	// Write a program that demonstrates the switch case. Implement the following
	// functionalities in the cases:
	// Case 1: Find the square root of a number using the Math class method.
	// Case 2: Display today’s date.
	// Case 3: Split the following string and store it in a sting array.
	// “I am learning Core Java”
	public static void switchCase(int num) {
		String str = "I am learning Core Java";
		Scanner scan = new Scanner(System.in);
		
		switch(num) {
		case 1:
			System.out.println("Enter a numer to recieve the square root of that number");
			String text = scan.nextLine();
			double enteredVal = Double.parseDouble(text);
			System.out.println(Math.sqrt(enteredVal));
			break;
		case 2:
			LocalDate date = LocalDate.now();
			System.out.println(date);
			break;
		case 3:
			String[] strings = new String[5];
			int count = 0;
			StringTokenizer st = new StringTokenizer(str, " ");
			while(st.hasMoreTokens()) {
				strings[count] = st.nextToken();
				count++;
			}
//			for (int i = 0; i < strings.length; i++) { 
//				System.out.println(strings[i]);
//			}
			break;
		}
	}
	
	// Create a notepad file called Data.txt and enter the following:
	// Mickey35:Arizona
	// Hulk:Hogan:50:Virginia
	// Roger22:California
	// Wonder18:Montana
	// Write a program that would read from the file and print it out to the screen
	// in the following format:
	// Name: Mickey Mouse
	// Age: 35 years
	// State: Arizona State
	public static void readAndPrint() {
		// in progress
	}
}
