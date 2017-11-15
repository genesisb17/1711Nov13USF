package com.revature.hello;
/* 
 * Search and sort assignment. 
 * Felix Abreu & Isai Alegria
 * Binary Search, Bubble and Insertion Sort
 */
public class SearchAndSorts {

	public static void main(String[] args) {
		int[] binarySearch = {1,2,3,4,5,6,7,8,9,10};
		int key = 8;
		int keyIndex = binarySearch(binarySearch, key);
		System.out.println("The index of where " + key + " is located is " + keyIndex);
		int[] bubbleSorter = {3,7,9,4,6,5,2,1};
		printArray(bubbleSorter);
		bubbleSort(bubbleSorter);
		printArray(bubbleSorter);
		int[] insertSorter = {3,7,9,4,6,5,2,1,6};
		printArray(insertSorter);
		insertionSort(insertSorter);
		printArray(insertSorter);
	}
	
	static void insertionSort(int[] inputArray) {
		/* the insertion sort algorithm is another way of sorting an unsorted array
		 * in comparison to the bubble sort algorithm, it is also better to use with
		 * small data sets. It is ideal to use when most data is sorted and only a few 
		 * elements need to be sorted. Worst case scenario for the algorithm would 
		 * be if data set is in reverse order, highest to lowest value.
		 */
		int size = inputArray.length;
		for(int i=1; i<size; ++i) {
			/*we start the sorting with the second element because the key
			 * were using to sort the elements is the first element in the array.
			 */
			int key = inputArray[i];
			int j = i-1; 
			while (j>=0 && inputArray[j] > key) {
				inputArray[j+1]= inputArray[j];
				j--;
			}
			inputArray[j+1]= key;
		}
	}
	
	
	
	static void bubbleSort(int[] inputArray) {
		/* the bubble sort method basically checks the first two elements
		 * compares them to each other, and sorts them accordingly, 
		 * placing the one with lower value to the left and higher
		 * value to the right
		 * 
		 */
		int size = inputArray.length;
		for(int x = 0; x< size-1; x++)
			for(int y = 0; y< size - x - 1; y++) {
				if(inputArray[y] > inputArray[y + 1]) {
					int temp = inputArray[y];
					inputArray[y] = inputArray[y+1];
					inputArray[y+1]= temp;
				}
			}
	}
	static void printArray(int[] inputArray) {
		
		/*This method will print the values inside an array
		 * 
		 */
		int size = inputArray.length;
		for(int x =0; x<size; x++) {
			System.out.print(inputArray[x] + " ");
		}
		System.out.println();
	}
	
	
	static int binarySearch(int[] inputArray, int key) {
		/*
		 * the binary search, referred to as divide and conquer, searches for
		 * the index of a key in a given array by starting its search
		 * by comparing the key with the value of the element in the middle
		 * of the sorted array. If the key is greater, then the search
		 * continues with the right side "subset". if the key is less than,
		 * the search continues with the left side "subset". 
		 */
		
		int begin = 0; // start index
		int end = inputArray.length - 1; // index of last element
		while(begin <= end) {
			int middle = (begin + end)/2; // used to determine where the search begins
			if(key == inputArray[middle]) {
				return middle;
			}
			if(key < inputArray[middle]) {
				end = middle - 1; 
				/*since the key is less, the search will then be 
				 * restricted to the index before the middle and 
				 * the beginning index
				 */
			}
			else {
				begin = middle +1;
			}
		}
		return 0;
	}
}
