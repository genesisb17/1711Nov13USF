package Primer;

import java.util.ArrayList;

public class PrimeChecker {

	public static void main(String[] args) {
		/*
		 * This program determines whether or not a number is prime 
		 * and prints it to the console
		 */
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=0; i<101; i++) {
			numbers.add(i);
		}
		for(int i=0; i<101; i++) {
			boolean result = primeChecker(numbers.get(i));
			if(result)
				System.out.println(numbers.get(i));
		}

	}
		public static boolean primeChecker(int x) {
			if( x <= 2) {
				return true;}
			for(int i=2; i<=x/2; i++) {
				if(x%i==0)
					return false;
			}
			return true;
	}
		}
