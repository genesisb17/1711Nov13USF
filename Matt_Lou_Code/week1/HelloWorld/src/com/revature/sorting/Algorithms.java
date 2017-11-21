package com.revature.sorting;

public class Algorithms {

	public static void main(String[] args) {
		int[] arr = {13, 46, 3, 56, 91, 82, 47, 94, 23, 67, 34, 38};
		//bubbleSort(arr);
		insertionSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		
		System.out.println(binarySearch(arr, 67));
		
	}
	
	public static void bubbleSort(int[] array) {
		int temp = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 1; j < array.length - i; j++) {
				if(array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					
				}
			}
		}
	}

	public static void insertionSort(int[] array) {
		int comp = 0;
		for(int i = 0; i < array.length; i++) {
			comp = array[i];
			int j = i - 1;
			while(j >= 0 && comp < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j+1] = comp;
		}
	}
	public static boolean binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		
		while(high >= low) {
			int mid = (high + low) / 2;
			if(array[mid] == key) {
				return true;
			}
			if(array[mid] > key) {
				high = mid - 1;
			}
			if(array[mid] < key) {
				low = mid + 1;
			}
			
		}
		return false;
	}

}



























