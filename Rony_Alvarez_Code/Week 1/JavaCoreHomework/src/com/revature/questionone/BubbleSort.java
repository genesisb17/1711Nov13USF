package com.revature.questionone;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		// Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
		
		
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}

	// BUBBLE SORT
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

}
