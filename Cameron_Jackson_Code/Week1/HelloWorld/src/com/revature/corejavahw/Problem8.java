package com.revature.corejavahw;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem8 {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>(
				Arrays.asList("karan", "madam", "tom", 
						"civic", "radar", "sexes", 
						"jimmy", "kayak", "john",
						"refer", "billy", "did"));
		ArrayList<String> palindromes = new ArrayList<String>();
		for (String w: words) {
			palindromes.add(reverseString(w));
		}
		
		for (String w: palindromes) {
			System.out.println(w);
		}
	}
	
	public static String reverseString(String str) {
		int i = 0, j = str.length() - 1;
		char[] ch_arr = str.toCharArray();
		char temp;
		while (j > 0) {
			if (i != j) {
				temp = ch_arr[i];
				ch_arr[i] = ch_arr[j];
				ch_arr[j] = temp;
				++i;
				--j;
			}
		}
		return new String(ch_arr);
	}
}
