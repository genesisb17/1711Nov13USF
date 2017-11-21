
public class BubbleSort {

	public static void main(String[] args) {
		/* 
		 * Program below performs a bubble sort on a given array
		 */
		int[] bubbleList = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Values in array are: ");
		printArray(bubbleList);
		bubbleSort(bubbleList);
		System.out.println("Values in array after bubbleSort are: ");
		printArray(bubbleList);
		

	}
	
	static void bubbleSort(int[] inputArray) {
		/* the bubble sort method basically checks the first two elements
		 * compares them to each other, and sorts them accordingly, 
		 * placing the one with lower value to the left and higher
		 * value to the right
		 * 
		 */
		int size = inputArray.length;
		for(int x = 0; x< size-1; x++)
			for(int y = 0; y< size - x - 1; y++) {
				if(inputArray[y] > inputArray[y + 1]) {
					int temp = inputArray[y];
					inputArray[y] = inputArray[y+1];
					inputArray[y+1]= temp;
				}
			}
	}
	static void printArray(int[] inputArray) {
		
		/*This method will print the values inside an array
		 * 
		 */
		int size = inputArray.length;
		for(int x =0; x<size; x++) {
			System.out.print(inputArray[x] + " ");
		}
		System.out.println();
	}
}
