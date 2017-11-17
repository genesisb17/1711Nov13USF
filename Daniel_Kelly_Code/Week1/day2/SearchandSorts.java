package com.revature.day2;

public class SearchandSorts {

	public static void main(String[] args) {
		/*
		 * implement following
		 * binary search
		 * breadth first search
		 * depth first search
		 * bubble sort
		 * merge sort
		 * insertion sort
		 */
		
		//BINARY SEARCH
		SearchandSorts ob = new SearchandSorts();
		int[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int n = numArr.length;
		int x = 3;
		int result = ob.binarySearch(numArr, 0, n-1, x);
		if (result == -1){
			System.out.println("element not present");
		}else{
			System.out.println("Binary Search. Element found at index " + result);
		}
		
		//BUBBLE SORT
		ob.bubbleSort(numArr);
		System.out.println("Bubble Sorted array");
		ob.printArray(numArr);
		
		//MERGE SORT
		int[] numArr2 = {12, 11, 13, 5, 6, 7};
		 System.out.println("Given Array");
	        printArray(numArr2);
	 
	        ob.sort(numArr2, 0, numArr2.length-1);
	 
	        System.out.println("Merge Sorted array");
	        printArray(numArr2);
	
	        //INSERTION SORT
	        System.out.println("Given Array");
	        int numArr3[] = {12, 11, 13, 5, 6};
	        printArray(numArr3);
	              
	        ob.insertionSort(numArr3);
	         
	        System.out.println("Insertion Sorted array");
	        printArray(numArr3);
		
		//BREADTH FIRST
		 Graph g = new Graph(4);
		 
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	 
	        System.out.println("Following is Breadth First Traversal "+
	                           "(starting from vertex 2)");
	 
	        g.BFS(2);
	        
	        //DEPTH FIRST
	        System.out.println("\nFollowing is Depth First Traversal "+
                    "(starting from vertex 2)");

	        g.DFS(2);

	}
	
	int binarySearch(int arr[], int l, int r, int x){
		 if (r>=l)
	        {
	            int mid = l + (r - l)/2;
	 
	            // If the element is present at the middle itself
	            if (arr[mid] == x)
	               return mid;
	 
	            // If element is smaller than mid, then it can only
	            // be present in left subarray
	            if (arr[mid] > x)
	               return binarySearch(arr, l, mid-1, x);
	 
	            // Else the element can only be present in right
	            // subarray
	            return binarySearch(arr, mid+1, r, x);
	        }
	 
	        // We reach here when element is not present in array
	        return -1;
	}
	
	 void bubbleSort(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (arr[j] > arr[j+1])
	                {
	                    // swap temp and arr[i]
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
	    }
	 
	// Merges two subarrays of arr[].
	    // First subarray is arr[l..m]
	    // Second subarray is arr[m+1..r]
	    void merge(int arr[], int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        /* Create temp arrays */
	        int L[] = new int [n1];
	        int R[] = new int [n2];
	 
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i)
	            L[i] = arr[l + i];
	        for (int j=0; j<n2; ++j)
	            R[j] = arr[m + 1+ j];
	 
	 
	        /* Merge the temp arrays */
	 
	        // Initial indexes of first and second subarrays
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	    // Main function that sorts arr[l..r] using
	    // merge()
	    void sort(int arr[], int l, int r)
	    {
	        if (l < r)
	        {
	            // Find the middle point
	            int m = (l+r)/2;
	 
	            // Sort first and second halves
	            sort(arr, l, m);
	            sort(arr , m+1, r);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
	    
	    /*Function to sort array using insertion sort*/
	    void insertionSort(int arr[])
	    {
	        int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = arr[i];
	            int j = i-1;
	 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = key;
	        }
	    }
	 
	    /* Prints the array */
	   static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	 

}
