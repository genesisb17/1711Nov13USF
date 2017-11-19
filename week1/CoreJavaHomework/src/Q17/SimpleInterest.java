package Q17;

import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Input principal amount: ");
			double principle=sc.nextDouble();
			System.out.println("Input interest rate: ");
			double rate=sc.nextDouble();
			System.out.println("Input time (in days): ");
			double time=sc.nextDouble();
			
			System.out.println("The interest is "+principle*rate*time);
		}
	}
}
