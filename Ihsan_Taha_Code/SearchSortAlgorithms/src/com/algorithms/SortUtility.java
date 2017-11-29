package com.algorithms;

import java.util.Random;

public class SortUtility {

	private int[] array;

	public SortUtility(int size) {
		array = new int[size];
	}

	public void fillRandomData() {
		Random random = new Random();
		for (int i = 0; i < array.length; ++i) {
			array[i] = random.nextInt(10000);
		}
	}

	public long bubbleSort() {
		boolean sorted = false;
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < array.length - 1 && !sorted; i++) {
			sorted = true;

			for (int j = 0; j < array.length - 1 - i; j++) {

				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					sorted = false;
				}
			}
		}

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public void printArray() {
		for (int i = 1; i <= array.length; i++) {
			if (i % 8 == 0)
				System.out.println(array[i-1] + "\t");
			else
				System.out.print(array[i-1] + "\t");
		}
		System.out.println();
	}

}
