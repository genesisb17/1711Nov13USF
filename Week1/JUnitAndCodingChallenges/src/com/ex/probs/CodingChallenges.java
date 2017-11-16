package com.ex.probs;

public class CodingChallenges {

	public int factorial(int n) {
		if (n<0) {
			System.out.println("Can't be negative");
			return 0;
		}
		else if (n == 0)
			return 1;
		else
			return(n * factorial(n-1));
	}
	
	public String reverseIt(String input) {
		/*implementation of reverse string function without
		 * using the function itself, but rather hard-coding it
		 */
		int size = input.length();
		char[] newName = new char[size];
		char[] firstName = input.toCharArray();
		for(int i=size-1; i>=0;i--) 
			for(int j=0; j<size-1; j++) {
				newName[j] = firstName[i];
			}
		String finalName = new String(newName);
		System.out.println(finalName);
		return finalName;
		
		
		
	}
	
}
