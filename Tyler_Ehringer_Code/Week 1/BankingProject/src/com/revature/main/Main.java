package com.revature.main;

import java.util.function.BiFunction;

/*
 * Requirements::
 * 
 * Create Account
 * Login
 * Add Money
 * Withdraw Money
 * View Balance
 */

public class Main {
	
	public static void main(String[] args) {
		System.out.println(doOperation(54, 23, (a, b) -> {
			return a + b;
		});
	}
	
	static int doOperation(Integer a, Integer b, BiFunction<Integer, Integer, Integer> fn) {
		return fn.apply(a, b);
	}
}
