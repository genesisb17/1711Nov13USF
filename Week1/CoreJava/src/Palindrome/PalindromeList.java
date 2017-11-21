package Palindrome;

import java.util.ArrayList;

public class PalindromeList {

	public static void main(String[] args) {
		/*
		 * This method will go through an array list, run a function
		 * that determines which names are a palindrome, and add them
		 * to a separate array list
		 */
		
		String[] nameList = {"karan", "madam", "tom","civic","radar","sexes","jimmy",
				"kayak","john","refer","billy","did"};
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		for(int x=0; x< nameList.length; x++)
			names.add(nameList[x]);

		System.out.println(names);
		palindrome(nameList,palindromes);
		System.out.println("The names that are palindromes in the list of names listed above are: " + palindromes);
		
	}
	static String reverseIt(String input) {
		/*implementation of reverse string function without
		 * using the function itself, but rather hard-coding it
		 */
		int size = input.length();
		int x= 0; // counter to index placement of letters reversed into new char array
		char[] newName = new char[size];
		char[] firstName = input.toCharArray();
		for(int i=size-1; i>=0;i--) {
				newName[x] = firstName[i];
				x++;
		}
		String finalName = new String(newName); //cast char array to a string
		return finalName;

	}
	static void palindrome(String[] names, ArrayList<String> output) {
			for(int x=0; x<names.length; x++) {
				String test = names[x];
				String test2 = reverseIt(test);
				if(test.equals(test2))
					output.add(test);
			}
				
			
			
			
		}
	}