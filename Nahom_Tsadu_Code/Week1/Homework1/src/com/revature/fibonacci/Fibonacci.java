package com.revature.fibonacci;

public class Fibonacci {
	public static void main(String[] args) {
		fibonacci(25);
	}
	static void fibonacci(int count){
		int x = 0, y = 0, z;
		for(int i = 0; i < count; i++){
			if(i == 0){
				x = 0;
				y = 1;
				z = x + y;
				System.out.println(z);
			}else{
				z = x + y;
				x = y;
				y = z;
				System.out.println(z);
			}
		}
	}
}
