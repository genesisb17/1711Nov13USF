package com.revature.sorters;


public class BubbleSorter extends Sorter{

	// using a lambda expression to override the sorter() method from the Sortable interface
	Sortable bubbleSort = (int[] userInput) -> {
		int length = userInput.length;
		int temp = 0;
		
		for(int i = 0; i < length; i ++) {
			
			for(int j = 1; j < length; j++) {
				
				if(userInput[j-1] > userInput[j]) {
					
					temp = userInput[j-1];
					userInput[j-1] = userInput[j];
					userInput[j] = temp;
				}
				
				else if(userInput[j-1] == userInput[j]) {
					
				}
			}
		}
		
		int[] sortedUserInput = userInput;
		
		return sortedUserInput;
	};
}
