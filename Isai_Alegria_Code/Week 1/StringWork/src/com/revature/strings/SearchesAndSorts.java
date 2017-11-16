package com.revature.strings;

import java.util.LinkedList;
import java.util.Queue;

public class SearchesAndSorts {
	
	class Node{
		
		int info;
		boolean visited;
		Node(int x)
		{
			this.info = x;
		}
	}



	
	void breadthFirstSearch() {
		
		Queue q = new LinkedList();
		Object rootNode;
		//q.add(rootNode);
		//System.out.println(rootNode);
		//visited[rootnode] = true;
	}
		
	static void bubbleSort(int[] arr)
	{	
		int temp;
		
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr.length -1; j++) {
				
			//check if the current element is greater than
			//the next element. if so, then swap. 
				if(arr[i]>arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				} // if statement
			} //inner for loop
		} //outer for loop
	
	}	
		static void printArray(int arr[]) {
			
			int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
			
		}
		
	
	
	public static void main(String[] args) {
		
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
		
		
	}
	
	

}
