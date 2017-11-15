package com.revature.hello;

import java.util.Arrays;

public class Sorting {
	
	public static int binarySearch(int[] vals, int target) {
		return binarySearch(vals, target, 0, vals.length - 1);
	}
	
	public static int binarySearch(int[] vals, int target, int start, int end) {
		if(end >= 1) {
			int mid = (start + end) / 2;
			if(vals[mid] == target) return mid;
			if(vals[mid] > target) return binarySearch(vals, target, start, mid - 1);
			return binarySearch(vals, target, mid + 1, end);
		}
		return -1;
	}
	
	public static int depthFirstSearch(int[] vals, int target) {
		return -1;
	}
	
	public static int breathFirstSearch(int[] vals, int target) {
		
		return -1;
	}
	
	public static int[] bubbleSort(int[] vals) {
		for(int i = 0; i < vals.length - 1; i++) {
			for(int j = 0; j < vals.length - 1; j++) {
				if(vals[j] > vals[j+1]) {
					int temp = vals[j+1];
					vals[j+1] = vals[j];
					vals[j] = temp;
				}
			}
		}
		return vals;
	}
	
	public static int[] insertionSort(int[] vals) {
		for(int i = 0; i < vals.length; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = i;
			for(int j = i; j < vals.length; j++) {
				if(vals[j] < min) {
					min = vals[j];
					minIndex = j;
				}
			}
			int temp = vals[i];
			vals[i] = vals[minIndex];
			vals[minIndex] = temp;
		}
		return vals;
	}
	
	public static void main(String[] args) {
		
		int[] x = {2, 432, 435,1243, 3245, 123, 213, 5};
		System.out.println(Arrays.toString(Sorting.insertionSort(x)));
		System.out.println(Sorting.binarySearch(x, 3245));
	}
	
}
