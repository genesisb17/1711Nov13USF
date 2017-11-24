package com.revature.homework;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EvenOddArray {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++) {
			al.add(i);
		}

		System.out.println(al.toString());
		
		int sum=0;
		for(int i : al) {
			if(i%2==0) {
				sum +=i;
			}
		}
		
		System.out.println(sum);
	}

}
