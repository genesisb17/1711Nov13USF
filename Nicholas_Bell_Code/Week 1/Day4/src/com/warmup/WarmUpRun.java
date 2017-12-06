package com.warmup;

public class WarmUpRun {
	
	public static void main(String[] args) {
		WarmUps w = new WarmUps();
		String soln1 = w.determineInt(5);
		System.out.println(soln1);
		soln1 = w.determineInt(6);
		System.out.println(soln1);
		
		w.primes();
		
		Integer soln3 = new Integer(1);
		w.Ternary(3, 6, soln3);
		
		w.Switch();
		
		w.readPrint();
		
		
	}

}
