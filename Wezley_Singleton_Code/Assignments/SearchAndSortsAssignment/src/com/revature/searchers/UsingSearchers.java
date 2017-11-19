package com.revature.searchers;

import java.util.HashMap;

public class UsingSearchers {

	public static void main(String[] args) {
	
		BinarySearcher binarySearcher = new BinarySearcher();
		HashMap<String, int[]> userInput = binarySearcher.binarySearchSetup();
		binarySearcher.binarySearch.search(userInput);
		
	}
}
