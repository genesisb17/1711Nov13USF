package day2;

public class SearchAndSorts {

	public static void main(String[] args) {
		/*
		 * Implement the following
		 * - binary search
		 * - breadth first search
		 * - depth first search
		 * - bubble sort
		 * - merge sort
		 * - insertion sort
		 */
		int[] arr = new int[] {1, 6, 13, 43, 55, 61, 89, 105, 216};
		int[] arr1 = new int[] {4, 3, 1, 5, 2};
		int[] arr2 = new int[] {1000, 3, 97, 2, 321, 22, 25, 71};
//		int bins = BinarySearch(22, arr2);
//		System.out.println(bins);
//		InsertionSort(arr2);
//		for(int i = 0; i < arr2.length; i++) {
//			System.out.println(arr2[i]);
//		}
	}
	static int BinarySearch(int target, int[] array) {
		BubbleSort(array);
		int start = 0;
		int mid = array.length/2;
		int end = array.length;
		while(start <= end && mid < array.length) {
			if (array[mid] == target) {
				return mid;
			}
			else if (target < array[mid]) {
				end = mid-1;
			}
			else if (target > array[mid]) {
				start = mid + 1;
			}
			mid = (start+end) / 2;
		}
		return -1;
		
	}
	static void BubbleSort(int... arr) {
		if (arr.length == 1) {
			return;
		}
		int end = arr.length;
		for(int i = 0; i + 1 < end; i++) {
			if(arr[i] > arr[i+1]) {
				int temp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			if ((i+2) == end) {
				end = end-1;
				i = -1;
			}
			if (i+2 > end) {
				return;
			}
		}	
	}
	
	static void InsertionSort(int... arr) {
        for (int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
	}
	static void MergeSort(int... arr) {
		
	}
}
