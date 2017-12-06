package com.revature.warmup;

import java.util.ArrayList;

public class Warmup1116 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isOdd(int i) {

		int j = i/2;
		return i != (j*2);

	}

	public ArrayList<Integer> primeList(){

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i < 101; i++) {
			result.add(i);
			for (int j = 0; j < i; j++) {
				if ((i % j)==0) {
					System.out.println(i);
					j = 200;
				}
			}
		}
		return result;
	}
	/*
		for (int i = 2; i < 101; i++) {

			for (int j = 2; j < i; j++ ) {
				if (this.isOdd(j)) {
					if ((i % j)==0) {
						result.remove(i);
						System.out.println(i);
					}
				}
			}
			/*
			if (this.isOdd(i)) {
				for (int j = 3; j < i; j++ ) {
					if (this.isOdd(j)) {
						if ((i % j)==0) {
							result.remove(i);
							System.out.println(i);
						}
					}
				}
			}
	 */

	public int ternaryMin(int x, int y) {
		return (x < y) ? x : y;
	}
	
	

}
