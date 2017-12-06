package com.revature;

public class MySearchAndSorts {
	public static void main(String[] args) {
	int[] uarr = {9, 7, 1, 3, 4, 8, 4, 5, 0, 2, 6};
	
	int[] sarr = {0,2,4,6,8,10,12,14,16,18};		
	
	int find = 17;
	
	int index = binarysearch(find, sarr);
	System.out.println(index);
	
	bubblesort(uarr);
	for (int i : uarr) {
		System.out.print(i);
	}
		System.out.print("\n");
	int[] uarr2 = {9, 7, 1, 3, 4, 8, 4, 5, 0, 2, 6};
	insertion(uarr2);
	for (int i : uarr2) {
		System.out.print(i);
	}
		System.out.print("\n");
	
	
	int[] uarr3 = {9, 7, 1, 3, 4, 8, 5, 0, 2, 6};
	mergesort(uarr3, 0, uarr3.length);
	for (int i : uarr3) {
		System.out.print(i);
	}
		System.out.print("\n");
	}

	/*
	 * implement:
	 * binary
	 * BFS
	 * DFS
	 * bubble
	 * merge
	 * insertion
	 */
	


	
	//binary
	static int binarysearch(int value, int[] nums)  {
		
		//initial minimum, maximum, and mid
		int min = 0;
		int max = nums.length;
		int mid = (max + min)/2;
		
		while (min < max) {
			
			if (value == nums[mid]) return mid;//if mid == value, you found it
			
			else if (value < nums[mid]) {//if value is smaller
				max = mid - 1;			 //the new max is one under the current mid
				mid = (max + min)/2;	 //the new middle is the avg of same min and new max
			}
			else {
				min = mid + 1;			//opposite as above
				mid = (max + min)/2;
			}
		}
		return -1;
	};
	
	static void bubblesort(int[] arr) {
		int len = arr.length;
		int track = 1;
		boolean swap = true;
		while(swap) {
			track = 1;
			swap = false;
			while (track < len) {
				if (arr[track] < arr[ track-1 ]) {
					swap(arr, track, track-1);
					swap = true;
				}
				track++;
			}
		}
	}
	
	static void swap(int[] arr, int in1, int in2 ) {
	int tmp = arr[in1];
	arr[in1] = arr[in2];
	arr[in2] = tmp;
	}
	
	
	
	/*
	 * start at ar[1]
	 * if larger than previous
	 * 	
	 */
	static void insertion(int[] arr) {
		int index = 1;
		int len = arr.length;
		int track;
		while (index < len) {
			track = index;	
			while(track > 0  && (arr[track] < arr[track - 1])) {
				swap(arr, track, (track - 1));
				track--;
			}
			index++;
		}
	}

	static void mergesort(int[] array) {
		mergesort(array, 0, array.length - 1);
	}
	static void mergesort(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if(left < right) {
			mid = (left + right) / 2;
			mergesort(arr, left, mid);
			mergesort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}

		
	}
	
	static void merge(int[] arr, int left, int mid, int right) {
		int size = arr.length;
		int[] tmp = new int[size];
		
		for (int i = left; i < right; i++) {
			tmp[i] = arr[left + i];
		}
		
		int l = left;
		int r = mid + 1;
		int cur = left;
		while (l <= mid && r <= right) {
			if(tmp[l] <= tmp[r]) {
				arr[cur] = tmp[l];
				l++;
			}
			else {
				arr[cur] = tmp[r];
				r++;
			}
			cur++;
		}
		
		int remain = mid - l;
		for (int i = 0; i < remain; i++) {
			arr[cur+i] = tmp[l + i];
		}
		

			

		
		
	}
}




