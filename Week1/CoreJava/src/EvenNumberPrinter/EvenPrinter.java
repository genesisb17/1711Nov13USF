package EvenNumberPrinter;

public class EvenPrinter {
	/* this class will populate an integer array with mumbers 1-100
	 * and then parse through array printing out the even numbers. 
	 * The array will be parsed using an enhanced for loop
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[100];
		for(int i=0; i < 100; i++) {
			numbers[i] = i+1;
		}
		System.out.println("Even numbers in the array are below");
		for(int x: numbers)
		{
			if(x % 2 == 0)
				System.out.println(x);
		}
		
	}

	
	
	
}
