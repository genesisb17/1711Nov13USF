package com.revature.andrew;

import java.util.StringTokenizer;

public class StringAndThings {

	//	private Runtime rt = Runtime 
	
	public static void main(String[] args) {

		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str.concat(" world");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str + " " + buff + " " + build);
		
		System.out.println(buff.reverse());
		
		//testBuild(build.toString());
		
		StringBuilder assignmentBuilder = new StringBuilder("assignment");
		System.out.println(assignmentBuilder);
		assignmentBuilder.insert(0, "my");
		System.out.println(assignmentBuilder);		
		assignmentBuilder.replace(2, 3, "A");
		System.out.println(assignmentBuilder);
		assignmentBuilder.reverse();
		System.out.println(assignmentBuilder);
		
		String rainbow = "red:orange:yellow:green:blue:violet";
		StringTokenizer st = new StringTokenizer(rainbow, ":");
		
		while (st.hasMoreTokens()) {
	         System.out.print(st.nextToken() + " ");
	    }
		System.out.println("");
		
		String twenty = "20";
		String thirty = "30";
		
		int strSum = Integer.parseInt(twenty) + Integer.parseInt(thirty);
		
		System.out.println(strSum);
		
		System.out.println(addStrings(twenty, thirty));
		
		System.gc();
		
		

	}
	
	static int addStrings(String x, String y) {
		return Integer.parseInt(x) + Integer.parseInt(y);
	}

	//stringTokenizer - this creates Token objects, not Strings
	
	
}
