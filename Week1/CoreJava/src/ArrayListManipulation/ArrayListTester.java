package ArrayListManipulation;

import java.util.ArrayList;
import Primer.PrimeChecker;
public class ArrayListTester {

	public static void main(String[] args) {
		/*This program will populate an arraylist with integers and then
		 * use methods from the arraylist to access certain numbers from the 
		 * list. 
		 */
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Integer> listOfPrime = new ArrayList<>();
		int evenTotal=0;
		int oddTotal=0;
		for(int x =0; x <10; x++) {
			numbers.add(x+1);
		}
		System.out.println(numbers);
		for(int x=0; x<numbers.size();x++) {
			if((numbers.get(x))%2 == 0)
				evenTotal=evenTotal + numbers.get(x);
			else
				oddTotal= oddTotal + numbers.get(x);
		}
		System.out.println(evenTotal);
		System.out.println(oddTotal);
		
		for(int i=0; i<10; i++) {
			boolean result = PrimeChecker.primeChecker(numbers.get(i));
			if(result)
				listOfPrime.add(numbers.get(i));
		}
		numbers.remove(listOfPrime.get(0));
		numbers.remove(listOfPrime.get(1));
		numbers.remove(listOfPrime.get(2));
		numbers.remove(listOfPrime.get(3));
		numbers.remove(listOfPrime.get(4));
		

		System.out.println(numbers);
		
	}

}
