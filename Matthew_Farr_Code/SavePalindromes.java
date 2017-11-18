package com.revature.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class SavePalindromes {
	ArrayList<String> words;
	ArrayList<String> palindromes;
	
	public static void main(String[] args) {
		SavePalindromes sp = new SavePalindromes();
		
		for (String str : sp.words) {
			if (sp.isPalindrome(str))
				sp.palindromes.add(str);
		}
		
		System.out.println("List of words: ");
		System.out.println(sp.words);
		
		System.out.println("\nList of palindromes: ");
		System.out.println(sp.palindromes);
	}
	
	SavePalindromes() {
		String[] arr = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", 
						"refer", "billy", "did"};

		words = new ArrayList<String>(Arrays.asList(arr));
		palindromes = new ArrayList<String>();
	}
	
	
	boolean isPalindrome(String str) {
		int len = str.length();
		for (int i=0; i<len/2; i++) {
			if (str.charAt(i) != str.charAt(len-1-i))
				return false;
		}
		return true;
	}

}
