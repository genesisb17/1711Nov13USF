package com.q9;

import java.util.ArrayList;

public class PrintPrimes {
	
	public static void main(String[] args) {
		
	
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 2 ; i <= 100 ; i++) {
			arr.add(i);
		}
		
		for(int a : arr) {
			int i = 2;
			boolean isPrime = true;
			while (i <= a/2) {
				if (a%i++ == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				ans.add(a);
			}
		}
		
		System.out.println(ans);		
	}

}
