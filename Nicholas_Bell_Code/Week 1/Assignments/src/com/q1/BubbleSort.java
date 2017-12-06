package com.q1;

/*
 * Performs a bubble sort on a provided array
 * to where the items are in ascending order
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		
		//The provided array
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		//Perform sort
		bubblesort(arr);
		
		//Print sort
		for (int i : arr) {
			System.out.print(i + " ");
		}//end for
		
		//end line
		System.out.print("\n");
		
	}//end main
	
	//a function that will swap two values within an array
	static void swap(int[] arr, int in1, int in2 ) {
	
		int tmp = arr[in1];
		arr[in1] = arr[in2];
		arr[in2] = tmp;
	}//end swap
	
	static void bubblesort(int[] arr) {
		
		//stores length of array
		int length = arr.length;
		
		//tracks current location while
		//iterating through array
		int tracker = 1;
		
		//a marker that tells us when a swap has occurred
		boolean swapflag;
		
		do{//iterate over the array at least once
			
			/* the tracker compares the item in
			 * to the item before it, thus it starts with
			 * the second item in the array 
			 */ 
			tracker = 1;
			
			//reset flag as if no swaps have occurred
			swapflag = false;
			
			while (tracker < length) {
				
				//if the item is not greater than the item before it...
				if (arr[tracker] < arr[ tracker-1 ]) {
					
					//...swap the two items and...
					swap(arr, tracker, tracker-1);
					
					//...show that a swap has occurred
					swapflag = true;
				}//end if
				
				//then move to the next item in the array
				tracker++;
			}//end while
		} while (swapflag);
	}//end bubblesort (function)
}//end BubbleSort (class)
