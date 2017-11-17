package com.revature.printPrimes;

import java.util.ArrayList;

public class PrintPrimes {

	public static void main(String[] args) {
		
		ArrayList<Integer> intArrList = generateArrayList();
		
		ArrayList<Integer> primeArrList = generatePrimeArrListFromIntArrList(intArrList);
		
		printPrimesFromPrimeArrList(primeArrList);
		

	}
	
	public static ArrayList<Integer> generateArrayList() {
		
		ArrayList<Integer> intArrList = new ArrayList<>();
		
		for (int i = 1; i <= 100; i++) {
			intArrList.add(i);
		}
		
		return intArrList;
		
	}
	
	public static ArrayList<Integer> generatePrimeArrListFromIntArrList(ArrayList<Integer> intArrList) {
		
		ArrayList<Integer> primeArrList = new ArrayList<>();
		
		for(int element : intArrList) {
			
			if(isPrime(element)) {
				primeArrList.add(element);
			}
			
		}
		
		return primeArrList;
	}
	
	public static boolean isPrime(int value) {
		
		for(int i = 2; i < value; i++) {
			
			if(value % i == 0) {
				return false;
			}
			
		}
		
		return true;
	}

	public static void printPrimesFromPrimeArrList(ArrayList<Integer> primeArrList) {
		
		for(int element : primeArrList) {
			System.out.println(element);
		}
	}
}
