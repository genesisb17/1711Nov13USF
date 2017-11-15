package com.algorithms;

public class SearchAndSortAlgorithms {

	public static void main(String[] args) {

		// Bubble Sort
		int size = 1000;
		SortUtility su = new SortUtility(size);
		su.fillRandomData();

		System.out.println("Before Bubble Sort: ");
		su.printArray();

		System.out.println("After Bubble Sort: ");
		long time = su.bubbleSort();
		su.printArray();

		System.out.println("\nTime Complexity is " + time + " milliseconds");

	}

}
