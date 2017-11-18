package com.revature.homework;

public class BubbleSort {
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("Input Array: " + bs.arrayAsString(arr));
		
		bs.bubbleSort(arr);
		
		System.out.println("Bubblesorted Array: " + bs.arrayAsString(arr));
	}
	
	void bubbleSort(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					// Swap arr[j] and arr[j+1] using bitwise XOR
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
				}
			}
		}
		return;
	}
	
	String arrayAsString(int[] arr) {
		String str = "[";
		if (arr.length > 0)
			str += " " + arr[0];
		for (int i=1; i<arr.length; i++) {
			str += ", " + arr[i];
		}
		str += " ]";
		return str;
	}
}
