package Q1;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println(Arrays.toString(array));
		int[] sorted=bubblesort(array);
		
		System.out.println(Arrays.toString(sorted));
		
	}
	
	
	public static int[] bubblesort(int ... array){
		int[] arr=array;
		int corrections=0;
		do{
			corrections=0;
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