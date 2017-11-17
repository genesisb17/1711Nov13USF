package com.revature.threads;

public class RedvsBlueDeadlock {
	public static String redFlag="secure";
	public static String blueFlag="secure";
	
	public static void main(String[] args) {
		Red r = new Red();
		Blue b = new Blue();
		
		Thread red= new Thread(r);
		Thread blue= new Thread(b);
		
		red.start();
		blue.start();
	}
}
