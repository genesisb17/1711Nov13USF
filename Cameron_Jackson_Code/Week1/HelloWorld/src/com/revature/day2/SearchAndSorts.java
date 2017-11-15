package com.revature.day2;

import java.util.Scanner;

public class SearchAndSorts {
	
	/*
	 * Parse input string into array of integers
	 */
	public static int[] StrToIntArr(String strarr) {
		String[] vals = strarr.split(" ");
		int[] nums = new int[vals.length];
		for (int i = 0; i < vals.length; ++i) {
			nums[i] = Integer.parseInt(vals[i]);
		}
		return nums;
	}

	/*
	 * Binary Search
	 * Breadth First Search
	 * Depth First Search
	 * Bubble Sort
	 * Merge Sort
	 * Insertion Sort
	 */
	public static void main(String[] args) {
		int[] nums;
		
		// Get array of numbers
		System.out.println("Input number separated by space: ");
		Scanner scan = new Scanner(System.in);
		nums = StrToIntArr(scan.nextLine());
		
		// BUBBLE SORT
//		System.out.println("**Bubble Sort**");
//		System.out.println("Unsorted array: ");
//		for (int x: nums) {
//			System.out.printf("%d ", x);
//		}
//		System.out.printf("\n");
//		System.out.println("Sorted array: ");
//		int[] numssorted = BubbleSort(nums);
//		for (int x: numssorted) {
//			System.out.printf("%d ", x);
//		}
//		System.out.printf("\n");
		// END BUBBLE SORT
		
		// MERGE SORT
		System.out.println("**Merge Sort**");
		System.out.println("Unsorted array: ");
		for (int x: nums) {
			System.out.printf("%d ", x);
		}
		System.out.printf("\n");
		System.out.println("Sorted array: ");
		int[] numssorted = MergeSort(nums, 0, nums.length-1);
		for (int x: nums) {
			System.out.printf("%d ", x);
		}
		System.out.printf("\n");		
		// END MERGE SORT
		
		// INSERTION SORT
//		System.out.println("**Insertion Sort**");
//		System.out.println("Unsorted array: ");
//		for (int x: nums) {
//			System.out.printf("%d ", x);
//		}
//		System.out.printf("\n");
//		System.out.println("Sorted array: ");
//		int[] numssorted = InsertionSort(nums);
//		for (int x: numssorted) {
//			System.out.printf("%d ", x);
//		}
//		System.out.printf("\n");
		// END INSERTION SORT
		
		// BINARY SEARCH
		System.out.println("**Binary Search**");
		System.out.println(BinarySearch(numssorted));
		// END BINARY SEARCH
		
		scan.close();
	}
	
	/*
	 * BinarySearch()
	 * Function takes array of numbers
	 * prompts for value to find
	 * returns the index of that value
	 * return -1 if not found
	 */
	static int BinarySearch(int[] nums) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter value to search:");
		int find = scan.nextInt();
		scan.close();
		
		int begin = 0;
		int end = nums.length-1;
		int index;
		while (begin <= end) {
			if (((end + begin)%2) != 0) { // odd
				index = ((end + begin) - 1)/2;
			} else { // even
				index = (end + begin)/2;
			}
			if (nums[index] > find) { // on left side
				end = index - 1;
			} else if (nums[index] < find) { // on right side
				begin = index + 1;
			} else {
				return index;
			}
		}
		return 0;
	}
	
	/*
	 * BubbleSort()
	 * Takes array of unsorted numbers
	 * applies bubble sort and returns sorted array
	 * Passes through array and swaps values that are out of order
	 * makes passes until there are no more swaps to make
	 */
	static int[] BubbleSort(int[] nums) {
		boolean swapped; // this gets set to true if a swap was made this pass
		int[] sortedarr = nums;
		do {
			swapped = false;
			for (int i = 0; i < sortedarr.length-1; ++i) { // loop through the array
				if (sortedarr[i] > sortedarr[i+1]) { // out of order, swap
					int temp = sortedarr[i];
					sortedarr[i] = sortedarr[i+1];
					sortedarr[i+1] = temp;
					swapped = true;
				}
			}
		} while (swapped == true);
		return sortedarr;
	}
	
	/*
	 * MergeSort()
	 * Recursively Splits list into multiple sublists and repeatedly merges them until
	 * sorted
	 * Depends on Merge() function as helper
	 */
	static int[] MergeSort(int[] arr, int beg, int end) {
		int[] larr, rarr;
		if (arr.length > 1) {
			int mid = (beg + end)/2;
			larr = new int[mid - beg + 1];
			
			// copy data from first half of array into larr
			for (int i = 0; i < larr.length; ++i) {
				larr[i] = arr[i];
			}
			rarr = new int[end - mid];
			// copy data from second half of array into rarr
			for (int j = mid+1; j < rarr.length; ++j) {
				rarr[j] = arr[j];
			}
			MergeSort(larr, beg, mid); // sort first half
			MergeSort(rarr, mid+1, end); // sort second half
			
			return Merge(larr, rarr, beg, mid, end); // merge halves
		} else {
			return arr;
		}
	}
	
	/*
	 * Merge()
	 * Merges two halves of array in sorted order
	 * TODO: REPLACE TEMP ARRAYS WITH LARR AND RARR. CREATE NEW ARRAY AND MERGE
	 * LARR AND RARR INTO NEW ARRAY THEN RETURN
	 */
	static int[] Merge(int[] larr, int[] rarr, int beg, int mid, int end) {
		// Get lengths of both halves of arrays
		int len1 = larr.length;
		int len2 = rarr.length;
		
		int[] arr = new int[len1+len2];
		
		// merge the arrays
		int x = 0; // index of first half
		int y = 0; // index of second half
		int z = 0; // merged main array index
		while ((x < len1) && (y < len2)) {
			if (larr[x] <= rarr[y]) {
				arr[z] = larr[x];
				++x;
			} else {
				arr[z] = rarr[y];
				++y;
			}
			++z;
		}
		
		// there will be leftover values in one of the arrays
		while (x < len1) {
			arr[z] = larr[x];
			++x;
			++z;
		}
		while (y < len2) {
			arr[z] = rarr[y];
			++y;
			++z;
		}
		
		return arr;
	}
		
	/* 
	 * InsertionSort()
	 * start at second value of array and moves forward.
	 * current value compared to previous value
	 * if current is greater than previous move forward
	 * if current less than previous, insert current into correct position:
	 * -- work backwards from this position while swapping until the current value is
	 * -- in sorted position
	 */
	static int[] InsertionSort(int[] nums) {
		int[] sortedarr = nums;
		int len = sortedarr.length;
		int j;
		for (int i = 1; i < len; ++i) { // loop through array starting at 2nd value
			j = i; // j is used to work backwards for insertion
			while ((j > 0) && (sortedarr[j-1] > sortedarr[j])) { // if not at beginning and current and previous values are unsorted
				int temp = sortedarr[j-1];
				sortedarr[j-1] = sortedarr[j];
				sortedarr[j] = temp;
				--j; 
			}
		}
		return sortedarr;
	}

}
