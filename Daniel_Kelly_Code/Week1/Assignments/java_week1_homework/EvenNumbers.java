package com.revature.homework;

import java.util.Arrays;

public class EvenNumbers {

	public static void main(String[] args) {
		
		int[] arr = new int[101];
		
		for(int i = 0; i<arr.length-1;i++) {
			arr[i] = i+1;
		}
		
		for(int n : arr) {
			if(n%2==0) {
				System.out.println(n);
			}
		}
	}

}
