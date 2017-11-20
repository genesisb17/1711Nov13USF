package Q10;

import java.util.Scanner;

public class Ternary {
	public static void main(String[] args) {
		System.out.println("Please enter in an Integer:");
		Scanner scanIn = new Scanner(System.in);
		int num1 = scanIn.nextInt();
		System.out.println("Please enter another Integer:");
		int num2=scanIn.nextInt();
		System.out.println((num1<num2)?num1:num2);
	}
}
