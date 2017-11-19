package com.revature.sorters;

public class UsingSorters {

	public static void main(String[] args) {
		
		BubbleSorter bubbleSorter = new BubbleSorter();
		int[] userInput = bubbleSorter.sorterSetup();
		int[] sortedArray = bubbleSorter.bubbleSort.sorter(userInput);
		bubbleSorter.printArrayToConsole(sortedArray);
		
	}
	
}
