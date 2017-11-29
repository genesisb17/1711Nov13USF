package day2demo;

import java.util.Arrays;

import javax.swing.tree.TreeModel;

public class SearchAndSorts {
/*
 * Implement the following:
 * -binary search 			x
 * -breadth first search
 * -depth first search
 * -bubble sort				x
 * -merge sort				x
 * -insertion sort			x
 */
	
	/*
	 * Inputs: 
	 * arr 		a presorted array of integers 
	 * x		the value to search for
	 * Output: 
	 * true if x is found
	 * false otherwise
	 */
	boolean BinarySearch(int[] arr, int x){
		boolean check=false;
		if(arr.length==1){
			if(arr[0]==x){
				check=true;
			}
		} else if (arr.length>1) {
			int middle= arr[arr.length/2];
			if(x<middle){
				int[] lower = Arrays.copyOfRange(arr, 0, arr.length/2);
				check=BinarySearch(lower,x);
			} else if (x>middle){
				int[] upper = Arrays.copyOfRange(arr, arr.length/2, arr.length);
				check=BinarySearch(upper,x);
			} else {
				check=true;
			}
		}
		
		return check;
	}
	
	//having trouble figuring out what data structures to use
	void BreadthFirstSearch(TreeModel tree, int x){
		
	}
	
	//again having trouble figuring out what data structures to use
	void DepthFirstSearch(int ... nums){
		
	}
	
	int[] BubbleSort(int ... nums){
		int[] arr=nums;
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
	
	int[] MergeSort(int ... nums){
		int[] arr=nums;
		if(arr.length>1){
			int[] l=Arrays.copyOfRange(arr, 0, arr.length/2);
			int[] r=Arrays.copyOfRange(arr,arr.length/2+1,arr.length-1);
			int[] lSorted=MergeSort(l);
			int[] rSorted=MergeSort(r);
			
			int indexL=0;
			int indexR=0;
			int indexSort=0;
			while(indexSort<arr.length){
				if(lSorted[indexL]<=rSorted[indexR]){
					arr[indexSort]=lSorted[indexL];
					indexL++;
					indexSort++;
				}
				else if(lSorted[indexL]>rSorted[indexR]){
					arr[indexSort]=rSorted[indexR];
					indexSort++;
				}
			}
		}
		return arr;
	}
	
	int[] InsertionSort(int ... nums){
		int[] arr=nums;
		int[] sorted= new int[arr.length];
		
		//first element to take out
		int firstSort=arr[0];
		sorted[0]=firstSort;
		
		//take each element from the unsorted array
		for(int i=1;i<arr.length;i++){
			int toSort=arr[i];
			
			//find the index where to put the element into sorted
			int sIndex=0;
			while(sIndex<arr.length || toSort<sorted[sIndex]){
				sIndex++;
			}
			
			//put the element into sorted
			if(sIndex!=sorted.length-1){
				//the elements to shift over
				int[] shift=Arrays.copyOfRange(sorted, sIndex, sorted.length-2);
				//insert element
				sorted[sIndex]=toSort;
				//put shifted elements back in
				for(int j=0;j<shift.length;j++){
					sorted[sIndex+1+j]=shift[j];
				}
			}	
		}
		return sorted;
	}
}
