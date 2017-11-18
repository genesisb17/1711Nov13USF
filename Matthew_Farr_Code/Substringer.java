package com.revature.homework;

public class Substringer {
	
	public static void main(String[] args) {
		
		Substringer substringer = new Substringer();
		
		// Input and index number
		String str = "Squirreled";
		int idx = 4;
		
		System.out.println("String: " + str);
		System.out.println("Index: " + idx);
		
		if (idx < 0) {
			System.out.println("Index " + idx + " is invalid; index must not be negative.");
			return;
		}
		if (idx >= str.length()) {
			System.out.println("Index " + idx + " and Length " + str.length() + " is invalid;");
			System.out.println("index must be within the bounds of the string.");
			return;
		}
		
		System.out.println("Substring: " + substringer.substring(str, idx));
	}
	
	String substring (String str, int idx) {
		
		char[] arr = new char[idx+1];
		
		for (int i=0; i<arr.length; i++)
			arr[i] = str.charAt(i);
		
		return new String(arr);
	}

}
