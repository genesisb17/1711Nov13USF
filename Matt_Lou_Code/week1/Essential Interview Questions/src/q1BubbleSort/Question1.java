package q1BubbleSort;

public class Question1 {

	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(arr);
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public static void bubbleSort(int[] array) {
		int temp = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 1; j < array.length - i - 1; j++) {
				if(array[j - 1] > array[j]) {
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
					
				}
			}
		}
	}

}
