package com.revature.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			Integer sum = Arrays.stream(scan.nextLine().split(" "))
					.map(Integer::parseInt)
					.filter(i -> i % 2 == 0)
					.reduce(0,  Integer::sum);
			System.out.println(sum);
		}		
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		list.add(384);
		list.add(14);
		list.stream().map(i -> i * 2).filter(i -> i < 100);
		
		
		int[] ints = {1,2,3,4,5,6,7,8};
		Arrays.stream(ints).forEach(System.out::println);
		
	}
}

