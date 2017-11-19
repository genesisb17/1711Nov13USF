package com.revature.q1;

public class Bubblesort {
	public void main(String[] args) {
		Integer[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		Integer[] sorted=bubblesort(array);
		
		System.out.println(sorted);
		
	}
	
	
	public Integer[] bubblesort(Integer ... array){
		Integer[] arr=array;
		int corrections=0;
		do{
			for(int i=0;i<arr.length-1;i++){
				if(arr[i]>arr[i+1]){
					int temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					corrections++;
				}
			}
		}while(corrections>0);
		
		return arr;
	}
}