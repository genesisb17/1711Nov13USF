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
		scan.close();
		
		// BUBBLE SORT
		System.out.println("Bubble Sort");
		System.out.println("Unsorted array: ");
		for (int x: nums) {
			System.out.printf("%d ", x);
		}
		System.out.printf("\n");
		System.out.println("Sorted array: ");
		int[] numssorted = BubbleSort(nums);
		for (int x: numssorted) {
			System.out.printf("%d ", x);
		}
		System.out.printf("\n");
		// END BUBBLE SORT
		
		System.out.println("Binary Search: ");
		System.out.println(BinarySearch(nums));
	}
	
	/*
	 * BinarySearch()
	 * Function takes array of numbers
	 * prompts for value to find
	 * returns the index of that value
	 * return -1 if not found
	 */
	static int BinarySearch(int[] nums) {
		System.out.println("Enter value to search:");
		Scanner scan = new Scanner(System.in);
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
	
	static int[] MergeSort(int[] nums) {
		int[] sortedarr = nums;
		
		return sortedarr;
	}

}
