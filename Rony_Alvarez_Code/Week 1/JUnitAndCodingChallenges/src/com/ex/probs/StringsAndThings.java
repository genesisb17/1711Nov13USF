package com.ex.probs;

public class StringsAndThings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str.concat(" string");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str + " " + buff + " " + build);
		
		System.out.println(buff.reverse());

	}

}
