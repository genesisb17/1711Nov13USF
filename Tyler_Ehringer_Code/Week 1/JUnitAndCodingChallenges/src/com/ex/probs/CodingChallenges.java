package com.ex.probs;

import java.util.Arrays;
import java.util.StringTokenizer;

public class CodingChallenges {

	public int factorial(int n) throws Exception {
		if(n < 0) throw new Exception("Factorial not defined for negative values: " + n);
		return n <= 1 ? 1 : n * factorial(n - 1);
	}

	public String reverseString(String s) {
		return s.length() <= 1 ? s : s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(" goodBye");
		sb.deleteCharAt(3);
		sb.reverse();
		
		String tokenable = "this,is,token,able";
		StringTokenizer st = new StringTokenizer(tokenable, ",");
		while(st.hasMoreTokens()) System.out.println(st.nextToken());
		
		String s1 = "213";
		String s2 = "478";
		System.out.println(addStrings(s1, s2));
		
		System.gc();
		
		Runtime run = Runtime.getRuntime();
		System.out.println(run.totalMemory());
		System.out.println(run.availableProcessors());
		run.gc();
	}
	
	public static int addStrings(String... strings) {
		return Arrays.stream(strings).map(Integer::parseInt).reduce(0, Integer::sum);
	}
}