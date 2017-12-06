package com.q8;

import java.util.ArrayList;
import java.util.Arrays;

public class IsPalindrome {
	
	public static void main(String[] args) {
		
	
		String[] init = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"};
		ArrayList<String> words = new ArrayList<String>(Arrays.asList(init));
		ArrayList<String> palindromes = new ArrayList<String>();
		
		for(String s : words) {
			int len = s.length() - 1;
			int i = 0;
			boolean isPal = true;
			while(i<len) {
				if ( s.charAt(i++) != s.charAt(len--) ){
					isPal = false;
					break;
				}
			}
			if(isPal) {
					palindromes.add(s);
			}
			
		}
	
		System.out.println(palindromes);
	}	
 
}
