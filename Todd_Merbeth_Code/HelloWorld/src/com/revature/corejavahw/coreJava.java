package com.revature.corejavahw;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class coreJava {
	public static void main(String[] args) {
		// fibonacci();
		// System.out.println(subString("does it work", 2));
		palinStore();
	}

	// Write a program to display the first 25 Fibonacci numbers beginning at 0.
	static void fibonacci() {
		int num1 = 0;
		int num2 = 1;
		System.out.print(num1 + ", " + num2);
		for (int i = 2; i < 25; i++) {
			System.out.print(", " + (num1 + num2));
			int temp = num2;
			num2 = num1 + num2;
			num1 = temp;
		}
	}

	// Write a substring method that accepts a string str and an integer idx and
	// returns the substring contained between 0 and idx-1 inclusive.Do NOT use any
	// of the existing substring methods in the String, StringBuilder, or
	// StringBuffer APIs
	static String subString(String str, int idx) {
		if (idx > str.length() || idx < 0) {
			return "invalid idx";
		}
		char[] chars = new char[idx];
		for (int i = 0; i < idx; i++) {
			chars[i] = str.charAt(i);
		}
		String result = new String(chars);
		return result;
	}

	// Sort two employees based on their name, department,and age using the
	// Comparator
	// interface

	// Write a program that stores the following strings in an ArrayList and saves
	// all the palindromes in another ArrayList
	// "karan", "madam","tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",
	// "refer", "billy", "did"
	
	static void palinStore() {
		String[] nameArray = {"karan", "madam", "tom", "civic", "radar", 
				"sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList names = new ArrayList();
		ArrayList pals = new ArrayList();
		for (int i = 0; i < nameArray.length; i++) {
			names.add(i, nameArray[i]);
			if (isPalindrome(nameArray[i])) {
				pals.add(nameArray[i]);
			}
		}
		System.out.println(pals);
	}
	static boolean isPalindrome(String str) {
		int i = str.length()/2 - 1;
		int j = str.length()/2;
		if(str.length() % 2 == 1) {
			j = str.length()/2 + 1;
		}
		while (i > -1) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			j++;
			i--;
		}
		return true;
	}

}
