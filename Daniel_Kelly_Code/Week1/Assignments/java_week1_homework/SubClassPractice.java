package com.revature.homework;

import java.math.BigInteger;

public class SubClassPractice extends SuperClassPractice{
	
	public boolean uppercaseCheck(String s) {
		for (int i = 0; i <= s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isUpperCase(c) == true) {
				return true;
			}
		}
		return false;
	}

	public String lowercaseReturn(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLowerCase(c) == true) {
				Character.toUpperCase(c);
			}
		}
		return s;
	}

	public void convertToInt(String s) {
		int i = Integer.parseInt(s);
		System.out.println(s + 10);
	}

}
