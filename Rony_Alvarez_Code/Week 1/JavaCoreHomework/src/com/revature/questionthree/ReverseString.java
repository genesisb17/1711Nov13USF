package com.revature.questionthree;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "TGIF";
		reverseString(str);

	}

	public static void reverseString(String str) {

		String reverseMe = str;
		for (int i = 0; i < reverseMe.length(); i++) {
			reverseMe = reverseMe.substring(1, reverseMe.length() - i) + reverseMe.substring(0, 1)
					+ reverseMe.substring(reverseMe.length() - i, reverseMe.length());
		}
		System.out.println(reverseMe);

	}

}
