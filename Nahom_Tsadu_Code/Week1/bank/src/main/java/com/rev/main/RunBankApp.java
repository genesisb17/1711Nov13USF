package com.rev.main;

import java.util.Scanner;


public class RunBankApp {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BankOps ops = BankOps.getInstance(scan);
		ops.run();
	}
}
