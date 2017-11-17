package Q17;

import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		System.out.println("Enter Principal: ");
		double principal=scanIn.nextDouble();
		System.out.println("Enter Rate: ");
		double rate=scanIn.nextDouble();
		System.out.println("Enter Time in years: ");
		double years=scanIn.nextDouble();
		System.out.println("Interest is: "+(principal*rate*years));
	}
}
