package Day2;

public class searchandsorts 
{

/*Implement the following
 * breadth the first search
 * dpth first search 
 * merge sort
 */
	
	public static void main(String[] args)
	{
		int arr[]= {1,2,5,4,3,6};	
		MergeSort m1 = new MergeSort();
		MergeSort m2 = new MergeSort();
		
		m2.array = m2.mergeSort(0,2,arr);
	    m1.array = m1.mergeSort(3,5,arr);
	    m1.combine(m1.array, m2.array);
		bubbleSort(arr);
		insertionSort(arr);
		int temp;
	     for (int i = 1; i < arr.length; i++) {
	         for(int j = i ; j > 0 ; j--){
	             if(arr[j] < arr[j-1]){
	                 temp = arr[j];
	                 arr[j] = arr[j-1];
	                 arr[j-1] = temp;
	             }
	         }
	     }
	     int n = 3;
		//binarySearch(arr[n],arr);
	}
 /*static void binarySearch(int key,int... arr)
 {
	 int size = arr.length;
	 int low = 0;
	 int high = size-1;
	 while(high >=low){
		 int middle=(low+high)/2;
		 if(arr[middle]==key)
		 {
			 System.out.println(middle);
			 break;
		 }
	      if(arr[middle] < key) 
	      {
	    	low= middle +1;
	    	int[] ar = new int[low];
	    	for(int i = 0; i < low;i++)
	    	{
	    		ar[i]=arr[i];
	    	}
	    	binarySearch(key,arr);
	      }
	      if(arr[middle]>key)
	      {
	    	  high = middle-1;
		    	int[] ar = new int[high];
		    	for(int i = middle; i < high;i++)
		    	{
		    		ar[i]=arr[i];
		    	}
		    	binarySearch(key,ar);
	      }
	 }

 }*/
 public static void insertionSort(int... arr){
     
     int temp;
     for (int i = 1; i < arr.length; i++) {
         for(int j = i ; j > 0 ; j--){
             if(arr[j] < arr[j-1]){
                 temp = arr[j];
                 arr[j] = arr[j-1];
                 arr[j-1] = temp;
             }
         }
     }
     int n = arr.length;
     for(int i=0; i < n; i++){  
    	 System.out.print(arr[i]);                
} 
     
 }
 static void bubbleSort(int... arr)
 {
	 int n = arr.length;
	 int temp;
     for(int i=0; i < n; i++){  
         for(int j=1; j < (n-i); j++){  
                  if(arr[j-1] > arr[j]){  
                         //swap elements  
                         temp = arr[j-1];  
                         arr[j-1] = arr[j];  
                         arr[j] = temp;  
                 }                  
         }  
 }
     for(int i=0; i < n; i++){  
        	 System.out.print(arr[i]);                
 } 
     }
}
