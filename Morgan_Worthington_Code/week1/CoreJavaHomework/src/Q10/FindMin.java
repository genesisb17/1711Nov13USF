package Q10;

import java.util.Scanner;

public class FindMin {
public static void main(String[] args) {
	
	try(Scanner sc=new Scanner(System.in)){
		System.out.println("Input first integer: ");
		int num1=sc.nextInt();
		System.out.println("Input second integer: ");
		int num2=sc.nextInt();
		
		int min=(num1<num2) ? num1:num2;
		System.out.println("The minimum is "+min);
		
	}
}
}
