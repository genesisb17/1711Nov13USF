package com.ex.probs;

public class StringsAndThings {
	
	public static void main(String[] args) {

	String str = "hello";
	StringBuffer buff = new StringBuffer("hello");
	StringBuilder build = new StringBuilder("hello");
	
	str.concat(" world");
	buff.append(" buff");
	build.append(" build");
	
	System.out.println(str + " " + buff + " " + " " + build);
	
	
	}
}
