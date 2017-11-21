package ScannerCheck;
import java.util.Scanner;

public class ScannerTester {

	private static Scanner keyboard;

	public static void main(String[] args) {
		/* This program calculates the simple interest on the principal, rate of interest
		 * and number of years based on information provided by the user. 
		 * The Scanner class is used to accept the user input.
		 */
		
		double principal;
		double rate;
		double years;
		double interest;
		keyboard = new Scanner(System.in);
		System.out.println("In order to determine the interest on your prinicipal, you must input "
				+ "the principal, rate of interest, and the number of years in that order");
		principal = keyboard.nextDouble();
		rate = keyboard.nextDouble();
		years = keyboard.nextDouble();
		interest = principal*rate*years;
		System.out.println("Based on the given numbers, your interest will be " + interest);
		
		
	}

}
