package com.revature.hello;

import java.util.Scanner;

public class StringExamples {
	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		String example = scanIn.nextLine();
		String exampleToLower = example.toLowerCase();
		String exampleToUpper = example.toUpperCase();
		String exampleReplace = example.replace("e", "2");
		int exampleLength = example.length();
		String exampleCharAt = "";
		if(exampleLength > 3)
			exampleCharAt = example.charAt(3)+"";
		System.out.println(example);
		System.out.println(exampleToLower);
		System.out.println(exampleToUpper);
		System.out.println(exampleReplace);
		System.out.println(exampleLength);
		System.out.println(exampleCharAt);
	}
}
