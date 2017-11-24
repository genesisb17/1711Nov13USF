package com.revature.homework;

import java.util.Scanner;

public class CalculateInterest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the principal: ");
		int principal = scan.nextInt();
		
		
		System.out.println("Enter the rate of interest: ");
		int rate = scan.nextInt();
		
		System.out.println("Enter the number of years: ");
		int time = scan.nextInt();
		
		double interest = principal*rate*time;
		System.out.println(interest);
	}

}
