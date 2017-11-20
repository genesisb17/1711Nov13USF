package q17;

import java.util.Scanner;

public class Interest {
	
	public static void main(String[] args) {
		Interest i = new Interest();
		double principal = i.promptInput("Please enter the principal amount:");
		double rate = i.promptInput("Please enter the interest rate:");
		double time = i.promptInput("Please enter the time in years:");
		System.out.println(i.calculateInterest(principal, rate, time));
	}
	
	private Scanner sc;
	
	public Interest() {
		this.sc = new Scanner(System.in);
	}
	
	public double promptInput(String s) {
		System.out.println(s);
		return Double.parseDouble(sc.nextLine());
	}
	
	public double calculateInterest(double principal, double rate, double time) {
		return principal * rate * time;
	}

}
