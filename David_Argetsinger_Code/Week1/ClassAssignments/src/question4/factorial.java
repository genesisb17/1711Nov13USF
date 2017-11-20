package question4;

import java.util.Scanner;

public class factorial {
	public static int factorial(int n){
		if(n < 0){ System.out.println("cannot be negative"); return 0;}
		else if(n == 0) return 1;
		else{
			return n*factorial(n-1);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);// scanner for user input
		System.out.println("please enter an integer to find the factorial");
		int input=0; // will hold user input
		input=in.nextInt();
		System.out.println(factorial(input)); // will print returning value
		
		
	}
}
