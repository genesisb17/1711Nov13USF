package q1bubblesort;

public class BubbleSort {
	public static void main(String[] args) {
		
		int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		SortUtility su = new SortUtility();
		
		su.printArray(su.bubbleSort(array));

	}
}
