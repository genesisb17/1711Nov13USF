package day3.java;

import java.util.StringTokenizer;

public class StringsAndThings {
	
	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		StringTokenizer token = new StringTokenizer("pickles:ketchup:mustard:onion");
		String val1 = "20";
		String val2 = "30";
		
		str.concat(" string");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str + " " + buff + " " + build);
		System.out.println("StringBuffer length: " + buff.length());
		System.out.println(buff.reverse());
		while(token.hasMoreTokens()) {
		System.out.print(token.nextToken(":") + " ");
		}
		System.out.println();
		System.out.println(val1 + val2);
		str = null;
		System.gc();
		testBuild(build.toString());
		Runtime.getRuntime().gc();
		
	}
	
	static String testBuild(String sb) {
		return sb;
		
	}
}
