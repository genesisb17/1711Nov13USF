package com.revature.questiontwo;

public class Fibonacci {

	public static void main(String[] args) {

		int num = 25;
		
		fibonacci(num);
		
	}
	
	// FIBONACCI
	static void fibonacci(int num) {
	    int a = 0, b = 1, i, c;

	    for (i = 0; i <= num; i++) {
	        if (i <= 1) {
	            c = i;
	        } else {
	            c = a + b;
	            a = b;
	            b = c;
	        }
	        System.out.print(c);
	        if(i != num) {
	            System.out.print(",");
	        }
	    }
	}

}
