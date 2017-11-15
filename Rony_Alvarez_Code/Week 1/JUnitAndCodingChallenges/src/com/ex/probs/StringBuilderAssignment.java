package com.ex.probs;

import java.util.StringTokenizer;

public class StringBuilderAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder str = new StringBuilder("abcdefgh");
		
		System.out.println(str.reverse());
		System.out.println(str.charAt(3));
		System.out.println(str.append('c'));
		
		
		StringTokenizer tokenizer =  new StringTokenizer("This is my String", "");
		while(tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
		
		
		
		
	}

}
