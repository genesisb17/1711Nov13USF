public class LinearSearch {
	public static void main(String[] args) {

		// Linear Search
		int[] array = { 0, 2, 4, 6, 8 };
		int i = 0, val = 6;
		boolean found = false;

		for (i = 0; i < array.length; i++) {
			if (array[i] == val) {
				found = true;
				break;
			}
		}

		if (found)
			System.out.println("The number " + val + " was found at index " + i);
		else
			System.out.println("The number " + val + " was not found.");

		
		
		int x = binarySearch(array, val);
		System.out.println(x);
		
		
		
		
	}

	// Binary Search
	public static int binarySearch(int[] array, int val) 
	{
		int low = 0, high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (val == array[mid])
				return mid;
			if (val < array[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		return 0;
	}
	
}
