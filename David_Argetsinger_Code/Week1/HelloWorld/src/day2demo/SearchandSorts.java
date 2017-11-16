package day2demo;

import java.util.Scanner;

public class SearchandSorts {
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
		bubbleSort(numArr); // and binary search! 
		
		
		

	}

}
