package com.revature.homework;

import java.util.ArrayList;

public class PrimePractice {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 1; i <= 100; i++) {
			al.add(i);
		}

		System.out.println(al.toString());

		ArrayList<Integer> primeList = new ArrayList<Integer>();

		for (int i : al) {
			// check if n is a multiple of 2
			if (i>2 && (i & 1) == 0)
				continue;
			// if not, then just check the odds
			for (int j = 3; j * j <= i; j += 2) {
				if (i % j == 0)
				{
				continue;
				}
			}
			primeList.add(i);
		}
		
		System.out.println(primeList.toString());

	}

}
