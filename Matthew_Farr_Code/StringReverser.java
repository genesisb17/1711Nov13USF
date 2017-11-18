package com.revature.homework;

public class StringReverser {
	
	public static void main(String[] args) {
		
		// String to reverse
		String str = "boobytrap";
		
		System.out.println("Original String: " + str);
		
		StringReverser sr = new StringReverser();
		
		System.out.println("Reversed String: " + sr.reverse(str));
	}
	
	String reverse(String str) {
		char[] arr = str.toCharArray();
		
		for (int i=0; i<arr.length/2; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		return new String(arr);
	}
	
}
