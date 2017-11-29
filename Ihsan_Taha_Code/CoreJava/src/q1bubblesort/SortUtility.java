package q1bubblesort;

public class SortUtility {

	private int[] array;
	
	public int[] bubbleSort(int[] array) {
		this.array = array;	
		boolean sorted = false;

		for (int i = 0; i < array.length - 1 && !sorted; i++) {
			sorted = true;

			for (int j = 0; j < array.length - 1 - i; j++) {

				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					sorted = false;
				}
			}
		}
		
		return array;
	}

	public void printArray(int[] array) {
		for (int i = 1; i <= array.length; i++) {
			if (i % 8 == 0)
				System.out.println(array[i-1] + "\t");
			else
				System.out.print(array[i-1] + "\t");
		}
		System.out.println();
	}

}
