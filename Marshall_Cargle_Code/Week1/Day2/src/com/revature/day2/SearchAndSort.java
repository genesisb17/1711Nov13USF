package com.revature.day2;

import java.util.Arrays;

public class SearchAndSort {

	public static void main(String[] args) {
		/*
		 * IMplement the following -binary search -breadth first search -depth first
		 * search -bubble sort -merge sort -insertion sort
		 */
		int searchArray[] = { 3, 4, 5, 6, 7 };
		int sortArray[] = { 5, 6, 4, 3, 8, 2 };
		binarySearch(8, searchArray);
		bubbleSort(sortArray);
		insertionSort(sortArray);
	}

	static void binarySearch(int search, int... nums) {
		{
			int startingPoint = 0;
			int endingPoint = nums.length - 1;
			while (startingPoint <= endingPoint) {
				int middlePoint = startingPoint + (endingPoint - startingPoint) / 2;
				if (nums[middlePoint] == search) {
					System.out.println("Does exist");
					return;
				}
				if (nums[middlePoint] < search)
					startingPoint = middlePoint + 1;
				else
					endingPoint = middlePoint - 1;
			}
			System.out.println("Does not exist");
		}
	}

	static void bubbleSort(int... nums) {
		int extra = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					extra = nums[j];
					nums[j] = nums[i];
					nums[i] = extra;
				}
			}
		}

	}

	static void insertionSort(int... nums) {
		int extra = 0;
		for (int i = 1; i < nums.length; i++) {
			extra = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > extra) {
				nums[j + 1] = nums[j];
				j = j - 1;
			}
			nums[j + 1] = extra;
		}
		System.out.println(Arrays.toString(nums));
	}
}
