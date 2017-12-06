package com.q6;

import java.util.Scanner;

public class DetermineEven {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x/2 != (x+1)/2) {
			System.out.println("Odd");
		}else {
			System.out.println("Even");
		}
	}
}
	




