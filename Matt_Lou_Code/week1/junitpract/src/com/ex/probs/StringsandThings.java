package com.ex.probs;

public class StringsandThings {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer ("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str.concat(" string");
		buff.append("buff");
		build.append( "build");
		
		System.out.println(str + " " + buff + " " + build);
		testBuild(build.toString());

	}
	static String testBuild(String sb){
		return sb;
	}

}
