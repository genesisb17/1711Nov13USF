package day3demo;

import java.util.StringTokenizer;

public class StringsandThings {

	public static void main(String[] args) {
		
		//--------------------------In Class---------------------------//
		String str = "hello";
		StringBuffer buff = new StringBuffer("hello");
		StringBuilder build = new StringBuilder("hello");
		
		str.concat(" world");
		buff.append(" buff");
		build.append(" build");
		
		System.out.println(str + " " + buff + " " + build);
		
		//-------------------------Assignment-------------------------//
		
		// StringBuilder Object
		StringBuilder B = new StringBuilder("Hello");
		
		// Replace
		System.out.println(B.replace(0, B.length() , "Hi"));
		
		// Append
		System.out.println(B.append(" Yosuf"));
		
		// Subsequence
		System.out.println(B.subSequence(3, B.length()));
		
		// Tokenizer
		String str1 = "pickles:ketchup:mustard:onion";
		StringTokenizer Tokenizer = new StringTokenizer(str1,":");		
		while(Tokenizer.hasMoreTokens()) {
			System.out.println(Tokenizer.nextToken());
		}
		
		// String objects with number values
		String a = "20";
		String b = "10";
		
		int z = addStrings(a,b);
		System.out.println(z);
		
	}

	// Method to add strings with number values
	static int addStrings(String x, String y) {
		int value = Integer.parseInt(x) + Integer.parseInt(y);
		// Requesting Garbage Collection in Method
		System.gc();
		return value;
	}
}
