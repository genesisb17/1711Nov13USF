package com.revature.Andy;

public class UnderstandSearchAndSorts {

	int[] arr;
	
	public UnderstandSearchAndSorts() {
		
	}
	
	public UnderstandSearchAndSorts(int[] a) {
		arr = a;
	}
	
	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int binarySearch(int value) {
		int L = 0;
		int R = arr.length - 1;
		int m = (L + R)/2;
		if (arr[m] < value) {
			return binaryHelp(m+1, R, value);
		}
		if (arr[m] > value) {
			return binaryHelp(L, m-1, value);
		}
		return -1; 
	}
	
	private int binaryHelp(int L, int R, int value) {
		int m = (L + R)/2;
		if (arr[m] < value) {
			binaryHelp(m+1, R, value);
		}
		else if (arr[m] > value) {
			binaryHelp(L, m-1, value);
		}
		else {
			return m;
		}
		return -1;
	}
	
	//public int breadthFirstSearch()

	//bubbleSort 
	public int [] bubbleSort() {
		int n = this.arr.length;
		boolean noSwap = false;
		while(noSwap) {
			noSwap = true;
			for (int i = 0; i < n-1 ; i++) {
				if (this.arr[i] > this.arr[i+1]) {
					int temp = this.arr[i];
					this.arr[i] = this.arr[i+1];
					this.arr[i+1] = temp;
					noSwap = false;
				}
			}
		}
		for (int i = 0; i < this.arr.length; i++){
			System.out.print(this.arr[i] + ", ");
			
		}
		return this.arr;
	}
	public int[] bubbleSort(int[] a) {
		int[] result = a;
		int n = result.length;
		boolean noSwap = true;
		while(noSwap) {
			noSwap = false;
			for (int i = 0; i < n-1 ; i++) {
				if (result[i] > result[i+1]) {
					int temp = result[i];
					result[i] = result[i+1];
					result[i+1] = temp;
					noSwap = true;
				}
			}
		}
		for (int i = 0; i < result.length; i++){
			System.out.print(result[i] + ", ");
			
		}
		System.out.println();
		return result;
	}
	
	//insertion sort
	public int[] insertionSort(int[] a) {
		int[] result = a;
		int i = 1;
		while (i < result.length) {
			int j = i;
			while ((j > 0) && (result[j-1] > result[j])) {
				int temp = result[j];
				result[j] = result[j-1];
				result[j-1] = temp;
				j--;
			}
			i++;
		}
		for (int j = 0; j < result.length; j++){
			System.out.print(result[j] + ", ");
			
		}
		System.out.println();
		return result;
	}
	
	
	//merge sort
	private void mergeSort(int[] A, int[] B, int n) {
		copyArray(A, 0, n, B);
		split(B, 0, n, A);
	}

	private void split(int[] b, int x, int y, int[] a) {
		// TODO Auto-generated method stub
		if((y - x) < 2) {
			return;
		}
		int m = (x + y)/2;
		split(a, x, m, b);
		split(a, m+1, y, b);
		
		merge(b, x, m, y, a);
	}

	private void merge(int[] b, int x, int m, int y, int[] a) {
		// TODO Auto-generated method stub
		int i = x;
		int j = m;
		for (int k = x; k < y; k++) {
			if (i < m && (j >= y || a[i] <= a[j])) {
				b[k] = a[i];
				i++;
			}
			else {
				b[k] = a[j];
				j++;				
			}
		}		
	}

	private void copyArray(int[] a, int x, int y, int[] b) {
		// TODO Auto-generated method stub
		for (int i = x; i < y; i++) {
			b[i] = a[i];
		}
		
	}
	
}
