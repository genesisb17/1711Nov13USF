package Q4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Input a whole number to find its factorial value: ");
		try(Scanner sc=new Scanner(System.in);){
			int compute=sc.nextInt();
			int fac=factorial(compute);
			System.out.println("Factorial: "+fac);
		}
	}
	
	public static int factorial(int input) {
		int out=1;
		if(input>1) {
			out*=input;
			out*=factorial(input-1);
		}
		return out;
	}
}
