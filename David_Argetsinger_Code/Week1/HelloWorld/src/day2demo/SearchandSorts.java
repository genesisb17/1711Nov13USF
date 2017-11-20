package day2demo;

import java.util.Scanner;

public class SearchandSorts {
	 static void merge(int arr[], int l, int m, int r)
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
	 
	    static // Main function that sorts arr[l..r] using
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
	
	
	
	
	
	
	/////////// end merge
	
	
	
	
	static int binarySearch ( int arr[], int left, int right, int x)
	{
		if(right >= left)
		{
			int mid=left+(right-left)/2;
		
			if (arr[mid]==x)
				return mid;
			if (arr[mid]>x)
				return binarySearch(arr,left,mid-1,x);
			 return binarySearch(arr, mid+1, right, x);
		}
		return -1;
	} 
	 static void bubbleSort(int... arr){
		 int n =arr.length;
		 int temp=0;
		 for(int i = 0 ; i < n; i++){
			 for(int j = 1; j< (n-i);j++){
				 if(arr[j-1] > arr[j]){  
				 temp=arr[j-1];
				 arr[j-1]=arr[j];
				 arr[j]=temp;
				 }
			 }
		 }
		 System.out.println("the sorted array looks like ");
		 for(int i = 0 ; i < arr.length; i++)
			 System.out.println(arr[i]);
		 System.out.println( " lets now binarysearch it for 66 ");
		 int hold = binarySearch(arr,0,arr.length-1,66);
		 if(hold == -1)
			 System.out.println("not found in binary search");
		 else
			 System.out.println("found in binary search at " + hold);
	 }
	
	 
	public static void main(String[] args) {
		System.out.println("enter numbers seperated by a single space:");
		Scanner in= new Scanner(System.in);
		
		String num = in.nextLine();
		String[] numStrings=num.split(" "); //regex 
		
		int[] numArr = new int[numStrings.length];
		
		for(int i = 0; i< numStrings.length;i++){
			numStrings[i]=numStrings[i].trim();// only works on front and back
			if(numStrings[i]!=" ")
			numArr[i]=Integer.parseInt(numStrings[i]);
		}
		
		in.close();
		int[] numArr2 = numArr.clone();
		bubbleSort(numArr); // and binary search! 
		
		

		 System.out.println("the unsorted array looks like ");
		 for(int i = 0 ; i < numArr2.length; i++)
			 System.out.println(numArr2[i]);
		 System.out.println("starting merge sort");
		
		sort(numArr2, 0, (numArr2.length-1));
		 for(int i = 0 ; i < numArr2.length; i++)
			 System.out.println(numArr2[i]);		
		
		
		

	}

}
