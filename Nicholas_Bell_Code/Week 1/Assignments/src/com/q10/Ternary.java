package com.q10;

import java.util.Scanner;

public class Ternary {
	
	public static void main(String[] args) {
		System.out.println("Enter two numbers seperated by spaces:");
		Scanner scan = new Scanner(System.in);
		int i1 = scan.nextInt();
		int i2 = scan.nextInt();
		
		System.out.println(Ternary(i1, i2));
	}
	
	public static int Ternary(int x, int y) {
		return  (x < y ? x : y);
	}

}
