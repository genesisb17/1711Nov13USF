package com.revature.day3;

import java.util.StringTokenizer;

public class StringsandTings {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str = str.concat(" string");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str + " " + buff + " " + build);
		System.out.println(buff.reverse());
		
		// DAY 3 ASSIGNMENT
		StringBuilder sbstr = new StringBuilder("Bob's your uncle");
		sbstr.append(". Punctuation matters.");
		sbstr.reverse();
		sbstr.insert(5, " pardon me ");
		
		StringTokenizer strtok = new StringTokenizer("comma:separated:list:of:things", ":");
		while (strtok.hasMoreTokens()) {
			System.out.println(strtok.nextToken());
		}
	}

}
