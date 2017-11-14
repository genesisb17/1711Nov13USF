package day2demo;

public class SearchAndSort {

	public static void main(String[] args) {
			
		/*
		 * Binary Search
		 * breadth first search
		 * depth first search
		 * bubble sort
		 * merge sort
		 * insertion sort
		 */

		// Binary Search Call
		int Arr[] = {1, 2, 4, 8, 17, 20, 21, 200, 300};
		int x = 8;
		int begin = 0;
		int end = Arr.length - 1;
		int index = BinarySearch(Arr, x, begin, end);
		System.out.println("The index of the element is: " + index);
		
		
		// Bubble sort call
		int Arr1[] = {1, 8, 4, 5, 20, 25, 15};
		BubbleSort(Arr1);
		
		// Insertion Sort call
		InsertionSort(Arr1);
	}

	static int BinarySearch(int[] Arr, int x, int begin, int end) {
		
		if(end >= begin) {
			
			int mid = begin + (end - begin) / 2;
			
			if(x == Arr[mid]) {
				return mid;
			}
			if(x < Arr[mid]) {
				return BinarySearch(Arr, x, begin, mid-1);
			}
			else 
				return BinarySearch(Arr, x, mid+1, end);		
		}
		
		return -1;
	}
	
	static void BubbleSort(int[] Arr) {
		
		int n = Arr.length - 1;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n - i - 1; j++) {
				
				if(Arr[j] > Arr[j+1]) {
					// Swap
					int temp = Arr[j];
					Arr[j] = Arr[j+1];
					Arr[j+1] = temp;	
				}	
			}
		// Print Array
		for(int k = 0; k < n; k++) {
			System.out.println(Arr[k]);
		}
	}
	
	static void InsertionSort(int[] Arr) {
		
		   int i, key, j;
		   int n = Arr.length - 1;
		   for (i = 1; i < n; i++)
		   {
		       key = Arr[i];
		       j = i-1;
		 
		       /* Move elements of arr[0..i-1], that are
		          greater than key, to one position ahead
		          of their current position */
		       while (j >= 0 && Arr[j] > key)
		       {
		           Arr[j+1] = Arr[j];
		           j = j-1;
		       }
		       Arr[j+1] = key;
		   }
		   
			System.out.println("Insertion Sort Results:");
		    for(int k = 0; k < n; k++) {
				System.out.println(Arr[k]);
			}

	}
	
}




