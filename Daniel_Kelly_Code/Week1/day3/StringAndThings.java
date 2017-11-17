package com.revature.day3;

import java.util.StringTokenizer;

public class StringAndThings {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str.concat(" string");
		buff.append(" buff");
		build.append(" build");
		
		char c = build.charAt(2);
		int i = build.capacity();
		build.reverse();
		String sub = build.substring(1);
		
		String del = "pickles:ketchup:mustard:onion";
		StringTokenizer st = new StringTokenizer(del, ":");
		System.out.println("String Tokenizer output: ");
		while(st.hasMoreElements()){
			System.out.println(st.nextElement());
		}
		
		String one = "20";
		String two = "20";
		
		addStrings(one, two);
		
		System.out.println(str + " " + buff + " " + build + " " + c + " " + i + " " + sub);
		

	}
	
	static public void addStrings(String a, String b){
		int one = Integer.parseInt(a);
		int two = Integer.parseInt(b);
		System.out.println(one+two);
		System.gc();
	}

}
