package com.rev.soap;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		//System.out.print(revString("hello"));
		//System.out.println(factorial(6));
//		System.out.println(isEven(5));
//		int[] array = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8};
//		for(int i = 0; i < array.length; i ++) {
//			System.out.print(bubbleSort(array)[i] + " ");
//		}

		
		
		
		
	}
	
	public static ArrayList<Integer> fibonacci(int num) {
		int n1 = 0, n2 = 1;
		ArrayList <Integer> arr = new ArrayList();
		for(int i = 2; i < num; i ++) {
			arr.add(0, n1);
			arr.add(1 ,n2);
			arr.add(i ,arr.get(i - 2) + arr.get(i - 1));
		}
		return arr;
	}
	
	public static int [] bubbleSort(int[] array) {
		for(int i = 0; i < array.length - 1; i ++) {
			for(int j = 0; j < i - array.length - 1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		return array;
	}
	
	public static String revString(String str) {
		String temp = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			temp = temp + str.charAt(i);
		}
		return temp;
	}
	
	public static int factorial(int num) {
		if(num == 1) {
			return 1;
		} 
		else {
			return num * factorial(num - 1);
		}
	}
	
	public static Boolean isEven(int num) {
		if((double)(num / 2) == Math.ceil(num / 2)){
			return false;
		}
		else {
			return true;
		}
	}
	
	

}
