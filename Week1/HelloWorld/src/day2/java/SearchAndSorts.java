package day2.java;

public class SearchAndSorts {
	/*
	 * Implement the following
	 * - binary search
	 * - breadth first search
	 * - depth first search
	 * - bubble sort
	 * - merge sort
	 * - insertion sort
	 * */
	
	
	public static int binarySearch(int[] arr, int first, int last, int key) {
		
		if(last >= first) {
			
			int mid = first + (last - first) / 2;
				
				if(arr[mid] == key) {
					return mid;
				}
				
				if(arr[mid] > key) {
					return binarySearch(arr, first, mid-1, key);
				}
				
				return binarySearch(arr, mid+1, last, key);
			
		}
		
		
		
		
		return 0;
	}
	
	public void BreadthFirst() {
		
		
	}
	
	public void DepthFirst() {
		
		
	}
	
	public static void bubbleSort(int[] arr) {
		
		int r = arr.length;
		int temp = 0;
        for(int i=0; i < r; i++){
            for(int j=1; j < (r-i) ; j++){  
                     if(arr[j-1] > arr[j]){  
                            //swap elements  
                            temp = arr[j-1];  
                            arr[j-1] = arr[j];  
                            arr[j] = temp;  
                    }  
                     
            }  
        }
	}
	
	public static void mergeSort() {
		
		
	}
	
    public static void insertionSort(int array[]) {  
        int n = array.length;  
        
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            
            while ((i > -1) && ( array [i] > key )) {  
                array [i+1] = array [i];  
                i--;  
            }  
            
            array[i+1] = key; 
            
        }
    }  
	
	public static void main(String[] args) {
		
		int arr[] = {5, 6, 2, 3, 7, 10};
		int n = arr.length;
		int key = 7;
		int result = binarySearch(arr, 0, n-1, key);
		
		if(result == 0) {			
			System.out.println("Element not found.");			
		}
		
		else {	
			System.out.println("Key " + key + " found at index " + result + ".");
		}
		
		//pre sort
		System.out.println("Array before sort:");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		bubbleSort(arr);
		//post bubble sort
		System.out.println("Array after bubble sort:");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		insertionSort(arr);
		System.out.println("Array after insertion sort:");
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}