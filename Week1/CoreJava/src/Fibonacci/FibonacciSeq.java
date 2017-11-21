package Fibonacci;

public class FibonacciSeq {
	static int first=0;
	static int second=1;
	static int next=0;
	
	public static void main(String[] args) {
		/* this program will recursively print the fibonacci sequence of the
		 * TotalNums requested. For example, this program will print the first
		 * 25 numbers of the fibonnaci sequence, so totalNums=25.
		 */
		int totalNums = 25;
		System.out.println(first + "\n" + second);
		printFib(totalNums);
		

	}
	
	static void printFib(int counter) {
		if(counter>0) {
			next=first + second;
			first = second;
			second = next;
			System.out.println(" " + next);
			printFib(counter-1);
		}
		
	}

}
