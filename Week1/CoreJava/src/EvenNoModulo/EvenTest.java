package EvenNoModulo;

public class EvenTest {

	public static void main(String[] args) {
		/*
		 * This program determines if an integer is even without using the modulus operator
		 */
		int num = 5;
		System.out.println("The number to be checked to see if even is: " + num);
		if (evenChecker(num))
			System.out.println("The given number is even");
		else
			System.out.println("The given number is odd");
	}
	
	static boolean evenChecker(int x) {
		/* check to see if a number is even without using 
		 * modulo
		 */
		if((x/2)+(x/2) == x) {
	
			return true;
		}
		else {
			
			return false;
		}
	}

}

