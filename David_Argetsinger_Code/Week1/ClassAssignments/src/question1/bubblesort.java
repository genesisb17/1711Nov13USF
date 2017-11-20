package question1;

public class bubblesort {
	 static void bubbleSort(int... arr){
		 
		 int n =arr.length;
		 // n is defined to be used in both loops
		 int temp=0;
		 // holds numbers as they are moved around to maintain integrity of set
		 for(int i = 0 ; i < n; i++){
			 for(int j = 1; j< (n-i);j++){
				 if(arr[j-1] > arr[j]){  
				 temp=arr[j-1];
				 arr[j-1]=arr[j];
				 arr[j]=temp;
				 }
			 }
		 }
		 
	 }
	 public static void main(String[] args) {
		int [] arr= {1,0,5,6,3,2,3,7,9,8,4};
		//initialize the array
		
		//print initial array
		 System.out.println("the unsorted array looks like ");
		 for(int i = 0 ; i < arr.length; i++)
			 System.out.println(arr[i]);
		 
		 //sort the array
		bubbleSort(arr);
		
		//print out sorted array
		 System.out.println("the sorted array looks like ");
		 for(int i = 0 ; i < arr.length; i++)
			 System.out.println(arr[i]);
		
		
	}

}
