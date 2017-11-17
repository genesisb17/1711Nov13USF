package com.revature.day4;

import java.util.ArrayList;

public class ArrayListPractice {
	
//	Write a program that creates an ArrayList
//	which stores numbers from 1 to 100 and prints out all the prime       
//	numbers to the console.

	public static void main(String[] args) {
		
	ArrayList<Integer> nums = new ArrayList<Integer>(100);
	
	for(int i = 0; i<=100;i++){
		nums.add(i);
	}
	
			System.out.println(nums.toString());
		
	}
	
/*	//checks whether an int is prime or not.
	boolean isPrime(ArrayList i) {
	    for(int i=2;2*i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}*/
}