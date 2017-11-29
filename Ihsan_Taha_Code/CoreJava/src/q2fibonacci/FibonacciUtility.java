package q2fibonacci;

public class FibonacciUtility {
	
	private int n1 = 0, n2 = 1, n3;
	
	public int[] getFibonacci(int n) {
		int[] array = new int[n];
		array[0] = 0;
			
			for (int i = 1;i < n;i++) {
				n3 = n1 + n2;
				array[i] = n3;
				n1 = n2;
				n2 = n3;
			}
			
			return array;
	}
	
	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
}
